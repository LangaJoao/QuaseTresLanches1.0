package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */public class No1<T extends Comparable<T>> {
    private T valor;
    private No1<T> esquerdo, direito;
    private int altura;

    public No1(T valor) {
        this.valor = valor;
        this.altura = 1;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No1<T> getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No1<T> esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No1<T> getDireito() {
        return direito;
    }

    public void setDireito(No1<T> direito) {
        this.direito = direito;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }}



