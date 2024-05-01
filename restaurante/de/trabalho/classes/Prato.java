package classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// Criação da classe Prato com os atributos nome, ingredientes e preço e seus respectivos setters e getters
public class Prato {
    private String nome;
    private Double preco;
    private ArrayList<Ingredientes> ingredientes;

    public Prato(String nome, Double preco, ArrayList<Ingredientes> ingredientes) {
        this.nome = nome;
        this.preco = preco;
        this.ingredientes = ingredientes;
    }

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
 
    public void cadastrarPratos(File arquivo) throws IOException {
        if(!arquivo.exists()){
            FileManager.criarArquivo(arquivo);
        }
        
        String texto = this.nome + ";" + this.preco;
        for (Ingredientes ingrediente : ingredientes) {
            texto = texto + ";" + ingrediente.getNome();
        }
        
        FileManager.escreverArquivo(arquivo, texto, true);
    }

}
