package Model;






import java.util.*;

public class ArvoreAVL1<T extends Comparable<T>> {
    private No1<T> raiz;

    public void inserir(T item) {
        raiz = inserirRecursivo(raiz, item);
    }

    private No1<T> inserirRecursivo(No1<T> no, T item) {
        if (no == null) {
            return new No1<>(item); // Cria um novo nó com o item
        }

        int comparacao = item.compareTo(no.getValor());
        if (comparacao < 0) {
            no.setEsquerdo(inserirRecursivo(no.getEsquerdo(), item)); // Inserir na subárvore esquerda
        } else if (comparacao > 0) {
            no.setDireito(inserirRecursivo(no.getDireito(), item)); // Inserir na subárvore direita
        }

        no.setAltura(1 + Math.max(getAltura(no.getEsquerdo()), getAltura(no.getDireito())));
        return balancear(no); // Balancear a árvore após a inserção
    }

    private No1<T> balancear(No1<T> no) {
        int balanceamento = getBalanceamento(no);

        if (balanceamento > 1) {
            if (getBalanceamento(no.getEsquerdo()) < 0) {
                no.setEsquerdo(rotacionarEsquerda(no.getEsquerdo()));
            }
            return rotacionarDireita(no);
        }

        if (balanceamento < -1) {
            if (getBalanceamento(no.getDireito()) > 0) {
                no.setDireito(rotacionarDireita(no.getDireito()));
            }
            return rotacionarEsquerda(no);
        }

        return no;
    }

    private No1<T> rotacionarDireita(No1<T> y) {
        No1<T> x = y.getEsquerdo();
        No1<T> T2 = x.getDireito();

        x.setDireito(y);
        y.setEsquerdo(T2);

        y.setAltura(Math.max(getAltura(y.getEsquerdo()), getAltura(y.getDireito())) + 1);
        x.setAltura(Math.max(getAltura(x.getEsquerdo()), getAltura(x.getDireito())) + 1);

        return x;
    }

    private No1<T> rotacionarEsquerda(No1<T> x) {
        No1<T> y = x.getDireito();
        No1<T> T2 = y.getEsquerdo();

        y.setEsquerdo(x);
        x.setDireito(T2);

        x.setAltura(Math.max(getAltura(x.getEsquerdo()), getAltura(x.getDireito())) + 1);
        y.setAltura(Math.max(getAltura(y.getEsquerdo()), getAltura(y.getDireito())) + 1);

        return y;
    }

    private int getAltura(No1<T> no) {
        if (no == null) {
            return 0;
        }
        return no.getAltura();
    }

    private int getBalanceamento(No1<T> no) {
        if (no == null) {
            return 0;
        }
        return getAltura(no.getEsquerdo()) - getAltura(no.getDireito());
    }

    // Método para listar os itens da árvore em ordem crescente
    public void listarEmOrdem(List<T> lista) {
        listarEmOrdemRecursivo(raiz, lista);
    }

    private void listarEmOrdemRecursivo(No1<T> no, List<T> lista) {
        if (no == null) {
            return;
        }
        listarEmOrdemRecursivo(no.getEsquerdo(), lista);
        lista.add(no.getValor());  // Adiciona o valor do nó à lista
        listarEmOrdemRecursivo(no.getDireito(), lista);
    }
}


