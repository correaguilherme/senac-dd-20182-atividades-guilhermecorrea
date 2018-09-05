package br.sc.senac.dd.aula04.exercicio.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.sc.senac.dd.aula04.exercicio.model.dao.CaminhaoDAO;
import br.sc.senac.dd.aula04.exercicio.model.vo.CaminhaoVO;

public class CaminhaoBO {
	
	public void cadastrarCaminhaoBO(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		if(caminhaoDAO.existeRegistroPorChassi(caminhaoVO.getChassi())){
			JOptionPane.showMessageDialog(null, "\nCaminhão já Cadastrado");
		} else {
			int idCaminhao = caminhaoDAO.inserir(caminhaoVO);
			if(idCaminhao > 0){
				JOptionPane.showMessageDialog(null, "\nCaminhão cadastrado com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nNão foi possível cadastrar o Caminhão.");
			}
		}
	}

	public void excluirCaminhaoBO(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		if(caminhaoDAO.existeRegistroPorIdCaminhao(caminhaoVO.getId())){
			boolean excluiuCaminhao = caminhaoDAO.excluir(caminhaoVO.getId());
			if(excluiuCaminhao){
				JOptionPane.showMessageDialog(null, "\nCaminhão excluído com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nNão foi possível excluir o Caminhão.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nCaminhão não existe na base da dados.");
		}
	}

	public void atualizarCaminhaoBO(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		if(caminhaoDAO.existeRegistroPorIdCaminhao(caminhaoVO.getId())){
			boolean sucessoUpdate = caminhaoDAO.atualizar(caminhaoVO, caminhaoVO.getId());
			if(sucessoUpdate){
				JOptionPane.showMessageDialog(null, "\nCaminhão atualizado com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nNão foi possível atualizar o Caminhão.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nCaminhão ainda não foi cadastrado.");
		}
	}
	
	public ArrayList<CaminhaoVO> consultarCaminhaosBO() throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		ArrayList<CaminhaoVO> caminhaosVO = (ArrayList<CaminhaoVO>) caminhaoDAO.listarTodos();
		if(caminhaosVO.isEmpty()){
			JOptionPane.showMessageDialog(null, "\nLista de Caminhão não Localizado.");
		}
		return caminhaosVO;
	}

	public CaminhaoVO consultarCaminhaoBO(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		CaminhaoVO caminhao = caminhaoDAO.pesquisarPorId(caminhaoVO.getId());
		if(caminhao == null){
			JOptionPane.showMessageDialog(null, "\nCaminhão não Localizado.");
		}
		return caminhao;
	}


}
