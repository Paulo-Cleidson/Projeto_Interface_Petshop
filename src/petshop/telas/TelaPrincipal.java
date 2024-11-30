package petshop.telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import petshop.controles.Administrador;
import petshop.modelos.Cliente;
import petshop.modelos.Produto;
import petshop.modelos.Servico;

public class TelaPrincipal extends JFrame {

    private DefaultTableModel modelEstoque;
    private JTable tabelEstoque;
    private JScrollPane scrollEstoque;
    private DefaultTableModel model;
    private JTable tabel;
    private JScrollPane scrollClientes;
    private DefaultTableModel modelServicos;
    private JTable tabelServicos;
    private JScrollPane scrollServicos;

    public TelaPrincipal(Administrador administrador) {

        setTitle("Tela do Administrador");
        setSize(770, 600);
        getContentPane().setBackground(new Color(102, 155, 188));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton cadastrarCliente = new JButton("Área Clientes");
        cadastrarCliente.setBounds(50, 50, 200, 30);
        cadastrarCliente.setFont(new Font("Arial", Font.BOLD, 15));
        cadastrarCliente.setForeground(new Color(0, 48, 73));
        add(cadastrarCliente);

        cadastrarCliente.addActionListener(e -> {
            TelaCadastraCliente telaCliente = new TelaCadastraCliente(administrador);
            telaCliente.setVisible(true);
        });

        JButton exibirClientes = new JButton("Exibir Clientes");
        exibirClientes.setBounds(270, 50, 200, 30);
        exibirClientes.setFont(new Font("Arial", Font.BOLD, 15));
        exibirClientes.setForeground(new Color(0, 48, 73));
        add(exibirClientes);

        model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("E-mail");
        model.addColumn("CPF");
        model.addColumn("Contato");
        model.addColumn("Data Nasc.");
        tabel = new JTable(model);
        scrollClientes = new JScrollPane(tabel);
        scrollClientes.setBounds(30, 290, 700, 250);

        exibirClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                add(scrollClientes);
                for(Cliente cliente: administrador.getClientes()){
                    model.addRow(new Object[]{cliente.getNome(), cliente.getEmail(),
                            cliente.getCpf(), cliente.getContato(), cliente.getDataNascimento()});
                }
            }
        });

        JButton estoque = new JButton("Estoque");
        estoque.setBounds(50, 100, 200, 30);
        estoque.setFont(new Font("Arial", Font.BOLD, 15));
        estoque.setForeground(new Color(0, 48, 73));
        add(estoque);

        estoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadstrarProdutos telaProduto = new TelaCadstrarProdutos(administrador);
                telaProduto.setVisible(true);
            }
        });

        JButton exibirEstoque = new JButton("Exibir Estoque");
        exibirEstoque.setBounds(270, 100, 200, 30);
        exibirEstoque.setFont(new Font("Arial", Font.BOLD, 15));
        exibirEstoque.setForeground(new Color(0, 48, 73));
        add(exibirEstoque);

        modelEstoque = new DefaultTableModel();
        modelEstoque.addColumn("Produto");
        modelEstoque.addColumn("Preço");
        tabelEstoque = new JTable(modelEstoque);
        scrollEstoque = new JScrollPane(tabelEstoque);
        scrollEstoque.setBounds(30, 290, 700, 250);

        exibirEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelEstoque.setRowCount(0);
                add(scrollEstoque);
                for(Produto produto: administrador.getEstoque().getListaProdutos()){
                    modelEstoque.addRow(new Object[]{produto.getNomeProduto(), produto.getPreco()});
                }
            }
        });

        JButton cadastrarServico = new JButton("Cadastrar Serviços");
        cadastrarServico.setBounds(50, 150, 200, 30);
        cadastrarServico.setFont(new Font("Arial", Font.BOLD, 15));
        cadastrarServico.setForeground(new Color(0, 48, 73));
        add(cadastrarServico);

        cadastrarServico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastrarServico telaCadastroServicos = new TelaCadastrarServico(administrador);
                telaCadastroServicos.setVisible(true);
            }
        });

        modelServicos = new DefaultTableModel();
        modelServicos.addColumn("Tipo de Serviço");
        modelServicos.addColumn("Valor do Serviço");
        tabelServicos = new JTable(modelServicos);
        scrollServicos = new JScrollPane(tabelServicos);
        scrollServicos.setBounds(30, 290, 700, 250);

        JButton exibirServico = new JButton("Exibir Serviços");
        exibirServico.setBounds(270, 150, 200, 30);
        exibirServico.setFont(new Font("Arial", Font.BOLD, 15));
        exibirServico.setForeground(new Color(0, 48, 73));
        add(exibirServico);

        exibirServico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelServicos.setRowCount(0);
                add(scrollServicos);
                for(Servico servico: administrador.getServicos()){
                    modelServicos.addRow(new Object[]{servico.getTipo(), servico.getPreco()});
                }
            }
        });

        JButton agendamentos = new JButton("Agendamentos");
        agendamentos.setBounds(50, 200, 200, 30);
        agendamentos.setFont(new Font("Arial", Font.BOLD, 15));
        agendamentos.setForeground(new Color(0, 48, 73));
        add(agendamentos);

        agendamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAgendamentos telaAgendamentos = new TelaAgendamentos(administrador);
                telaAgendamentos.setVisible(true);
            }
        });

    }

}
