package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
     public static void criarArquivo(File arquivo) throws IOException {
        if(!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

    public static void deletarArquivo(File arquivo) throws IOException {
        if(arquivo.exists()) {
            arquivo.delete();
        }
    }

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
