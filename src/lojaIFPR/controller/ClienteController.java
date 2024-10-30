package lojaIFPR.controller;

import lojaIFPR.dao.ClienteDAO;
import lojaIFPR.model.Cliente;


public class ClienteController {
	
	public void cadastrarCliente(String nome, String telefone) throws Exception{
		if (nome != null && nome.length() > 0 && telefone != null && telefone.length() > 0) {
			Cliente cliente = new Cliente(nome, telefone);
			cliente.cadastrarCliente(cliente);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
	public Cliente consultarCliente(String nome) throws Exception{
		if (nome != null && nome.length() > 0) {
			Cliente cliente = new ClienteDAO().consultarCliente(nome);
			return cliente;
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
	public void alterarCliente(int codCli, String nome, String telefone) throws Exception{
		if (nome != null && nome.length() > 0 && telefone != null && telefone.length() > 0) { 
			Cliente cliente = new Cliente(nome, telefone);
			cliente.setCodCli(codCli);
			cliente.alterarCliente(cliente);
		} else {
			throw new Exception("Preencha os campos corretamente!");
		}
	}
	
	public void excluirCliente(int codCli) throws Exception{
		if (codCli > 0) {
			Cliente cliente = new Cliente();
			cliente.excluirCliente(codCli);
		} else {
			throw new Exception("ID do cliente é inválido!");
		}
	}
}
