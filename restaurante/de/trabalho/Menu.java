import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import classes.Cliente;
import classes.FileManager;
import classes.Funcionario;
import classes.Ingredientes;

public class Menu {
    public static void main(String[] args) throws IOException {
        File caminho = new File("arquivos");
        FileManager.criarDiretorio(caminho);

        escolhaMenu();
    }

    public static void mostrarMenu() {
        System.out.println("======= MENU PRINCIPAL =======");
        System.out.println("[0] Sair");
        System.out.println("[1] Cliente");
        System.out.println("[2] Funcionario");
        System.out.println("[3] Ingredientes");
        System.out.println("Digite o que deseja fazer: ");
    }

    public static void escolhaMenu() throws IOException {
        Scanner scan = new Scanner(System.in);
        int opcao = -1;
        while (opcao != 0) {
            mostrarMenu();
            opcao = scan.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    File arquivoCliente = new File("./arquivos/clientes.txt");
                    FileManager.criarArquivo(arquivoCliente);
                    menuCliente(scan, arquivoCliente);
                    break;
                case 2:
                    File arquivoFuncionario = new File("./arquivos/funcionarios.txt");
                    FileManager.criarArquivo(arquivoFuncionario);
                    menuFuncionario(scan, arquivoFuncionario);
                    break;
                case 3:
                    File arquivoIngredientes = new File("./arquivos/ingredientes.txt");
                    FileManager.criarArquivo(arquivoIngredientes);
                    menuIngredientes(scan, arquivoIngredientes);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    public static void menuCliente(Scanner scan, File arquivoCliente) throws IOException {
        int opcaoCliente;
        do {
            System.out.println("======= MENU CLIENTE =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar um cliente");
            System.out.println("[2] Ver clientes cadastrados");
            System.out.println("[3] Excluir um cliente");
            opcaoCliente = scan.nextInt();
            switch (opcaoCliente) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    System.out.println("Digite seu nome: ");
                    String nome = scan.next();

                    Cliente cliente = new Cliente(nome);
                    cliente.cadastrarCliente(arquivoCliente);
                    System.out.println("Cliente cadastrado!");
                    break;
                case 2:
                    Cliente.mostrarCliente(arquivoCliente);
                    break;
                case 3:
                    Cliente.mostrarCliente(arquivoCliente);
                    System.out.println("Digite a posição do item que deseja deletar: ");
                    int posicao = scan.nextInt() - 1;
                    FileManager.deletarItem(arquivoCliente, posicao);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoCliente != 0);
    }

    public static void menuFuncionario(Scanner scan, File arquivoFuncionario) throws IOException {
        int opcaoFuncionario;
        do {
            System.out.println("======= MENU FUNCIONÁRIO =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar um funcionário");
            System.out.println("[2] Ver funcionários cadastrados");
            System.out.println("[3] Excluir um funcionário");
            opcaoFuncionario = scan.nextInt();
            switch (opcaoFuncionario) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    System.out.println("Digite o nome do funcionário: ");
                    String nome = scan.next();
                    System.out.println("Digite o CPF do funcionário: ");
                    String cpf = scan.next();
                    System.out.println("Digite o salário do funcionário: ");
                    Double salario = scan.nextDouble();
                    System.out.println("Digite a função do funcionário: ");
                    String funcao = scan.next();

                    Funcionario funcionario = new Funcionario(nome, cpf, salario, funcao);
                    funcionario.cadastrarFuncionario(arquivoFuncionario);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;
                case 2:
                    Funcionario.mostrarFuncionario(arquivoFuncionario);
                    break;
                case 3:
                    Funcionario.mostrarFuncionario(arquivoFuncionario);
                    System.out.println("Digite a posição do item que deseja deletar: ");
                    int posicao = scan.nextInt() - 1;
                    FileManager.deletarItem(arquivoFuncionario, posicao);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoFuncionario != 0);
    }

    public static void menuIngredientes(Scanner scan, File arquivoIngredientes) throws IOException {
        int opcaoIngredientes;
        do {
            System.out.println("======= MENU INGREDIENTES =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar um ingrediente");
            System.out.println("[2] Ver ingredientes cadastrados");
            System.out.println("[3] Excluir um ingrediente");
            opcaoIngredientes = scan.nextInt();
            switch (opcaoIngredientes) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    System.out.println("Digite o nome do ingrediente: ");
                    String nomeIngrediente = scan.next();

                    Ingredientes ingrediente = new Ingredientes(nomeIngrediente);
                    ingrediente.cadastrarIngrediente(arquivoIngredientes);
                    System.out.println("Ingrediente cadastrado!");
                    break;
                case 2:
                    Ingredientes.mostrarIngredientes(arquivoIngredientes);
                    break;
                case 3:
                    Ingredientes.mostrarIngredientes(arquivoIngredientes);
                    System.out.println("Digite a posição do ingrediente que deseja excluir: ");
                    int posicao = scan.nextInt() - 1;
                    FileManager.deletarItem(arquivoIngredientes, posicao);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoIngredientes != 0);
    }
}
