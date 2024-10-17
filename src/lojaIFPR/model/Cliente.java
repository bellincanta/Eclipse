package lojaIFPR.model;

import java.util.ArrayList;

import lojaIFPR.dao.ClienteDAO;
import lojaIFPR.dao.ExceptionDAO;

public class Cliente {
	private int codCli;
	private String nome;
	private String telefone;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public int getCodCli () {
		return codCli;
	}
	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void cadastrarCliente(Cliente cliente) throws ExceptionDAO{
		new ClienteDAO().cadastrarCliente(cliente);
	}

}
