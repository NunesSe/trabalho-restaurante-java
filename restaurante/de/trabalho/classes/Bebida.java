package classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Bebida {
    private String nome;
    private Double preco;

    public Bebida(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    // Cadastro de nova bebida
    public void cadastrarBebida(File arquivo) throws IOException {
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }

        String texto = this.nome + ";" + this.preco;
        FileManager.escreverArquivo(arquivo, texto, true);
    }

    // Mostra as bebidas cadastradas
    public static void mostrarBebidas(File arquivo) throws IOException {
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        int posicao = 1;
        for (String string : resultado) {
            String[] partes = string.split(";");
            System.out.println("================================");
            System.out.println("Posicao: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("Preço: " + partes[1]);
            System.out.println("================================");
            posicao++;
        }
    }

    // Deleta uma bebida
    public static void deletarBebida(File arquivo, int posicao) throws IOException {
        FileManager.deletarItem(arquivo, posicao);
    }
}
