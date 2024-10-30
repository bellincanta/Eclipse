package lojaIFPR.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lojaIFPR.model.Cliente;

public class ClienteDAO {

	public void cadastrarCliente(Cliente cliente)throws ExceptionDAO {
		String sql = "insert into Cliente (nome, telefone) values (?,?)";
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
	
	public Cliente consultarCliente(String nome)throws ExceptionDAO {
		String sql = "select * from Cliente where nome = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1,nome);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodCli(rs.getInt("codCli"));
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				return cliente;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao consultar cliente: " + e);
		} 
		return null;
	}
	
	public void alterarCliente(Cliente cliente)throws ExceptionDAO {
		String sql = "update Cliente set nome = ?, telefone = ? where codCli = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1,cliente.getNome());
			stmt.setString(2,cliente.getTelefone());
			stmt.setInt(3,cliente.getCodCli());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao alterar cliente: " + e);
		} 
	}
	
	public void excluirCliente(int codCli)throws ExceptionDAO {
		String sql = "delete from Cliente where codCli = ?";
		try (Connection connection = new ConexaoBD().getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1,codCli);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ExceptionDAO("Erro ao excluir cliente: " + e);
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
