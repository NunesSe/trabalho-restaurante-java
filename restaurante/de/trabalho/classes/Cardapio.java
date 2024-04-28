package classes;

import java.util.ArrayList;

public class Cardapio {
    private ArrayList<Prato> pratos;

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }  
}
