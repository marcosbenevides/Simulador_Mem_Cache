/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.teste;

import com.una.simulador.NumeroBinario;


/**
 *
 * @author Henrique Gallis
 */
public class TesteMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] t = new String[2];
        t[0] = "";
        if(t[0].isEmpty()){
            System.err.println("Nulo é vazio");
        }else{
            System.err.println("Deu ruim");
        }
    }

}
