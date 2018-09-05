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
			JOptionPane.showMessageDialog(null, "\nMoto já Cadastrada");
		} else {
			int idMoto = motoDAO.inserir(motoVO);
			if(idMoto > 0){
				JOptionPane.showMessageDialog(null, "\nMoto cadastrada com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nNão foi possível cadastrar a Moto.");
			}
		}
	}

	public void excluirMotoBO(MotoVO motoVO) throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		if(motoDAO.existeRegistroPorIdMoto(motoVO.getId())){
			boolean excluiuMoto = motoDAO.excluir(motoVO.getId());
			if(excluiuMoto){
				JOptionPane.showMessageDialog(null, "\nMoto excluída com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nNão foi possível excluir a Moto.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nMoto não existe na base da dados.");
		}
	}

	public void atualizarMotoBO(MotoVO motoVO) throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		if(motoDAO.existeRegistroPorIdMoto(motoVO.getId())){
			boolean sucessoUpdate = motoDAO.atualizar(motoVO, motoVO.getId());
			if(sucessoUpdate){
				JOptionPane.showMessageDialog(null, "\nMoto atualizada com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nNão foi possível atualizar a Moto.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nMoto ainda não foi cadastrada.");
		}
	}
	
	public ArrayList<MotoVO> consultarMotosBO() throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		ArrayList<MotoVO> motosVO = (ArrayList<MotoVO>) motoDAO.listarTodos();
		if(motosVO.isEmpty()){
			JOptionPane.showMessageDialog(null, "\nLista de Moto não Localizada.");
		}
		return motosVO;
	}

	public MotoVO consultarMotoBO(MotoVO motoVO) throws SQLException {
		MotoDAO motoDAO = new MotoDAO();
		MotoVO moto = motoDAO.pesquisarPorId(motoVO.getId());
		if(moto == null){
			JOptionPane.showMessageDialog(null, "\nMoto não Localizada.");
		}
		return moto;
	}

	
}
