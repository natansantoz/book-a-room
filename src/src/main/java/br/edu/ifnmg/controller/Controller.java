package br.edu.ifnmg.controller;

import br.edu.ifnmg.entity.Campus;
import br.edu.ifnmg.entity.Predio;
import br.edu.ifnmg.model.IModel;
import br.edu.ifnmg.model.Model;
import br.edu.ifnmg.view.View;

import java.util.ArrayList;

public abstract class Controller<E, K> implements IController {

    private Model<E, K> model;
    private View<E, K> view;

    public Controller() {
    }

    public Controller(Model<E, K> model, View<E, K> view) {
        this.model = model;
        this.view = view;
    }

    public Model<E, K> getModel() {
        return model;
    }

    public void setModel(Model<E, K> model) {
        this.model = model;
        model.setController(this);
    }

    public View<E, K> getView() {
        return view;
    }

    public void setView(View<E, K>  view) {
        this.view = view;
        view.setController(this);
    }

    public void cadastrar() {
        E entidade = (E) getView().cadastrar();
        getModel().salvar(entidade);
    }

    public void listar() {
        ArrayList<E> entidades = getModel().localizarTodos();
        getView().listar(entidades);
    }

    public void cadastrar(Controller controller) {
        E entidade =  getView().cadastrar(controller);

        if (entidade != null) {
            getModel().salvar(entidade);
        }
    }

    @Override
    public void listar(long id) {
        ArrayList<E> entidades = getModel().localizarTodos();
        getView().listar(entidades, id);
    }

}
