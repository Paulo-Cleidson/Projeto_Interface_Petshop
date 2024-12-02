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

    private JLabel textoInicial;

    public TelaPrincipal(Administrador administrador) {

        setTitle("Tela do Administrador");
        setSize(770, 600);
        getContentPane().setBackground(new Color(102, 155, 188));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        textoInicial = new JLabel("======================================================================");
        textoInicial.setBounds(32, 270, 700, 20);
        textoInicial.setFont(new Font("Arial", Font.BOLD, 17));
        textoInicial.setForeground(new Color(0, 48, 73));
        add(textoInicial);

        JButton areaCliente = new JButton("Área Clientes");
        areaCliente.setBounds(270, 70, 200, 30);
        areaCliente.setFont(new Font("Arial", Font.BOLD, 15));
        areaCliente.setForeground(new Color(0, 48, 73));
        add(areaCliente);

        areaCliente.addActionListener(e -> {
            TelaCadastraCliente telaCliente = new TelaCadastraCliente(administrador);
            telaCliente.setVisible(true);
        });

        JButton exibirClientes = new JButton("Exibir Clientes");
        exibirClientes.setBounds(500, 70, 200, 30);
        exibirClientes.setFont(new Font("Arial", Font.BOLD, 15));
        exibirClientes.setForeground(new Color(0, 48, 73));
        add(exibirClientes);

        DefaultTableModel model = new DefaultTableModel(){
            // Impede a edição de todas as células
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Nome");
        model.addColumn("E-mail");
        model.addColumn("CPF");
        model.addColumn("Contato");
        model.addColumn("Data Nasc.");
        JTable tabel = new JTable(model);
        JScrollPane scrollClientes = new JScrollPane(tabel);
        scrollClientes.setBounds(30, 300, 700, 230);

        exibirClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoInicial.setText("Lista de Clientes Cadastrados:");
                // Remove todos os JScrollPane
                Component[] components = getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JScrollPane) {
                        remove(component); // Remove o componente do contêiner
                    }
                }
                model.setRowCount(0);
                add(scrollClientes);
                for(Cliente cliente: administrador.getClientes()){
                    model.addRow(new Object[]{cliente.getNome(), cliente.getEmail(),
                            cliente.getCpf(), cliente.getContato(), cliente.getDataNascimento()});
                }
            }
        });

        JButton exibirPets = new JButton("Exibir Pets");
        exibirPets.setBounds(50, 220, 200, 30);
        exibirPets.setFont(new Font("Arial", Font.BOLD, 15));
        exibirPets.setForeground(new Color(0, 48, 73));
        add(exibirPets);

        exibirPets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaExibePets telaExibePets = new TelaExibePets(administrador);
                telaExibePets.setVisible(true);
            }
        });

        JButton estoque = new JButton("Estoque");
        estoque.setBounds(270, 120, 200, 30);
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
        exibirEstoque.setBounds(500, 120, 200, 30);
        exibirEstoque.setFont(new Font("Arial", Font.BOLD, 15));
        exibirEstoque.setForeground(new Color(0, 48, 73));
        add(exibirEstoque);

        DefaultTableModel modelEstoque = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelEstoque.addColumn("Produto");
        modelEstoque.addColumn("Preço");
        JTable tabelEstoque = new JTable(modelEstoque);
        JScrollPane scrollEstoque = new JScrollPane(tabelEstoque);
        scrollEstoque.setBounds(30, 300, 700, 230);

        exibirEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoInicial.setText("Lista de Produtos em Estoque:");
                Component[] components = getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JScrollPane) {
                        remove(component);
                    }
                }
                modelEstoque.setRowCount(0);
                add(scrollEstoque);
                for(Produto produto: administrador.getEstoque().getListaProdutos()){
                    modelEstoque.addRow(new Object[]{produto.getNomeProduto(), produto.getPreco()});
                }
            }
        });

        JButton cadastrarServico = new JButton("Cadastrar Serviços");
        cadastrarServico.setBounds(270, 170, 200, 30);
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

        DefaultTableModel modelServicos = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelServicos.addColumn("Tipo de Serviço");
        modelServicos.addColumn("Valor do Serviço");
        JTable tabelServicos = new JTable(modelServicos);
        JScrollPane scrollServicos = new JScrollPane(tabelServicos);
        scrollServicos.setBounds(30, 300, 700, 230);

        JButton exibirServico = new JButton("Exibir Serviços");
        exibirServico.setBounds(500, 170, 200, 30);
        exibirServico.setFont(new Font("Arial", Font.BOLD, 15));
        exibirServico.setForeground(new Color(0, 48, 73));
        add(exibirServico);

        exibirServico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoInicial.setText("Lista de Serviços Cadastrados:");
                Component[] components = getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JScrollPane) {
                        remove(component);
                    }
                }
                modelServicos.setRowCount(0);
                add(scrollServicos);
                for(Servico servico: administrador.getServicos()){
                    modelServicos.addRow(new Object[]{servico.getTipo(), servico.getPreco()});
                }
            }
        });

        JButton agendamentos = new JButton("Agendamentos");
        agendamentos.setBounds(270, 220, 200, 30);
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

        DefaultTableModel modelAgendamentos = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modelAgendamentos.addColumn("Nome do Cliente");
        modelAgendamentos.addColumn("Serviço Agendado");
        JTable tabelAgendamentos = new JTable(modelAgendamentos);
        JScrollPane scrollAgendamentos = new JScrollPane(tabelAgendamentos);
        scrollAgendamentos.setBounds(30, 300, 700, 230);

        JButton exibirAgendamentos = new JButton("Exibir Agendamentos");
        exibirAgendamentos.setBounds(500, 220, 200, 30);
        exibirAgendamentos.setFont(new Font("Arial", Font.BOLD, 15));
        exibirAgendamentos.setForeground(new Color(0, 48, 73));
        add(exibirAgendamentos);

        exibirAgendamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoInicial.setText("Lista de Serviços Agendados:");
                Component[] components = getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JScrollPane) {
                        remove(component);
                    }
                }
                modelAgendamentos.setRowCount(0);
                add(scrollAgendamentos);
                for(int i=0; i < administrador.getListaAgendamentos().size(); i++)
                    modelAgendamentos.addRow(new Object[]{administrador.getListaAgendamentos().
                            get(i).getCliente().getNome(), administrador.getListaAgendamentos().
                            get(i).getServico().getTipo()});

                }

        });

        // Caminho da imagem
        String imagePath = "src/petshop/icons/logo.png";
        // Carrega a imagem
        ImageIcon imageIcon = new ImageIcon(imagePath);
        // Redimensiona a imagem (opcional)
        Image scaledImage = imageIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        // Adiciona a imagem em um JLabel
        JLabel labelImage = new JLabel(imageIcon);
        labelImage.setBounds(60,50,180,180);
        add(labelImage);

        String imagemLogo = "src/petshop/icons/logo01.png";
        ImageIcon imagemLogoIcon = new ImageIcon(imagemLogo);
        Image scaledImagemLogo = imagemLogoIcon.getImage().getScaledInstance(150,50, Image.SCALE_SMOOTH);
        imagemLogoIcon = new ImageIcon(scaledImagemLogo);
        JLabel labelImagemLogo = new JLabel(imagemLogoIcon);
        labelImagemLogo.setBounds(75,10,150,50);
        add(labelImagemLogo);

    }

}
