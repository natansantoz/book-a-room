package br.edu.ifnmg.controller;

import br.edu.ifnmg.entity.Entidade;
import br.edu.ifnmg.entity.SalaReuniao;

import java.util.ArrayList;

public interface IController {

    default void cadastrar(
            SalaReuniaoController salaReuniaoController,
            FuncionarioController funcionarioController,
            EquipamentoController equipamentoController,
            CampusController campusController
    ) {
        throw new UnsupportedOperationException("Não implementado.");
    }

    default void cadastrar(Controller controller) {
        throw new UnsupportedOperationException("Não implementado.");
    }

    default void listar(long id) {
        throw new UnsupportedOperationException("Não implementado.");
    }


}
