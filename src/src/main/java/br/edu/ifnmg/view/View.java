package br.edu.ifnmg.view;

import br.edu.ifnmg.controller.Controller;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class View<E, K> {

    private Scanner scanner = new Scanner(System.in);

    private Controller<E, K> controller;

    public Controller<E, K> getController() {
        return controller;
    }

    public void setController(Controller<E, K> controller) {
        this.controller = controller;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public abstract E cadastrar();

    public abstract E cadastrar(Controller controller);

    public abstract void listar(ArrayList<E> entidades);

    public abstract void listar(ArrayList<E> entidades, long id);
}
