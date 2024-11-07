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
public class Pizza1 implements ItemDeVenda {
    private String nome;
    private double preco;
    private String recheio;
    private String borda;
    private String molho;

    public Pizza1(String nome, double preco, String recheio, String borda, String molho) {
        this.nome = nome;
        this.preco = preco;
        this.recheio = recheio;
        this.borda = borda;
        this.molho = molho;
    }

    public String detalhes() {
        return String.format("Pizza: %s, Recheio: %s, Borda: %s, Molho: %s, Preço: R$ %.2f", 
                             nome, recheio, borda, molho, preco);
    }

    public double getPreco() {
        return preco;
    }

    public void atualizarPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPreco(double preco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarDados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(ItemDeVenda t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


