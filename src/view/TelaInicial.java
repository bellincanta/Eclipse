package src.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import componente.grafico.*;
import componente.sequencia.*;

public class TelaInicial {

    private static IProgressaoGeometrica gp = new ProgressaoGeometrica();
    private static IGrafico bc = new Grafico();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Progressão Geométrica e Gráfico");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2));
        
        // Text fields for user input
        JLabel viLabel = new JLabel("Valor Inicial (Vi):");
        JTextField viField = new JTextField();
        JLabel rzLabel = new JLabel("Razão (Rz):");
        JTextField rzField = new JTextField();
        JLabel nLabel = new JLabel("Número de Elementos (N):");
        JTextField nField = new JTextField();
        JLabel caracterLabel = new JLabel("Caractere:");
        JTextField caracterField = new JTextField();
        
        // Checkbox for filled graphic
        JCheckBox preenchidoCheckBox = new JCheckBox("Preenchido", true);
        
        // Button to plot graph
        JButton plotButton = new JButton("Plotar Gráfico");

        // Add components to frame
        frame.add(viLabel);
        frame.add(viField);
        frame.add(rzLabel);
        frame.add(rzField);
        frame.add(nLabel);
        frame.add(nField);
        frame.add(caracterLabel);
        frame.add(caracterField);
        frame.add(preenchidoCheckBox);
        frame.add(plotButton);

        // Action listener for plot button
        plotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Set Progressão Geométrica values
                    gp.setVi(Integer.parseInt(viField.getText()));
                    gp.setRz(Integer.parseInt(rzField.getText()));

                    // Set Graphic values
                    bc.setPreenchido(preenchidoCheckBox.isSelected());
                    bc.setCaracter(caracterField.getText().charAt(0));
                    bc.setN(Integer.parseInt(nField.getText()));
                    
                    // Connect and plot
                    bc.connect(gp);
                    bc.plot();
                    
                    JOptionPane.showMessageDialog(frame, "Gráfico plotado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos.");
                }
            }
        });

        frame.setVisible(true);
    }
}
