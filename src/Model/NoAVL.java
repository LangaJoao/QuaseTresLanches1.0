package Model;

// Classe para representar um nó da árvore AVL
public class NoAVL {
//    Item item;            // Item armazenado no nó (Pizza ou Salgadinho)
//    int altura;           // Altura do nó
//    AVLNo esquerda, direita; // Filhos esquerdo e direito
//
//    public AVLNo(Item item) {
//        this.item = item;
//        this.altura = 1; // Altura inicial do nó é 1
//    }

    Item item;
    NoAVL esquerda, direita;
    int altura;

    public NoAVL(Item item) {
        this.item = item;
        this.esquerda = this.direita = null;
        this.altura = 1;  // A altura de um nó recém-criado é 1
    }
}
