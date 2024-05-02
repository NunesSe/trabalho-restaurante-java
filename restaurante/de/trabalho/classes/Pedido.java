package classes;

import java.io.File;
import java.io.IOException;
import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Prato> pratos;
    private ArrayList<Bebida> bebidas;
    private Double precoFinal;

    public Pedido(Cliente cliente, Funcionario funcionario, ArrayList<Prato> pratos, ArrayList<Bebida> bebidas) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pratos = pratos;
        this.bebidas = bebidas;
        calcularPrecoFinal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    // Método para calcular o preço final do pedido
    public void calcularPrecoFinal() {
        double precoPratos = 0.0;
        double precoBebidas = 0.0;

        // Calcula o preço total dos pratos
        if (pratos.size() > 0) {
            for (Prato prato : pratos) {
                precoPratos += prato.getPreco();
            }
        }

        // Calcula o preço total das bebidas
        if (bebidas.size() > 0) {
            for (Bebida bebida : bebidas) {
                precoBebidas += bebida.getPreco();
            }
        }

        // Soma os preços dos pratos e das bebidas para obter o preço final
        this.precoFinal = precoPratos + precoBebidas;
    }

    // Método para cadastrar pedidos em um arquivo
    public void cadastrarPedidos(File arquivo) throws IOException {
        if (!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        }

        String texto = this.cliente.getNome() + ";" + this.funcionario.getNome() + ";" + this.precoFinal;
        texto = texto + "/ ";
        for (Prato prato : pratos) {
            texto = texto + ";" + prato.getNome();
        }
        texto = texto + "/ ";
        for (Bebida bebida : bebidas) {
            texto = texto + ";" + bebida.getNome();
        }

        FileManager.escreverArquivo(arquivo, texto, true);
    }

    // Método para mostrar pedidos
    public static void mostrarPedidos(File arquivo) throws IOException {
        // Leitura de arquivo
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        // Inicialização de variavel
        int posicao = 1;
        // Looping para cada linha do arquivo
        for (String string : resultado) {
            //
            String resultadoString = string;
            String[] resultadoDados = resultadoString.split("/");
           
            String[] primeiraParte = resultadoDados[0].split(";");
            String[] pratosDados = resultadoDados[1].split(";");
            String[] bebidaDados = resultadoDados[2].split(";");
            System.out.println("================================");
            System.out.println("Posicao: " + posicao);
            System.out.println("Cliente: " + primeiraParte[0]);
            System.out.println("Funcionario: " + primeiraParte[1]);
            System.out.println("Preço total: " + primeiraParte[2]);
            System.out.println("Pratos: ");
            for (String prato : pratosDados) {
                System.out.print(prato + " ");
            }
            System.out.print("\n");
            System.out.println("Bebidas: ");
            for (String bebida : bebidaDados) {
                System.out.print(bebida + " ");
            }
            System.out.print("\n");
            posicao++;
        }
    }

    public static void deletarPedidos(File arquivo, int posicao) throws IOException{
        FileManager.deletarItem(arquivo, posicao);
    }}
