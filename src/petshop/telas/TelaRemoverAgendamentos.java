package petshop.telas;

import petshop.controles.Administrador;
import petshop.modelos.Agendamentos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRemoverAgendamentos extends JFrame {

    public TelaRemoverAgendamentos(Administrador administrador) {

        setTitle("Canselar Agendamentos");
        setSize(350, 200);
        getContentPane().setBackground(new Color(102, 155, 188));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel dadosAgendamentos = new JLabel("Lista de Agendamentos");
        dadosAgendamentos.setBounds(15,10,250,25);
        dadosAgendamentos.setForeground(new Color(0, 48, 73));
        dadosAgendamentos.setFont(new Font("Poppins", Font.BOLD, 18));
        add(dadosAgendamentos);

        JComboBox<String> listaDeAgendamentos = new JComboBox<>();
        listaDeAgendamentos.setBounds(15,50,305,24);
        for(Agendamentos agendamentos : administrador.getListaAgendamentos()){
            listaDeAgendamentos.addItem(agendamentos.toString());
        }
        add(listaDeAgendamentos);

        JButton removerAgendamento = new JButton("Remover Agendamento");
        removerAgendamento.setBounds(15, 100, 170, 30);
        removerAgendamento.setFont(new Font("Arial", Font.BOLD, 12));
        removerAgendamento.setForeground(new Color(0, 48, 73));
        add(removerAgendamento);

        removerAgendamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agendamentos agendamento = administrador.
                        verificaAgendamento(String.valueOf(listaDeAgendamentos.getSelectedItem()));
                administrador.removerAgendamento(agendamento);
                JOptionPane.showMessageDialog(null,"Agendamento Cancelado!");

            }

        });

    }

}
