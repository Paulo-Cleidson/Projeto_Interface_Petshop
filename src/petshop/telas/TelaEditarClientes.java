package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditarClientes extends JFrame {

    private JTextField nomeField;
    private JTextField emailField;
    private JTextField cpfField;
    private JTextField contatoField;
    private JTextField dataField;

    public TelaEditarClientes(Administrador administrador) {

        setTitle("Editar Clientes");
        setSize(380, 370);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel clientes = new JLabel("Lista de Clientes");
        clientes.setBounds(10, 8,200,25);
        clientes.setFont(new Font("Arial", Font.BOLD, 18));
        clientes.setForeground(new Color(0, 48, 73));
        add(clientes);

        JComboBox<String> listaDeClientes = new JComboBox<>();
        listaDeClientes.setBounds(15,40,300,24);
        for(Cliente cliente : administrador.getClientes()){
            listaDeClientes.addItem(cliente.getNome());
        }
        add(listaDeClientes);

        JLabel dadosCliente = new JLabel("Dados do cliente para edição");
        dadosCliente.setBounds(10,75,300,25);
        dadosCliente.setFont(new Font("Poppins", Font.BOLD, 18));
        dadosCliente.setForeground(new Color(0, 48, 73));
        add(dadosCliente);

        JLabel nomeLabel = new JLabel("Nome do Cliente:");
        nomeLabel.setBounds(10, 105, 100, 25);
        nomeLabel.setForeground(new Color(0, 48, 73));
        add(nomeLabel);
        nomeField = new JTextField();
        nomeField.setBounds(140, 105, 180, 25);
        add(nomeField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 135, 80, 25);
        emailLabel.setForeground(new Color(0, 48, 73));
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(140, 135, 180, 25);
        add(emailField);

        JLabel cpfLabel = new JLabel("CPF: ");
        cpfLabel.setBounds(10,165,80,25);
        cpfLabel.setForeground(new Color(0, 48, 73));
        add(cpfLabel);
        cpfField = new JTextField();
        cpfField.setBounds(140,165,180,25);
        add(cpfField);

        JLabel contatoLabel = new JLabel("Contato: ");
        contatoLabel.setBounds(10,195,80,25);
        contatoLabel.setForeground(new Color(0, 48, 73));
        add(contatoLabel);
        contatoField = new JTextField();
        contatoField.setBounds(140,195,180,25);
        add(contatoField);

        JLabel dataLabel = new JLabel("Data de Nascimento: ");
        dataLabel.setBounds(10,225,120,25);
        dataLabel.setForeground(new Color(0, 48, 73));
        add(dataLabel);
        dataField = new JTextField();
        dataField.setBounds(140,225,180,25);
        add(dataField);

        JButton confirmar = new JButton("Confirmar");
        confirmar.setBounds(20, 280, 150, 30);
        confirmar.setFont(new Font("Arial", Font.BOLD, 12));
        confirmar.setForeground(new Color(0, 48, 73));
        add(confirmar);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente c1 = administrador.verificaCliente(String.valueOf(listaDeClientes.getSelectedItem()));
                String nome = nomeField.getText();
                String email = emailField.getText();
                String cpf = cpfField.getText();
                int contato = Integer.parseInt(contatoField.getText());
                int data = Integer.parseInt(dataField.getText());
                c1.setNome(nome);
                c1.setEmail(email);
                c1.setCpf(cpf);
                c1.setDataNascimento(data);
                c1.setContato(contato);
                nomeField.setText("");
                emailField.setText("");
                cpfField.setText("");
                contatoField.setText("");
                dataField.setText("");
                JOptionPane.showMessageDialog(null,
                        "Os dados do Cliente foram atualizados");

            }

        });

    }

}
