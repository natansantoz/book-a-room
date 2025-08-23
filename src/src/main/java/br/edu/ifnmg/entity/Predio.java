package br.edu.ifnmg.entity;

import java.util.ArrayList;

public class Predio extends Entidade {

    private String nome;
    private Campus campus;
    private ArrayList<SalaReuniao> salas;
    private static Long proximoId = 0L;

    public Predio() {
        super(++proximoId);
        salas = new ArrayList<SalaReuniao>();
    }

    public Predio(String nome) {
        super(++proximoId);
        this.nome = nome;
        salas = new ArrayList<SalaReuniao>();
    }

    public Predio(String nome, Campus campus) {
        super(++proximoId);
        this.nome = nome;
        this.campus = campus;
        salas = new ArrayList<SalaReuniao>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public ArrayList<SalaReuniao> getSalas() {
        return salas;
    }

    public void setSalas(ArrayList<SalaReuniao> salas) {
        this.salas = salas;
    }

    public void addSala(SalaReuniao sala) {
        this.salas.add(sala);
        sala.setPredio(this);
    }

}
