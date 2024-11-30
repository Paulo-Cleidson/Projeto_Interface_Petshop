package petshop.modelos;

import java.util.ArrayList;

public class ClientePadrao implements Cliente {

    private String nome;
    private String email;
    private String cpf;
    private int contato;
    private int dataNascimento;

    private ArrayList<Pet> listaPetsCliente = new ArrayList<>();

    public ClientePadrao(String nome, String email, String cpf, int contato, int dataNascimento) throws Exception {

        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.contato = contato;
        this.dataNascimento = dataNascimento;

        if (nome == null || nome.isEmpty()){
            throw new Exception("O campo nome está vazio!");
        }

        if (email == null || !email.contains("@")){
            throw new Exception("O e-mail está inválido!");
        }

        if (cpf == null || cpf.length() != 11){
            throw new Exception("O CPF deve conter 11 dígitos, tente novamente!");
        }

        if (contato <= 0){
            throw new Exception("Preencha um número de contato válido!");
        }

        if (dataNascimento <= 19000101 || dataNascimento >= 20240101){
            throw new Exception("A data de nascimento é inválida!");
        }

    }

    @Override
    public void cadastarPet(Pet pet) {
        this.listaPetsCliente.add(pet);
    }

    @Override
    public void removerPet(Pet pet) {
        this.listaPetsCliente.remove(pet);
    }

    @Override
    public Pet verificaPet(String nome) {
        for (int i=0; i < listaPetsCliente.size(); i++){
            if(listaPetsCliente.get(i).getNomePet().equals(nome)){
                return listaPetsCliente.get(i);
            }
        }
        return null;
    }

    @Override
    public String exibirPets() {
        StringBuilder sb = new StringBuilder();
        for(Pet pet: listaPetsCliente) {
            sb.append(pet);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Nome: "+nome + ", Email: "+email + ", CPF:"+cpf + ", Contato: "+contato +
                ", Data de Nascimento: "+dataNascimento;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int getContato() {
        return contato;
    }

    @Override
    public void setContato(int contato) {
        this.contato = contato;
    }

    @Override
    public int getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public ArrayList<Pet> getListaPetsCliente() {
        return this.listaPetsCliente;
    }

}
