package petshop.modelos;

public class Agendamentos {
    private Cliente cliente;
    private Servico servico;
    
    public Agendamentos(Cliente cliente, Servico servico) {
        this.cliente = cliente;
        this.servico = servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "Agendamento P/ Cliente: "+cliente + ", Serviço: "+servico;
    }
    
}
