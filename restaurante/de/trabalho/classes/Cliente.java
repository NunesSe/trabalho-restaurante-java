package classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// Criação da classe Funcionario com o atributos nome e numero e seus respectivos setters e getters
public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

   
    // Metodo para poder realizar o cadastro do cliente 
    public void cadastrarCliente(File arquivo) throws IOException {
        if(!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        } 
        FileManager.escreverArquivo(arquivo, this.nome + ";", true);
    }
    // Metodo que mostrar os clientes cadastrado
    public static void mostrarCliente(File arquivo) throws IOException {
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        int posicao = 1;
        for (String string : resultado) {
            System.out.println("=========================================");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + string);
            System.out.println("=========================================");
            posicao++;
        }
    }
    // Metodo que deleta clientes ja cadastrado 
    public static void deletarCliente(File arquivo, int posicao) throws IOException {
        FileManager.deletarItem(arquivo, posicao);
    }

}
