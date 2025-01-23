package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Cliente;
import petshop.modelos.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRemoverPet extends JFrame {

    public TelaRemoverPet(Administrador administrador) {

        setTitle("Remover Pet");
        setSize(390, 190);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nomeClienteLabel = new JLabel("Nome do Cliente:");
        nomeClienteLabel.setForeground(new Color(0, 48, 73));
        nomeClienteLabel.setBounds(10, 20, 100, 25);
        add(nomeClienteLabel);

        JComboBox<String> listaDeClientes = new JComboBox<>();
        listaDeClientes.setBounds(120,20,240,24);
        for(Cliente cliente : administrador.getClientes()){
            listaDeClientes.addItem(cliente.getNome());
        }
        add(listaDeClientes);

        JLabel nomePetLabel = new JLabel("Nome do Pet:");
        nomePetLabel.setBounds(10, 60, 100, 25);
        nomePetLabel.setForeground(new Color(0, 48, 73));
        add(nomePetLabel);

        JComboBox<String> listaDePets = new JComboBox<>();
        listaDePets.setBounds(120,60,240,24);

        listaDeClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDePets.removeAllItems(); // Limpa os pets atuais
                Cliente clienteSelecionado = administrador.
                        verificaCliente((String) listaDeClientes.getSelectedItem());
                if (clienteSelecionado != null) {
                    for (int i=0; i < clienteSelecionado.getListaPetsCliente().size(); i++) {
                        Pet pet = (Pet) clienteSelecionado.getListaPetsCliente().get(i);
                        listaDePets.addItem(pet.getNomePet());
                    }
                }
            }
        });
        add(listaDePets);

        JButton removerPet = new JButton("Remover Pet");
        removerPet.setBounds(30, 110, 130, 25);
        removerPet.setForeground(new Color(0, 48, 73));
        removerPet.setFont(new Font("Arial", Font.BOLD, 12));
        add(removerPet);

        removerPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administrador.verificaCliente(String.valueOf(listaDeClientes.getSelectedItem())).
                    removerPet(administrador.verificaCliente(String.valueOf(listaDeClientes.getSelectedItem())).
                               verificaPet(String.valueOf(listaDePets.getSelectedItem())));

                JOptionPane.showMessageDialog(null, "Pet Removido");

            }

        });

    }

}
