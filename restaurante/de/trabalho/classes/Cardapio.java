package classes;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Prato> pratos;
    private ArrayList<Bebida> bebidas;

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }  

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }
}
