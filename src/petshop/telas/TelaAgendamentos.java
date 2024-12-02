package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Agendamentos;
import petshop.modelos.Cliente;
import petshop.modelos.Servico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAgendamentos extends JFrame {

    private Cliente clienteselecionado;
    private Servico servicoSelecionado;

    public TelaAgendamentos(Administrador administrador) {

        setTitle("Cadastrar Agendamento");
        setSize(380, 250);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel clientes = new JLabel("Lista de Clientes");
        clientes.setBounds(10, 8,200,25);
        clientes.setFont(new Font("Arial", Font.BOLD, 16));
        clientes.setForeground(new Color(0, 48, 73));
        add(clientes);

        JComboBox<String> listaDeClientes = new JComboBox<>();
        listaDeClientes.setBounds(15,40,300,24);
        for(Cliente cliente : administrador.getClientes()){
            listaDeClientes.addItem(cliente.getNome());
        }
        add(listaDeClientes);

        JLabel servicos = new JLabel("Lista de Serviços");
        servicos.setBounds(10, 70,200,25);
        servicos.setFont(new Font("Arial", Font.BOLD, 16));
        servicos.setForeground(new Color(0, 48, 73));
        add(servicos);

        JComboBox<String> listaDeServicos = new JComboBox<>();
        listaDeServicos.setBounds(15,106,300,24);
        for(Servico servico : administrador.getServicos()) {
            listaDeServicos.addItem(servico.getTipo());
        }
        add(listaDeServicos);

        JButton agendar = new JButton("Criar Agendamento");
        agendar.setBounds(10, 150, 150, 30);
        agendar.setFont(new Font("Arial", Font.BOLD, 12));
        agendar.setForeground(new Color(0, 48, 73));
        add(agendar);

        agendar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteselecionado = administrador.
                        verificaCliente(String.valueOf(listaDeClientes.getSelectedItem()));
                servicoSelecionado = administrador.
                        verificaServico(String.valueOf(listaDeServicos.getSelectedItem()));
                Agendamentos agendamento = new Agendamentos(clienteselecionado, servicoSelecionado);
                administrador.addAgendamento(agendamento);
                JOptionPane.showMessageDialog(null, "Serviço Agendado!");
            }
        });

        JButton editarRemover = new JButton("Remover Agendamento");
        editarRemover.setBounds(170, 150, 170, 30);
        editarRemover.setFont(new Font("Arial", Font.BOLD, 12));
        editarRemover.setForeground(new Color(0, 48, 73));
        add(editarRemover);

        editarRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRemoverAgendamentos telaEditarRemoverAgendamentos =
                        new TelaRemoverAgendamentos(administrador);
                telaEditarRemoverAgendamentos.setVisible(true);
            }
        });

    }

}
