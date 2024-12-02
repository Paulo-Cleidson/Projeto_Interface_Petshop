package petshop.controles;

import petshop.modelos.Agendamentos;
import petshop.modelos.Cliente;
import petshop.modelos.Estoque;
import petshop.modelos.Servico;

import java.util.ArrayList;

public class Administrador {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Servico> servicos = new ArrayList<>();
    private ArrayList<Agendamentos> listaAgendamentos = new ArrayList<>();
    private Estoque estoque;

    public Administrador() {
        this.estoque = new Estoque();
    }

    public void addClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente verificaCliente (String nome) {
        for (int i=0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equals(nome)) {
                return clientes.get(i);
            }
        }
        return null;
    }

    public Servico verificaServico (String string) {
        for (int i=0; i < servicos.size(); i++) {
            if (servicos.get(i).getTipo().equals(string)) {
                return servicos.get(i);
            }
        }
        return null;
    }

    public Agendamentos verificaAgendamento(String string) {
        for (Agendamentos agendamento : listaAgendamentos) {
            if(agendamento.toString().equals(string)) {
                return agendamento;
            }
        }
        return null;
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Estoque getEstoque() {
        return this.estoque;
    }

    public void addServicos(Servico servico) {
        servicos.add(servico);
    }

    public ArrayList<Servico> getServicos() {
        return this.servicos;
    }

    public void addAgendamento(Agendamentos agendamento) {
        listaAgendamentos.add(agendamento);
    }

    public void removerAgendamento(Agendamentos agendamento) {
        listaAgendamentos.remove(agendamento);
    }

    public ArrayList<Agendamentos> getListaAgendamentos() {
        return this.listaAgendamentos;
    }

    public void removeServico(Servico servico) {
        servicos.remove(servico);
    }

}
