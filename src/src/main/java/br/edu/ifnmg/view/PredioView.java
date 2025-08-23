package br.edu.ifnmg.view;

import br.edu.ifnmg.controller.CampusController;
import br.edu.ifnmg.controller.Controller;
import br.edu.ifnmg.entity.Campus;
import br.edu.ifnmg.entity.Predio;
import java.util.ArrayList;
import br.edu.ifnmg.util.Util;


public class PredioView extends View<Predio, Long>{

    public PredioView() {
        super();
    }

    @Override
    public Predio cadastrar(Controller campusController) {

        if (campusController.getModel().localizarTodos().isEmpty()) {
            System.out.println("\nNão há campus cadastrados!\n");
            return null;
        }

        System.out.println("===============================================================================================================");
        System.out.println("                                               Cadastrar Predio                                                ");
        System.out.println("===============================================================================================================");

        Campus campus = Util.obterIdCampus((CampusController) campusController);

        System.out.print("Digite o nome do prédio: ");
        String nome = getScanner().nextLine();

        return new Predio(nome, campus);
    }

    @Override
    public void listar(ArrayList<Predio> entidades) {

    }

    @Override
    public Predio cadastrar() {
        return null;
    }

    @Override
    public void listar(ArrayList<Predio> predios, long idCampus) {

        if (predios.isEmpty()) {
            System.out.println("\nNão há prédios cadastrados!");
            return;
        }

        System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                              Prédios Encontrados                                            ");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        Util.formatarPredio(predios);
    }

}
