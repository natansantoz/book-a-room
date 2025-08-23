package br.edu.ifnmg.model;

import java.util.List;

public interface IModel <E, K> {

    public abstract K salvar(E entidade);


    public abstract K atualizar(E entidade);


    public abstract E localizarPorId(K id);


    public abstract List<E> localizarTodos();


    public abstract void excluir(K id);

}
