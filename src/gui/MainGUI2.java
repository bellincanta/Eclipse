package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI2 extends JFrame {

    private static final long serialVersionUID = 4054127033268274948L;
	// Componentes da interface gráfica
    private JTextField textField;
    private JLabel labelOutput;
    private JCheckBox checkBox;
    private JComboBox<String> comboBox;

    // Construtor da GUI
    public MainGUI2() {
        setTitle("Exemplo com Eventos de Focus e Janela");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurando o layout
        setLayout(new FlowLayout());

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5));

        // Componentes
        JLabel label = new JLabel("Digite seu nome:");
        textField = new JTextField(10);
        JButton button = new JButton("Enviar");
        checkBox = new JCheckBox("Consentimento para receber emails");
        String[] statusItems = {"Estudante", "Professor", "Outro"};
        comboBox = new JComboBox<>(statusItems);
        labelOutput = new JLabel("");

        // Adiciona componentes ao painel
        panel.add(label);
        panel.add(textField);
        panel.add(checkBox);
        panel.add(comboBox);
        panel.add(button);
        panel.add(labelOutput);

        // Adiciona o painel à janela
        add(panel);

        // Tratamento de eventos

        // Evento de clique no botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick();
            }
        });

        // Evento de foco no campo de texto
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                labelOutput.setText("Campo de texto ativo.");
            }

            @Override
            public void focusLost(FocusEvent e) {
                labelOutput.setText("Campo de texto inativo.");
            }
        });

        // Evento de seleção no JComboBox
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                labelOutput.setText("Selecionado: " + selected);
            }
        });

        // Evento de janela (WindowListener)
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Bem-vindo! A janela foi aberta.");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                // Nada a fazer aqui, pois já definimos o comportamento de fechamento
            }

            @Override
            public void windowClosed(WindowEvent e) {
                // Código para quando a janela for fechada (se necessário)
            }

            @Override
            public void windowIconified(WindowEvent e) {
                labelOutput.setText("Janela minimizada.");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                labelOutput.setText("Janela restaurada.");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                labelOutput.setText("Janela ativa.");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                labelOutput.setText("Janela inativa.");
            }
        });
    }

    // Método para tratar o clique no botão
    private void handleButtonClick() {
        String nome = textField.getText();
        String status = (String) comboBox.getSelectedItem();

        if (nome.isEmpty() || !checkBox.isSelected()) {
            labelOutput.setText("Erro: Nome vazio ou consentimento não marcado.");
        } else {
            labelOutput.setText("Nome: " + nome + ", Status: " + status + ", Emails: Permitidos.");
        }
    }

    // Método main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI2().setVisible(true);
            }
        });
    }
}

