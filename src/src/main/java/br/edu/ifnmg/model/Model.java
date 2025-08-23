package br.edu.ifnmg.model;
import br.edu.ifnmg.controller.Controller;
import br.edu.ifnmg.entity.Entidade;
import java.util.ArrayList;

public abstract class Model<E, K>  implements IModel<E, K> {

    private ArrayList<E> entidades;
    private Controller<E, K> controller;


    public Model(){
        entidades = new ArrayList<>();
    }

    public Controller<E, K> getController() {
        return controller;
    }

    public void setController(Controller<E, K> controller) {
        this.controller = controller;
    }

    @Override
    public K salvar(E entidade) {

        entidades.add(entidade);

        return (K) ((Entidade) entidade).getId();
    }

    @Override
    public K atualizar(E entidade) {
        for (E e : entidades) {
            if(((Entidade) e).getId().equals(((Entidade) entidade).getId())) {
                entidades.remove(e);
                entidades.add(entidade);
                break;
            }
        }

        return (K) ((Entidade) entidade).getId();
    }

    @Override
    public E localizarPorId(K id) {

        return entidades.stream().filter(e -> ((Entidade) e).getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public ArrayList<E> localizarTodos() {
        return new ArrayList<>(entidades);
    }

    @Override
    public void excluir(K id) {
        for (E e : entidades) {

            if(((Entidade) e).getId().equals(id)){
                entidades.remove(e);
                return;
            }
        }

        System.out.println("Não foi possível realizar a exclusão, verifique o id!");
    }

}