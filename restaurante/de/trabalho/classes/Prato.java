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
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }

        String texto = this.nome + ";" + this.preco + "/";
        for (Ingredientes ingrediente : ingredientes) {
            texto = texto + ";" + ingrediente.getNome();
        }

        FileManager.escreverArquivo(arquivo, texto, true);
    }
    // Método para mostrar os detalhes dos pratos armazenados em um arquivo, incluindo nome, preço e ingredientes.
    public static void mostrarPratos(File arquivo) throws IOException {
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        int posicao = 1;
        for (String string : resultado) {
            String[] partes = string.split("/");
            String[] primeiraParte = partes[0].split(";");
            String[] segundaParte = partes[1].split(";");

            System.out.println("================================");
            System.out.println("Posicao: " + posicao);
            System.out.println("Nome: " + primeiraParte[0]);
            System.out.println("Preço: " + primeiraParte[1]);
            System.out.println("Ingredientes: ");
            for (String ingrediente : segundaParte) {
                System.out.print(ingrediente + " ");
            }
            System.out.println("\n================================");
            posicao++;

        }
    }
    // Metodo para deletar qualquer prato indicando a posicao que se encontra
    public static void deletarPratos(File arquivo, int posicao) throws IOException {
        FileManager.deletarItem(arquivo, posicao);
    }
    
    // Método para buscar e exibir os pratos que contêm um ingrediente específico, lendo informações de arquivos de ingredientes e pratos.
    public static void buscarPorIngrediente(File arquivoIngredientes, File arquivoPratos, int posicaoIngrediente) throws IOException {
        ArrayList<String> linhasIngredientes = FileManager.lerArquivo(arquivoIngredientes);

        if (posicaoIngrediente < 0 || posicaoIngrediente >= linhasIngredientes.size()) {
            System.out.println("Posição de ingrediente inválida.");
            return;
        }

        String nomeIngrediente = linhasIngredientes.get(posicaoIngrediente).replace(";", "");

        ArrayList<String> linhasPratos = FileManager.lerArquivo(arquivoPratos);

        System.out.println("Pratos que contêm o ingrediente '" + nomeIngrediente + "':");

        boolean pratoEncontrado = false;

        for (String linhaPrato : linhasPratos) {
            String[] partes = linhaPrato.split("/");
            String[] primeiraParte = partes[0].split(";");
            String[] ingredientesString = partes[1].split(";;");

            ArrayList<Ingredientes> ingredientesLista = new ArrayList<>();

            for (String ingrediente : ingredientesString) {
                ingrediente = ingrediente.replace(";", "");
                ingredientesLista.add(new Ingredientes(ingrediente));
            }

            for (Ingredientes ingrediente : ingredientesLista) {
                if (nomeIngrediente.equals(ingrediente.getNome())) {
                    if (!pratoEncontrado) {
                        pratoEncontrado = true;
                        System.out.println("================================");
                    }
                    System.out.println("Nome: " + primeiraParte[0]);
                    System.out.println("Preço: " + primeiraParte[1]);
                    System.out.println("Ingredientes:");
                    for (Ingredientes ingredientePrato : ingredientesLista) {
                        System.out.print(ingredientePrato.getNome() + " ");
                    }
                    System.out.println("\n================================");
                    break; 
                }
            }
        }

        if (!pratoEncontrado) {
            System.out.println("Nenhum prato encontrado com o ingrediente " + nomeIngrediente + ".");
        }
    }
}
