package br.sc.senac.dd.aula04.exercicio.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.sc.senac.dd.aula04.exercicio.model.dao.CarroDAO;
import br.sc.senac.dd.aula04.exercicio.model.vo.CarroVO;

public class CarroBO {

	public void cadastrarCarroBO(CarroVO carroVO) throws SQLException {
		CarroDAO carroDAO = new CarroDAO();
		if(carroDAO.existeRegistroPorChassi(carroVO.getChassi())){
			JOptionPane.showMessageDialog(null, "\nCarro j� Cadastrado");
		} else {
			int idCarro = carroDAO.inserir(carroVO);
			if(idCarro > 0){
				JOptionPane.showMessageDialog(null, "\nCarro cadastrado com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel cadastrar o Carro.");
			}
		}
	}

	public void excluirCarroBO(CarroVO carroVO) throws SQLException {
		CarroDAO carroDAO = new CarroDAO();
		if(carroDAO.existeRegistroPorIdCarro(carroVO.getId())){
			boolean excluiuCarro = carroDAO.excluir(carroVO.getId());
			if(excluiuCarro){
				JOptionPane.showMessageDialog(null, "\nCarro exclu�do com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel excluir o Carro.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nCarro n�o existe na base da dados.");
		}
	}

	public void atualizarCarroBO(CarroVO carroVO) throws SQLException {
		CarroDAO carroDAO = new CarroDAO();
		if(carroDAO.existeRegistroPorIdCarro(carroVO.getId())){
			boolean sucessoUpdate = carroDAO.atualizar(carroVO, carroVO.getId());
			if(sucessoUpdate){
				JOptionPane.showMessageDialog(null, "\nCarro atualizado com Sucesso.");
			} else {
				JOptionPane.showMessageDialog(null, "\nN�o foi poss�vel atualizar o Carro.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "\nCarro ainda n�o foi cadastrado.");
		}
	}
	
	public ArrayList<CarroVO> consultarCarrosBO() throws SQLException {
		CarroDAO carroDAO = new CarroDAO();
		ArrayList<CarroVO> carrosVO = (ArrayList<CarroVO>) carroDAO.listarTodos();
		if(carrosVO.isEmpty()){
			JOptionPane.showMessageDialog(null, "\nLista de Carro n�o Localizada.");
		}
		return carrosVO;
	}

	public CarroVO consultarCarroBO(CarroVO carroVO) throws SQLException {
		CarroDAO carroDAO = new CarroDAO();
		CarroVO carro = carroDAO.pesquisarPorId(carroVO.getId());
		if(carro == null){
			JOptionPane.showMessageDialog(null, "\nCarro n�o Localizado.");
		}
		return carro;
	}

}