/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author mac
 */
public class Salgadinho implements ItemDeVenda<Salgadinho> {
    private String nome;
    private double preco;
    private String tipo;
    private String massa;
    private String recheio;

    // Construtor e métodos
    public Salgadinho(String nome, double preco, String tipo, String massa, String recheio) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.massa = massa;
        this.recheio = recheio;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
}

