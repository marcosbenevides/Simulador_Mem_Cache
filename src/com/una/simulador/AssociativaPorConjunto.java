/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.simulador;

/**
 *
 * @author Marcos
 */
public class AssociativaPorConjunto {
    Bloco[] bloco;
    private static Integer contador = 0;
    Integer id;

    public AssociativaPorConjunto(Integer quantBloco) {
        id = contador;
        contador ++;
        bloco = new Bloco[quantBloco];
    }
    
    @Override
    public String toString(){
        String retorno  = "AC: " + id + "\nQuantidade de Blocos: " + bloco.length + "\n--------------------------------";
        return retorno;
    }
}
