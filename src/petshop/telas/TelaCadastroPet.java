package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Cliente;
import petshop.modelos.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroPet extends JFrame {

    private JTextField nomePetField;
    private JTextField epecieField;
    private JTextField racaField;
    private JTextField idadeField;
    private JButton adicionarPet;

    public TelaCadastroPet(Administrador administrador) {

        setTitle("Cadastro de Pets");
        setSize(380, 310);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Selecione o Cliente");
        nomeLabel.setBounds(10, 8, 200, 25);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nomeLabel.setForeground(new Color(0, 48, 73));
        add(nomeLabel);

        JComboBox<String> listaDeClientes = new JComboBox<>();
        listaDeClientes.setBounds(15,40,300,24);
        for(Cliente cliente : administrador.getClientes()){
            listaDeClientes.addItem(cliente.getNome());
        }
        add(listaDeClientes);

        JLabel dadosPet = new JLabel("Dados do Pet");
        dadosPet.setBounds(10,70,200,25);
        dadosPet.setForeground(new Color(0, 48, 73));
        dadosPet.setFont(new Font("Arial", Font.BOLD, 18));
        add(dadosPet);

        JLabel nomePetLabel = new JLabel("Nome do Pet:");
        nomePetLabel.setBounds(10, 100, 80, 25);
        nomePetLabel.setForeground(new Color(0, 48, 73));
        add(nomePetLabel);
        nomePetField = new JTextField();
        nomePetField.setBounds(140, 100, 180, 25);
        add(nomePetField);

        JLabel especieLabel = new JLabel("Especie:");
        especieLabel.setBounds(10, 130, 80, 25);
        especieLabel.setForeground(new Color(0, 48, 73));
        add(especieLabel);
        epecieField = new JTextField();
        epecieField.setBounds(140, 130, 180, 25);
        add(epecieField);

        JLabel racaLabel = new JLabel("Raça:");
        racaLabel.setBounds(10, 160, 80, 25);
        racaLabel.setForeground(new Color(0, 48, 73));
        add(racaLabel);
        racaField = new JTextField();
        racaField.setBounds(140, 160, 180, 25);
        add(racaField);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeLabel.setBounds(10, 190, 80, 25);
        idadeLabel.setForeground(new Color(0, 48, 73));
        add(idadeLabel);
        idadeField = new JTextField();
        idadeField.setBounds(140, 190, 180, 25);
        add(idadeField);

        adicionarPet = new JButton("Cadastrar");
        adicionarPet.setBounds(20, 230, 100, 25);
        adicionarPet.setForeground(new Color(0, 48, 73));
        adicionarPet.setFont(new Font("Arial", Font.BOLD, 12));
        add(adicionarPet);

        adicionarPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = String.valueOf(listaDeClientes.getSelectedItem());
                String nomePet = nomePetField.getText();
                String especie = epecieField.getText();
                String raca = racaField.getText();
                int idade = Integer.parseInt(idadeField.getText());

                try{
                    Pet novoPet = new Pet(nomePet,especie,raca,idade);
                    administrador.verificaCliente(nomeCliente).cadastarPet(novoPet);
                    JOptionPane.showMessageDialog(null, "Pet cadastrado: " + novoPet.toString());
                } catch(Exception exception){
                    JOptionPane.showMessageDialog(null, exception);
                }
                nomePetField.setText("");
                epecieField.setText("");
                racaField.setText("");
                idadeField.setText("");
            }
        });

    }

}