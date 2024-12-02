package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditarRemoverServicos extends JFrame {

    private JTextField nomeServico;
    private JTextField valorServico;

    public TelaEditarRemoverServicos(Administrador administrador) {

        setTitle("Edição de Serviços");
        setSize(350, 260);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel dadosProduto = new JLabel("Lista de Serviços");
        dadosProduto.setBounds(15,10,180,25);
        dadosProduto.setForeground(new Color(0, 48, 73));
        dadosProduto.setFont(new Font("Poppins", Font.BOLD, 18));
        add(dadosProduto);

        JComboBox<String> listaDeServicos = new JComboBox<>();
        listaDeServicos.setBounds(15,40,305,24);
        for(Servico servico : administrador.getServicos()){
            listaDeServicos.addItem(servico.getTipo());
        }
        add(listaDeServicos);

        JLabel nomeLabel = new JLabel("Tipo do Serviço:");
        nomeLabel.setBounds(15, 80, 118, 25);
        nomeLabel.setForeground(new Color(0, 48, 73));
        add(nomeLabel);
        nomeServico = new JTextField();
        nomeServico.setBounds(140, 80, 180, 25);
        add(nomeServico);

        JLabel valorLabel = new JLabel("Valor do Serviço:");
        valorLabel.setForeground(new Color(0, 48, 73));
        valorLabel.setBounds(15, 120, 118, 25);
        add(valorLabel);
        valorServico = new JTextField();
        valorServico.setBounds(140, 120, 180, 25);
        add(valorServico);

        JButton editarServico = new JButton("Editar Serviço");
        editarServico.setBounds(15, 170, 140, 25);
        editarServico.setForeground(new Color(0, 48, 73));
        editarServico.setFont(new Font("Arial", Font.BOLD, 12));
        add(editarServico);

        editarServico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Servico servico = administrador.
                        verificaServico(String.valueOf(listaDeServicos.getSelectedItem()));
                servico.setTipo(nomeServico.getText());
                servico.setPreco(Double.parseDouble(valorServico.getText()));
                nomeServico.setText("");
                valorServico.setText("");
                JOptionPane.showMessageDialog(null,"Serviço Editado!");
            }
        });

        JButton removerServico = new JButton("Remover Serviço");
        removerServico.setBounds(180, 170, 140, 25);
        removerServico.setForeground(new Color(0, 48, 73));
        removerServico.setFont(new Font("Arial", Font.BOLD, 12));
        add(removerServico);

        removerServico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Servico servico = administrador.
                        verificaServico(String.valueOf(listaDeServicos.getSelectedItem()));
                administrador.removeServico(servico);
                JOptionPane.showMessageDialog(null,"Serviço Removido!");

            }

        });

    }

}
