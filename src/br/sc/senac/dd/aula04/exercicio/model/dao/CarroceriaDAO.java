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
		return "CAPACIDADECARGAQUILOS";
	}

	@Override
	public String getInterrogacoesInsert() {
		return "?";
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
			preparedStmt.setDouble(1, entidade.getCapacidadeCargaQuilos());
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
		 clausulaSet += "CAPACIDADECARGAQUILOS ='" + entidade.getCapacidadeCargaQuilos() + "'";

		return null;
	}

	@Override
	public CarroceriaVO construirObjetoDoResultSet(ResultSet resultado) {

		CarroceriaVO carroceria = new CarroceriaVO();
		try {
			carroceria.setCapacidadeCargaQuilos(Double.parseDouble(resultado.getString(1)));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carroceria;
	}

	public boolean existeRegistroPorId(int Id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM carroceria WHERE id like '" + Id + "'";
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
		String query = "SELECT * FROM carroceria WHERE idCarroceria = " + idCarroceria;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Carroceria por Id.");
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

