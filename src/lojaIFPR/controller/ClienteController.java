package lojaIFPR.controller;

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
	
}
