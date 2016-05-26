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
        listaLRU = new String[colunas][linhas];
    }

    /**
     * @return the listaLRU
     */
    public static String getListaLRU() {
        String lista = "";
        for (String[] lista1 : listaLRU) {
            for (String[] lista11 : listaLRU) {
                if ("".equals(lista11)) {
                } else {
                    lista += "[" + lista11 + "]";
                }
            }

        }
        return lista;
    }

    public static boolean eListaLRUVazia() {
        for (String[] lista1 : listaLRU) {
            for (String[] lista11 : listaLRU) {
                try {
                    if (lista11 == null || lista11.equals("")) {
                        System.out.println("-- vazio --");
                    } else {
                        return false;
                    }
                } catch (NullPointerException ex) {
                    System.err.println("Erro eListaLRUVazia " + ex);
                }
            }
        }
        return true;
    }

    public static boolean taNaLista(String valor) {
        for (int i = 0; i < listaLRU.length; i++) {
            for (int j = 0; j < listaLRU[i].length; j++) {
                try {
                    if (listaLRU[i][j].equals(valor)) {
                        naLista = i;
                        return true;
                    }
                } catch (NullPointerException ex) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void setListaLRU(String valor, String[] palavras) {
        if (taNaLista(valor)) {
            int i = naLista;
            int x = i + 1;
            for (i = naLista; i < controleLista - 1; i++) {
                for (int j = 0; j < listaLRU[i].length; j++) {
                    listaLRU[i][j] = listaLRU[x][j];
                }
            }
            for (int j = 0; j < listaLRU[controleLista - 1].length; j++) {
                listaLRU[controleLista - 1][j] = palavras[j];
            }
        } else {
            if (controleLista == listaLRU.length) {
                int i = 0, x = i + 1;
                for (i = 0; i < controleLista - 1; i++) {
                    for (int j = 0; j < listaLRU[i].length; j++) {
                        System.err.println("for\t " + listaLRU[i][j] + "\t" + listaLRU[x][j] + "\n" + getListaLRU());
                        listaLRU[i][j] = listaLRU[x][j];
                        x++;
                    }
                }
                for (int j = 0; j < listaLRU[controleLista - 1].length; j++) {
                    listaLRU[controleLista - 1][j] = palavras[j];
                }
            } else {
                for (int j = 0; j < listaLRU[controleLista].length; j++) {
                    listaLRU[controleLista][j] = palavras[j];
                }
                controleLista++;
            }

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
     * @param ram
     * @return
     */
    protected static Integer getTempoMedio(Integer tempoCache, Integer ram) {
        return (tempoCache + ((1 - getHit()) * ram));
    }
}
