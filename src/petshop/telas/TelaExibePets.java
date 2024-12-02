package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Cliente;
import petshop.modelos.Pet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaExibePets extends JFrame {

    public TelaExibePets(Administrador administrador) {

        setTitle("Tela de Exibição de Pets");
        setSize(750, 360);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel listaDeClientesPets = new JLabel("Lista de Clientes:");
        listaDeClientesPets.setBounds(30, 10,220,25);
        listaDeClientesPets.setFont(new Font("Arial", Font.BOLD, 18));
        listaDeClientesPets.setForeground(new Color(0, 48, 73));
        add(listaDeClientesPets);

        JComboBox<String> listaDeClientes = new JComboBox<>();
        listaDeClientes.setBounds(30,40,300,24);
        for(Cliente cliente : administrador.getClientes()){
            listaDeClientes.addItem(cliente.getNome());
        }
        add(listaDeClientes);

        JLabel listaPets = new JLabel("Lista de Pets do Cliente:");
        listaPets.setBounds(30, 80,300,25);
        listaPets.setFont(new Font("Arial", Font.BOLD, 18));
        listaPets.setForeground(new Color(0, 48, 73));
        add(listaPets);

        DefaultTableModel modelPets = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelPets.addColumn("Nome Pet");
        modelPets.addColumn("Espécie");
        modelPets.addColumn("Raça");
        modelPets.addColumn("Idade");
        JTable tabelPets = new JTable(modelPets);
        JScrollPane scrollPets = new JScrollPane(tabelPets);
        scrollPets.setBounds(30, 110, 680, 200);

        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JScrollPane) {
                remove(component);
            }
        }
        add(scrollPets);

        listaDeClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente clienteSelecionado = administrador.
                        verificaCliente(String.valueOf(listaDeClientes.getSelectedItem()));
                modelPets.setRowCount(0);
                for(int i = 0; i < clienteSelecionado.getListaPetsCliente().size(); i++){
                    Pet pet = (Pet) clienteSelecionado.getListaPetsCliente().get(i);
                    modelPets.addRow(new Object[]{pet.getNomePet(), pet.getEspecie(),
                            pet.getRaca(), pet.getIdade()});

                }

            }

        });

    }

}
