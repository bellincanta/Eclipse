package lojaIFPR.controller;


import java.sql.SQLException;

import lojaIFPR.dao.ClienteDAO;
import lojaIFPR.dao.ExceptionDAO;

public class LoginController {
    private ClienteDAO clienteDAO;

    public LoginController() {
        this.clienteDAO = new ClienteDAO();
    }

    public boolean autenticar(String username, String password) throws SQLException {
        try {
            return clienteDAO.autenticarUsuario(username, password);
        } catch (ExceptionDAO e) {
            System.out.println("Erro ao autenticar usuário: " + e.getMessage());
            return false;
        }
    }
}



