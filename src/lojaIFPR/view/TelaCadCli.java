package lojaIFPR.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
		
				
	}
}

