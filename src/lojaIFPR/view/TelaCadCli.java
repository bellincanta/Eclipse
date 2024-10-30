package lojaIFPR.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import lojaIFPR.controller.ClienteController;
import lojaIFPR.model.Cliente;

public class TelaCadCli extends JFrame {

	private static final long serialVersionUID = 5756598100844974336L;

	private JLabel nomeJLabel;
	private JTextField nomeJTxtField;
	private JLabel foneJLabel;
	private JTextField foneJTxtField;
	public JButton incluirBtn;
	public JButton limparBtn;
	public JButton cancelarBtn;
	public JButton consultarBtn;
	public JButton alterarBtn;
	public JButton excluirBtn;
	
	public TelaCadCli() {
		super("Cadastro de Clientes");

		nomeJLabel = new JLabel("Nome");
		nomeJTxtField = new JTextField();
		foneJLabel = new JLabel("Telefone");
		foneJTxtField = new JTextField();
		incluirBtn = new JButton("Incluir");
		alterarBtn = new JButton("Alterar");
		limparBtn = new JButton("Limpar");
		cancelarBtn = new JButton("Cancelar");
		consultarBtn = new JButton("Consultar");
		excluirBtn = new JButton("Excluir");
		

		setSize(450, 200);
		// setTitle("Cadastro de Clientes");
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		nomeJLabel.setBounds(10, 10, 100, 25);
		nomeJTxtField.setBounds(50, 10, 200, 25);
		foneJLabel.setBounds(10, 50, 100, 25);
		foneJTxtField.setBounds(70, 50, 200, 25);
		
		incluirBtn.setBounds(20,100,70,25);
		limparBtn.setBounds(80,100,70,25);
		cancelarBtn.setBounds(140,100,80,25);
		consultarBtn.setBounds(210,100,90,25);
		alterarBtn.setBounds(290,100,80,25);
		excluirBtn.setBounds(360,100,80,25);
		

		add(nomeJLabel);
		add(nomeJTxtField);
		add(foneJLabel);
		add(foneJTxtField);
		add(incluirBtn);
		add(limparBtn);
		add(cancelarBtn);
		add(consultarBtn);
		add(alterarBtn);
		add(excluirBtn);
		
		alterarBtn.setEnabled(false);
		excluirBtn.setEnabled(false);
		//incluirBtn.setEnabled(false);
		
		incluirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteController clienteController = new ClienteController();
					clienteController.cadastrarCliente(nomeJTxtField.getText(), foneJTxtField.getText());
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso");
					limparCampos();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
				}
				
			}
		});
		
		consultarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteController clienteController = new ClienteController();
					Cliente cliente = clienteController.consultarCliente(nomeJTxtField.getText());
					if (cliente != null) {
						nomeJTxtField.setText(cliente.getNome());
						foneJTxtField.setText(cliente.getTelefone());
						alterarBtn.setEnabled(true);
						excluirBtn.setEnabled(true);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
				}
				
			}
		});
		
		alterarBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteController clienteController = new ClienteController();
					int codCli = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do cliente"));
					clienteController.alterarCliente(codCli, nomeJTxtField.getText(), foneJTxtField.getText());
					JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
				}
			}
		});
		
		limparBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nomeJTxtField.setText("");
				foneJTxtField.setText("");
			}
		});
		
		excluirBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteController clienteController = new ClienteController();
					int codCli = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do cliente a ser excluído: " ));
					clienteController.excluirCliente(codCli);
					JOptionPane.showMessageDialog(null,"Cliente excluído com sucesso!");
					limparCampos();
				} catch (Exception ex){
					JOptionPane.showInputDialog("null", "Erro: " + ex.getMessage());
				}
			}
		});
		
		
	}
	private void limparCampos() {
		nomeJTxtField.setText("");
		foneJTxtField.setText("");
		alterarBtn.setEnabled(true);
		excluirBtn.setEnabled(true);
	}
}

