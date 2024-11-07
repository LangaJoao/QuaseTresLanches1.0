package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */public class Salgadinho1 implements ItemDeVenda {
    private String nome;
    private double preco;
    private String tipo; // frito ou assado
    private String massa;
    private String recheio;

    public Salgadinho1(String nome, double preco, String tipo, String massa, String recheio) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.massa = massa;
        this.recheio = recheio;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public void atualizarDados() {
        // Exemplo: Atualizar o preço ou outros atributos
        System.out.println("Atualizando dados do salgadinho...");
        // Lógica de atualização
    }

    @Override
    public String detalhes() {
        return String.format("Salgadinho: %s, Tipo: %s, Massa: %s, Recheio: %s, Preço: %.2f", 
                nome, tipo, massa, recheio, preco);
    }

    @Override
    public int compareTo(ItemDeVenda outro) {
        return Double.compare(this.preco, outro.getPreco());
    }
}

