package br.edu.ifnmg.controller;


import br.edu.ifnmg.entity.SalaReuniao;
import br.edu.ifnmg.model.SalaReuniaoModel;

import java.util.ArrayList;

public class SalaReuniaoController extends Controller<SalaReuniao, Long> {

    public void listarPorCampus(long id) {
        ArrayList<SalaReuniao> entidades = ((SalaReuniaoModel) getModel()).localizarPorIdDoCampus(id);
        getView().listar(entidades, id);
    }

}
