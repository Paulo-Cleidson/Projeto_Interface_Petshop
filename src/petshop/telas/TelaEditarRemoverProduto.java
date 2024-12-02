package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditarRemoverProduto extends JFrame {

    private JTextField nomeProduto;
    private JTextField valorProduto;

    public TelaEditarRemoverProduto(Administrador administrador) {

        setTitle("Edição de Produtos");
        setSize(350, 260);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel dadosProduto = new JLabel("Lista de Produtos");
        dadosProduto.setBounds(15,10,180,25);
        dadosProduto.setForeground(new Color(0, 48, 73));
        dadosProduto.setFont(new Font("Poppins", Font.BOLD, 18));
        add(dadosProduto);

        JComboBox<String> listaDeProdutos = new JComboBox<>();
        listaDeProdutos.setBounds(15,40,305,24);
        for(Produto produto : administrador.getEstoque().getListaProdutos()){
            listaDeProdutos.addItem(produto.getNomeProduto());
        }
        add(listaDeProdutos);

        JLabel nomeLabel = new JLabel("Nome do Produto:");
        nomeLabel.setBounds(15, 80, 118, 25);
        nomeLabel.setForeground(new Color(0, 48, 73));
        add(nomeLabel);
        nomeProduto = new JTextField();
        nomeProduto.setBounds(140, 80, 180, 25);
        add(nomeProduto);

        JLabel valorLabel = new JLabel("Valor do Produto:");
        valorLabel.setForeground(new Color(0, 48, 73));
        valorLabel.setBounds(15, 120, 118, 25);
        add(valorLabel);
        valorProduto = new JTextField();
        valorProduto.setBounds(140, 120, 180, 25);
        add(valorProduto);

        JButton editarProduto = new JButton("Editar Produto");
        editarProduto.setBounds(15, 170, 140, 25);
        editarProduto.setForeground(new Color(0, 48, 73));
        editarProduto.setFont(new Font("Arial", Font.BOLD, 12));
        add(editarProduto);

        editarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto produto = administrador.getEstoque().
                        verificaProduto(String.valueOf(listaDeProdutos.getSelectedItem()));
                produto.setNomeProduto(nomeProduto.getText());
                produto.setPreco(Double.parseDouble(valorProduto.getText()));
                nomeProduto.setText("");
                valorProduto.setText("");
                JOptionPane.showMessageDialog(null,"Produto Editado!");
            }
        });

        JButton removerProduto = new JButton("Remover Produto");
        removerProduto.setBounds(180, 170, 140, 25);
        removerProduto.setForeground(new Color(0, 48, 73));
        removerProduto.setFont(new Font("Arial", Font.BOLD, 12));
        add(removerProduto);

        removerProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto produto = administrador.getEstoque().
                        verificaProduto(String.valueOf(listaDeProdutos.getSelectedItem()));
                administrador.getEstoque().removerProduto(produto);
                JOptionPane.showMessageDialog(null,"Produto Removido!");

            }

        });

    }

}
