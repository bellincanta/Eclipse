package lojaIFPR.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lojaIFPR.dao.ConexaoBD;
import lojaIFPR.dao.ExceptionDAO;
import lojaIFPR.model.Cliente;

public class ClienteDAO {

	public void cadastrarCliente(Cliente cliente)throws ExceptionDAO {
		String sql = "insert into cliente (nome, telefone) values (?,?)";
		PreparedStatement stmt = null;
		Connection connection = null;
		try {
			connection = new ConexaoBD().getConnection();
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao cadastrar cliente: " + e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean autenticarUsuario(String username, String password) throws ExceptionDAO, SQLException {
	    Connection connection = null;
	    PreparedStatement pStatement = null;
	    ResultSet rs = null;

	    try {
	        connection = new ConexaoBD().getConnection();
	        String sql = "SELECT * FROM Usuario WHERE username = ? AND password = ?";
	        pStatement = connection.prepareStatement(sql);
	        pStatement.setString(1, username);
	        pStatement.setString(2, password);
	        rs = pStatement.executeQuery();

	        return rs.next(); // Retorna true se encontrar o usuário
	    } catch (SQLException e) {
	        throw new ExceptionDAO("Erro ao autenticar usuário: " + e.getMessage());
	    } finally {
	        if (rs != null) rs.close();
	        if (pStatement != null) pStatement.close();
	        if (connection != null) connection.close();
	    }
	}
}
