package Model;

import java.io.Serializable;
import java.util.Date;

public class Venda implements Serializable {
    private Item item;
    private int quantidade;
    private Date dataVenda;

    public Venda(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
        this.dataVenda = new Date();
    }

    public Item getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    @Override
    public String toString() {
        return "Venda [Item=" + item + ", Quantidade=" + quantidade + ", Data=" + dataVenda + "]";
    }
}

