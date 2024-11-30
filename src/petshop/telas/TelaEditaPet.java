package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Cliente;
import petshop.modelos.Pet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditaPet extends JFrame {

        private DefaultTableModel model;
        private JTable tabel;
        private JScrollPane scrollPane;
        JComboBox<Cliente> listaClientes;

    public TelaEditaPet(Administrador administrador) {

        setTitle("Editar Pets");
        setSize(900, 410);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel clientes = new JLabel("Clientes");
        clientes.setBounds(15,20,270,25);
        clientes.setFont(new Font("Poppins", Font.BOLD, 18));
        clientes.setForeground(new Color(0, 48, 73));
        add(clientes);

        listaClientes = new JComboBox<>();
        listaClientes.setBounds(40, 50,800,20);
        for(Cliente cliente : administrador.getClientes()){
            listaClientes.addItem(cliente);
        }
        add(listaClientes);

        JLabel dadosPets = new JLabel("Dados dos Pets");
        dadosPets.setBounds(15,120,300,25);
        dadosPets.setFont(new Font("Poppins", Font.BOLD, 18));
        dadosPets.setForeground(new Color(0, 48, 73));
        add(dadosPets);

        model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Espécie");
        model.addColumn("Raça");
        model.addColumn("Idade");

        listaClientes.getSelectedItem();

        tabel = new JTable(model);
        scrollPane = new JScrollPane(tabel);
        scrollPane.setBounds(40, 180, 800, 170);
        add(scrollPane);

    }

    public static void main(String[] args) {
        TelaEditaPet telaEP = new TelaEditaPet(new Administrador());
        telaEP.setVisible(true);
    }
}
