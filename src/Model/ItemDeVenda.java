/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

/**
 *
 * @author mac
 */

import java.io.Serializable;

 interface ItemDeVenda extends Comparable<ItemDeVenda>, Serializable {
    String getNome();
    double getPreco();
    void setPreco(double preco);
    void atualizarDados();
    String detalhes();
}
