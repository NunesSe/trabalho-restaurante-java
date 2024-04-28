package classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// Criação da classe Funcionario com o atributos nome e numero e seus respectivos setters e getters
public class Cliente {
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void cadastrarCliente(File arquivo) throws IOException {
        if(!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        } 
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.telefone, true);
    }

    public static void mostrarCliente(File arquivo) throws IOException {
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        int posicao = 1;
        for (String string : resultado) {
            String[] partes = string.split(";");
            System.out.println("=========================================");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("Telefone: " + partes[1]);
            System.out.println("=========================================");
            posicao++;
        }
    }

    public static void deletarCliente(File arquivo, int posicao) throws IOException {
        FileManager.deletarItem(arquivo, posicao);
    }
}
