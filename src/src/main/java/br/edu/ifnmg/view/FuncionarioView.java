package br.edu.ifnmg.view;

import br.edu.ifnmg.controller.CampusController;
import br.edu.ifnmg.controller.Controller;
import br.edu.ifnmg.controller.FuncionarioController;
import br.edu.ifnmg.entity.Campus;
import br.edu.ifnmg.entity.Funcionario;

import java.util.ArrayList;
import br.edu.ifnmg.util.Util;


public class FuncionarioView extends View<Funcionario, Long>{

    @Override
    public Funcionario cadastrar(Controller campusController) {

        long ramal = 0;

        if (campusController.getModel().localizarTodos().isEmpty()) {
            System.out.println("\nNão há campus cadastrados!\n");
            return null;
        }

        System.out.println("===============================================================================================================");
        System.out.println("                                           Cadastrar Funcionário                                               ");
        System.out.println("===============================================================================================================");

        long idCampus = Util.obterIdCampus();

        Campus campus = (Campus) campusController.getModel().localizarPorId(idCampus);

        System.out.print("Digite o nome do funcionário: ");
        String nome = getScanner().nextLine();
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = getScanner().nextLine();
        System.out.print("Digite o ramal do funcionário: ");


        while (ramal == 0) {
            try {
                ramal = Long.parseLong(getScanner().nextLine());

            } catch (Exception e) {
                System.out.println("\nRamal inválido!\n");
                System.out.print("Digite o ramal do funcionário: ");
                return null;
            }
        }

        return new Funcionario(nome, cargo, ramal, campus);
    }

    @Override
    public void listar(ArrayList<Funcionario> funcionarios, long idCampus) {

        if (funcionarios.isEmpty()) {
            System.out.println("\nNão há funcionários cadastrados!");
            return;
        }

        System.out.println("\n-------------------------------------------------------------------------------------------------------------");
        System.out.println("                                           Funcionários Encontrados                                          ");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        Util.formatarFuncionario(funcionarios);
    }

    @Override
    public void listar(ArrayList<Funcionario> entidades) {

    }

    @Override
    public Funcionario cadastrar() {
        return null;
    }

}
