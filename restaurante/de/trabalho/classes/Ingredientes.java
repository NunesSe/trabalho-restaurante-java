package classes;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Ingredientes {
    private String nome;
    
    public Ingredientes(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     //Cadastra os novos ingredientes;
    public void cadastrarIngredientes(File arquivo) throws IOException{               
        if(!arquivo.exists()){
            FileManager.criarArquivo(arquivo);
        }
        FileManager.escreverArquivo(arquivo, this.nome + ";", true);
    }
    
    // Mostra os ingredientes disponiveis do estabelecimento;
    public static void mostrarIngredientes(File arquivo) throws IOException{           
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        int posicao = 1;
        for(String string : resultado) {
            String[] partes = string.split(";");
            System.out.println("================================");
            System.out.println("Posicao: "+posicao);
            System.out.println("Nome: "+partes[0]);
            System.out.println("================================");
            posicao++;
        
        }
    }
    // Deleta os ingredientes 
    public static void deletarIngredientes(File arquivo, int posicao) throws IOException{
        FileManager.deletarItem(arquivo, posicao);
    }
}
