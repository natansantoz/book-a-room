package br.edu.ifnmg.model;

import br.edu.ifnmg.entity.Funcionario;
import java.util.ArrayList;

public class FuncionarioModel extends Model<Funcionario, Long>{

    public ArrayList<Funcionario> localizarPorIdDoCampus(long idCampus) {

        ArrayList<Funcionario> entidadesDoCampus = new ArrayList<>();

        for (Funcionario funcionario : localizarTodos()) {
            if(funcionario.getCampus().getId().equals(idCampus)){
                entidadesDoCampus.add(funcionario);
            }
        }

        return entidadesDoCampus;
    }
}