package br.edu.ifnmg.entity;

public abstract class Entidade {

    private Long id;

    public Entidade() {
    }

    public Entidade(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}