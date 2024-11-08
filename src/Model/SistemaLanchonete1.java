/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Hp
 */

public class SistemaLanchonete1 {
    
    private List<Pizza> estoquePizzas;            
    private List<Salgadinho> estoqueSalgadinhos;  
    private List<ItemDeVenda> vendas;             

    public SistemaLanchonete1() {

    }

    public List<Pizza> getEstoquePizzas() {
        return estoquePizzas;
    }

    public void setEstoquePizzas(List<Pizza> estoquePizzas) {
        this.estoquePizzas = estoquePizzas;
    }

    public List<Salgadinho> getEstoqueSalgadinhos() {
        return estoqueSalgadinhos;
    }

    public void setEstoqueSalgadinhos(List<Salgadinho> estoqueSalgadinhos) {
        this.estoqueSalgadinhos = estoqueSalgadinhos;
    }

    public List<ItemDeVenda> getVendas() {
        return vendas;
    }

    public void setVendas(List<ItemDeVenda> vendas) {
        this.vendas = vendas;
    }
}

