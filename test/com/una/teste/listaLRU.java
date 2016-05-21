/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.teste;

/**
 *
 * @author Marcos
 */
class listaLRU {

    public Integer[] listaLRU;
    public int naLista, posicao = 0, j = 1;

    public boolean taNaLista(Integer valor) {
        for (int i = 0; i < listaLRU.length; i++) {
            try {
                if (listaLRU[i] == valor) {
                    naLista = i;
                    return true;
                }
            } catch (NullPointerException ex) {
                return false;
            }
        }
        return false;
    }

    public void setLista(Integer valor) {
        if (taNaLista(valor)) {
            int i = naLista;
            int x = i + 1;
            for (i = naLista; i < posicao - 1; i++) {
                listaLRU[i] = listaLRU[x];
            }
            listaLRU[posicao - 1] = valor;
        } else {
            if (posicao == listaLRU.length) {
                int i = 0, j=i+1;
                for (i = 0; i < posicao - 1; i++) {
                    System.err.println("for\t " + listaLRU[i] + "\t" + listaLRU[j]);
                    getLista();
                    listaLRU[i] = listaLRU[j];
                    j++;

                }
                listaLRU[posicao - 1] = valor;
            } else {
                listaLRU[posicao] = valor;
                posicao++;
            }

        }
    }

    public void getLista() {
        for (Integer lista : listaLRU) {
            System.err.print("[" + lista + "]");
        }
        System.err.println("\n");
    }
}
