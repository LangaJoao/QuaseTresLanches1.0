package Model;
// Classe da árvore AVL

public class ArvoreAVL {
    
    private NoAVL raiz;

    // Método para calcular a altura do nó
    private int altura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }

    // Método para obter o fator de balanceamento do nó
    private int obterBalanceamento(NoAVL no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    // Rotação à direita
    private NoAVL rodarADireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;
        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    // Rotação à esquerda
    private NoAVL rodarAEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;
        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    // Método para inserir um item na árvore AVL
    private NoAVL inserir(NoAVL no, Item item) {
        if (no == null) {
            return new NoAVL(item);
        }

        // Inserção com base no preço
        if (item.getPreco() < no.item.getPreco()) {
            no.esquerda = inserir(no.esquerda, item);
        } else if (item.getPreco() > no.item.getPreco()) {
            no.direita = inserir(no.direita, item);
        } else {
            return no; // Não insere itens com o mesmo preço
        }

        // Atualiza a altura do nó ancestral
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        // Verifica o balanceamento do nó
        int balanceamento = obterBalanceamento(no);

        // Casos de desbalanceamento
        if (balanceamento > 1 && item.getPreco() < no.esquerda.item.getPreco()) {
            return rodarADireita(no);
        }
        if (balanceamento < -1 && item.getPreco() > no.direita.item.getPreco()) {
            return rodarAEsquerda(no);
        }
        if (balanceamento > 1 && item.getPreco() > no.esquerda.item.getPreco()) {
            no.esquerda = rodarAEsquerda(no.esquerda);
            return rodarADireita(no);
        }
        if (balanceamento < -1 && item.getPreco() < no.direita.item.getPreco()) {
            no.direita = rodarADireita(no.direita);
            return rodarAEsquerda(no);
        }

        return no;
    }

    // Método público para inserir um item a partir da raiz
    public void inserir(Item item) {
        raiz = inserir(raiz, item);
    }

    // Listar pizzas em ordem crescente de preço
    public void listarPizzas() {
        listarPizzas(raiz);
    }

    private void listarPizzas(NoAVL no) {
        if (no != null) {
            listarPizzas(no.esquerda);
            if (no.item instanceof Pizza) {
                System.out.println(no.item);
            }
            listarPizzas(no.direita);
        }
    }

    // Listar salgadinhos em ordem crescente de preço
    public void listarSalgadinhos() {
        listarSalgadinhos(raiz);
    }

    private void listarSalgadinhos(NoAVL no) {
        if (no != null) {
            listarSalgadinhos(no.esquerda);
            if (no.item instanceof Salgadinho) {
                System.out.println(no.item);
            }
            listarSalgadinhos(no.direita);
        }
    }

    // Getter para acessar a raiz, se necessário
    public NoAVL getRaiz() {
        return raiz;
    }

}


