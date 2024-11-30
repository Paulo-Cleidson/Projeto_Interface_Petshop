package petshop.modelos;

import java.util.ArrayList;

public interface Cliente {

    void cadastarPet(Pet pet);
    void removerPet(Pet pet);
    Pet verificaPet(String string);
    String exibirPets();
    String getNome();
    String getEmail();
    public String getCpf();
    public int getContato();
    public int getDataNascimento();
    public ArrayList getListaPetsCliente();

    void setNome(String string);
    void setEmail(String string);
    void setCpf(String string);
    void setDataNascimento(int i);
    void setContato(int i);

}
