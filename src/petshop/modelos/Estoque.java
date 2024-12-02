package petshop.modelos;

import java.util.ArrayList;

public class Estoque {

    private ArrayList<Produto> listaProdutos = new ArrayList<>();

    public void cadastrarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public int verificaListaProdutos(Produto produto) {
        return this.listaProdutos.size();
    }

    public Produto verificaProduto(String string) {
        for(Produto produto : listaProdutos){
            if(produto.getNomeProduto().equals(string)){
                return produto;
            }
        }
        return null;
    }

    public void removerProduto(Produto produto) {
        listaProdutos.remove(produto);
    }

    public ArrayList<Produto> getListaProdutos() {
        return this.listaProdutos;
    }

}
