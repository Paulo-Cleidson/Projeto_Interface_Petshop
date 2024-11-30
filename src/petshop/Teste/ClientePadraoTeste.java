package petshop.Teste;
import org.junit.jupiter.api.Test;
import petshop.modelos.ClientePadrao;
import petshop.modelos.Pet;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientePadraoTeste {

    @org.junit.jupiter.api.Test
    public void exibirPets() throws Exception {
        ClientePadrao clientePadrao = new ClientePadrao("neto","netinho@","12345678111",9999999,20022006);
        Pet pet1 = new Pet("rex","cachorro","vira lata",2);
        clientePadrao.cadastarPet(pet1);
        clientePadrao.verificapetlist(pet1);
        assertEquals(1,clientePadrao.verificapetlist(pet1));
    }
    @org.junit.jupiter.api.Test
    public void removerPet() throws Exception {
        ClientePadrao clientePadrao1 = new ClientePadrao("neton","netinhon@","12345678112",9199999,20022006);
        Pet pet2 = new Pet("pingo","gato","sein",3);
        clientePadrao1.cadastarPet(pet2);
        ClientePadrao clientePadrao2 = new ClientePadrao("netom","netinhom@","12345677112",9199199,20022006);
        Pet pet3 = new Pet("chica","cachorro","pitbull",5);
        clientePadrao2.cadastarPet(pet3);
        clientePadrao2.removerPet(pet2);
        clientePadrao2.verificapetlist(pet2);
        assertEquals(1,clientePadrao2.verificapetlist(pet2));
    }

}
