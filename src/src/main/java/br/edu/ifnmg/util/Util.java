package br.edu.ifnmg.util;

import br.edu.ifnmg.controller.*;
import br.edu.ifnmg.entity.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Util {

    public static void carregarDadosTeste(
            CampusController campusController,
            EquipamentoController equipamentoController,
            FuncionarioController funcionarioController,
            PredioController predioController,
            ReservaController reservaController,
            SalaReuniaoController salaReuniaoController
    ) {

        Campus campus1 = new Campus();
        campus1.setNome("Instituto Federal do Norte de Minas Gerais, Campus Montes Claros");
        campus1.setEndereco("R. Dois, 300 - Village do Lago I, Montes Claros - MG");

        Predio predio1 = new Predio("Prédio 1");
        Predio predio2 = new Predio("Prédio 2");

        campus1.addPredio(predio1);
        campus1.addPredio(predio2);

        SalaReuniao salaReuniao1 = new SalaReuniao();
        salaReuniao1.setNumero(100);
        salaReuniao1.setQtdLugares(15);

        SalaReuniao salaReuniao2 = new SalaReuniao();
        salaReuniao2.setNumero(200);
        salaReuniao2.setQtdLugares(25);

        SalaReuniao salaReuniao3 = new SalaReuniao();
        salaReuniao3.setNumero(300);
        salaReuniao3.setQtdLugares(35);

        predio1.addSala(salaReuniao1);
        predio1.addSala(salaReuniao2);
        predio2.addSala(salaReuniao3);


        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("João Silva");
        funcionario1.setCargo("Professor");
        funcionario1.setRamal(1234);

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("Maria Oliveira");
        funcionario2.setCargo("Coordenadora de Curso");
        funcionario2.setRamal(5678);

        Funcionario funcionario3 = new Funcionario();
        funcionario3.setNome("José Santos");
        funcionario3.setCargo("Diretor");
        funcionario3.setRamal(9876);

        campus1.addFuncionario(funcionario1);
        campus1.addFuncionario(funcionario2);
        campus1.addFuncionario(funcionario3);

        Equipamento equipamento1 = new Equipamento();
        equipamento1.setNome("Notebook Dell Latitude 9510");
        equipamento1.setPatrimonio("DELL9510-123456");

        Equipamento equipamento2 = new Equipamento();
        equipamento2.setNome("Projetor Epson PowerLite 1781W");
        equipamento2.setPatrimonio("EPSON1781W-654321");

        Reserva reserva1 = new Reserva();
        reserva1.setDataAlocacao(LocalDate.now().plusDays(1));
        reserva1.setHoraInicio(Time.valueOf("23:10:00"));
        reserva1.setHoraFim(Time.valueOf("23:20:00"));
        reserva1.setAssunto("Reunião de Planejamento");
        reserva1.setSolicitante(funcionario1);
        reserva1.setSalaReuniao(salaReuniao1);
        reserva1.addEquipamento(equipamento1);

        Reserva reserva2 = new Reserva();
        reserva2.setDataAlocacao(LocalDate.now().plusDays(2));
        reserva2.setHoraInicio(Time.valueOf("12:30:00"));
        reserva2.setHoraFim(Time.valueOf("14:40:00"));
        reserva2.setAssunto("Alinhamento de Projetos");
        reserva2.setSolicitante(funcionario2);
        reserva2.setSalaReuniao(salaReuniao1);
        reserva2.addEquipamento(equipamento2);

        Campus campus2 = new Campus();
        campus2.setNome("Instituto Federal do Norte de Minas Gerais, Campus Salinas");
        campus2.setEndereco("Rodovia MG-404, Km 02 s/n Zona Rural, Salinas - MG");

        Predio predio3 = new Predio("Prédio Agronomia");
        Predio predio4 = new Predio("Prédio Engenharia");

        campus2.addPredio(predio3);
        campus2.addPredio(predio4);

        SalaReuniao salaReuniao4 = new SalaReuniao();
        salaReuniao4.setNumero(400);
        salaReuniao4.setQtdLugares(45);

        SalaReuniao salaReuniao5 = new SalaReuniao();
        salaReuniao5.setNumero(500);
        salaReuniao5.setQtdLugares(55);

        predio3.addSala(salaReuniao4);
        predio4.addSala(salaReuniao5);

        Funcionario funcionario4 = new Funcionario();
        funcionario4.setNome("Ana Souza");
        funcionario4.setCargo("Professora");
        funcionario4.setRamal(4321);

        Funcionario funcionario5 = new Funcionario();
        funcionario5.setNome("Carlos Santos");
        funcionario5.setCargo("Professor");
        funcionario5.setRamal(8765);

        Funcionario funcionario6 = new Funcionario();
        funcionario6.setNome("Mariana Oliveira");
        funcionario6.setCargo("Diretora");
        funcionario6.setRamal(5678);

        campus2.addFuncionario(funcionario4);
        campus2.addFuncionario(funcionario5);
        campus2.addFuncionario(funcionario6);

        Equipamento equipamento3 = new Equipamento();
        equipamento3.setNome("Data Show Benq MS527");
        equipamento3.setPatrimonio("BENQMS527-123456");

        Equipamento equipamento4 = new Equipamento();
        equipamento4.setNome("Notebook Lenovo ThinkPad T14");
        equipamento4.setPatrimonio("LENOVOT14-654321");

        Reserva reserva3 = new Reserva();
        reserva3.setDataAlocacao(LocalDate.now().minusDays(3));
        reserva3.setHoraInicio(Time.valueOf("08:00:00"));
        reserva3.setHoraFim(Time.valueOf("10:00:00"));
        reserva3.setAssunto("Aula de Cálculo");
        reserva3.setSolicitante(funcionario4);
        reserva3.setSalaReuniao(salaReuniao4);
        reserva3.addEquipamento(equipamento3);

        Reserva reserva4 = new Reserva();
        reserva4.setDataAlocacao(LocalDate.now().plusDays(4));
        reserva4.setHoraInicio(Time.valueOf("14:00:00"));
        reserva4.setHoraFim(Time.valueOf("16:00:00"));
        reserva4.setAssunto("Demonstração do ResNet para Contornar o Desaparecimento do Gradiente na Rede");
        reserva4.setSolicitante(funcionario5);
        reserva4.setSalaReuniao(salaReuniao4);
        reserva4.addEquipamento(equipamento4);

        campusController.getModel().salvar(campus1);
        campusController.getModel().salvar(campus2);

        predioController.getModel().salvar(predio1);
        predioController.getModel().salvar(predio2);
        predioController.getModel().salvar(predio3);
        predioController.getModel().salvar(predio4);


        salaReuniaoController.getModel().salvar(salaReuniao1);
        salaReuniaoController.getModel().salvar(salaReuniao2);
        salaReuniaoController.getModel().salvar(salaReuniao3);
        salaReuniaoController.getModel().salvar(salaReuniao4);
        salaReuniaoController.getModel().salvar(salaReuniao5);


        funcionarioController.getModel().salvar(funcionario1);
        funcionarioController.getModel().salvar(funcionario2);
        funcionarioController.getModel().salvar(funcionario3);
        funcionarioController.getModel().salvar(funcionario4);
        funcionarioController.getModel().salvar(funcionario5);
        funcionarioController.getModel().salvar(funcionario6);


        equipamentoController.getModel().salvar(equipamento1);
        equipamentoController.getModel().salvar(equipamento2);
        equipamentoController.getModel().salvar(equipamento3);
        equipamentoController.getModel().salvar(equipamento4);


        reservaController.getModel().salvar(reserva1);
        reservaController.getModel().salvar(reserva2);
        reservaController.getModel().salvar(reserva3);
        reservaController.getModel().salvar(reserva4);

    }

    private static String padRight(String str, int length) {
        return String.format("%-" + length + "s", str);
    }

    private static String getUppercaseFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String formatarData(String data) {

        String[] partes = data.split("-");
        String dataFormatada = partes[2] + "/" + partes[1] + "/" + partes[0];
        return dataFormatada;
    }

    public static void formatarFuncionario(ArrayList<Funcionario> funcionarios) {

        int numColunas = 5;
        int[] colWidths = new int[numColunas];

        for (Funcionario funcionario : funcionarios) {
            colWidths[0] = Math.max(colWidths[0], String.valueOf(funcionario.getId()).length());
            colWidths[1] = Math.max(colWidths[1], funcionario.getNome().length());
            colWidths[2] = Math.max(colWidths[2], funcionario.getCargo().length());
            colWidths[3] = Math.max(colWidths[3], String.valueOf(funcionario.getRamal()).length());
            colWidths[4] = Math.max(colWidths[4], String.valueOf(funcionario.getCampus().getId()).length());
        }

        int numFuncionarios = funcionarios.size();
        String[][] dados = new String[numFuncionarios + 1][numColunas];

        dados[0][0] = "\t" + padRight("ID", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("NOME", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("CARGO", colWidths[2]) + "\t";
        dados[0][3] = "\t" + padRight("RAMAL", colWidths[3]) + "\t";
        dados[0][4] = "\t" + padRight("ID_CAMPUS", colWidths[4]) + "\t";

        for (int i = 1; i < dados.length; i++) {
            Funcionario funcionario = funcionarios.get(i - 1);
            dados[i][0] = "\t" + padRight(String.valueOf(funcionario.getId()), colWidths[0]) + "\t";
            dados[i][1] = "\t" + padRight(funcionario.getNome(), colWidths[1]) + "\t";
            dados[i][2] = "\t" + padRight(funcionario.getCargo(), colWidths[2]) + "\t";
            dados[i][3] = "\t" + padRight(String.valueOf(funcionario.getRamal()), colWidths[3]) + "\t";
            dados[i][4] = "\t" + padRight(String.valueOf(funcionario.getCampus().getId()), colWidths[4]) + "\t";
        }

        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }

    }

    public static void formatarCampus(ArrayList<Campus> campus) {

        int numColunas = 3;
        int[] colWidths = new int[numColunas];

        for (Campus campusAux : campus) {
            colWidths[0] = Math.max(colWidths[0], String.valueOf(campusAux.getId()).length());
            colWidths[1] = Math.max(colWidths[1], campusAux.getNome().length());
            colWidths[2] = Math.max(colWidths[2], campusAux.getEndereco().length());
        }

        int numCampus = campus.size();
        String[][] dados = new String[numCampus + 1][numColunas];

        dados[0][0] = "\t" + padRight("ID", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("NOME", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("ENDEREÇO", colWidths[2]) + "\t";

        for (int i = 1; i < dados.length; i++) {
            Campus campusAux = campus.get(i - 1);
            dados[i][0] = "\t" + padRight(String.valueOf(campusAux.getId()), colWidths[0]) + "\t";
            dados[i][1] = "\t" + padRight(campusAux.getNome(), colWidths[1]) + "\t";
            dados[i][2] = "\t" + padRight(campusAux.getEndereco(), colWidths[2]) + "\t";
        }

        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void formatarEquipamento(ArrayList<Equipamento> equipamentos) {

        int numColunas = 3;
        int[] colWidths = new int[numColunas];

        for (Equipamento equipamento : equipamentos) {
            colWidths[0] = Math.max(colWidths[0], String.valueOf(equipamento.getId()).length());
            colWidths[1] = Math.max(colWidths[1], equipamento.getNome().length());
            colWidths[2] = Math.max(colWidths[2], equipamento.getPatrimonio().length());
        }

        int numEquipamentos = equipamentos.size();
        String[][] dados = new String[numEquipamentos + 1][numColunas];

        dados[0][0] = "\t" + padRight("ID", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("NOME", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("PATRIMÔNIO", colWidths[2]) + "\t";

        for (int i = 1; i < dados.length; i++) {
            Equipamento equipamento = equipamentos.get(i - 1);
            dados[i][0] = "\t" + padRight(String.valueOf(equipamento.getId()), colWidths[0]) + "\t";
            dados[i][1] = "\t" + padRight(equipamento.getNome(), colWidths[1]) + "\t";
            dados[i][2] = "\t" + padRight(equipamento.getPatrimonio(), colWidths[2]) + "\t";
        }

        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void formatarPredio(ArrayList<Predio> predios) {

        int numColunas = 3;
        int[] colWidths = new int[numColunas];

        for (Predio predio : predios) {
            colWidths[0] = Math.max(colWidths[0], String.valueOf(predio.getId()).length());
            colWidths[1] = Math.max(colWidths[1], predio.getNome().length());
            colWidths[2] = Math.max(colWidths[2], String.valueOf(predio.getCampus().getId()).length());
        }

        int numPredios = predios.size();
        String[][] dados = new String[numPredios + 1][numColunas];

        dados[0][0] = "\t" + padRight("ID", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("NOME", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("ID_CAMPUS", colWidths[2]) + "\t";

        for (int i = 1; i < dados.length; i++) {
            Predio predio = predios.get(i - 1);
            dados[i][0] = "\t" + padRight(String.valueOf(predio.getId()), colWidths[0]) + "\t";
            dados[i][1] = "\t" + padRight(predio.getNome(), colWidths[1]) + "\t";
            dados[i][2] = "\t" + padRight(String.valueOf(predio.getCampus().getId()), colWidths[2]) + "\t";
        }

        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void formatarReserva(ArrayList<Reserva> reservas) {

        int numColunas = 8;
        int[] colWidths = new int[numColunas];

        for (Reserva reserva : reservas) {
            colWidths[0] = Math.max(colWidths[0], String.valueOf(reserva.getId()).length());
            colWidths[1] = Math.max(colWidths[1], String.valueOf(reserva.getDataAlocacao()).length());
            colWidths[2] = Math.max(colWidths[2], String.valueOf(reserva.getHoraInicio()).length());
            colWidths[3] = Math.max(colWidths[3], String.valueOf(reserva.getHoraFim()).length());
            colWidths[4] = Math.max(colWidths[4], reserva.getAssunto().length());
            colWidths[5] = Math.max(colWidths[5], reserva.getSolicitante().getNome().length());
            colWidths[6] = Math.max(colWidths[6], String.valueOf(reserva.getSalaReuniao().getId()).length());
            colWidths[7] = Math.max(colWidths[7], String.valueOf(reserva.exibirEquipamentos()).length());
        }

        int numReservas = reservas.size();
        String[][] dados = new String[numReservas + 1][numColunas];

        dados[0][0] = "\t" + padRight("ID", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("DATA", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("HORA INICIO", colWidths[2]) + "\t";
        dados[0][3] = "\t" + padRight("HORA FIM", colWidths[3]) + "\t";
        dados[0][4] = "\t" + padRight("ASSUNTO", colWidths[4]) + "\t";
        dados[0][5] = "\t" + padRight("SOLICITANTE", colWidths[5]) + "\t";
        dados[0][6] = "\t" + padRight("ID_SALA", colWidths[6]) + "\t";
        dados[0][7] = "\t" + padRight("EQUIPAMENTOS", colWidths[7] + 2) + "\t";

        for (int i = 1; i < dados.length; i++) {
            Reserva reserva = reservas.get(i - 1);
            dados[i][0] = "\t" + padRight(String.valueOf(reserva.getId()), colWidths[0]) + "\t";
            dados[i][1] = "\t" + padRight(formatarData(String.valueOf(reserva.getDataAlocacao())), colWidths[1]) + "\t";
            dados[i][2] = "\t" + padRight(String.valueOf(reserva.getHoraInicio()).substring(0, 5), colWidths[2]) + "\t";
            dados[i][3] = "\t" + padRight(String.valueOf(reserva.getHoraFim()).substring(0, 5), colWidths[3]) + "\t";
            dados[i][4] = "\t" + padRight(reserva.getAssunto(), colWidths[4]) + "\t";
            dados[i][5] = "\t" + padRight(reserva.getSolicitante().getNome(), colWidths[5]) + "\t";
            dados[i][6] = "\t" + padRight(String.valueOf(reserva.getSalaReuniao().getId()), colWidths[6]) + "\t";
            dados[i][7] = "\t" + padRight(String.valueOf(reserva.exibirEquipamentos()), 1) + "\t";
        }


        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void formatarSalaReuniao(ArrayList<SalaReuniao> salasReuniao) {

        int numColumns = 4;
        int[] colWidths = new int[numColumns];

        for (SalaReuniao salaReuniao : salasReuniao) {
            colWidths[0] = Math.max(colWidths[0], String.valueOf(salaReuniao.getId()).length());
            colWidths[1] = Math.max(colWidths[1], String.valueOf(salaReuniao.getNumero()).length());
            colWidths[2] = Math.max(colWidths[2], String.valueOf(salaReuniao.getQtdLugares()).length());
            colWidths[3] = Math.max(colWidths[3], String.valueOf(salaReuniao.getPredio().getId()).length());
        }

        int numSalasReuniao = salasReuniao.size();
        String[][] dados = new String[numSalasReuniao + 1][numColumns];

        dados[0][0] = "\t" + padRight("ID", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("NUMERO", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("QTD_LUGARES", colWidths[2]) + "\t";
        dados[0][3] = "\t" + padRight("ID_PREDIO", colWidths[3]) + "\t";

        for (int i = 1; i < dados.length; i++) {
            SalaReuniao salaReuniao = salasReuniao.get(i - 1);
            dados[i][0] = "\t" + padRight(String.valueOf(salaReuniao.getId()), colWidths[0]) + "\t";
            dados[i][1] = "\t" + padRight(String.valueOf(salaReuniao.getNumero()), colWidths[1]) + "\t\t\t";
            dados[i][2] = "\t" + padRight(String.valueOf(salaReuniao.getQtdLugares()), colWidths[2]) + "\t\t\t";
            dados[i][3] = "\t" + padRight(String.valueOf(salaReuniao.getPredio().getId()), colWidths[3]) + "\t";
        }

        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void formatarSalasDisponiveis(Map<Long, Object[] > mapaSituacaoReservas) {

        int numColumns = 6;
        int[] colWidths = new int[numColumns];

        int counter = 1;

        for (Map.Entry<Long, Object[]> tupla : mapaSituacaoReservas.entrySet()) {
            Object[] reservaESituacao = tupla.getValue();
            SalaReuniao salaReuniao = (SalaReuniao) reservaESituacao[0];

            colWidths[0] = Math.max(colWidths[0], String.valueOf(salaReuniao.getId()).length());
            colWidths[1] = Math.max(colWidths[1], "Disponível".length());
            colWidths[2] = Math.max(colWidths[2], String.valueOf(salaReuniao.getNumero()).length());
            colWidths[3] = Math.max(colWidths[3], String.valueOf(salaReuniao.getQtdLugares()).length());
            colWidths[4] = Math.max(colWidths[4], String.valueOf(salaReuniao.getPredio().getId()).length());
            colWidths[5] = Math.max(colWidths[5], String.valueOf(salaReuniao.getPredio().getNome()).length());

        }

        int numSalasReuniao = mapaSituacaoReservas.size();
        String[][] dados = new String[numSalasReuniao + 1][numColumns];

        dados[0][0] = "\t" + padRight("ID_SALA", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("DISPONIBILIDADE", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("NUMERO", colWidths[1]) + "\t";
        dados[0][3] = "\t" + padRight("QTD_LUGARES", colWidths[2]) + "\t";
        dados[0][4] = "\t" + padRight("ID_PREDIO", colWidths[3]) + "\t";
        dados[0][5] = "\t" + padRight("NOME_PREDIO", colWidths[4]) + "\t";

        for (Map.Entry<Long, Object[]> tupla : mapaSituacaoReservas.entrySet()) {
            Object[] reservaESituacao = tupla.getValue();
            SalaReuniao salaReuniao = (SalaReuniao) reservaESituacao[0];
            String situacao = (String) reservaESituacao[1];

            dados[counter][0] = "\t" + padRight(String.valueOf(salaReuniao.getId()), colWidths[0]) + "\t\t  ";
            dados[counter][1] = "\t" + padRight(situacao, colWidths[1]) + "\t\t";
            dados[counter][2] = "\t" + padRight(String.valueOf(salaReuniao.getNumero()), colWidths[2]) + "\t\t\t";
            dados[counter][3] = "\t" + padRight(String.valueOf(salaReuniao.getQtdLugares()), colWidths[3]) + "\t\t\t";
            dados[counter][4] = "\t" + padRight(String.valueOf(salaReuniao.getPredio().getId()), colWidths[4]) + "\t\t\t";
            dados[counter][5] = "\t" + padRight(String.valueOf(salaReuniao.getPredio().getNome()), colWidths[5]) + "\t";

            counter++;
        }

        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void formatarReservasAtivasEInativas(Map<Long, Object[] > mapaSituacaoReservas) {


        int numColumns = 9;
        int[] colWidths = new int[numColumns];

        int counter = 1;

        for (Map.Entry<Long, Object[]> tupla : mapaSituacaoReservas.entrySet()) {
            Object[] reservaESituacao = tupla.getValue();
            Reserva reserva = (Reserva) reservaESituacao[0];

            colWidths[0] = Math.max(colWidths[0], String.valueOf(reserva.getId()).length());
            colWidths[1] = Math.max(colWidths[1], "Inativa".length());
            colWidths[2] = Math.max(colWidths[2], String.valueOf(reserva.getDataAlocacao()).length());
            colWidths[3] = Math.max(colWidths[3], String.valueOf(reserva.getHoraInicio()).length());
            colWidths[4] = Math.max(colWidths[4], String.valueOf(reserva.getHoraFim()).length());
            colWidths[5] = Math.max(colWidths[5], reserva.getAssunto().length());
            colWidths[6] = Math.max(colWidths[6], reserva.getSolicitante().getNome().length());
            colWidths[7] = Math.max(colWidths[7], String.valueOf(reserva.getSalaReuniao().getId()).length());
            colWidths[8] = Math.max(colWidths[8], String.valueOf(reserva.exibirEquipamentos()).length());

        }

        int numSalasReuniao = mapaSituacaoReservas.size();
        String[][] dados = new String[numSalasReuniao + 1][numColumns];

        dados[0][0] = "\t" + padRight("ID", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("SITUAÇÃO", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("DATA", colWidths[2]) + "\t";
        dados[0][3] = "\t" + padRight("HORA INICIO", colWidths[3]) + "\t";
        dados[0][4] = "\t" + padRight("HORA FIM", colWidths[4]) + "\t";
        dados[0][5] = "\t" + padRight("ASSUNTO", colWidths[5]) + "\t";
        dados[0][6] = "\t" + padRight("SOLICITANTE", colWidths[6]) + "\t";
        dados[0][7] = "\t" + padRight("ID_SALA", colWidths[7]) + "\t";
        dados[0][8] = "\t" + padRight("EQUIPAMENTOS", colWidths[8] + 2) + "\t";


        for (Map.Entry<Long, Object[]> tupla : mapaSituacaoReservas.entrySet()) {
            Object[] reservaESituacao = tupla.getValue();
            Reserva reserva = (Reserva) reservaESituacao[0];
            String situacao = (String) reservaESituacao[1];

            dados[counter][0] = "\t" + padRight(String.valueOf(reserva.getId()), colWidths[0]) + "\t";
            dados[counter][1] = "\t" + padRight(situacao, colWidths[1]) + "\t\t";
            dados[counter][2] = "\t" + padRight(formatarData(String.valueOf(reserva.getDataAlocacao())), colWidths[2]) + "\t";
            dados[counter][3] = "\t" + padRight(String.valueOf(reserva.getHoraInicio()).substring(0, 5), colWidths[3]) + "\t";
            dados[counter][4] = "\t" + padRight(String.valueOf(reserva.getHoraFim()).substring(0, 5), colWidths[4]) + "\t";
            dados[counter][5] = "\t" + padRight(reserva.getAssunto(), colWidths[5]) + "\t";
            dados[counter][6] = "\t" + padRight(reserva.getSolicitante().getNome(), colWidths[6]) + "\t";
            dados[counter][7] = "\t" + padRight(String.valueOf(reserva.getSalaReuniao().getId()), colWidths[7]) + "\t";
            dados[counter][8] = "\t" + padRight(String.valueOf(reserva.exibirEquipamentos()), 1) + "\t";

            counter++;
        }

        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void formatarSalasOcupadas(ArrayList<Reserva> reservas) {

        int numColumns = 6;
        int[] colWidths = new int[numColumns];

        Map<String, ArrayList<Object>> mapaOcupacaoSalas = formatarOcupacoesDeCadaSala(reservas);
        int comprimentoOcupacaoMaximo = 0;

        for (Map.Entry<String, ArrayList<Object>> tupla : mapaOcupacaoSalas.entrySet()) {
            ArrayList<Object> arrayListOcupacaoAtual = tupla.getValue();

            String ocupacaoAtual = (String) arrayListOcupacaoAtual.get(3);

            comprimentoOcupacaoMaximo = Math.max(comprimentoOcupacaoMaximo, ocupacaoAtual.length());
        }

        for (Reserva reserva : reservas) {
            colWidths[0] = Math.max(colWidths[0], String.valueOf(reserva.getSalaReuniao().getId()).length());
            colWidths[1] = Math.max(colWidths[1], String.valueOf(reserva.getSalaReuniao().getNumero()).length());
            colWidths[2] = Math.max(colWidths[2], String.valueOf(reserva.getSalaReuniao().getQtdLugares()).length());
            colWidths[3] = Math.max(colWidths[3], String.valueOf(reserva.getSalaReuniao().getPredio().getId()).length());
            colWidths[4] = Math.max(colWidths[4], String.valueOf(reserva.getDataAlocacao()).length());
        }

        colWidths[5] = comprimentoOcupacaoMaximo;

        int numSalasReuniao = mapaOcupacaoSalas.size();

        String[][] dados = new String[numSalasReuniao + 1][numColumns];

        dados[0][0] = "\t" + padRight("ID_SALA", colWidths[0]) + "\t";
        dados[0][1] = "\t" + padRight("NUMERO", colWidths[1]) + "\t";
        dados[0][2] = "\t" + padRight("QTD_LUGARES", colWidths[2]) + "\t";
        dados[0][3] = "\t" + padRight("ID_PREDIO", colWidths[3]) + "\t";
        dados[0][4] = "\t" + padRight("DATA_OCUPACAO", colWidths[4]) + "\t";
        dados[0][5] = "\t" + padRight("HORARIOS_OCUPACOES", colWidths[5]) + "\t";

        int counter = 1;

        for (Map.Entry<String, ArrayList<Object>> tupla : mapaOcupacaoSalas.entrySet()) {

            ArrayList<Object> arrayListOcupacaoAtual = tupla.getValue();
            Reserva reservaAtual = (Reserva) arrayListOcupacaoAtual.get(4);


            dados[counter][0] = "\t" + padRight(String.valueOf(reservaAtual.getSalaReuniao().getId()), colWidths[0]) + "\t\t";
            dados[counter][1] = "\t" + padRight(String.valueOf(arrayListOcupacaoAtual.get(0)), colWidths[1]) + "\t\t\t";
            dados[counter][2] = "\t" + padRight(String.valueOf(arrayListOcupacaoAtual.get(1)), colWidths[2]) + "\t\t\t";
            dados[counter][3] = "\t" + padRight(String.valueOf(arrayListOcupacaoAtual.get(2)), colWidths[3]) + "\t\t";

            dados[counter][4] = "\t" + padRight(formatarData(String.valueOf(reservaAtual.getDataAlocacao())), colWidths[4]) + "\t\t";

            dados[counter][5] = "\t" + padRight(String.valueOf(arrayListOcupacaoAtual.get(3)), colWidths[5]) + "\t";

            counter++;
        }

        for (String[] row : dados) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static Map<String, ArrayList<Object>> formatarOcupacoesDeCadaSala(ArrayList<Reserva> reservas) {

        Map<String, ArrayList<Object>> mapaOcupacaoSalas = new HashMap<>();

        for (Reserva reserva : reservas) {

            if (!mapaOcupacaoSalas.containsKey(reserva.getSalaReuniao().getId().toString() + reserva.getId().toString())) {
                mapaOcupacaoSalas.put(reserva.getSalaReuniao().getId().toString() + reserva.getId().toString(), new ArrayList<>());

                ArrayList<Object> arrayListOcupacaoAtual = mapaOcupacaoSalas.get(reserva.getSalaReuniao().getId().toString() + reserva.getId().toString());
                arrayListOcupacaoAtual.add(reserva.getSalaReuniao().getNumero());
                arrayListOcupacaoAtual.add(reserva.getSalaReuniao().getQtdLugares());
                arrayListOcupacaoAtual.add(reserva.getSalaReuniao().getPredio().getId());
                arrayListOcupacaoAtual.add("");
                arrayListOcupacaoAtual.add(reserva);
            }

            String ocupacaoAtual = (String) mapaOcupacaoSalas.get(reserva.getSalaReuniao().getId().toString() + reserva.getId().toString()).get(3);
            ocupacaoAtual += new SimpleDateFormat("HH:mm").format(reserva.getHoraInicio()) + " às " + new SimpleDateFormat("HH:mm").format(reserva.getHoraFim()) + "   ";
            mapaOcupacaoSalas.get(reserva.getSalaReuniao().getId().toString() + reserva.getId().toString()).set(3, ocupacaoAtual);
        }

        return mapaOcupacaoSalas;
    }

    public static long obterIdCampus() {

        boolean idCampusInvalido = true;
        long idCampus = 0;

        while (idCampusInvalido) {
            System.out.print("Digite o id do campus: ");

            try {
                idCampus = Long.parseLong( new Scanner(System.in).nextLine());
                idCampusInvalido = false;
            } catch (Exception e) {
                System.out.print("\nID inválido!\n");
            }
        }



        return idCampus;
    }

    public static Campus obterIdCampus(CampusController campusController) {

        boolean idCampusInvalido = true;
        long idCampus = 0;
        Campus campus = null;

        while (idCampusInvalido) {
            System.out.print("Digite o id do campus: ");

            try {
                idCampus = Long.parseLong( new Scanner(System.in).nextLine());
                campus = campusController.getModel().localizarPorId(idCampus);

                if (campus == null) {
                    System.out.println("\nCampus não encontrado!\n");
                    continue;
                }

                idCampusInvalido = false;
            } catch (Exception e) {
                System.out.println("\nID inválido!\n");
            }
        }
        return campus;
    }

    public static Object obterIdQualquer(Controller controller, String da, String Entidade, Boolean buscaInterna) {

        boolean idInvalido = true;
        long idEntidade = 0;

        while (idInvalido) {
            System.out.printf("Digite o ID %s %s: ", da, Entidade);

            try {
                idEntidade = Long.parseLong( new Scanner(System.in).nextLine());
                if(buscaInterna) {
                    if (Objects.isNull(controller.getModel().localizarPorId(idEntidade))) {
                        System.out.printf("\nNão há %s com esse ID!\n\n", Entidade);
                        continue;
                    }
                    idInvalido = false;
                    return controller.getModel().localizarPorId(idEntidade);
                }
                idInvalido = false;
                return idEntidade;
            } catch (Exception e) {
                System.out.println("\nID inválido!\n");
            }
        }

        return controller.getModel().localizarPorId(idEntidade);
    }

    public static LocalDate obterData(String mensagemQualData) {

        boolean dataInvalida = true;
        LocalDate dataReserva = null;

        while (dataInvalida) {

            System.out.print(mensagemQualData);
            String data =  new Scanner(System.in).nextLine();

            if (data.length() != 10) {
                System.out.println("\nData inválida! Utilize o formato DD/MM/AAAA.\n");
                continue;
            }

            for (int i = 0; i < data.length(); i++) {
                if (i == 2 || i == 5) {
                    if (data.charAt(i) != '/') {
                        System.out.println("\nData inválida! Utilize o formato DD/MM/AAAA.\n");
                        continue;
                    }
                } else if (!Character.isDigit(data.charAt(i))) {
                    System.out.println("\nData inválida! Utilize o formato DD/MM/AAAA.\n");
                    continue;
                }
            }

            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            formatoData.setLenient(false);

            try {
                dataReserva = formatoData.parse(data).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            } catch (ParseException | DateTimeParseException e) {
                System.out.println("\nData inválida! Utilize o formato DD/MM/AAAA.\n");
                continue;
            }

            if (!dataReserva.isBefore(LocalDate.now())) {
                dataInvalida = false;
            } else {
                System.out.println("\nData inválida! A data deve ser posterior ou igual a data atual.\n");
            }

        }

        return dataReserva;
    }

    public static Time obterHorario(String mensagemQualHorario, LocalDate dataReserva, boolean ehHorarioInicio, Time horaInicio) {

        boolean horaInvalida = true;
        Time hora = null;
        SimpleDateFormat formatoHorario = new SimpleDateFormat("HH:mm");

        while (horaInvalida) {

            System.out.print(mensagemQualHorario);
            String horarioInicio = new Scanner(System.in).nextLine();

            if (horarioInicio.length() != 5) {
                System.out.println("\nHorário inválido! Utilize o formato hh:mm.\n");
                continue;
            }

            for (int i = 0; i < horarioInicio.length(); i++) {
                if (i == 2) {
                    if (horarioInicio.charAt(i) != ':') {
                        System.out.println("\nHorário inválido! Utilize o formato hh:mm.\n");
                        continue;
                    }
                } else if (!Character.isDigit(horarioInicio.charAt(i))) {
                    System.out.println("\nHorário inválido! Utilize o formato hh:mm.\n");
                    continue;
                }
            }

            formatoHorario.setLenient(false);

            try {
                Date horaTerminoDate = formatoHorario.parse(horarioInicio);
                hora = new Time(horaTerminoDate.getTime());

            } catch (ParseException | DateTimeParseException e) {
                System.out.println("\nHorário inválido! Utilize o formato hh:mm.\n");
                continue;
            }

            if (ehHorarioInicio) {
                if (dataReserva.isEqual(LocalDate.now())) {
                    if (hora.toLocalTime().isBefore(LocalTime.now())) {
                        System.out.println("\nHorário de início deve ser posterior ao horario atual!\n");
                        continue;
                    }
                }
            }

            if (!ehHorarioInicio) {
                if (dataReserva.isEqual(LocalDate.now())) {
                    if (hora.toLocalTime().isBefore(LocalTime.now())) {
                        System.out.println("\nHorário de término deve ser posterior ao horario atual!\n");
                        continue;
                    }
                }

                if (horaInicio != null && (hora.before(horaInicio))) {
                    System.out.println("\nHorário de término deve ser posterior ao horário de início!\n");
                    continue;
                }
            }

            horaInvalida = false;
        }

        return hora;
    }

    public static void addEquipamentosAReserva(Controller equipamentoController, Reserva reserva) {
        Long idEquipamento = null;
        boolean idEquipamentoInvalido = true;

        System.out.print("Deseja adicionar equipamentos a reserva? (s/n): ");
        String adicionarEquipamento = new Scanner(System.in).nextLine();

        Scanner scanner = new Scanner(System.in);

        while (!adicionarEquipamento.equalsIgnoreCase("n")) {
            while (!adicionarEquipamento.equalsIgnoreCase("s") && !adicionarEquipamento.equalsIgnoreCase("n")) {
                System.out.println("\nOpção inválida! Digite 's' para sim ou 'n' para não.\n");
                System.out.print("Deseja adicionar equipamentos a reserva? (s/n): ");
                adicionarEquipamento = scanner.nextLine();
            }

            if (adicionarEquipamento.equalsIgnoreCase("n")) {
                break;
            }

            while (idEquipamentoInvalido) {
                System.out.print("Digite o id do equipamento que deseja adicionar a reserva: ");

                try {
                    idEquipamento = Long.parseLong(scanner.nextLine());
                    idEquipamentoInvalido = false;
                } catch (Exception e) {
                    System.out.print("\nID inválido!\n");
                }
            }

            if (Objects.isNull(equipamentoController.getModel().localizarPorId(idEquipamento))) {
                System.out.println("\nEquipamento não encontrado!\n");
            } else {
                if (reserva.getEquipamentos().contains(equipamentoController.getModel().localizarPorId(idEquipamento))) {
                    System.out.println("\nEquipamento já adicionado a reserva!\n");

                }else {
                    Equipamento equipamento = (Equipamento) equipamentoController.getModel().localizarPorId(idEquipamento);

                    reserva.addEquipamento(equipamento);

                    System.out.println(
                            String.format(
                                    "\n%s adicionado com sucesso!\n",
                                    equipamento.getNome()
                            )
                    );
                }
            }

            idEquipamentoInvalido = true;
            System.out.print("Deseja continuar adicionando equipamentos a reserva? (s/n): ");
            adicionarEquipamento = scanner.nextLine();


        }
    }
}
