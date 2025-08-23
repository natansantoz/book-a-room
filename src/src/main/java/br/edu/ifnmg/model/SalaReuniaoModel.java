package br.edu.ifnmg.model;

import br.edu.ifnmg.controller.PredioController;
import br.edu.ifnmg.entity.SalaReuniao;

import java.util.ArrayList;

public class SalaReuniaoModel extends Model<SalaReuniao, Long>{

    public ArrayList<SalaReuniao> localizarPorIdDoCampus(long id) {

        ArrayList<SalaReuniao> entidadesDoCampus = new ArrayList<>();

        for (SalaReuniao salaReuniao : localizarTodos()) {
            if(salaReuniao.getPredio().getCampus().getId().equals(id)){
                entidadesDoCampus.add(salaReuniao);
            }
        }

        return entidadesDoCampus;
    }
}
