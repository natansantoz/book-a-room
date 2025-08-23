package br.edu.ifnmg.view;

import br.edu.ifnmg.controller.Controller;
import br.edu.ifnmg.entity.Campus;
import br.edu.ifnmg.util.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class CampusView extends View<Campus, Long> {

    private Scanner scanner;

    public CampusView() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Campus cadastrar() {

        System.out.println("===============================================================================================================");
        System.out.println("                                              Cadastrar Campus                                                 ");
        System.out.println("===============================================================================================================");

        System.out.print("Digite o nome do campus: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço do campus: ");
        String endereco = scanner.nextLine();

        Campus campus = new Campus();
        campus.setNome(nome);
        campus.setEndereco(endereco);

        return campus;
    }

    @Override
    public void listar(ArrayList<Campus> campi) {

        if (campi.isEmpty()) {
            System.out.println("\nNão há campus cadastrados!");
            return;
        }

        System.out.println("\n---------------------------------------------------------------------------------------------------------------");
        System.out.println("                                             Campi Encontrados                                               ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        Util.formatarCampus(campi);
    }

    @Override
    public void listar(ArrayList<Campus> entidades, long id) {

    }

    @Override
    public Campus cadastrar(Controller controller) {
        return null;
    }
}
