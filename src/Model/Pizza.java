package Model;
//
//import Model.Item;
//
//public class Pizza implements Item {
//   private int id;
//    private String nome;
//    private double preco;
//    private String recheio;
//    private String borda;
//    private String molho;
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setPreco(double preco) {
//        this.preco = preco;
//    }
//
//    public void setRecheio(String recheio) {
//        this.recheio = recheio;
//    }
//
//    public void setBorda(String borda) {
//        this.borda = borda;
//    }
//
//    public void setMolho(String molho) {
//        this.molho = molho;
//    }
//
//    @Override
//    public double getPreco() {
//        return preco;
//    }
//
//    @Override
//    public String toString() {
//        return "Pizza{" + "nome='" + nome + '\'' + ", preco=" + preco +
//                ", recheio='" + recheio + '\'' + ", borda='" + borda +
//                '\'' + ", molho='" + molho + '\'' + '}';
//    }
//
//    @Override
//    public String getNome() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public int getId() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//}
public class Pizza implements Item {
    private int id;
    private String nome;
    private double preco;

    // Construtor
    public Pizza() {
     
    }

    // Implementação dos métodos da interface Item
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pizza{id=" + id + ", nome='" + nome + "', preco=" + preco + "}";
    }

    @Override
    public void setPreco(double novoPreco) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
