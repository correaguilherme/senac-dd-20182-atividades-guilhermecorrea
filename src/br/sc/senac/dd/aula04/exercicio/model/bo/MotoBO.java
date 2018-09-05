package br.sc.senac.dd.aula04.exercicio.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.sc.senac.dd.aula04.exercicio.model.dao.MotoDAO;
import br.sc.senac.dd.aula04.exercicio.model.vo.MotoVO;

public class MotoBO {

	public void cadastrarMotoBO(MotoVO motoVO) throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		if(motoDAO.existeRegistroPorChassi(motoVO.getChassi())){
			JOptionPane.showMessageDialog(null, "\nMoto j� Cadastrada");
		} else {
			int idMoto = motoDAO.inserir(motoVO);
			if(idMoto > 0){
				JOptionPane.showMessageDialog(null, "\nMoto cadastrada com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel cadastrar a Moto.");
			}
		}
	}

	public void excluirMotoBO(MotoVO motoVO) throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		if(motoDAO.existeRegistroPorIdMoto(motoVO.getId())){
			boolean excluiuMoto = motoDAO.excluir(motoVO.getId());
			if(excluiuMoto){
				JOptionPane.showMessageDialog(null, "\nMoto exclu�da com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel excluir a Moto.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nMoto n�o existe na base da dados.");
		}
	}

	public void atualizarMotoBO(MotoVO motoVO) throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		if(motoDAO.existeRegistroPorIdMoto(motoVO.getId())){
			boolean sucessoUpdate = motoDAO.atualizar(motoVO, motoVO.getId());
			if(sucessoUpdate){
				JOptionPane.showMessageDialog(null, "\nMoto atualizada com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel atualizar a Moto.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nMoto ainda n�o foi cadastrada.");
		}
	}
	
	public ArrayList<MotoVO> consultarMotosBO() throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		ArrayList<MotoVO> motosVO = (ArrayList<MotoVO>) motoDAO.listarTodos();
		if(motosVO.isEmpty()){
			JOptionPane.showMessageDialog(null, "\nLista de Moto n�o Localizada.");
		}
		return motosVO;
	}

	public MotoVO consultarMotoBO(MotoVO motoVO) throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		MotoVO moto = motoDAO.pesquisarPorId(motoVO.getId());
		if(moto == null){
			JOptionPane.showMessageDialog(null, "\nMoto n�o Localizada.");
		}
		return moto;
	}

	
}
