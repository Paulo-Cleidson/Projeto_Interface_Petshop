package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Estoque;
import petshop.modelos.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadstrarProdutos extends JFrame {

    private JTextField nomeProdutos;
    private JTextField valorProduto;

    public TelaCadstrarProdutos(Administrador administrador) {

        setTitle("Cadastro em Estoque");
        setSize(390, 220);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel dadosProduto = new JLabel("Dados do Produto");
        dadosProduto.setBounds(10,10,180,25);
        dadosProduto.setForeground(new Color(0, 48, 73));
        dadosProduto.setFont(new Font("Poppins", Font.BOLD, 18));
        add(dadosProduto);

        JLabel nomeLabel = new JLabel("Nome do Produto:");
        nomeLabel.setBounds(10, 50, 118, 25);
        nomeLabel.setForeground(new Color(0, 48, 73));
        add(nomeLabel);
        nomeProdutos = new JTextField();
        nomeProdutos.setBounds(140, 50, 180, 25);
        add(nomeProdutos);

        JLabel valorLabel = new JLabel("Valor do Produto:");
        valorLabel.setForeground(new Color(0, 48, 73));
        valorLabel.setBounds(10, 90, 118, 25);
        add(valorLabel);
        valorProduto = new JTextField();
        valorProduto.setBounds(140, 90, 180, 25);
        add(valorProduto);

        JButton cadastrarProduto = new JButton("Cadastrar Produto");
        cadastrarProduto.setBounds(10, 130, 170, 25);
        cadastrarProduto.setForeground(new Color(0, 48, 73));
        cadastrarProduto.setFont(new Font("Arial", Font.BOLD, 12));
        add(cadastrarProduto);

        cadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProduto = nomeProdutos.getText();
                double valor = Double.parseDouble(valorProduto.getText());
                Produto produto = new Produto(nomeProduto,valor);
                administrador.getEstoque().cadastrarProduto(produto);
                JOptionPane.showMessageDialog(null,
                        "Produto Cadastrado: " + produto.toString());
                nomeProdutos.setText("");
                valorProduto.setText("");
            }
        });

        JButton editarProduto = new JButton("Editar/Remover Produto");
        editarProduto.setBounds(190, 130, 170, 25);
        editarProduto.setForeground(new Color(0, 48, 73));
        editarProduto.setFont(new Font("Arial", Font.BOLD, 12));
        add(editarProduto);

        editarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditarRemoverProduto telaEditarRemoverProduto =
                        new TelaEditarRemoverProduto(administrador);
                telaEditarRemoverProduto.setVisible(true);

            }

        });

    }

}
