package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import br.sc.senac.dd.aula04.exercicio.model.bo.CarroBO;
import br.sc.senac.dd.aula04.exercicio.model.vo.CarroVO;

public class ControladoraCarro {

	public void cadastrarCarroController(CarroVO carroVO) throws SQLException {
		CarroBO carroBO = new CarroBO();
		carroBO.cadastrarCarroBO(carroVO);
	}

	public void excluirCarroController(CarroVO carroVO) throws SQLException {
		CarroBO carroBO = new CarroBO();
		carroBO.excluirCarroBO(carroVO);
	}

	public void atualizarCarroController(CarroVO carroVO) throws SQLException {
		CarroBO carroBO = new CarroBO();
		carroBO.atualizarCarroBO(carroVO);
	}

	public ArrayList<CarroVO> consultarTodosCarroesController() throws SQLException {
		CarroBO carroBO = new CarroBO();
		return carroBO.consultarCarrosBO();
	}

	public CarroVO consultarCarroController(CarroVO carroVO) throws SQLException {
		CarroBO carroBO = new CarroBO();
		return carroBO.consultarCarroBO(carroVO);
	}

}
