package br.edu.ifnmg.view;

import br.edu.ifnmg.controller.*;
import br.edu.ifnmg.entity.Reserva;

import java.util.ArrayList;
import java.util.Map;


public interface IReservaView {

    default Object[] verificarDisponibilidade(ArrayList<Reserva> reservas, SalaReuniaoController salaReuniaoController, long idCampus) {
        throw new UnsupportedOperationException("Não implementado.");
    }

    default void obterSituacaoReserva(long idCampus) {
        throw new UnsupportedOperationException("Não implementado.");
    }

    default void verificarReservasNumPeriodo(long idCampus) {
        throw new UnsupportedOperationException("Não implementado.");
    }

    default Reserva  cadastrar(
            SalaReuniaoController salaReuniaoController,
            FuncionarioController funcionarioController,
            EquipamentoController equipamentoController,
            CampusController campusController
    ) {

        throw new UnsupportedOperationException("Não implementado.");
    }

}
