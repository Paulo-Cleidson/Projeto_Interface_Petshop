package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastrarServico extends JFrame {

    private JTextField nomeServico;
    private JTextField valorServico;
    private JButton cadastrarServico;

    public TelaCadastrarServico (Administrador administrador) {

        setTitle("Cadastro de Serviços");
        setSize(380, 230);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel dadosServico = new JLabel("Dados do Serviço");
        dadosServico.setBounds(10,10,180,25);
        dadosServico.setForeground(new Color(0, 48, 73));
        dadosServico.setFont(new Font("Poppins", Font.BOLD, 18));
        add(dadosServico);

        JLabel nomeLabel = new JLabel("Nome do Serviço:");
        nomeLabel.setBounds(10, 50, 118, 25);
        nomeLabel.setForeground(new Color(0, 48, 73));
        add(nomeLabel);
        nomeServico = new JTextField();
        nomeServico.setBounds(140, 50, 180, 25);
        add(nomeServico);

        JLabel valorLabel = new JLabel("Valor do Serviço:");
        valorLabel.setBounds(10, 90, 118, 25);
        valorLabel.setForeground(new Color(0, 48, 73));
        add(valorLabel);
        valorServico = new JTextField();
        valorServico.setBounds(140, 90, 180, 25);
        add(valorServico);

        cadastrarServico = new JButton("Cadastrar Serviço");
        cadastrarServico.setBounds(15, 140, 140, 25);
        cadastrarServico.setForeground(new Color(0, 48, 73));
        cadastrarServico.setFont(new Font("Arial", Font.BOLD, 11));
        add(cadastrarServico);

        cadastrarServico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeDoServico = nomeServico.getText();
                double valorDoServico = Double.parseDouble(valorServico.getText());
                Servico servico = new Servico(nomeDoServico, valorDoServico);
                administrador.addServicos(servico);

                JOptionPane.showMessageDialog(null,"Serviço cadastrado" + servico.toString());
                nomeServico.setText("");
                valorServico.setText("");
            }
        });

    }

}
