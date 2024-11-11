///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package View;
//
//import Model.AVLFileManager;
//import Model.Item;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// *
// * @author mac
// */
//public class QuaseTresLanches {
//    
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Scanner scanner = new Scanner(System.in);
//        boolean running = true;
//
//        while (running) {
//            System.out.println("\nMenu:");
//            System.out.println("1. Cadastrar item de venda");
//            System.out.println("2. Atualizar item de venda");
//            System.out.println("3. Listar pizzas");
//            System.out.println("4. Listar salgadinhos");
//            System.out.println("5. Registrar venda");
//            System.out.println("6. Listar vendas");
//            System.out.println("7. Excluir item de venda");
//            System.out.println("0. Sair");
//            System.out.print("Escolha uma opção: ");
//            int opcao = scanner.nextInt();
//
//            switch (opcao) {
//                case 1:
//                    // Aqui você pode capturar os dados de entrada e criar um item Pizza ou Salgadinho.
//                    // Em seguida, salvar o item usando AVLFileManager.adicionarItem().
//                    break;
//                case 2:
//                    // Implementar atualização de item (obtendo ID e novos dados do usuário).
//                    break;
//                case 3:
//                    ArrayList<Item> listaDeItens = AVLFileManager.carregarItensDoArquivo();
//                    AVLFileManager.listarPizzas(listaDeItens);
//                    break;
//                case 4:
//                    listaDeItens = AVLFileManager.carregarItensDoArquivo();
//                    AVLFileManager.listarSalgadinhos(listaDeItens);
//                    break;
//                case 5:
//                    // Registrar uma venda usando AVLFileManager.registrarVenda().
//                    break;
//                case 6:
//                    AVLFileManager.listarVendas();
//                    break;
//                case 7:
//                    // Excluir item usando AVLFileManager.removerItem().
//                    break;
//                case 0:
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Opção inválida. Tente novamente.");
//            }
//        }
//
//        scanner.close();
//    }
//    
//}

import Model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Model.AVLFileManager;

public class QuaseTresLanches {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar item de venda");
            System.out.println("2. Atualizar item de venda");
            System.out.println("3. Listar pizzas");
            System.out.println("4. Listar salgadinhos");
            System.out.println("5. Registrar venda");
            System.out.println("6. Listar vendas");
            System.out.println("7. Excluir item de venda");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o restante da linha para evitar problemas de entrada

            switch (opcao) {
                case 1:
                    cadastrarItem(scanner);
                    break;
                case 2:
                    atualizarItem(scanner);
                    break;
                case 3:
                    listarPizzas();
                    break;
                case 4:
                    listarSalgadinhos();
                    break;
                case 5:
                    registrarVenda(scanner);
                    break;
                case 6:
                    listarVendas();
                    break;
                case 7:
                    excluirItem(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void cadastrarItem(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.print("Digite o tipo de item (1 para Pizza, 2 para Salgadinho): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Digite o recheio da pizza: ");
            String recheio = scanner.nextLine();
            System.out.print("Digite a borda: ");
            String borda = scanner.nextLine();
            System.out.print("Digite o molho: ");
            String molho = scanner.nextLine();
            System.out.print("Digite o preço: ");
            double preco = scanner.nextDouble();

            Pizza pizza = new Pizza();
            AVLFileManager.adicionarItem(pizza);
            System.out.println("Pizza cadastrada com sucesso!");
        } else if (tipo == 2) {
            System.out.print("Digite o tipo do salgadinho (frito ou assado): ");
            String tipoSalgadinho = scanner.nextLine();
            System.out.print("Digite a massa: ");
            String massa = scanner.nextLine();
            System.out.print("Digite o recheio: ");
            String recheio = scanner.nextLine();
            System.out.print("Digite o preço: ");
            double preco = scanner.nextDouble();

            Salgadinho salgadinho = new Salgadinho();
            AVLFileManager.adicionarItem(salgadinho);
            System.out.println("Salgadinho cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de item inválido.");
        }
    }

    private static void atualizarItem(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.print("Digite o ID do item a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Item item = AVLFileManager.buscarItem(id);
        if (item == null) {
            System.out.println("Item não encontrado.");
            return;
        }

        System.out.print("Digite o novo preço: ");
        double novoPreco = scanner.nextDouble();
        item.setPreco(novoPreco);

        AVLFileManager.atualizarItem(item);
        System.out.println("Item atualizado com sucesso!");
    }

    private static void listarPizzas() throws IOException, ClassNotFoundException {
        ArrayList<Item> listaDeItens = AVLFileManager.carregarItensDoArquivo();
        AVLFileManager.listarPizzas(listaDeItens);
    }

    private static void listarSalgadinhos() throws IOException, ClassNotFoundException {
        ArrayList<Item> listaDeItens = AVLFileManager.carregarItensDoArquivo();
        AVLFileManager.listarSalgadinhos(listaDeItens);
    }

    private static void registrarVenda(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.print("Digite o ID do item para registrar a venda: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Item item = AVLFileManager.buscarItem(id);
        if (item == null) {
            System.out.println("Item não encontrado.");
            return;
        }

        System.out.print("Digite a quantidade vendida: ");
        int quantidade = scanner.nextInt();

        Venda venda = new Venda(item, quantidade);
        AVLFileManager.registrarVenda(venda);
        System.out.println("Venda registrada com sucesso!");
    }

    private static void listarVendas() throws IOException, ClassNotFoundException {
        AVLFileManager.listarVendas();
    }

    private static void excluirItem(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.print("Digite o ID do item a ser excluído: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        AVLFileManager.removerItem(id);
        System.out.println("Item excluído com sucesso!");
        
//        try {
//            Item item = AVLFileManager.buscarItem(101);  // Buscando um item com ID 101
//            if (item != null) {
//                System.out.println("Item encontrado: " + item);
//            } else {
//                System.out.println("Item não encontrado.");
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }

}
