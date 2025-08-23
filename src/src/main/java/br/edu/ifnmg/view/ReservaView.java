package br.edu.ifnmg.view;

import br.edu.ifnmg.controller.*;
import br.edu.ifnmg.entity.Funcionario;
import br.edu.ifnmg.entity.Reserva;
import br.edu.ifnmg.entity.SalaReuniao;
import br.edu.ifnmg.model.ReservaModel;
import br.edu.ifnmg.model.SalaReuniaoModel;
import br.edu.ifnmg.util.Util;

import java.sql.Time;
import java.time.*;
import java.util.*;

public class ReservaView extends View<Reserva, Long> implements IReservaView {

    @Override
    public Reserva cadastrar() {
        return null;
    }

    @Override
    public Reserva cadastrar(Controller controller) {
        return null;
    }

    @Override
    public void listar(ArrayList<Reserva> reservas) {
    }

    @Override
    public Reserva cadastrar(
        SalaReuniaoController salaReuniaoController,
        FuncionarioController funcionarioController,
        EquipamentoController equipamentoController,
        CampusController campusController
    ) {

        System.out.println("===============================================================================================================");
        System.out.println("                                               Cadastrar Reserva                                               ");
        System.out.println("===============================================================================================================");

        campusController.listar();
        System.out.println();

        long idCampus = Util.obterIdCampus(campusController).getId();

        Object[] reservaEMapaDisponibilidadeSalas = verificarDisponibilidade(getController().getModel().localizarTodos(), salaReuniaoController, idCampus);

        if (Objects.isNull(reservaEMapaDisponibilidadeSalas)) {
            System.out.println("\nReserva não realizada!\n");
            return null;
        }

        Reserva reserva = (Reserva) reservaEMapaDisponibilidadeSalas[0];

        Map<Long, Object[]> salasEDisponibilidades = (Map<Long, Object[]>) reservaEMapaDisponibilidadeSalas[1];

        if (Objects.isNull(salasEDisponibilidades)) return null;

        long idSala = -1;
        boolean salaValida = false;

        while (!salaValida) {
            idSala = (Long) Util.obterIdQualquer(salaReuniaoController, "da", "sala", false);

            if(salasEDisponibilidades.containsKey(idSala)) {
                if (salasEDisponibilidades.get(idSala)[1].equals("Ocupada")) {
                    System.out.println("\nSala ocupada no horário selecionado!\n");
                    continue;
                } else {
                    salaValida = true;
                }
            }else {
                System.out.println("\nSala não encontrada!\n");
            }
        }

        SalaReuniao salaReuniao = (SalaReuniao) salasEDisponibilidades.get(idSala)[0];

        if (Objects.isNull(salaReuniao)) return null;

        funcionarioController.listarPorCampus(idCampus);

        System.out.println();

        Funcionario solicitante = (Funcionario) Util.obterIdQualquer(funcionarioController, "do", "funcionário", true);

        if (Objects.isNull(solicitante)) return null;

        System.out.print("Digite o assunto da reserva: ");
        String assunto = getScanner().nextLine();

        reserva.setSalaReuniao(salaReuniao);
        reserva.setSolicitante(solicitante);
        reserva.setAssunto(assunto);

        equipamentoController.listar();
        System.out.println();

        Util.addEquipamentosAReserva(equipamentoController, reserva);

        ArrayList<Reserva> reservasQueColidem = ((ReservaModel) getController().getModel()).verificarColisaoReservas(reserva);

        if (!reservasQueColidem.isEmpty()) {
            System.out.print("\nReserva não realizada! Colisão de horários com as seguintes reservas:\n");
            listar(reservasQueColidem);
            return null;
        }

        System.out.println("\nReserva realizada com sucesso!");
        return reserva;
    }

    @Override
    public void listar(ArrayList<Reserva> reservas, long idCampus) {
        if (reservas.isEmpty()){
            System.out.println("\nNão há reservas cadastradas!");
            return;
        }

        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             Reservas Encontradas                                               ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");


        Util.formatarReserva(reservas);
    }

    @Override
    public Object[] verificarDisponibilidade(ArrayList<Reserva> reservas, SalaReuniaoController salaReuniaoController, long idCampus) {

        ArrayList<SalaReuniao> salas = ((SalaReuniaoModel) salaReuniaoController.getModel()).localizarPorIdDoCampus(idCampus);

        if (salas.isEmpty()) {
            System.out.println("\nNão há salas cadastradas!");
            return null;
        };

        LocalDate dataDesejada = Util.obterData("Digite a data para a verificação da disponibilidade DD/MM/AAAA: ");
        Time horaInicio = Util.obterHorario("Digite o horário de início (hh:mm): ", dataDesejada, true, null);
        Time horaFim = Util.obterHorario("Digite o horário de término (hh:mm): ", dataDesejada, false, horaInicio);

        ArrayList<Reserva> reservasQueColidem = new ArrayList<>();

        Map<Long, Object[]> mapaSituacaoReservas = ((ReservaModel) getController().getModel()).mapearDisponibilidadeSalas(
                salas,
                dataDesejada,
                horaInicio,
                horaFim
        );

        if (mapaSituacaoReservas.isEmpty()) {
            System.out.println("\nTodas as salas estão livres!");
            return null;
        }

        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        System.out.println("                                           Disponibilidade das Salas                                            ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        Util.formatarSalasDisponiveis(mapaSituacaoReservas);

        System.out.println();

        Reserva reserva = new Reserva();
        reserva.setDataAlocacao(dataDesejada);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFim(horaFim);

        return new Object[]{reserva, mapaSituacaoReservas};
    }

    @Override
    public void obterSituacaoReserva(long idCampus) {

        Map<Long, Object[]> mapaSituacaoReservas = ((ReservaModel) getController().getModel()).obterSituacaoReserva(idCampus);

        if (mapaSituacaoReservas.isEmpty()) {
            System.out.println("\nNão há reservas cadastradas!");
            return;
        }

        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             Situação das Reservas                                              ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        Util.formatarReservasAtivasEInativas(mapaSituacaoReservas);
    }

    @Override
    public void verificarReservasNumPeriodo(long idCampus) {

        System.out.print("Deseja verificar as ocupações do (1) dia, (2) semana ou (3) mês?: ");
        String periodo = getScanner().nextLine();

        while (!periodo.matches("^[1-3]$")) {
            System.out.println("\nOpção inválida!\n");
            System.out.print("Deseja verificar as ocupações do (1) dia, (2) semana ou (3) mês?: ");
            periodo = getScanner().nextLine();
        }

        switch (periodo) {
            case "1":
                ArrayList<Reserva> reservasPorDia = ((ReservaModel) getController().getModel()).verificarReservasDoDia(idCampus);

                if (reservasPorDia.isEmpty()) {
                    System.out.println("\nNão há ocupações hoje!");
                    return;
                }
                exibirOcupacaoNumPeriodo(reservasPorDia);
                break;

            case "2":
                ArrayList<Reserva> reservasDaSemana = ((ReservaModel) getController().getModel()).verificarReservasDaSemana(idCampus);

                if (reservasDaSemana.isEmpty()) {
                    System.out.println("\nNão há ocupações nos próximos 7 dias!");
                    return;
                }
                exibirOcupacaoNumPeriodo(reservasDaSemana);
                break;
            case "3":
                ArrayList<Reserva> reservasDoMes = ((ReservaModel) getController().getModel()).verificarReservasDoMes(idCampus);

                if (reservasDoMes.isEmpty()) {
                    System.out.println("\nNão há ocupações de hoje até o fim desse mês!");
                    return;
                }
                exibirOcupacaoNumPeriodo(reservasDoMes);
                break;
            default:
                System.out.println("\nOpção inválida!\n");
        }
    }

    public void exibirOcupacaoNumPeriodo(ArrayList<Reserva> reservas) {

        System.out.println("\n----------------------------------------------------------------------------------------------------------------");
        System.out.println("                                                 Salas Ocupadas                                                 ");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        Util.formatarSalasOcupadas(reservas);
    }
}
