package petshop.Teste;

import org.junit.Test;
import petshop.modelos.Estoque;
import petshop.modelos.Produto;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstoqueTeste {

    @org.junit.jupiter.api.Test
    public void verificaListaProdutos(){

        Produto produto1 = new Produto("Ração", 45);
        Estoque estoque1 = new Estoque();
        estoque1.cadastrarProduto(produto1);
        estoque1.verificaListaProdutos(produto1);

        assertEquals(1, estoque1.verificaListaProdutos(produto1));
    }
}
