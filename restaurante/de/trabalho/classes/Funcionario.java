package classes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// Criação da classe Funcionario com o atributos nome, CPF, salario e função e seus respectivos setters e getters
public class Funcionario {
    private String nome;
    private String cpf;
    private Double salario;
    private String funcao;
 
    // Construtor
    public Funcionario(String nome, String cpf, Double salario, String funcao) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }


    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    // Metodo que realiza o cadastro 
     public void cadastrarFuncionario(File arquivo) throws IOException {
        if(!arquivo.exists()) {
            FileManager.criarArquivo(arquivo);
        } 
        FileManager.escreverArquivo(arquivo, this.nome + ";" + this.cpf + ";" + this.salario + ";" + 
        this.funcao, true);
    }
        // Metodo que mostra os funcionarios cadastrados
        public static void mostrarFuncionario(File arquivo) throws IOException {
        ArrayList<String> resultado = FileManager.lerArquivo(arquivo);
        int posicao = 1;
        for (String string : resultado) {
            String[] partes = string.split(";");
            System.out.println("=========================================");
            System.out.println("Posição: " + posicao);
            System.out.println("Nome: " + partes[0]);
            System.out.println("CPF: " + partes[1]);
            System.out.println("Salario: " + partes[2]);
            System.out.println("Função: " + partes[3]);
            System.out.println("=========================================");
            posicao++;
        }
    }
        // Metodo que deleta funcionario ja cadastrado
        public static void deletarFuncionario(File arquivo, int posicao) throws IOException {
            FileManager.deletarItem(arquivo, posicao);
        }
}
