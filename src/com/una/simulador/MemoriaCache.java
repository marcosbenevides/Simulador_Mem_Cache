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
public abstract class MemoriaCache {

    static private Integer hit = 0, missComp = 0, miss = 0,
            endereco = 0, tempoMedio = 0, controleLista = 0, naLista;
    static private String politicaSubs, tipoCache, listaLRU[][];

    /**
     * @return the naLista
     */
    public static Integer getNaLista() {
        return naLista;
    }

    public MemoriaCache() {
        MemoriaCache.setEndereco();
    }

    /**
     * @return the politicaSubs
     */
    public static String getPoliticaSubs() {
        return politicaSubs;
    }

    /**
     * @param aPoliticaSubs the politicaSubs to set
     */
    public static void setPoliticaSubs(String aPoliticaSubs) {
        politicaSubs = aPoliticaSubs;
    }

    /**
     * @return the tipoCache
     */
    public static String getTipoCache() {
        return tipoCache;
    }

    /**
     * @param aTipoCache the tipoCache to set
     */
    public static void setTipoCache(String aTipoCache) {
        tipoCache = aTipoCache;
    }

    /**
     * @return the controleLista
     */
    public static Integer getControleLista() {
        return controleLista;
    }

    /**
     */
    public static void setControleLista() {
        controleLista++;
    }

    public static void criarListaLRU(Integer colunas, Integer linhas) {
        listaLRU = new String[linhas][colunas];
    }

    /**
     * Pega as linhas adicionam a um vetor e deste vetor é percorrido por mais
     * um for que adiciona cada posição a uma string lista. Depois de percorrer
     * a linha por completo adiciona-se um \n para dar a quebra de linha e
     * separar os vetores de linha da matriz.
     *
     * @return the listaLRU
     */
    public static String getListaLRU() {
        String lista = "";
        for (String[] lista1 : listaLRU) {
            for (String lista11 : lista1) {
                lista += "[" + lista11 + "]";
            }
            lista += "\n";
        }
        return lista;
    }

    public static boolean eListaLRUVazia() {
        for (String[] lista1 : listaLRU) {
            for (String lista11 : lista1) {
                try {
                    if (lista11 == null || lista11.equals("")) {
                    } else {
                        return false;
                    }
                } catch (NullPointerException ex) {
                }
            }
        }
        return true;
    }

    public static boolean taNaLista(String valor) {
        naLista = 10000;
        for (int i = 0; i < listaLRU[0].length; i++) {
            for (int j = 0; j < listaLRU.length; j++) {
                try {
                    if (listaLRU[j][i].equalsIgnoreCase(valor)) {
                        naLista = i;
                     //   setHit();
                        return true;
                    }
                } catch (NullPointerException ex) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setListaLRU(String valor, String[] palavras) {
        if (taNaLista(valor) && getNaLista() != 10000) {
            int i = getNaLista();
            int x = i + 1;
            if (palavras.length > 1) {
                for (i = getNaLista(); i < (controleLista - 1); i++) {
                    for (int j = 0; j < listaLRU.length; j++) {
                        listaLRU[j][i] = listaLRU[j][x];
                    }
                    x++;
                }
                for (int j = 0; j < listaLRU.length; j++) {
                    listaLRU[j][controleLista - 1] = palavras[j];
                }
            } else {
                for (i = getNaLista(); i < (controleLista - 1); i++) {
                    listaLRU[0][i] = listaLRU[0][x];
                    x++;
                }
                listaLRU[0][controleLista - 1] = valor;
            }
        } else if (controleLista == listaLRU[0].length) {
            int i = 0, x = i + 1;
            if (palavras.length > 1) {
                for (i = 0; i < controleLista - 1; i++) {
                    for (int j = 0; j < listaLRU.length; j++) {
                        listaLRU[j][i] = listaLRU[j][x];
                    }
                    x++;
                }
                for (int j = 0; j < listaLRU.length; j++) {
                    listaLRU[j][controleLista - 1] = palavras[j];
                }
            } else {
                for (i = 0; i < controleLista - 1; i++) {
                    listaLRU[0][i] = listaLRU[0][x];
                    x++;
                }
                listaLRU[0][controleLista - 1] = valor;
            }
        } else {
            if (palavras.length > 1) {
                for (int j = 0; j < listaLRU.length; j++) {
                    listaLRU[j][controleLista] = palavras[j];
                }
            } else {
                listaLRU[0][controleLista] = valor;
            }
            controleLista++;
        }
    }

    /**
     * @return the hit
     */
    public static Integer getHit() {
        return hit;
    }

    /**
     */
    public static void setHit() {
        hit++;
    }

    /**
     * @return the missComp
     */
    public static Integer getMissComp() {
        return missComp;
    }

    /**
     */
    public static void setMissComp() {
        missComp++;
    }

    /**
     * @return the miss
     */
    public static Integer getMiss() {
        return miss;
    }

    /**
     */
    public static void setMiss() {
        miss++;
    }

    /**
     * @return the endereco
     */
    public static Integer getEndereco() {
        return endereco;
    }

    /**
     */
    public static void setEndereco() {
        endereco++;
    }

    @Override
    public String toString() {
        return "Hits: " + getHit() + "\tMiss Compusórios: " + getMissComp() + "\tMiss: " + getMiss();
    }

    /**
     *
     * @param tempoCache
     * @param tempoRam
     * @return
     */
    protected static Integer getTempoMedio(Integer tempoCache, Integer tempoRam) {
        return (((hit + miss)*tempoRam)/(hit*tempoCache)+(miss*tempoRam));
    }
}
