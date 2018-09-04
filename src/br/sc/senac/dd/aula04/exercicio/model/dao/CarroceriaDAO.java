package br.sc.senac.dd.aula04.exercicio.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.sc.senac.dd.aula04.exercicio.model.vo.CarroceriaVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um Data Access Object (DAO) da classe CarroceriaVO.
 * 
 * @author Adriano de Melo
 *  	   Vilmar César Pereira Júnior (continuação em Desenvolvimento Desktop 2018/2)
 * 
 */
public class CarroceriaDAO extends BaseDAO<CarroceriaVO> {

	@Override
	public String getNomeTabela() {
		return "CARROCERIA";
	}

	@Override
	public String getNomeColunaChavePrimaria() {
		return "IDCARROCERIA";
	}

	@Override
	public String getNomesColunasInsert() {
		return "MARCA, MODELO, ANOFABRICACAO, CHASSI";
	}

	@Override
	public String getInterrogacoesInsert() {
		return "?, ?, ?, ?";
	}

	@Override
	public void setValoresAtributosInsert(CarroceriaVO entidade, PreparedStatement preparedStmt) {
		// TODO Auto-generated method stub
		/**
		 * Exemplos:
		 * preparedStmt.setInt(1, entidade.getId());  
		 * preparedStmt.setString(2, entidade.getMarca());
		 *  
		 */
		try {
			preparedStmt.setString(1, entidade.getMarca());
			preparedStmt.setString(2, entidade.getModelo());
			preparedStmt.setString(3, entidade.getAnoFabricacao());
			preparedStmt.setString(4, entidade.getChassi());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getValoresClausulaSetUpdate(CarroceriaVO entidade) {
		// TODO Auto-generated method stub

		/**
		 * Exemplos:
		 * 
		 * String clausulaSet = "";
		 * clausulaSet = getMarcaColunaChavePrimaria() " = " + entidade.getIdCarroceria() + ",";
		 * clausulaSet += "NOME ='" + entidade.getMarca() + "'";
		 */
		
		String clausulaSet = "";
		 clausulaSet = getNomeColunaChavePrimaria() + " = " + entidade.getId() + ",";
		 clausulaSet += "MARCA ='" + entidade.getMarca() + "'";
		 clausulaSet += "MODELO ='" + entidade.getModelo() + "'";
		 clausulaSet += "ANOFABRICACAO ='" + entidade.getAnoFabricacao() + "'";
		 clausulaSet += "CHASSI ='" + entidade.getChassi() + "'";

		return null;
	}

	@Override
	public CarroceriaVO construirObjetoDoResultSet(ResultSet resultado) {

		CarroceriaVO carro = new CarroceriaVO();
		try {
			carro.setId(Integer.parseInt(resultado.getString(1)));
			carro.setMarca(resultado.getString(2));
			carro.setModelo(resultado.getString(3));
			carro.setAnoFabricacao(resultado.getString(4));
			carro.setChassi(resultado.getString(5));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carro;
	}

	public boolean existeRegistroPorId(int Id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM moto WHERE id like '" + Id + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Carroceria por ID.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean existeRegistroPorIdCarroceria(int idCarroceria) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM moto WHERE idCarroceria = " + idCarroceria;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Registro por Id.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	@Override
	public void setValoresAtributosUpdate(CarroceriaVO entidade, PreparedStatement stmt) {
		// TODO Auto-generated method stub

	}
}

