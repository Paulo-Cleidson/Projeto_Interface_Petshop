package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRemoverCliente extends JFrame {

    public TelaRemoverCliente(Administrador administrador) {

        setTitle("Remover Cliente");
        setSize(380, 160);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome do Cliente:");
        nomeLabel.setForeground(new Color(0, 48, 73));
        nomeLabel.setBounds(10, 20, 100, 25);
        add(nomeLabel);

        JComboBox<String> listaDeClientes = new JComboBox<>();
        listaDeClientes.setBounds(120,20,240,24);
        for(Cliente cliente : administrador.getClientes()){
            listaDeClientes.addItem(cliente.getNome());
        }
        add(listaDeClientes);

        JButton removerCliente = new JButton("Remover Cliente");
        removerCliente.setBounds(30, 70, 130, 25);
        removerCliente.setForeground(new Color(0, 48, 73));
        removerCliente.setFont(new Font("Arial", Font.BOLD, 12));
        add(removerCliente);

        removerCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = String.valueOf(listaDeClientes.getSelectedItem());
                administrador.removerCliente(administrador.verificaCliente(nome));
                JOptionPane.showMessageDialog(null, "Cliente removido");

            }

        });

    }

}
