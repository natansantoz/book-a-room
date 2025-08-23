package br.edu.ifnmg.controller;

import br.edu.ifnmg.entity.Predio;
import br.edu.ifnmg.entity.Predio;
import br.edu.ifnmg.model.FuncionarioModel;
import br.edu.ifnmg.model.PredioModel;

import java.util.ArrayList;

public class PredioController extends Controller<Predio, Long> {

    public void listarPorCampus(long id) {
        ArrayList<Predio> entidades = ((PredioModel) getModel()).localizarPorIdDoCampus(id);
        getView().listar(entidades, id);
    }
}
