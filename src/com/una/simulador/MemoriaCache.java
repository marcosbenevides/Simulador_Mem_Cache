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
            endereco = 0, tempoMedio = 0, controleLista = 0, posicaoLista;
    static private String politicaSubs, tipoCache, listaLRU[];

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

    public static void criarListaLRU(Integer valor) {
        listaLRU = new String[valor];
    }

    /**
     * @return the listaLRU
     */
    public static String getListaLRU() {
        String lista = "";
        for (String lista1 : listaLRU) {
            if ("".equals(lista1)) {
            } else {
                lista += "[" + lista1 + "]";
            }
        }
        return lista;
    }

    /**
     * @param numBin
     */
    public static void setListaLRU(String numBin) {
        if (getControleLista().equals(0)) {
            listaLRU[getControleLista()] = numBin;
            setControleLista();
        } else if (taNaLista(numBin)) {
            listaLRU[getControleLista()] = numBin;
            listaLRU[posicaoLista] = "";
            setControleLista();
        } else {
            listaLRU[getControleLista()] = numBin;
            setControleLista();
        }
    }

    private static boolean taNaLista(String numBin) {
        for (int i = 0; i < getControleLista(); i++) {
            if (listaLRU[i].equalsIgnoreCase(numBin)) {
                posicaoLista = i;
                return true;
            }
        }
        return false;
    }

    public boolean eListaLRUVazia() {
        for (String listaLRU1 : listaLRU) {
            try {
                if (listaLRU1 == null || listaLRU1.isEmpty()) {
                    System.out.println("-- vazio --");
                } else {
                    return false;
                }
            } catch (NullPointerException ex) {
                System.err.println("Erro eListaLRUVazia " + ex);
            }
        }
        return true;
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
