package br.sc.senac.dd.aula04.exercicio.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.sc.senac.dd.aula04.exercicio.model.bo.MotoBO;
import br.sc.senac.dd.aula04.exercicio.model.vo.MotoVO;

public class ControladoraMoto {
	
	public void cadastrarMotoController(MotoVO motoVO) throws SQLException {
		MotoBO motoBO = new MotoBO();
		motoBO.cadastrarMotoBO(motoVO);
	}

	public void excluirMotoController(MotoVO motoVO) throws SQLException {
		MotoBO motoBO = new MotoBO();
		motoBO.excluirMotoBO(motoVO);
	}

	public void atualizarMotoController(MotoVO motoVO) throws SQLException {
		MotoBO motoBO = new MotoBO();
		motoBO.atualizarMotoBO(motoVO);
	}

	public ArrayList<MotoVO> consultarTodosMotoesController() throws SQLException {
		MotoBO motoBO = new MotoBO();
		return motoBO.consultarMotosBO();
	}

	public MotoVO consultarMotoController(MotoVO motoVO) throws SQLException {
		MotoBO motoBO = new MotoBO();
		return motoBO.consultarMotoBO(motoVO);
	}

}
