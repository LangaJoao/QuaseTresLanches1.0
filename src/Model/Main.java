package model;

import Model.ArvoreAVL;
import Model.Salgadinho;
import model.Pizza;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL tree = new ArvoreAVL();

        // Criando uma pizza e configurando seus atributos
        Pizza pizza = new Pizza();
        pizza.setNome("Calabresa");
        pizza.setPreco(25.0);
        pizza.setRecheio("Calabresa");
        pizza.setBorda("Recheada");
        pizza.setMolho("Tomate");
        tree.inserir(pizza);

        // Criando um salgadinho e configurando seus atributos
        Salgadinho salgadinho = new Salgadinho();
        salgadinho.setNome("Coxinha");
        salgadinho.setPreco(5.0);
        salgadinho.setTipo("Frito");
        salgadinho.setMassa("Massa de Batata");
        salgadinho.setRecheio("Frango");
        tree.inserir(salgadinho);

        System.out.println("Pizzas em ordem crescente de preço:");
        tree.listarPizzas();

        System.out.println("\nSalgadinhos em ordem crescente de preço:");
        tree.listarSalgadinhos();
    }
}