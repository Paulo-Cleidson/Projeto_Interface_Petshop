package petshop.Teste;

import static org.junit.jupiter.api.Assertions.*;
import petshop.modelos.Produto;

public class ProdutoTeste {

    @org.junit.jupiter.api.Test
    public void getNomeProduto() {
        Produto produto1 = new Produto("Ração para cachorros", 50);
        produto1.setNomeProduto("Ração");

        assertEquals("Ração", produto1.getNomeProduto());
    }

}
