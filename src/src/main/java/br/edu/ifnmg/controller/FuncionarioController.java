package br.edu.ifnmg.controller;

import br.edu.ifnmg.entity.Funcionario;
import br.edu.ifnmg.entity.Predio;
import br.edu.ifnmg.entity.SalaReuniao;
import br.edu.ifnmg.model.FuncionarioModel;

import java.util.ArrayList;

public class FuncionarioController extends Controller<Funcionario, Long> {

    public void listarPorCampus(long id) {
        ArrayList<Funcionario> entidades = ((FuncionarioModel) getModel()).localizarPorIdDoCampus(id);
        getView().listar(entidades, id);
    }
}
