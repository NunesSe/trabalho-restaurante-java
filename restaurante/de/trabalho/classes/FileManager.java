package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Metodo onde cria um diretório se ele não existir.
public class FileManager {
    public static void criarDiretorio(File arquivo) throws IOException {
        if(!arquivo.exists()) {
            arquivo.mkdir();
        }
    }
        // Metodo onde cria um arquivo caso ele nao exista.
     public static void criarArquivo(File arquivo) throws IOException {
        if(!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }
    // Metodo que possibilita deletar arquivos que existem.
    public static void deletarArquivo(File arquivo) throws IOException {
        if(arquivo.exists()) {
            arquivo.delete();
        }
    }
    // Método que escreve o texto em um arquivo caso ele existir ou criando um novo arquivo se não existir.
    public static void escreverArquivo(File arquivo, String texto, boolean append) throws IOException {
        if (!arquivo.exists()) {
            criarArquivo(arquivo);
        }
        FileWriter writer = new FileWriter(arquivo, append); 
        writer.write(texto);
        writer.write("\n");
        writer.flush();
        writer.close(); 
    }
    
    // Método que lê o conteúdo do arquivo linha por linha e o armazena em um ArrayList de Strings, criando o arquivo se não existir.
    public static ArrayList<String> lerArquivo(File arquivo) throws IOException {
        criarArquivo(arquivo);
        FileReader fileReader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = "";
        ArrayList<String> resultado = new ArrayList<String>();
        while((linha = bufferedReader.readLine()) != null) {
            
            resultado.add(linha);
        }

        fileReader.close();
        bufferedReader.close();
        return resultado;
    }

    // Método que deleta uma linha de um arquivo na posição especificada e imprime uma mensagem de sucesso.
    public static void deletarItem(File arquivo, int posicao) throws IOException {
        ArrayList<String> linhas = lerArquivo(arquivo);


        if (posicao < 0 || posicao >= linhas.size()) {
            System.out.println("Posição inválida.");
            return;
        }

        
        linhas.remove(posicao);
        deletarArquivo(arquivo);

        for (String linha : linhas) {
            escreverArquivo(arquivo, linha, true);
        }
    
        System.out.println("Item deletado com sucesso.");
    }
    
   
}
