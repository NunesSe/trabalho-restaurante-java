import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import classes.Cliente;
import classes.FileManager;

public class Menu {
    public static void main(String[] args) throws IOException {
        // Inicialização de arquivos
        escolhaMenu();
    }

    public static void mostrarMenu() {
        System.out.println("======= MENU PRINCIPAL =======");
        System.out.println("[0] Sair");
        System.out.println("[1] Cliente");
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
                    // Inicialização do arquivo de clientes
                    File arquivoCliente = new File("./arquivos/clientes.txt");
                    FileManager.criarArquivo(arquivoCliente);
                    menuCliente(scan, arquivoCliente);
                    
                    break;
                default:
                    System.out.println("Opção invalida!");
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
                                System.out.println("Digite seu telefone: ");
                                String telefone = scan.next();

                                Cliente cliente = new Cliente(nome, telefone);
                                cliente.cadastrarCliente(arquivoCliente);
                                System.out.println("Cliente cadastrado!");
                                break;
                            case 2:
                                Cliente.mostrarCliente(arquivoCliente);
                                break;
                            case 3:
                                Cliente.mostrarCliente(arquivoCliente);
                                System.out.println("Digite a posição do item que deseja deletar: ");
                                Scanner scannerExclusao = new Scanner(System.in);
                                int posicao = scannerExclusao.nextInt() - 1;
                                FileManager.deletarItem(arquivoCliente, posicao);
                                break;
                            default:
                                System.out.println("Opção invalida!");
                                break;
                        }
                    } while (opcaoCliente != 0);
    }
}
