package br.edu.ifnmg.view;
import br.edu.ifnmg.controller.Controller;
import br.edu.ifnmg.entity.Campus;
import br.edu.ifnmg.entity.Entidade;
import br.edu.ifnmg.entity.Equipamento;
import br.edu.ifnmg.util.Util;

import java.util.ArrayList;

public class EquipamentoView extends View<Equipamento, Long>{

    @Override
    public Equipamento cadastrar() {
        System.out.println("===============================================================================================================");
        System.out.println("                                           Cadastrar Equipamento                                               ");
        System.out.println("===============================================================================================================");

        System.out.print("Digite o nome do equipamento: ");
        String nome = getScanner().nextLine();
        System.out.print("Digite o patrimônio do equipamento: ");
        String patrimonio = getScanner().nextLine();

        return new Equipamento(nome, patrimonio);
    }

    @Override
    public void listar(ArrayList<Equipamento> equipamentos) {
        if (equipamentos.isEmpty()) {
            System.out.println("\nNão há equipamentos cadastrados!");
            return;
        }

        System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                           Equipamentos Encontrados                                          ");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        Util.formatarEquipamento(equipamentos);
    }

    @Override
    public void listar(ArrayList<Equipamento> equipamentos, long id) {

    }

    @Override
    public Equipamento cadastrar(Controller controller) {
        return null;
    }

}
