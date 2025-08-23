package br.edu.ifnmg.view;

import br.edu.ifnmg.controller.CampusController;
import br.edu.ifnmg.controller.Controller;
import br.edu.ifnmg.controller.PredioController;
import br.edu.ifnmg.entity.Campus;
import br.edu.ifnmg.entity.Predio;
import br.edu.ifnmg.entity.SalaReuniao;
import br.edu.ifnmg.util.Util;

import java.util.ArrayList;

public class SalaReuniaoView extends View<SalaReuniao, Long>{

    @Override
    public SalaReuniao cadastrar() {
        return null;
    }

    @Override
    public SalaReuniao cadastrar(Controller predioController) {

        int numero;
        int qtdLugares;

        if (predioController.getModel().localizarTodos().isEmpty()) {
            System.out.println("\nNão há prédios cadastrados!\n");
            return null;
        }

        System.out.println("===============================================================================================================");
        System.out.println("                                               Cadastrar Sala                                                  ");
        System.out.println("===============================================================================================================");

        Predio predio = (Predio) Util.obterIdQualquer(predioController,"do", "Prédio", true);

        System.out.print("Digite o número da sala: ");

        try {
            numero = Integer.parseInt(getScanner().nextLine());

        } catch (Exception e) {

            System.out.print("\nNumero inválido!\n");
            return null;
        }

        System.out.print("Digite a quantidade de lugares: ");

        try {
            qtdLugares = Integer.parseInt(getScanner().nextLine());
        } catch (Exception e) {
            System.out.print("\nQuantidade de lugares inválida!\n");
            return null;
        }

        return new SalaReuniao(numero, qtdLugares, predio);
    }

    @Override
    public void listar(ArrayList<SalaReuniao> salasReuniao) {

    }

    @Override
    public void listar(ArrayList<SalaReuniao> salasReuniao, long idCampus) {

        if (salasReuniao.isEmpty()) {
            System.out.println("\nNão há salas cadastradas!");
            return;
        }

        System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                              Salas Encontradas                                              ");
        System.out.println("-------------------------------------------------------------------------------------------------------------");


        Util.formatarSalaReuniao(salasReuniao);
    }

}
