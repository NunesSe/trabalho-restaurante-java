import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Cliente;
import classes.FileManager;
import classes.Funcionario;
import classes.Ingredientes;
import classes.Prato;

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
        System.out.println("[4] Pratos");
        System.out.println("Digite o que deseja fazer: ");
    }

    public static void escolhaMenu() throws IOException {
        // Inicialização do Scanner
        Scanner scan = new Scanner(System.in);
        // Inicialização das variaveis de arquivos e criação dos mesmos se necessario
        File arquivoCliente = new File("./arquivos/clientes.txt");
        FileManager.criarArquivo(arquivoCliente);

        File arquivoFuncionario = new File("./arquivos/funcionarios.txt");
        FileManager.criarArquivo(arquivoFuncionario);

        File arquivoIngredientes = new File("./arquivos/ingredientes.txt");
        FileManager.criarArquivo(arquivoIngredientes);

        File arquivoPratos = new File("./arquivos/pratos.txt");
        FileManager.criarArquivo(arquivoPratos);

        int opcao = -1;
        while (opcao != 0) {
            mostrarMenu();
            opcao = scan.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    menuCliente(scan, arquivoCliente);
                    break;
                case 2:
                    menuFuncionario(scan, arquivoFuncionario);
                    break;
                case 3:
                    menuIngredientes(scan, arquivoIngredientes);
                    break;
                case 4:
                    menuPratos(scan, arquivoPratos, arquivoIngredientes);
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
                    ingrediente.cadastrarIngredientes(arquivoIngredientes);
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

    public static void menuPratos(Scanner scan, File arquivoPratos, File arquivoIngredientes) throws IOException {
        int opcaoPratos;
        do {
            System.out.println("======= MENU PRATOS =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar um prato");
            System.out.println("[2] Ver pratos cadastrados");
            System.out.println("[3] Excluir um prato");
            opcaoPratos = scan.nextInt();
            switch (opcaoPratos) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    // Inciailização da variavel de escolha
                    int ingredientesEscolhido;

                    // Recebendo nome
                    System.out.println("Digite o nome do prato: ");
                    String nome = scan.next();

                    // Criação de array para armazenar os nomes dos ingredientes
                    ArrayList<String> nomesIngredientes = new ArrayList<>();

                    // Mostrando lista de ingredientes
                     Ingredientes.mostrarIngredientes(arquivoIngredientes);

                    // Criação de do-while para poder adicionar varios ingredientes em um prato
                    do {
                        

                        // Escolha ingrediente para ser adicionado ao prato
                        System.out.println("Digite a posição do ingrediente que deseja adicionar ao prato: ");
                        System.out.println("0 - PARA SALVAR / SAIR");
                        ingredientesEscolhido = scan.nextInt();

                        // Sai do do while se a escolha for 0
                        if(ingredientesEscolhido == 0) {
                            break;
                        }

                        // Verifica se a escolha é uma posição valida
                        if (ingredientesEscolhido > 0 && ingredientesEscolhido <= FileManager.lerArquivo(arquivoIngredientes).size()) {
                            // Inicialização da variavel
                            String nomeIngrediente = FileManager.lerArquivo(arquivoIngredientes).get(ingredientesEscolhido - 1);

                            // Se não ainda não foi adicionado, adiciona o ingrediente
                            if(!nomesIngredientes.contains(nomeIngrediente)) {
                                System.out.println("Ingrediente adicionado: " + nomeIngrediente );
                                nomesIngredientes.add(nomeIngrediente);
                            } 
                            // Mensagem de erro caso ingrediente ja esteja na lista
                            else {
                                System.out.println("Esse ingrediente ja foi selecionado!");
                            }
                        } 
                        // Mensagem de erro para posição invalida
                        else {
                            System.out.println("Digite uma posição valida!");
                        }

                       
                    } while (ingredientesEscolhido != 0);

                    // Volta ao menu se nenhum ingrediente foi selecionado
                    if (nomesIngredientes.size() == 0) {
                        System.out.println("Não selecionou nenhum ingrediente!");
                        break;
                    }

                    // Criação da array ingredientes
                    ArrayList<Ingredientes> ingredientes = new ArrayList<>();
                    for (String texto : nomesIngredientes) {
                        // Transformação de nomes para objetos
                        Ingredientes ingredienteTemporario = new Ingredientes(texto);
                        // Adicionando o objeto ao array
                        ingredientes.add(ingredienteTemporario);
                    }

                    // Solicitação de preço
                    System.out.println("Digite o preço do prato: ");
                    Double preco = scan.nextDouble();

                    // Criação do Prato em si
                    Prato prato = new Prato(nome, preco, ingredientes);
                    // Cadastro do prato no arquivo
                    prato.cadastrarPratos(arquivoPratos);
                    System.out.println("Prato registrado com sucesso!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoPratos != 0);

    }
}
