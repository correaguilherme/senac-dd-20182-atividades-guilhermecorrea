package br.sc.senac.dd.aula04.exercicio.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.sc.senac.dd.aula04.exercicio.model.vo.CaminhaoVO;

/**
 * Classe criada na disciplina de POO (2018/1)
 * 
 * Representa um Data Access Object (DAO) da classe CaminhaoVO.
 * 
 * @author Adriano de Melo
 *  	   Vilmar César Pereira Júnior (continuação em Desenvolvimento Desktop 2018/2)
 * 
 */
public class CaminhaoDAO extends BaseDAO<CaminhaoVO> {

    private String CaminhaoVO;

	@Override
	public String getNomeTabela() {
		return "CAMINHAO";
	}

	@Override
	public String getNomeColunaChavePrimaria() {
		return "IDCAMINHAO";
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
	public void setValoresAtributosInsert(CaminhaoVO entidade, PreparedStatement preparedStmt) {
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
	public String getValoresClausulaSetUpdate(CaminhaoVO entidade) {
		// TODO Auto-generated method stub

		/**
		 * Exemplos:
		 * 
		 * String clausulaSet = "";
		 * clausulaSet = getMarcaColunaChavePrimaria() " = " + entidade.getIdCaminhao() + ",";
		 * clausulaSet += "NOME ='" + entidade.getMarca() + "'";
		 */
		
		String clausulaSet = "";
		 clausulaSet = getNomeColunaChavePrimaria() + " = " + entidade.getId() + ",";
		 clausulaSet += "MARCA ='" + entidade.getMarca() + "'";
		 clausulaSet += "MODELO ='" + entidade.getModelo() + "'";
		 clausulaSet += "ANOFABRICACAO ='" + entidade.getAnoFabricacao() + "'";
		 clausulaSet += "CHASSI ='" + entidade.getChassi() + "'";

		return CaminhaoVO;
	}
        
        @Override
	public void setValoresAtributosUpdate(CaminhaoVO entidade, PreparedStatement preparedStmt) {
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
	public CaminhaoVO construirObjetoDoResultSet(ResultSet resultado) {

		CaminhaoVO carro = new CaminhaoVO();
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

	public boolean existeRegistroPorChassi(String chassi) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM caminhao WHERE chassi like '" + chassi + "'";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Caminhao por Chassi.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public boolean existeRegistroPorIdCaminhao(int idCaminhao) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM caminhao WHERE idCaminhao = " + idCaminhao;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existência de Caminhao por Id.");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}
        
}

