package petshop.modelos;

public class Pet {

    private String nomePet;
    private String especie;
    private String raca;
    private int idade;

    public Pet(String nomePet, String especie, String raca, int idade) throws Exception {

        this.nomePet = nomePet;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;

        if(nomePet == null || nomePet.trim().isEmpty()){
            throw new Exception("Preencha o nome do pet! ");
        }
        if (especie == null || especie.trim().isEmpty()){
            throw new Exception("Preencha a espécie do pet!");
        }
        if (raca == null || raca.trim().isEmpty()){
            throw new Exception("Preencha a raça do pet!");
        }
        if (idade < 0){
            throw new Exception("Idade inválida!");
        }
    }

    @Override
    public String toString() {
        return "Nome do Pet: "+nomePet + ", Espécie: "+especie + ", Raça: "+raca + ", Idade: "+idade + "\n";
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

}
