package br.edu.ifnmg.model;

import br.edu.ifnmg.controller.*;
import br.edu.ifnmg.entity.Reserva;
import br.edu.ifnmg.entity.SalaReuniao;
import br.edu.ifnmg.util.Util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class ReservaModel extends Model<Reserva, Long> {

    public ArrayList<Reserva> localizarPorIdDoCampus(long idCampus) {

        ArrayList<Reserva> entidadesDoCampus = new ArrayList<>();

        for (Reserva reserva : localizarTodos()) {
            if(reserva.getSalaReuniao().getPredio().getCampus().getId().equals(idCampus)){
                entidadesDoCampus.add(reserva);
            }
        }

        return entidadesDoCampus;
    }

    public ArrayList<Reserva> verificarReservasDoDia(long idCampus) {
        ArrayList<Reserva> reservasPorDia = new ArrayList<>();

        for (Reserva reserva : localizarTodos()) {
            if (reserva.getDataAlocacao().isEqual(LocalDate.now()) && reserva.getSalaReuniao().getPredio().getCampus().getId().equals(idCampus)) {
                reservasPorDia.add(reserva);
            }
        }

        return reservasPorDia;
    }

    public ArrayList<Reserva> verificarReservasDaSemana(long idCampus) {

        ArrayList<Reserva> reservasPorSemana = new ArrayList<>();

        for (Reserva reserva : localizarTodos()) {
            if (
                    !reserva.getDataAlocacao().isBefore(LocalDate.now())
                        &&
                    !reserva.getDataAlocacao().isAfter(LocalDate.now().plusDays(6))
                        &&
                    reserva.getSalaReuniao().getPredio().getCampus().getId().equals(idCampus)

            ) {
                reservasPorSemana.add(reserva);
            }
        }

        return reservasPorSemana;
    }

    public ArrayList<Reserva> verificarReservasDoMes(long idCampus) {

        int mesAtual = LocalDate.now().getMonthValue();
        int anoAtual = LocalDate.now().getYear();

        ArrayList<Reserva> reservasPorMes = new ArrayList<>();

        for (Reserva reserva : localizarTodos()) {
            if (
                    reserva.getDataAlocacao().getMonthValue() == mesAtual
                        &&
                    reserva.getDataAlocacao().getYear() == anoAtual
                        &&
                    reserva.getSalaReuniao().getPredio().getCampus().getId().equals(idCampus)
            ) {
                reservasPorMes.add(reserva);
            }
        }

        return reservasPorMes;
    }

    public Map<Long, Object[]> obterSituacaoReserva(long idCampus) {

        ArrayList<Reserva> reservas = localizarPorIdDoCampus(idCampus);

        if (reservas.isEmpty()) {
            return new HashMap<>();
        }

        Map<Long, Object[]> mapaSituacaoReservas = new HashMap<Long, Object[]>();

        for (Reserva reserva : reservas) {

            if (
                    reserva.getDataAlocacao().getMonthValue() >= LocalDate.now().getMonthValue()
                        &&
                    reserva.getDataAlocacao().getYear() == LocalDate.now().getYear()
            ) {
                if (
                        reserva.getDataAlocacao().isBefore(LocalDate.now())
                                ||
                        (reserva.getDataAlocacao().isBefore(LocalDate.now()) && reserva.getHoraFim().before(Time.valueOf(LocalTime.now())))
                ) {
                    mapaSituacaoReservas.put(reserva.getId(), new Object[]{reserva, "Inativa"});
                } else {
                    mapaSituacaoReservas.put(reserva.getId(), new Object[]{reserva, "Ativa"});
                }
            }
        }

        return mapaSituacaoReservas;
    }

    public  ArrayList<Reserva> verificarColisaoReservas(Reserva reserva) {

        ArrayList<Reserva> reservasQueColidem = new ArrayList<>();
        ArrayList<Reserva> reservas = (ArrayList<Reserva>) getController().getModel().localizarTodos();
        reservas.sort(Comparator.comparing(Reserva::getDataAlocacao).thenComparing(Reserva::getHoraInicio).thenComparing(Reserva::getHoraFim));

        for (Reserva reservaExistente : reservas) {
            if (! reservaExistente.getSalaReuniao().getId().equals(reserva.getSalaReuniao().getId())){
                continue;
            }
            if (reserva.getDataAlocacao().compareTo(reservaExistente.getDataAlocacao()) == 0) {

                if (
                        reserva.getHoraInicio().compareTo(reservaExistente.getHoraInicio()) >= 0
                            &&
                        reserva.getHoraInicio().compareTo(reservaExistente.getHoraFim()) <= 0

                            ||

                        reserva.getHoraFim().compareTo(reservaExistente.getHoraInicio()) > 0
                            &&
                        reserva.getHoraFim().compareTo(reservaExistente.getHoraFim()) <= 0
                ) {
                    reservasQueColidem.add(reservaExistente);
                }
            }
        }

        return reservasQueColidem;
    }

    public Map<Long, Object[]> mapearDisponibilidadeSalas(ArrayList<SalaReuniao> salas, LocalDate dataDesejada, Time horaInicio, Time horaFim) {
        ArrayList<Reserva> reservasQueColidem = new ArrayList<>();

        Map<Long, Object[]> mapaSituacaoSalas = new HashMap<>();

        for (SalaReuniao salaReuniao : salas) {

            if (salaReuniao.getReservas().isEmpty()) {
                mapaSituacaoSalas.put(salaReuniao.getId(), new Object[]{salaReuniao, "Disponível"});
                continue;
            }

            for (Reserva reserva : salaReuniao.getReservas()) {

                if (reserva.getDataAlocacao().isEqual(dataDesejada)) {
                    if (
                            // hora de inicio da reserva nova está entre a hora de inicio e fim da existente
                            horaInicio.compareTo(reserva.getHoraInicio()) >= 0 && horaInicio.compareTo(reserva.getHoraFim()) < 0
                                ||
                            // hora de fim da reserva nova está entre a hora de inicio e fim da existente
                            horaFim.compareTo(reserva.getHoraInicio()) > 0 && horaFim.compareTo(reserva.getHoraFim()) <= 0
                                ||
                            // hora de inicio da reserva nova é antes da hora de inicio da existente e a hora de fim é depois da hora de fim da existente
                            horaInicio.compareTo(reserva.getHoraInicio()) < 0 && horaFim.compareTo(reserva.getHoraFim()) > 0
                    ) {
                        reservasQueColidem.add(reserva);
                        mapaSituacaoSalas.put(reserva.getSalaReuniao().getId(), new Object[]{reserva.getSalaReuniao(), "Ocupada"});
                        continue;
                    }
                }

                if (mapaSituacaoSalas.get(reserva.getSalaReuniao().getId()) != null) {
                    if (mapaSituacaoSalas.get(reserva.getSalaReuniao().getId())[1].equals("Ocupada")) {
                        continue;
                    }
                }
                mapaSituacaoSalas.put(reserva.getSalaReuniao().getId(), new Object[]{reserva.getSalaReuniao(), "Disponível"});
            }
        }

        return mapaSituacaoSalas;
    }
}
