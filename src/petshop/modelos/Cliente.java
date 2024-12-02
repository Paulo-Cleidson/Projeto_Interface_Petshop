package petshop.modelos;

import java.util.ArrayList;

public interface Cliente {

    void setNome(String string);
    void setEmail(String string);
    void setCpf(String string);
    void setContato(int i);
    void setDataNascimento(int i);
    String getNome();
    String getEmail();
    String getCpf();
    int getContato();
    int getDataNascimento();
    void cadastarPet(Pet pet);
    void removerPet(Pet pet);
    Pet verificaPet(String string);
    ArrayList getListaPetsCliente();

}
