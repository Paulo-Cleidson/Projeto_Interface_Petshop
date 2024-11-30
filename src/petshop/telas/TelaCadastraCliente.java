package petshop.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import petshop.modelos.ClientePadrao;
import petshop.controles.Administrador;

public class TelaCadastraCliente extends JFrame {

    private JTextField nomeField;
    private JTextField emailField;
    private JTextField cpfField;
    private JTextField contatoField;
    private JTextField dataField;
    private JButton cadastrarCliente;
    private JButton cadastrarPet;
    private JButton editarCliente;
    private JButton editarPet;
    private JButton removerCliente;
    private JButton removerPet;

    public TelaCadastraCliente(Administrador administrador) {

        setTitle("Cadastro de Clientes");
        setSize(380, 360);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel dadosCliente = new JLabel("Dados do cliente para cadastro");
        dadosCliente.setBounds(10,10,270,25);
        dadosCliente.setForeground(new Color(0, 48, 73));
        dadosCliente.setFont(new Font("Arial", Font.BOLD, 17));
        add(dadosCliente);

        JLabel nomeLabel = new JLabel("Nome do Cliente:");
        nomeLabel.setBounds(10, 40, 100, 25);
        nomeLabel.setForeground(new Color(0, 48, 73));
        add(nomeLabel);
        nomeField = new JTextField();
        nomeField.setBounds(140, 40, 180, 25);
        add(nomeField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 70, 80, 25);
        emailLabel.setForeground(new Color(0, 48, 73));
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(140, 70, 180, 25);
        add(emailField);

        JLabel cpfLabel = new JLabel("CPF: ");
        cpfLabel.setBounds(10,100,80,25);
        cpfLabel.setForeground(new Color(0, 48, 73));
        add(cpfLabel);
        cpfField = new JTextField();
        cpfField.setBounds(140,100,180,25);
        add(cpfField);

        JLabel contatoLabel = new JLabel("Contato: ");
        contatoLabel.setBounds(10,130,80,25);
        contatoLabel.setForeground(new Color(0, 48, 73));
        add(contatoLabel);
        contatoField = new JTextField();
        contatoField.setBounds(140,130,180,25);
        add(contatoField);

        JLabel dataLabel = new JLabel("Data de Nascimento: ");
        dataLabel.setBounds(10,160,120,25);
        dataLabel.setForeground(new Color(0, 48, 73));
        add(dataLabel);
        dataField = new JTextField();
        dataField.setBounds(140,160,180,25);
        add(dataField);

        cadastrarCliente = new JButton("Cadastrar Cliente");
        cadastrarCliente.setBounds(15, 210, 130, 25);
        cadastrarCliente.setForeground(new Color(0, 48, 73));
        cadastrarCliente.setFont(new Font("Arial", Font.BOLD, 11));
        add(cadastrarCliente);

        cadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String cpf = cpfField.getText();
                int contato = Integer.parseInt(contatoField.getText());
                int data = Integer.parseInt(dataField.getText());
                try{  
                    ClientePadrao clientePadrao = new ClientePadrao(nome,email,cpf,contato,data);
                    administrador.addClientes(clientePadrao);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado: " + clientePadrao.toString());
                } catch(Exception exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }
                nomeField.setText("");
                emailField.setText("");
                cpfField.setText("");
                contatoField.setText("");
                dataField.setText("");
            }
        });

        cadastrarPet = new JButton("Cadastrar Pet");
        cadastrarPet.setBounds(190, 210, 130, 25);
        cadastrarPet.setForeground(new Color(0, 48, 73));
        cadastrarPet.setFont(new Font("Arial", Font.BOLD, 12));
        add(cadastrarPet);

        cadastrarPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroPet telaPet = new TelaCadastroPet(administrador);
                telaPet.setVisible(true);
            }
        });

        editarCliente = new JButton("Editar Cliente");
        editarCliente.setBounds(15, 240, 130, 25);
        editarCliente.setForeground(new Color(0, 48, 73));
        editarCliente.setFont(new Font("Arial", Font.BOLD, 12));
        add(editarCliente);

        editarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditarClientes telaEC = new TelaEditarClientes(administrador);
                telaEC.setVisible(true);
            }
        });

        editarPet = new JButton("Editar Pet");
        editarPet.setBounds(190, 240, 130, 25);
        editarPet.setForeground(new Color(0, 48, 73));
        editarPet.setFont(new Font("Arial", Font.BOLD, 12));
        add(editarPet);

        editarPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaEditaPet telaEP = new TelaEditaPet(administrador);
                telaEP.setVisible(true);
            }
        });

        removerCliente = new JButton("Remover Cliente");
        removerCliente.setBounds(15, 270, 130, 25);
        removerCliente.setForeground(new Color(0, 48, 73));
        removerCliente.setFont(new Font("Arial", Font.BOLD, 12));
        add(removerCliente);

        removerCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRemoverCliente telaRC = new TelaRemoverCliente(administrador);
                telaRC.setVisible(true);
            }
        });

        removerPet = new JButton("Remover Pet");
        removerPet.setBounds(190, 270, 130, 25);
        removerPet.setForeground(new Color(0, 48, 73));
        removerPet.setFont(new Font("Arial", Font.BOLD, 12));
        add(removerPet);

        removerPet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRemoverPet telaRP = new TelaRemoverPet(administrador);
                telaRP.setVisible(true);
            }
        });

    }

}
