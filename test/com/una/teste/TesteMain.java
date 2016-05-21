/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.teste;

/**
 *
 * @author Henrique Gallis
 */
public class TesteMain {

    public static void main(String[] args) {
    listaLRU lista = new listaLRU();
    lista.listaLRU = new Integer[4];
    
    lista.setLista(1);
    lista.getLista();
    lista.setLista(2);
    lista.getLista();
    lista.setLista(3);
    lista.getLista();
    lista.setLista(4);
    lista.getLista();
    
    
    
    lista.setLista(5);
    lista.getLista();

}
}
