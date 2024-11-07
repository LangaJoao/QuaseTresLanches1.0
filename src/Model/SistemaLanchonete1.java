package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
import java.io.*;
import java.util.*;

import java.io.*;
import java.util.*;

public class SistemaLanchonete1 {

    // Definindo o estoque de pizzas e salgadinhos
    private static ArvoreAVL<Pizza> estoquePizzas = new ArvoreAVL<>();
    private static ArvoreAVL<Salgadinho> estoqueSalgadinhos = new ArvoreAVL<>();
    private static List<ItemDeVenda> vendas = new ArrayList<>(); // Lista de vendas

    // Função para cadastrar uma pizza
    public static void cadastrarPizza(Pizza pizza) {
        estoquePizzas.inserir(pizza);
    }

    // Função para cadastrar um salgadinho
    public static void cadastrarSalgadinho(Salgadinho salgadinho) {
        estoqueSalgadinhos.inserir(salgadinho);
    }

    // Função para registrar uma venda
    public static void registrarVenda(ItemDeVenda item) {
        vendas.add(item);
    }

    // Função para listar pizzas em ordem crescente de preço
    public static void listarPizzas() {
        System.out.println("Pizzas disponíveis:");
        // Exibindo pizzas e seus preços
        List<Pizza> listaPizzas = new ArrayList<>();
        estoquePizzas.listarEmOrdem(listaPizzas);  // Preenche a lista com pizzas ordenadas
        for (int i = 0; i < listaPizzas.size(); i++) {
            Pizza pizza = listaPizzas.get(i);
            System.out.println((i + 1) + ". " + pizza.getNome() + " - Preço: R$" + pizza.getPreco());
        }
    }

    // Função para listar salgadinhos em ordem crescente de preço
    public static void listarSalgadinhos() {
        System.out.println("Salgadinhos disponíveis:");
        // Exibindo salgadinhos e seus preços
        List<Salgadinho> listaSalgadinhos = new ArrayList<>();
        estoqueSalgadinhos.listarEmOrdem(listaSalgadinhos);  // Preenche a lista com salgadinhos ordenados
        for (int i = 0; i < listaSalgadinhos.size(); i++) {
            Salgadinho salgadinho = listaSalgadinhos.get(i);
            System.out.println((i + 1) + ". " + salgadinho.getNome() + " - Preço: R$" + salgadinho.getPreco());
        }
    }

    // Função para listar todas as vendas registradas
    public static void listarVendas() {
        System.out.println("Vendas registradas:");
        for (ItemDeVenda venda : vendas) {
            System.out.println(venda.detalhes());
        }
    }

    // Função para salvar os dados em arquivos
    public static void salvarDados() {
        try (ObjectOutputStream outPizzas = new ObjectOutputStream(new FileOutputStream("pizzas.dat"));
             ObjectOutputStream outSalgadinhos = new ObjectOutputStream(new FileOutputStream("salgadinhos.dat"));
             ObjectOutputStream outVendas = new ObjectOutputStream(new FileOutputStream("vendas.dat"))) {

            outPizzas.writeObject(estoquePizzas);
            outSalgadinhos.writeObject(estoqueSalgadinhos);
            outVendas.writeObject(vendas);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Função para carregar os dados de arquivos
    public static void carregarDados() {
        try (ObjectInputStream inPizzas = new ObjectInputStream(new FileInputStream("pizzas.dat"));
             ObjectInputStream inSalgadinhos = new ObjectInputStream(new FileInputStream("salgadinhos.dat"));
             ObjectInputStream inVendas = new ObjectInputStream(new FileInputStream("vendas.dat"))) {

            estoquePizzas = (ArvoreAVL<Pizza>) inPizzas.readObject();
            estoqueSalgadinhos = (ArvoreAVL<Salgadinho>) inSalgadinhos.readObject();
            vendas = (List<ItemDeVenda>) inVendas.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Função para realizar um pedido
    public static void realizarPedido(Scanner scanner) {
        try {
            int tipoProduto;
            System.out.println("\nEscolha o tipo de produto:");
            System.out.println("1. Pizza");
            System.out.println("2. Salgadinho");
            System.out.print("Digite o número correspondente: ");
            tipoProduto = scanner.nextInt();

            if (tipoProduto == 1) {
                // Listar pizzas
                listarPizzas();
                System.out.print("Escolha a pizza (1, 2, ...): ");
                int escolhaPizza = scanner.nextInt();

                // Buscando a pizza pelo índice
                Pizza pizzaEscolhida = buscarPizzaPorIndice(escolhaPizza - 1); // Índice começa de 0
                if (pizzaEscolhida != null) {
                    registrarVenda(pizzaEscolhida);
                    System.out.println("Pedido de pizza registrado: " + pizzaEscolhida.getNome());
                } else {
                    System.out.println("Pizza não encontrada!");
                }
            } else if (tipoProduto == 2) {
                // Listar salgadinhos
                listarSalgadinhos();
                System.out.print("Escolha o salgadinho (1, 2, ...): ");
                int escolhaSalgadinho = scanner.nextInt();

                // Buscando o salgadinho pelo índice
                Salgadinho salgadinhoEscolhido = buscarSalgadinhoPorIndice(escolhaSalgadinho - 1); // Índice começa de 0
                if (salgadinhoEscolhido != null) {
                    registrarVenda(salgadinhoEscolhido);
                    System.out.println("Pedido de salgadinho registrado: " + salgadinhoEscolhido.getNome());
                } else {
                    System.out.println("Salgadinho não encontrado!");
                }
            } else {
                System.out.println("Opção inválida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, digite um número.");
            scanner.nextLine(); // Limpa o buffer do scanner
        }
    }

    // Função para buscar pizza pelo índice
    private static Pizza buscarPizzaPorIndice(int indice) {
        // Vamos listar todas as pizzas e retornar a pizza na posição desejada
        List<Pizza> listaPizzas = new ArrayList<>();
        estoquePizzas.listarEmOrdem(listaPizzas); // Preenche a lista com pizzas da árvore AVL

        // Verifica se o índice é válido
        if (indice >= 0 && indice < listaPizzas.size()) {
            return listaPizzas.get(indice); // Retorna a pizza correspondente ao índice
        }
        return null; // Se o índice for inválido, retorna null
    }

    // Função para buscar salgadinho pelo índice
    private static Salgadinho buscarSalgadinhoPorIndice(int indice) {
        // Vamos listar todos os salgadinhos e retornar o salgadinho na posição desejada
        List<Salgadinho> listaSalgadinhos = new ArrayList<>();
        estoqueSalgadinhos.listarEmOrdem(listaSalgadinhos); // Preenche a lista com salgadinhos da árvore AVL

        // Verifica se o índice é válido
        if (indice >= 0 && indice < listaSalgadinhos.size()) {
            return listaSalgadinhos.get(indice); // Retorna o salgadinho correspondente ao índice
        }
        return null; // Se o índice for inválido, retorna null
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Carregar dados existentes
        carregarDados();

        // Exemplo de cadastro de itens
        Pizza pizza1 = new Pizza("Calabresa", 30.0, "Calabresa", "Recheada", "Tomate");
        Pizza pizza2 = new Pizza("Marguerita", 25.0, "Queijo", "Normal", "Manjericão");
        Salgadinho salgadinho1 = new Salgadinho("Coxinha", 5.0, "Frito", "Massa Tradicional", "Frango");
        Salgadinho salgadinho2 = new Salgadinho("Empada", 4.0, "Assado", "Massa Folhada", "Carne");

        // Cadastrando itens no estoque
        cadastrarPizza(pizza1);
        cadastrarPizza(pizza2);
        cadastrarSalgadinho(salgadinho1);
        cadastrarSalgadinho(salgadinho2);

        // Realizar um pedido
        realizarPedido(scanner);

        // Listando itens e vendas
        listarPizzas();
        listarSalgadinhos();
        listarVendas();

        // Salvar dados no arquivo
        salvarDados();
    }
}








