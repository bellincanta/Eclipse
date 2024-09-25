package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import componente.grafico.Grafico;
import componente.sequencia.ProgressaoGeometrica;

public class TelaInicial2 extends JFrame {

    private static final long serialVersionUID = 1L;
	private JTextField txtCaracter, txtN, txtVi, txtRz;
    private JCheckBox chkPreenchido;
    private JTextArea areaGrafico;
    
    private Grafico grafico;
    private ProgressaoGeometrica progressao;

    public TelaInicial2() {
        setTitle("Gerador de Gráfico");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        grafico = new Grafico();
        progressao = new ProgressaoGeometrica();
        grafico.connect(progressao);
        
        // Painel para as entradas
        JPanel painelEntrada = new JPanel(new GridLayout(5, 2));
        
        painelEntrada.add(new JLabel("Caractere:"));
        txtCaracter = new JTextField();
        painelEntrada.add(txtCaracter);
        
        painelEntrada.add(new JLabel("Número de linhas (n):"));
        txtN = new JTextField();
        painelEntrada.add(txtN);
        
        painelEntrada.add(new JLabel("Valor inicial (vi):"));
        txtVi = new JTextField();
        painelEntrada.add(txtVi);
        
        painelEntrada.add(new JLabel("Razão (rz):"));
        txtRz = new JTextField();
        painelEntrada.add(txtRz);
        
        painelEntrada.add(new JLabel("Preenchido:"));
        chkPreenchido = new JCheckBox();
        chkPreenchido.setSelected(true);
        painelEntrada.add(chkPreenchido);
        
        // Botão para gerar o gráfico
        JButton btnGerar = new JButton("Gerar Gráfico");
        btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarGrafico();
            }
        });
        
        // Área de texto para exibir o gráfico
        areaGrafico = new JTextArea(10, 30);
        areaGrafico.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaGrafico.setEditable(false);
        
        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        painelPrincipal.add(painelEntrada, BorderLayout.NORTH);
        painelPrincipal.add(new JScrollPane(areaGrafico), BorderLayout.CENTER);
        painelPrincipal.add(btnGerar, BorderLayout.SOUTH);
        
        add(painelPrincipal);
    }

    private void gerarGrafico() {
        // Capturando as entradas do usuário
        grafico.setCaracter(txtCaracter.getText().charAt(0));
        grafico.setN(Integer.parseInt(txtN.getText()));
        grafico.setPreenchido(chkPreenchido.isSelected());
        
        progressao.setVi(Integer.parseInt(txtVi.getText()));
        progressao.setRz(Integer.parseInt(txtRz.getText()));

        // Limpar área de gráfico
        areaGrafico.setText("");

        // Gerar o gráfico e exibir na área de texto
        StringBuilder graficoTexto = new StringBuilder();
        int value = progressao.primeiro();
        for (int s = 1; s <= grafico.getN(); s++) {
            for (int v = 1; v < value; v++) {
                graficoTexto.append(grafico.estaPreenchido() ? grafico.getCaracter() : ' ');
            }
            graficoTexto.append(grafico.getCaracter()).append("\n");
            value = progressao.proximo();
        }

        // Exibir o gráfico na interface
        areaGrafico.setText(graficoTexto.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaInicial2().setVisible(true);
            }
        });
    }
}
