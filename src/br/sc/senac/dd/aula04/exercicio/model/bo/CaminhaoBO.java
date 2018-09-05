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
			JOptionPane.showMessageDialog(null, "\nCaminh�o j� Cadastrado");
		} else {
			int idCaminhao = caminhaoDAO.inserir(caminhaoVO);
			if(idCaminhao > 0){
				JOptionPane.showMessageDialog(null, "\nCaminh�o cadastrado com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel cadastrar o Caminh�o.");
			}
		}
	}

	public void excluirCaminhaoBO(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		if(caminhaoDAO.existeRegistroPorIdCaminhao(caminhaoVO.getId())){
			boolean excluiuCaminhao = caminhaoDAO.excluir(caminhaoVO.getId());
			if(excluiuCaminhao){
				JOptionPane.showMessageDialog(null, "\nCaminh�o exclu�do com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel excluir o Caminh�o.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nCaminh�o n�o existe na base da dados.");
		}
	}

	public void atualizarCaminhaoBO(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		if(caminhaoDAO.existeRegistroPorIdCaminhao(caminhaoVO.getId())){
			boolean sucessoUpdate = caminhaoDAO.atualizar(caminhaoVO, caminhaoVO.getId());
			if(sucessoUpdate){
				JOptionPane.showMessageDialog(null, "\nCaminh�o atualizado com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel atualizar o Caminh�o.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nCaminh�o ainda n�o foi cadastrado.");
		}
	}
	
	public ArrayList<CaminhaoVO> consultarCaminhaosBO() throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		ArrayList<CaminhaoVO> caminhaosVO = (ArrayList<CaminhaoVO>) caminhaoDAO.listarTodos();
		if(caminhaosVO.isEmpty()){
			JOptionPane.showMessageDialog(null, "\nLista de Caminh�o n�o Localizado.");
		}
		return caminhaosVO;
	}

	public CaminhaoVO consultarCaminhaoBO(CaminhaoVO caminhaoVO) throws SQLException {
		CaminhaoDAO caminhaoDAO = new CaminhaoDAO();
		CaminhaoVO caminhao = caminhaoDAO.pesquisarPorId(caminhaoVO.getId());
		if(caminhao == null){
			JOptionPane.showMessageDialog(null, "\nCaminh�o n�o Localizado.");
		}
		return caminhao;
	}


}
