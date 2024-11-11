package Model;


public class Salgadinho implements Item {

    private String nome;
    private double preco;
    private String tipo;
    private String massa;
    private String recheio;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Salgadinho{" + "nome='" + nome + '\'' + ", preco=" + preco
                + ", tipo='" + tipo + '\'' + ", massa='" + massa + '\''
                + ", recheio='" + recheio + '\'' + '}';
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}