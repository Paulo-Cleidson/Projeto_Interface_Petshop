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

    public void editarProduto(Produto entradaProduto,String nome, int preco) {
        for(Produto p: listaProdutos) {
            if(p.getNomeProduto().equals(entradaProduto.getNomeProduto())) {
                p.setNomeProduto(nome);
                p.setPreco(preco);
            }
        }
    }

    public void removerProduto(Produto produto) {
        listaProdutos.remove(produto);
    }

    public String listarProdutos() {
        StringBuilder sb = new StringBuilder();
        for(Produto p: listaProdutos ) {
            sb.append(p);
        }
        return sb.toString();
    }

    public ArrayList<Produto> getListaProdutos() {
        return this.listaProdutos;
    }
}
