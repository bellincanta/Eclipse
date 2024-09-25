package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI extends JFrame {

    private static final long serialVersionUID = 7352018073986710489L;

	// Construtor da GUI
    public MainGUI() {
        setTitle("Exemplo de Eventos em Swing");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurando o layout
        setLayout(new FlowLayout());

        // Criando componentes
        JButton button = new JButton("Clique em mim");
        JLabel label = new JLabel("Texto inicial");
        JTextField textField = new JTextField(10);
        String[] items = {"Item 1", "Item 2", "Item 3"};
        JComboBox<String> comboBox = new JComboBox<>(items);

        // Adicionando componentes ao painel
        add(button);
        add(label);
        add(textField);
        add(comboBox);

        // Adicionando eventos
        // Evento de clique no botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Botão clicado!");
            }
        });

        // Evento de alteração no campo de texto
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("Texto: " + textField.getText());
            }
        });

        // Evento de seleção na combo box
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                label.setText("Selecionado: " + selected);
            }
        });
    }

    public static void main(String[] args) {
        // Cria e exibe a GUI na Thread de despacho de eventos (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }
}

