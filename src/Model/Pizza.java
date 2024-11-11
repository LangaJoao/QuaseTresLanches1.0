package model;

import Model.Item;

public class Pizza implements Item {
    private String nome;
    private double preco;
    private String recheio;
    private String borda;
    private String molho;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public void setBorda(String borda) {
        this.borda = borda;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Pizza{" + "nome='" + nome + '\'' + ", preco=" + preco +
                ", recheio='" + recheio + '\'' + ", borda='" + borda +
                '\'' + ", molho='" + molho + '\'' + '}';
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}