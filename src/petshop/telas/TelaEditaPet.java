package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Cliente;
import petshop.modelos.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditaPet extends JFrame {

    private JTextField nomePetField;
    private JTextField epecieField;
    private JTextField racaField;
    private JTextField idadeField;
    private JButton confirmarEicao;
    private Cliente clienteSelecionado;
    private Pet petselecionado;

    public TelaEditaPet(Administrador administrador) {

        setTitle("Editar Pets");
        setSize(380, 370);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nomeClienteLabel = new JLabel("Selecione o Cliente:");
        nomeClienteLabel.setForeground(new Color(0, 48, 73));
        nomeClienteLabel.setBounds(10, 20, 120, 25);
        add(nomeClienteLabel);

        JComboBox<String> listaDeClientes = new JComboBox<>();
        listaDeClientes.setBounds(140,20,220,24);
        for(Cliente cliente : administrador.getClientes()){
            listaDeClientes.addItem(cliente.getNome());
        }
        add(listaDeClientes);

        JLabel nomePetLabel = new JLabel("Selecione o Pet:");
        nomePetLabel.setBounds(10, 60, 100, 25);
        nomePetLabel.setForeground(new Color(0, 48, 73));
        add(nomePetLabel);

        JComboBox<String> listaDePets = new JComboBox<>();
        listaDePets.setBounds(140,60,220,24);
        listaDeClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDePets.removeAllItems(); // Limpa os pets atuais
                clienteSelecionado = administrador.verificaCliente((String) listaDeClientes.getSelectedItem());
                if (clienteSelecionado != null) {
                    for (int i=0; i < clienteSelecionado.getListaPetsCliente().size(); i++) {
                        Pet pet = (Pet) clienteSelecionado.getListaPetsCliente().get(i);
                        listaDePets.addItem(pet.getNomePet());
                    }
                }
            }
        });
        add(listaDePets);

        JLabel dadosPet = new JLabel("Dados do Pet Para Edição");
        dadosPet.setBounds(10, 100, 250, 25);
        dadosPet.setFont(new Font("Arial", Font.BOLD, 15));
        dadosPet.setForeground(new Color(0, 48, 73));
        add(dadosPet);

        JLabel nomePetEditadoLabel = new JLabel("Nome do Pet:");
        nomePetEditadoLabel.setBounds(10, 140, 80, 25);
        nomePetEditadoLabel.setForeground(new Color(0, 48, 73));
        add(nomePetEditadoLabel);
        nomePetField = new JTextField();
        nomePetField.setBounds(120, 140, 200, 25);
        add(nomePetField);

        JLabel especieLabel = new JLabel("Especie:");
        especieLabel.setBounds(10, 170, 80, 25);
        especieLabel.setForeground(new Color(0, 48, 73));
        add(especieLabel);
        epecieField = new JTextField();
        epecieField.setBounds(120, 170, 200, 25);
        add(epecieField);

        JLabel racaLabel = new JLabel("Raça:");
        racaLabel.setBounds(10, 200, 80, 25);
        racaLabel.setForeground(new Color(0, 48, 73));
        add(racaLabel);
        racaField = new JTextField();
        racaField.setBounds(120, 200, 200, 25);
        add(racaField);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeLabel.setBounds(10, 230, 80, 25);
        idadeLabel.setForeground(new Color(0, 48, 73));
        add(idadeLabel);
        idadeField = new JTextField();
        idadeField.setBounds(120, 230, 200, 25);
        add(idadeField);

        confirmarEicao = new JButton("Confirmar Edição");
        confirmarEicao.setBounds(20, 280, 140, 25);
        confirmarEicao.setForeground(new Color(0, 48, 73));
        confirmarEicao.setFont(new Font("Arial", Font.BOLD, 12));
        add(confirmarEicao);

        confirmarEicao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                petselecionado = clienteSelecionado.verificaPet((String) listaDePets.getSelectedItem());
                String nomePet = nomePetField.getText();
                String especie = epecieField.getText();
                String raca = racaField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                petselecionado.setNomePet(nomePet);
                petselecionado.setEspecie(especie);
                petselecionado.setRaca(raca);
                petselecionado.setIdade(idade);
                JOptionPane.showMessageDialog(null, "Pet Editado!");
                nomePetField.setText("");
                epecieField.setText("");
                racaField.setText("");
                idadeField.setText("");

            }

        });

    }

}
