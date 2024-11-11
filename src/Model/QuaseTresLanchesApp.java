package Model;
//
//import Model.ArvoreAVL;
//import Model.Salgadinho;
//
//public class Main {
//    public static void main(String[] args) {
//        ArvoreAVL tree = new ArvoreAVL();
//
//        // Criando uma pizza e configurando seus atributos
//        Pizza pizza = new Pizza();
//        pizza.setNome("Calabresa");
//        pizza.setPreco(25.0);
//        pizza.setRecheio("Calabresa");
//        pizza.setBorda("Recheada");
//        pizza.setMolho("Tomate");
//        tree.inserir(pizza);
//
//        // Criando um salgadinho e configurando seus atributos
//        Salgadinho salgadinho = new Salgadinho();
//        salgadinho.setNome("Coxinha");
//        salgadinho.setPreco(5.0);
//        salgadinho.setTipo("Frito");
//        salgadinho.setMassa("Massa de Batata");
//        salgadinho.setRecheio("Frango");
//        tree.inserir(salgadinho);
//
//        System.out.println("Pizzas em ordem crescente de preço:");
//        tree.listarPizzas();
//
//        System.out.println("\nSalgadinhos em ordem crescente de preço:");
//        tree.listarSalgadinhos();
//    }
//}
import Model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuaseTresLanchesApp {
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

            switch (opcao) {
                case 1:
                    // Aqui você pode capturar os dados de entrada e criar um item Pizza ou Salgadinho.
                    // Em seguida, salvar o item usando AVLFileManager.adicionarItem().
                    break;
                case 2:
                    // Implementar atualização de item (obtendo ID e novos dados do usuário).
                    break;
                case 3:
                    ArrayList<Item> listaDeItens = AVLFileManager.carregarItensDoArquivo();
                    AVLFileManager.listarPizzas(listaDeItens);
                    break;
                case 4:
                    listaDeItens = AVLFileManager.carregarItensDoArquivo();
                    AVLFileManager.listarSalgadinhos(listaDeItens);
                    break;
                case 5:
                    // Registrar uma venda usando AVLFileManager.registrarVenda().
                    break;
                case 6:
                    AVLFileManager.listarVendas();
                    break;
                case 7:
                    // Excluir item usando AVLFileManager.removerItem().
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
}
