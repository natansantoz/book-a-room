package br.edu.ifnmg.entity;

import java.util.ArrayList;

public class Funcionario extends Entidade{

    private String nome;
    private String cargo;
    private long ramal;
    private Campus campus;
    private ArrayList<Reserva> reservas;
    private static Long proximoId = 0L;

    public Funcionario() {
        super(++proximoId);
        reservas = new ArrayList<Reserva>();
    }

    public Funcionario(String nome, String cargo, long ramal, Campus campus) {
        super(++proximoId);
        this.nome = nome;
        this.cargo = cargo;
        this.ramal = ramal;
        this.campus = campus;
        reservas = new ArrayList<Reserva>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getRamal() {
        return ramal;
    }

    public void setRamal(long ramal) {
        this.ramal = ramal;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
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


