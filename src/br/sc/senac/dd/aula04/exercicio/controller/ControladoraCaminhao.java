package br.sc.senac.dd.aula04.exercicio.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.sc.senac.dd.aula04.exercicio.model.bo.CaminhaoBO;
import br.sc.senac.dd.aula04.exercicio.model.vo.CaminhaoVO;

public class ControladoraCaminhao {
	
	public void cadastrarCaminhaoController(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoBO caminhaoBO = new CaminhaoBO();
		caminhaoBO.cadastrarCaminhaoBO(caminhaoVO);
	}

	public void excluirCaminhaoController(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoBO caminhaoBO = new CaminhaoBO();
		caminhaoBO.excluirCaminhaoBO(caminhaoVO);
	}

	public void atualizarCaminhaoController(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoBO caminhaoBO = new CaminhaoBO();
		caminhaoBO.atualizarCaminhaoBO(caminhaoVO);
	}

	public ArrayList<CaminhaoVO> consultarTodosCaminhaoesController() throws SQLException {
		CaminhaoBO caminhaoBO = new CaminhaoBO();
		return caminhaoBO.consultarCaminhaosBO();
	}

	public CaminhaoVO consultarCaminhaoController(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoBO caminhaoBO = new CaminhaoBO();
		return caminhaoBO.consultarCaminhaoBO(caminhaoVO);
	}

}
