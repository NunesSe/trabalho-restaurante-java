import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Bebida;
import classes.Cliente;
import classes.FileManager;
import classes.Funcionario;
import classes.Ingredientes;
import classes.Pedido;
import classes.Prato;

public class Menu {
    public static void main(String[] args) throws IOException {
        File caminho = new File("./arquivos");
        FileManager.criarDiretorio(caminho);

        escolhaMenu();
    }
    //Metodo que mostra o menu para navegar pelo codigo
    public static void mostrarMenu() {
        System.out.println("======= MENU PRINCIPAL =======");
        System.out.println("[0] Sair");
        System.out.println("[1] Clientes");
        System.out.println("[2] Funcionarios");
        System.out.println("[3] Ingredientes");
        System.out.println("[4] Pratos");
        System.out.println("[5] Bebidas");
        System.out.println("[6] Pedidos (principal)");
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

        File arquivoBebidas = new File("./arquivos/bebidas.txt");
        FileManager.criarArquivo(arquivoBebidas);

        File arquivoPedidos = new File("./arquivos/pedidos.txt");
        FileManager.criarArquivo(arquivoPedidos);

        int opcao = -1;
        //  Loop para exibir o menu e processar a escolha do usuário
        while (opcao != 0) {
            // Linhas para limpar o terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();
            // Exibe o menu de opções
            mostrarMenu();
            opcao = Integer.parseInt(scan.nextLine()); // Lê a opção escolhida pelo usuário
            // Realiza a ação correspondente à opção escolhida
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
                    menuIngrediente(scan, arquivoIngredientes);
                    break;
                case 4:
                    menuPrato(scan, arquivoPratos, arquivoIngredientes);
                    break;
                case 5:
                    menuBebida(scan, arquivoBebidas);
                    break;
                case 6:
                    menuPedido(scan, arquivoPedidos, arquivoFuncionario, arquivoCliente, arquivoPratos, arquivoBebidas);
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
            opcaoCliente = Integer.parseInt(scan.nextLine());
            switch (opcaoCliente) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                 // Opção para cadastrar um novo cliente    
                System.out.println("Digite seu nome: ");  
                    String nome = scan.nextLine();

                    Cliente cliente = new Cliente(nome);
                    cliente.cadastrarCliente(arquivoCliente);
                    System.out.println("Cliente cadastrado!");
                    break;
                case 2:
                    Cliente.mostrarCliente(arquivoCliente); // Opção para mostrar os clientes cadastrados
                    break;
                case 3:
                    // Opção para excluir um cliente
                    Cliente.mostrarCliente(arquivoCliente);
                    System.out.println("Digite a posição do item que deseja deletar: ");
                    int posicao = Integer.parseInt(scan.nextLine()) - 1;
                    FileManager.deletarItem(arquivoCliente, posicao);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoCliente != 0); // Continua o loop até o usuário escolher sair
    }

    public static void menuFuncionario(Scanner scan, File arquivoFuncionario) throws IOException {
        int opcaoFuncionario;
        do {
            System.out.println("======= MENU FUNCIONÁRIO =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar um funcionário");
            System.out.println("[2] Ver funcionários cadastrados");
            System.out.println("[3] Excluir um funcionário");
            opcaoFuncionario = Integer.parseInt(scan.nextLine());
            switch (opcaoFuncionario) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    // Opção para cadastrar um novo funcionário
                    System.out.println("Digite o nome do funcionário: ");
                    String nome = scan.nextLine();
                    System.out.println("Digite o CPF do funcionário: ");
                    String cpf = scan.nextLine();
                    System.out.println("Digite o salário do funcionário: ");
                    Double salario = Double.parseDouble(scan.nextLine());
                    System.out.println("Digite a função do funcionário: ");
                    String funcao = scan.nextLine();

                    Funcionario funcionario = new Funcionario(nome, cpf, salario, funcao);
                    funcionario.cadastrarFuncionario(arquivoFuncionario);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;
                case 2:
                    // Opção para mostrar os funcionários cadastrados
                    Funcionario.mostrarFuncionario(arquivoFuncionario);
                    break;
                case 3:
                    // Opção para excluir um funcionário
                    Funcionario.mostrarFuncionario(arquivoFuncionario);
                    System.out.println("Digite a posição do item que deseja deletar: ");
                    int posicao = Integer.parseInt(scan.nextLine()) - 1;
                    FileManager.deletarItem(arquivoFuncionario, posicao);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoFuncionario != 0);  // Continua o loop até o usuário escolher sair
    }

    public static void menuIngrediente(Scanner scan, File arquivoIngredientes) throws IOException {
        int opcaoIngredientes;
        do {
            System.out.println("======= MENU INGREDIENTES =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar um ingrediente");
            System.out.println("[2] Ver ingredientes cadastrados");
            System.out.println("[3] Excluir um ingrediente");
            opcaoIngredientes = Integer.parseInt(scan.nextLine());
            switch (opcaoIngredientes) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    System.out.println("Digite o nome do ingrediente: ");
                    String nomeIngrediente = scan.nextLine();

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
                    int posicao = Integer.parseInt(scan.nextLine()) - 1;
                    FileManager.deletarItem(arquivoIngredientes, posicao);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoIngredientes != 0);
    }
    // Mostra o menu dos pratos disponiveis
    public static void menuPrato(Scanner scan, File arquivoPratos, File arquivoIngredientes) throws IOException {
        int opcaoPratos;
        do {
            System.out.println("======= MENU PRATOS =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar um prato");
            System.out.println("[2] Ver pratos cadastrados");
            System.out.println("[3] Excluir um prato");
            System.out.println("[4] Pesquisar por ingredientes");
            opcaoPratos = Integer.parseInt(scan.nextLine());
            switch (opcaoPratos) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    // Inciailização da variavel de escolha
                    int ingredientesEscolhido;

                    // Recebendo nome
                    System.out.println("Digite o nome do prato: ");
                    String nome = scan.nextLine();

                    // Criação de array para armazenar os nomes dos ingredientes
                    ArrayList<String> nomesIngredientes = new ArrayList<>();

                    // Mostrando lista de ingredientes
                    Ingredientes.mostrarIngredientes(arquivoIngredientes);

                    // Criação de do-while para poder adicionar varios ingredientes em um prato
                    do {

                        // Escolha ingrediente para ser adicionado ao prato
                        System.out.println("Digite a posição do ingrediente que deseja adicionar ao prato: ");
                        System.out.println("0 - PARA SALVAR / SAIR");
                        ingredientesEscolhido = Integer.parseInt(scan.nextLine());

                        // Sai do do while se a escolha for 0
                        if (ingredientesEscolhido == 0) {
                            break;
                        }

                        // Verifica se a escolha é uma posição valida
                        if (ingredientesEscolhido > 0
                                && ingredientesEscolhido <= FileManager.lerArquivo(arquivoIngredientes).size()) {
                            // Inicialização da variavel
                            String nomeIngrediente = FileManager.lerArquivo(arquivoIngredientes)
                                    .get(ingredientesEscolhido - 1);

                            // Se não ainda não foi adicionado, adiciona o ingrediente
                            if (!nomesIngredientes.contains(nomeIngrediente)) {
                                System.out.println("Ingrediente adicionado: " + nomeIngrediente);
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
                    
                    Double preco = Double.parseDouble(scan.nextLine());

                    // Criação do Prato em si
                    Prato prato = new Prato(nome, preco, ingredientes);
                    // Cadastro do prato no arquivo
                    prato.cadastrarPratos(arquivoPratos);
                    System.out.println("Prato registrado com sucesso!");
                    break;
                case 2:
                    // Opção para mostrar os pratos cadastrados
                    Prato.mostrarPratos(arquivoPratos);
                    break;
                case 3:
                    // Opção para excluir um prato
                    Prato.mostrarPratos(arquivoPratos);
                    System.out.println("Digite a posição do prato que deseja excluir: ");
                    int posicao = Integer.parseInt(scan.nextLine()) - 1;
                    FileManager.deletarItem(arquivoPratos, posicao);
                    break;
                case 4:
                    // Opção para buscar pratos por ingrediente
                    Ingredientes.mostrarIngredientes(arquivoIngredientes);
                    int posicaoIngrediente = Integer.parseInt(scan.nextLine()) -1;
                    Prato.buscarPorIngrediente(arquivoIngredientes, arquivoPratos, posicaoIngrediente);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoPratos != 0);

    }
    // Mostra o menu de bebidas disponiveis
    public static void menuBebida(Scanner scan, File arquivoBebidas) throws IOException {
        int opcaoBebida;
        do {
            System.out.println("======= MENU BEBIDAS =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar uma bebida");
            System.out.println("[2] Ver bebidas cadastradas");
            System.out.println("[3] Excluir uma bebida");
            opcaoBebida = Integer.parseInt(scan.nextLine());
            switch (opcaoBebida) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:
                    // Solicita o nome da bebida
                    System.out.println("Digite o nome da bebida: ");
                    String nomeBebida = scan.nextLine();
                    // Solicita o preço da bebida
                    System.out.println("Digite o preço da bebida: ");
                    Double precoBebida = Double.parseDouble(scan.nextLine());

                    // Cria o objeto bebeida
                    Bebida bebida = new Bebida(nomeBebida, precoBebida);
                    // Cadastra a bebida no arquivo de texto
                    bebida.cadastrarBebida(arquivoBebidas);
                    System.out.println("Bebida cadastrada com sucesso!");
                    break;
                case 2:
                    // Chama o metodo de mostrar as bebidas
                    Bebida.mostrarBebidas(arquivoBebidas);
                    break;
                case 3:
                    // Mostra as bebidas cadastradas
                    Bebida.mostrarBebidas(arquivoBebidas);
                    // Solicita a posição para deleatr
                    System.out.println("Digite a posição da bebida que deseja excluir: ");
                    int posicao = Integer.parseInt(scan.nextLine()) - 1;
                    // Deleta o item do arquivo de texto
                    FileManager.deletarItem(arquivoBebidas, posicao);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcaoBebida != 0);
    }
    //Mostra o menu do pedido onde possibilita cadastrar um pedido, ver os cadastrados, excluir e ver os ordenados por precos
    public static void menuPedido(Scanner scan, File arquivoPedidos, File arquivoFuncionario, File arquivoCliente,
            File arquivoPratos,
            File arquivoBebidas) throws IOException {
        int opcaoPedido;
        do {
            System.out.println("======= MENU PEDIDOS =======");
            System.out.println("[0] Sair");
            System.out.println("[1] Cadastrar um pedido");
            System.out.println("[2] Ver pedidos cadastradas");
            System.out.println("[3] Excluir um pedido");
            System.out.println("[4] Ver pedidos ordenados por preço total");
            opcaoPedido = Integer.parseInt(scan.nextLine());
            switch (opcaoPedido) {
                case 0:
                    System.out.println("Saindo");
                    break;
                case 1:

                    // CLIENTE
                    Cliente.mostrarCliente(arquivoCliente);
                    System.out.println("Digite a posição do cliente para o pedido: ");
                    int escolhaCliente = Integer.parseInt(scan.nextLine());

                    if (escolhaCliente < 1 || escolhaCliente > FileManager.lerArquivo(arquivoCliente).size()) {
                        System.out.println("Número invalido");
                        break;
                    }

                    // Cria o cliente com o nome escolhido
                    Cliente cliente = new Cliente(
                            FileManager.lerArquivo(arquivoCliente).get(escolhaCliente - 1).replace(";", ""));

                    // FUNCIONARIO
                    Funcionario.mostrarFuncionario(arquivoFuncionario);
                    System.out.println("Digite a posição do funcionario para o pedido: ");
                    int escolhaFuncionario = Integer.parseInt(scan.nextLine());

                    if (escolhaFuncionario < 1
                            || escolhaFuncionario > FileManager.lerArquivo(arquivoFuncionario).size()) {
                        System.out.println("Número invalido");
                        break;
                    }

                    String funcionarioString = FileManager.lerArquivo(arquivoFuncionario).get(escolhaFuncionario - 1);

                    String[] funcionarioDados = funcionarioString.split(";");

                    String nome = funcionarioDados[0];
                    String cpf = funcionarioDados[1];
                    // Convertendo a String para double
                    Double salario = Double.parseDouble(funcionarioDados[2]);
                    String funcao = funcionarioDados[3];

                    Funcionario funcionario = new Funcionario(nome, cpf, salario, funcao);

                    // PRATOS
                    Prato.mostrarPratos(arquivoPratos);
                    int escolhaPrato;
                    ArrayList<Prato> pratos = new ArrayList<>();
                    do {
                        System.out.println("Digite a posição do prato para o pedido: ");
                        System.out.println("0 - SALVAR / SAIR");

                        escolhaPrato = Integer.parseInt(scan.nextLine());

                        if (escolhaPrato < 0
                                || escolhaPrato > FileManager.lerArquivo(arquivoPratos).size()) {
                            System.out.println("Número invalido");
                            break;
                        }

                        if (escolhaPrato == 0) {
                            System.out.println("Saindo");
                            break;
                        }

                        String pratoString = FileManager.lerArquivo(arquivoPratos).get(escolhaPrato - 1);
                        String[] pratoDados = pratoString.replace(";", ";").split(";");

                        String nomePrato = pratoDados[0];
                        Double precoPrato = Double.parseDouble(pratoDados[1]);
                        ArrayList<Ingredientes> ingredientesPrato = new ArrayList<>();
                        for (int i = 2; i < pratoDados.length; i++) {
                            ingredientesPrato.add(new Ingredientes(pratoDados[i]));
                        }

                        Prato pratoTemporario = new Prato(nomePrato, precoPrato, ingredientesPrato);
                        pratos.add(pratoTemporario);
                        System.out.println("Prato adicionado!");
                    } while (escolhaPrato != 0);

                    // BEBIDAS
                    Bebida.mostrarBebidas(arquivoBebidas);
                    int escolhaBebida;
                    ArrayList<Bebida> bebidas = new ArrayList<>();
                    do {
                        System.out.println("Digite a bebida para o pedido: ");
                        System.out.println("0 - SALVAR / SAIR");
                        escolhaBebida = Integer.parseInt(scan.nextLine());

                        if (escolhaBebida < 0 || escolhaBebida > FileManager.lerArquivo(arquivoBebidas).size()) {
                            System.out.println("Número invalido");
                            break;
                        }

                        if (escolhaBebida == 0) {
                            System.out.println("Saindo");
                            break;
                        }

                        String bebidaString = FileManager.lerArquivo(arquivoBebidas).get(escolhaBebida - 1);
                        String[] bebidaDados = bebidaString.split(";");
                        Bebida bebidaTemporaria = new Bebida(bebidaDados[0], Double.parseDouble(bebidaDados[1]));
                        bebidas.add(bebidaTemporaria);
                        System.out.println("Bebida adicionada");
                    } while (escolhaBebida != 0);
                    Pedido pedido = new Pedido(cliente, funcionario, pratos, bebidas);
                    pedido.cadastrarPedidos(arquivoPedidos);
                    System.out.println("Pedido cadastrado!");
                    break;
                case 2:
                    Pedido.mostrarPedidos(arquivoPedidos);
                    break;
                case 3:
                    // Mostra os pedidos cadastrados
                    Pedido.mostrarPedidos(arquivoPedidos);
                    // Solicita a posição para deleatr
                    System.out.println("Digite a posição do pedido que deseja excluir: ");
                    int posicao = Integer.parseInt(scan.nextLine()) - 1;
                    // Deleta o item do arquivo de texto
                    FileManager.deletarItem(arquivoPedidos, posicao);
                    break;
                case 4:
                    Pedido.mostrarPedidosOrdenadosPorPreco(arquivoPedidos);
                    break;
            
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (opcaoPedido != 0);
    }
}
