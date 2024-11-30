import petshop.modelos.*;
import petshop.telas.TelaPrincipal;
import petshop.controles.Administrador;

public class Main {
    public static void main(String[] args) {

        Administrador petshop = new Administrador();

        TelaPrincipal tela = new TelaPrincipal(petshop);
        tela.setVisible(true);

    }
}
