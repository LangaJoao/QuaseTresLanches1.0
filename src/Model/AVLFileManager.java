package Model;

//import Model.AVLNo;
import Model.ArvoreAVL;
import Model.Item;
import Model.NoAVL;
import java.io.*;
import java.util.ArrayList;

public class AVLFileManager {
    
    private static final String NOME_ARQUIVO = "vendas.dat";

    public static void salvarParaArquivo(ArvoreAVL arvore) throws IOException {
        ArrayList<Item> listaDeItens = new ArrayList<>();
        arvoreParaLista(arvore, listaDeItens, arvore.getRaiz()); // Obter a raiz usando um getter.

        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            saida.writeObject(listaDeItens);
        }
    }

    private static void arvoreParaLista(ArvoreAVL arvore, ArrayList<Item> lista, NoAVL no) {
        if (no != null) {
            arvoreParaLista(arvore, lista, no.esquerda);
            lista.add(no.item);
            arvoreParaLista(arvore, lista, no.direita);
        }
    }

    public static ArvoreAVL carregarDoArquivo() throws IOException, ClassNotFoundException {
        ArvoreAVL arvore = new ArvoreAVL();

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
            ArrayList<Item> listaDeItens = (ArrayList<Item>) entrada.readObject();
            for (Item item : listaDeItens) {
                arvore.inserir(item);
            }
        }

        return arvore;
    }
}

