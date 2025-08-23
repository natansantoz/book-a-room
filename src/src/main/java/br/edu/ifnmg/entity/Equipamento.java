package br.edu.ifnmg.entity;

import java.util.ArrayList;

public class Equipamento extends Entidade {

    private String nome;
    private String patrimonio;
    private ArrayList<Reserva> reservas;
    private static Long proximoId = 0L;

    public Equipamento() {
        super(++proximoId);
        reservas = new ArrayList<Reserva>();
    }

    public Equipamento(String nome, String patrimonio) {
        super(++proximoId);
        this.nome = nome;
        this.patrimonio = patrimonio;
        reservas = new ArrayList<Reserva>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }
}
