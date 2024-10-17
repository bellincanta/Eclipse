package lojaIFPR.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
