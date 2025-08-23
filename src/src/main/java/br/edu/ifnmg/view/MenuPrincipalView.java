package br.edu.ifnmg.view;

import br.edu.ifnmg.controller.*;
import java.util.Scanner;
import br.edu.ifnmg.controller.CampusController;
import br.edu.ifnmg.util.Util;

public class MenuPrincipalView {

    Scanner scanner = new Scanner(System.in);

    private CampusController campusController;
    private EquipamentoController equipamentoController;
    private FuncionarioController funcionarioController;
    private PredioController predioController;
    private ReservaController reservaController;
    private SalaReuniaoController salaReuniaoController;

    public MenuPrincipalView() {
        campusController = new CampusController();
        equipamentoController = new EquipamentoController();
        funcionarioController = new FuncionarioController();
        predioController = new PredioController();
        reservaController = new ReservaController();
        salaReuniaoController = new SalaReuniaoController();

    }

    public MenuPrincipalView(
            CampusController campusController,
            EquipamentoController equipamentoController,
            FuncionarioController funcionarioController,
            PredioController predioController,
            ReservaController reservaController,
            SalaReuniaoController salaReuniaoController
    ) {


        this.campusController = campusController;
        this.equipamentoController = equipamentoController;
        this.funcionarioController = funcionarioController;
        this.predioController = predioController;
        this.reservaController = reservaController;
        this.salaReuniaoController = salaReuniaoController;
    }

    public void exibirMenuPrincipal() {

            while (true) {
                System.out.println("\n=================================================================================================================");
                System.out.println("                                                  Book A Room                                                    ");
                System.out.println("=================================================================================================================");
                System.out.println("1. Área de Cadastro");
                System.out.println("2. Área de Reservas");
                System.out.println("3. Área de Listagem");
                System.out.println("4. Sair do Sistema");
                System.out.print("\nDigite a opção desejada: ");

                switch (scanner.nextLine()) {
                    case "1" -> exibirMenuCadastrar();
                    case "2" -> exibirMenuReservas();
                    case "3" -> exibirMenuListar();
                    case "4" -> { return; }
                    default -> System.out.print("\nOpção inválida!\n");
                }
            }
    }

    public void exibirMenuCadastrar() {

        while (true) {
            System.out.println("\n\n\n=================================================================================================================");
            System.out.println("                                                    Cadastro                                                     ");
            System.out.println("=================================================================================================================");

            System.out.println("1. Cadastrar Campus");
            System.out.println("2. Cadastrar Prédio");
            System.out.println("3. Cadastrar Funcionário");
            System.out.println("4. Cadastrar Sala");
            System.out.println("5. Cadastrar Equipamento");
            System.out.println("6. Retornar ao Menu Principal");
            System.out.print("\nDigite a opção desejada: ");

            switch (scanner.nextLine()) {
                case "1"->  campusController.cadastrar();
                case "2" -> predioController.cadastrar(campusController);
                case "3" -> funcionarioController.cadastrar(campusController);
                case "4" -> salaReuniaoController.cadastrar(predioController);
                case "5" -> { equipamentoController.cadastrar(); exibirMenuCadastrar(); }
                case "6" -> { return; }
                default -> {System.out.print("\nOpção inválida!\n");}
            }
        }
    }

    public void exibirMenuListar() {

        while (true) {
            System.out.println("\n\n\n=================================================================================================================");
            System.out.println("                                                  Listagem                                                       ");
            System.out.println("=================================================================================================================");
            System.out.println("1. Listar Campi");
            System.out.println("2. Listar Prédios");
            System.out.println("3. Listar Funcionários");
            System.out.println("4. Listar Salas");
            System.out.println("5. Listar Equipamentos");
            System.out.println("6. Retornar ao Menu Principal");
            System.out.print("\nDigite a opção desejada: ");

            switch (scanner.nextLine()) {
                case "1" -> campusController.listar();
                case "2" -> predioController.listarPorCampus(Util.obterIdCampus(campusController).getId());
                case "3" -> funcionarioController.listarPorCampus(Util.obterIdCampus(campusController).getId());
                case "4" -> salaReuniaoController.listarPorCampus(Util.obterIdCampus(campusController).getId());
                case "5" -> equipamentoController.listar();
                case "6" -> { return; }
                default -> System.out.print("\nOpção inválida!\n");
            }
        }
    }

    public void exibirMenuReservas() {

        while (true) {
            System.out.println("\n\n\n================================================================================================================");
            System.out.println("                                                    Reservas                                                    ");
            System.out.println("================================================================================================================");
            System.out.println("1. Realizar Reserva");
            System.out.println("2. Listar Todas as Reservas Do Campus");
            System.out.println("3. Verificar Reservas Ativas e Inativas");
            System.out.println("4. Verificar Ocupação Das Salas por Dia, Semana ou Mês");
            System.out.println("5. Retornar ao Menu Principal");
            System.out.print("\nDigite a opção desejada: ");

            switch (scanner.nextLine()) {
                case "1" -> { reservaController.cadastrar(salaReuniaoController, funcionarioController, equipamentoController, campusController); }
                case "2" -> { reservaController.listarPorCampus(Util.obterIdCampus(campusController).getId()); }
                case "3" -> { reservaController.obterSituacaoReserva(Util.obterIdCampus(campusController).getId()); }
                case "4" -> { reservaController.verificarReservasNumPeriodo(Util.obterIdCampus(campusController).getId()); }
                case "5" -> { return; }
                default -> System.out.print("\nOpção inválida!\n");
            }
        }
    }
}
