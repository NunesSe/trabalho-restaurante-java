package classes;

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
}
