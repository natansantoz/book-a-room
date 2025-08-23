package br.edu.ifnmg;
import br.edu.ifnmg.controller.*;
import br.edu.ifnmg.model.*;
import br.edu.ifnmg.util.Util;
import br.edu.ifnmg.view.*;


public class Main {

    public static void main(String[] args) {

        CampusController campusController = new CampusController();
        CampusView campusView = new CampusView();
        CampusModel campusModel = new CampusModel();
        campusController.setView(campusView);
        campusController.setModel(campusModel);


        EquipamentoController equipamentoController = new EquipamentoController();
        EquipamentoView equipamentoView = new EquipamentoView();
        EquipamentoModel equipamentoModel = new EquipamentoModel();
        equipamentoController.setView(equipamentoView);
        equipamentoController.setModel(equipamentoModel);


        FuncionarioController funcionarioController = new FuncionarioController();
        FuncionarioView funcionarioView = new FuncionarioView();
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioController.setView(funcionarioView);
        funcionarioController.setModel(funcionarioModel);


        PredioController predioController = new PredioController();
        PredioView predioView = new PredioView();
        PredioModel predioModel = new PredioModel();
        predioController.setView(predioView);
        predioController.setModel(predioModel);


        ReservaController reservaController = new ReservaController();
        ReservaView reservaView = new ReservaView();
        ReservaModel reservaModel = new ReservaModel();
        reservaController.setView(reservaView);
        reservaController.setModel(reservaModel);


        SalaReuniaoController salaReuniaoController = new SalaReuniaoController();
        SalaReuniaoView salaReuniaoView = new SalaReuniaoView();
        SalaReuniaoModel salaReuniaoModel = new SalaReuniaoModel();
        salaReuniaoController.setView(salaReuniaoView);
        salaReuniaoController.setModel(salaReuniaoModel);

        Util.carregarDadosTeste(
                campusController,
                equipamentoController,
                funcionarioController,
                predioController,
                reservaController,
                salaReuniaoController
        );

        MenuPrincipalView menuPrincipalView = new MenuPrincipalView(
            campusController,
            equipamentoController,
            funcionarioController,
            predioController,
            reservaController,
            salaReuniaoController
        );

        menuPrincipalView.exibirMenuPrincipal();
    }
}