package Model;





public class ArvoreAVL<T extends Comparable<T>> {

    private No1<T> raiz;   
    private int tamanho;     

    public ArvoreAVL() {
        this.raiz = null;      
        this.tamanho = 0;     
    }

    public No1<T> getRaiz() {
        return raiz;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setRaiz(No1<T> raiz) {
        this.raiz = raiz;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    
}
