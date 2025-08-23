package br.edu.ifnmg.entity;

import java.util.ArrayList;

public class Campus extends Entidade {

    private String nome;
    private String endereco;
    ArrayList<Predio> predios;
    ArrayList<Funcionario> funcionarios;
    private static Long proximoId = 0L;

    public Campus() {
        super(++proximoId);
        predios = new ArrayList<Predio>();
        funcionarios = new ArrayList<Funcionario>();
    }

    public Campus(String nome, String endereco) {
        super(++proximoId);
        this.nome = nome;
        this.endereco = endereco;
        predios = new ArrayList<Predio>();
        funcionarios = new ArrayList<Funcionario>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Predio> getPredios() {
        return predios;
    }

    public void setPredios(ArrayList<Predio> predios) {
        this.predios = predios;
    }

    public void addPredio(Predio predio) {
        this.predios.add(predio);
        predio.setCampus(this);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        funcionario.setCampus(this);
    }

}
