package br.edu.ifnmg.entity;

import java.util.ArrayList;

public class SalaReuniao extends Entidade {

    private int numero;
    private int qtdLugares;
    private Predio predio;
    private ArrayList<Reserva> reservas;
    private static Long proximoId = 0L;


    public SalaReuniao() {
        super(++proximoId);
        reservas = new ArrayList<Reserva>();
    }

    public SalaReuniao(int numero, int qtdLugares, Predio predio) {
        super(++proximoId);
        this.numero = numero;
        this.qtdLugares = qtdLugares;
        this.predio = predio;
        this.reservas = new ArrayList<Reserva>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getQtdLugares() {
        return qtdLugares;
    }

    public void setQtdLugares(int qtdLugares) {
        this.qtdLugares = qtdLugares;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
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
