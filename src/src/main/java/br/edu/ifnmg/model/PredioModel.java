package br.edu.ifnmg.model;

import br.edu.ifnmg.controller.CampusController;
import br.edu.ifnmg.entity.Predio;

import java.util.ArrayList;

public class PredioModel extends Model<Predio, Long>{

    public ArrayList<Predio> localizarPorIdDoCampus(long idCampus) {

        ArrayList<Predio> entidadesDoCampus = new ArrayList<>();

        for (Predio predio : localizarTodos()) {
            if(predio.getCampus().getId().equals(idCampus)){
                entidadesDoCampus.add(predio);
            }
        }

        return entidadesDoCampus;
    }
}
