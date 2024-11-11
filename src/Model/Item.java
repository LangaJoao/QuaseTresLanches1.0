/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

/**
 *
 * @author mac
 */
//import java.io.Serializable;
//import java.util.ArrayList;
//
// interface ItemDeVenda extends Comparable<ItemDeVenda>, Serializable {
//    String getNome();
//    double getPreco();
//    void setPreco(double preco);
//    
//    String recheio(String recheio);
//    
//    void cadastrarItemDeVenda();
//    
//    void atualizarItemDeVenda();
//    
//    ArrayList<T> listarItemVenda();
//     
////    String detalhes();
//}
import java.io.Serializable;

public interface Item extends Serializable {

    String getNome();

    double getPreco();

    String toString();
}
