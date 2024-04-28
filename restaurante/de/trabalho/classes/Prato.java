package classes;

import java.util.ArrayList;

// Criação da classe Prato com os atributos nome, ingredientes e preço e seus respectivos setters e getters
public class Prato {
    private String nome;
    private ArrayList<Ingredientes> ingredientes;
    private Double preco;

    public ArrayList<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
