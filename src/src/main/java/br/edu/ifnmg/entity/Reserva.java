package br.edu.ifnmg.entity;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Reserva extends Entidade {

    private LocalDate dataAlocacao;
    private Time horaInicio;
    private Time horaFim;
    private String assunto;
    private Funcionario solicitante;
    private SalaReuniao salaReuniao;
    private ArrayList<Equipamento> equipamentos;
    private static Long proximoId = 0L;

    public Reserva() {
        super(++proximoId);
        equipamentos = new ArrayList<Equipamento>();
    }
    public Reserva(LocalDate dataAlocacao, Time horaInicio, Time horaFim, String assunto,
                   Funcionario solicitante, SalaReuniao salaReuniao) {

        super(++proximoId);

        this.dataAlocacao = dataAlocacao;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.assunto = assunto;
        this.solicitante = solicitante;
        this.salaReuniao = salaReuniao;
        equipamentos = new ArrayList<Equipamento>();
    }

    public Reserva(Date dataReserva, Time horaInicio, Time horaTermino, String assunto, Funcionario funcionario) {
    }

    public LocalDate getDataAlocacao() {
        return dataAlocacao;
    }

    public void setDataAlocacao(LocalDate dataAlocacao) {
        this.dataAlocacao = dataAlocacao;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Funcionario solicitante) {
        this.solicitante = solicitante;
        solicitante.addReserva(this);
    }

    public SalaReuniao getSalaReuniao() {
        return salaReuniao;
    }

    public void setSalaReuniao(SalaReuniao salaReuniao) {
        this.salaReuniao = salaReuniao;
        salaReuniao.addReserva(this);
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public void addEquipamento(Equipamento equipamento) {
        this.equipamentos.add(equipamento);
        equipamento.addReserva(this);
    }

    public String exibirEquipamentos() {
        StringBuilder equipamentos = new StringBuilder();

        for(int i = 0; i < this.equipamentos.size(); i++) {
            if (i == this.equipamentos.size() - 1) {
                equipamentos.append(this.equipamentos.get(i).getNome());
            } else {
                equipamentos.append(this.equipamentos.get(i).getNome()).append(", ");
            }
        }

        return equipamentos.toString();
    }


}
