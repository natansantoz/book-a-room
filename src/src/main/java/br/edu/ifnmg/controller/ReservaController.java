package br.edu.ifnmg.controller;

import br.edu.ifnmg.entity.Reserva;
import br.edu.ifnmg.entity.SalaReuniao;
import br.edu.ifnmg.model.ReservaModel;
import br.edu.ifnmg.view.IReservaView;

import java.util.ArrayList;
import java.util.Map;

public class ReservaController extends Controller<Reserva, Long> {

    public void verificarDisponibilidade(SalaReuniaoController salaReuniaoController, long idCampus) {
        IReservaView view = (IReservaView) getView();
        view.verificarDisponibilidade(getModel().localizarTodos(), salaReuniaoController, idCampus);
    }

    public void obterSituacaoReserva(long idCampus) {
        IReservaView view = (IReservaView) getView();
        view.obterSituacaoReserva(idCampus);
    }

    public void verificarReservasNumPeriodo(long idCampus) {
        ArrayList<Reserva> reservas = getModel().localizarTodos();
        IReservaView view = (IReservaView) getView();
        view.verificarReservasNumPeriodo(idCampus);
    }

    @Override
    public void cadastrar(
            SalaReuniaoController salaReuniaoController,
            FuncionarioController funcionarioController,
            EquipamentoController equipamentoController,
            CampusController campusController
    ) {
        IReservaView view = (IReservaView) getView();
        Reserva reserva = view.cadastrar(salaReuniaoController, funcionarioController, equipamentoController, campusController);

        if (reserva != null) {
            getModel().salvar(reserva);
        }
    }



    public void listarPorCampus(long id) {
        ArrayList<Reserva> entidades = ((ReservaModel) getModel()).localizarPorIdDoCampus(id);
        getView().listar(entidades, id);
    }
}
