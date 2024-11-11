//package Model;
//
////import Model.AVLNo;
//import Model.ArvoreAVL;
//import Model.Item;
//import Model.NoAVL;
//import java.io.*;
//import java.util.ArrayList;
//
//public class AVLFileManager {
//
//    private static final String NOME_ARQUIVO = "vendas.dat";
//
//    public static void salvarParaArquivo(ArvoreAVL arvore) throws IOException {
//        ArrayList<Item> listaDeItens = new ArrayList<>();
//        arvoreParaLista(arvore, listaDeItens, arvore.getRaiz()); // Obter a raiz usando um getter.
//
//        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
//            saida.writeObject(listaDeItens);
//        }
//    }
//
//    private static void arvoreParaLista(ArvoreAVL arvore, ArrayList<Item> lista, NoAVL no) {
//        if (no != null) {
//            arvoreParaLista(arvore, lista, no.esquerda);
//            lista.add(no.item);
//            arvoreParaLista(arvore, lista, no.direita);
//        }
//    }
//
//    public static ArvoreAVL carregarDoArquivo() throws IOException, ClassNotFoundException {
//        ArvoreAVL arvore = new ArvoreAVL();
//
//        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
//            ArrayList<Item> listaDeItens = (ArrayList<Item>) entrada.readObject();
//            for (Item item : listaDeItens) {
//                arvore.inserir(item);
//            }
//        }
//
//        return arvore;
//    }
//}
package Model;

import java.io.*;
import java.util.ArrayList;

public class AVLFileManager {
    private static final String NOME_ARQUIVO_ITENS = "itens.dat";
    private static final String NOME_ARQUIVO_VENDAS = "vendas.dat";

    // Método para salvar os itens de venda em arquivo
    public static void salvarItensParaArquivo(ArrayList<Item> listaDeItens) throws IOException {
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO_ITENS))) {
            saida.writeObject(listaDeItens);
        }
    }

    // Carregar itens de venda do arquivo
    public static ArrayList<Item> carregarItensDoArquivo() throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO_ITENS))) {
            return (ArrayList<Item>) entrada.readObject();
        }
    }

    // Adicionar um novo item à lista e salvar
    public static void adicionarItem(Item item) throws IOException, ClassNotFoundException {
        ArrayList<Item> listaDeItens = carregarItensDoArquivo();
        listaDeItens.add(item);
        salvarItensParaArquivo(listaDeItens);
    }

    // Atualizar item
    public static void atualizarItem(Item itemAtualizado) throws IOException, ClassNotFoundException {
        ArrayList<Item> listaDeItens = carregarItensDoArquivo();
        for (int i = 0; i < listaDeItens.size(); i++) {
            if (listaDeItens.get(i).getId() == itemAtualizado.getId()) {
                listaDeItens.set(i, itemAtualizado);
                break;
            }
        }
        salvarItensParaArquivo(listaDeItens);
    }

    // Remover item
    public static void removerItem(int idItem) throws IOException, ClassNotFoundException {
        ArrayList<Item> listaDeItens = carregarItensDoArquivo();
        listaDeItens.removeIf(item -> item.getId() == idItem);
        salvarItensParaArquivo(listaDeItens);
    }

    // Listar itens ordenados pelo preço (exemplo para pizzas e salgadinhos)
    public static void listarPizzas(ArrayList<Item> listaDeItens) {
        listaDeItens.stream()
            .filter(item -> item instanceof Pizza)
            .sorted((a, b) -> Double.compare(a.getPreco(), b.getPreco()))
            .forEach(System.out::println);
    }

    public static void listarSalgadinhos(ArrayList<Item> listaDeItens) {
        listaDeItens.stream()
            .filter(item -> item instanceof Salgadinho)
            .sorted((a, b) -> Double.compare(a.getPreco(), b.getPreco()))
            .forEach(System.out::println);
    }

    // Registrar uma nova venda
    public static void registrarVenda(Venda venda) throws IOException, ClassNotFoundException {
        ArrayList<Venda> listaDeVendas = carregarVendasDoArquivo();
        listaDeVendas.add(venda);
        salvarVendasParaArquivo(listaDeVendas);
    }

    // Salvar vendas em arquivo
    public static void salvarVendasParaArquivo(ArrayList<Venda> listaDeVendas) throws IOException {
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO_VENDAS))) {
            saida.writeObject(listaDeVendas);
        }
    }

    // Carregar vendas do arquivo
    public static ArrayList<Venda> carregarVendasDoArquivo() throws IOException, ClassNotFoundException {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO_VENDAS))) {
            return (ArrayList<Venda>) entrada.readObject();
        }
    }

    // Listar todas as vendas
    public static void listarVendas() throws IOException, ClassNotFoundException {
        ArrayList<Venda> listaDeVendas = carregarVendasDoArquivo();
        listaDeVendas.forEach(System.out::println);
    }
    
    // Método para buscar um item pelo ID
public static Item buscarItem(int idItem) throws IOException, ClassNotFoundException {
    ArrayList<Item> listaDeItens = carregarItensDoArquivo();
    for (Item item : listaDeItens) {
        if (item.getId() == idItem) {
            return item;  // Retorna o item se encontrar o ID
        }
    }
    return null;  // Retorna null se o item não for encontrado
}

}
