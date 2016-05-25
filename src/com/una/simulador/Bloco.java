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
public class Bloco extends MemoriaCache {

    private Boolean bitValidade;
    private String historico[][];
    private Integer id, contHistorico = 0, contPalavra = 0, qntPalavra;

    public Bloco(Integer mt, String tipoMemoria, String politicaSubs, Integer qntPalavra, Integer qntBlocos) {

        MemoriaCache.setTipoCache(tipoMemoria);
        MemoriaCache.setPoliticaSubs(politicaSubs);

        Bloco.criarListaLRU(qntBlocos);

        historico = new String[qntPalavra][mt];
        bitValidade = false;
        this.qntPalavra = qntPalavra;
        this.setId();
    }

    public void setHistorico(String palavra, String[] p) {
        if (getBitValidade()) {
            System.err.println("Entrou if SetHistorico()");
            if (eHit(palavra, getContHistorico())) {
                System.err.println("Entrou if-2 SetHistorico()");
                setHit();
            } else if (qntPalavra > 1) {
                System.err.println("Entrou else-2 SetHistorico() " + qntPalavra);
                for (int i = 0; i < p.length; i++) {
                    System.err.println("Entrou else-2 SetHistorico() " + qntPalavra);
                    historico[i][getContHistorico()] = p[i];
                    setMiss();
                }
                setContHistorico();
            } else {
                System.err.println("Entrou else-3 SetHistorico()");
                historico[0][getContHistorico()] = palavra;
                setContHistorico();
                setMiss();
            }
        } else {
            System.err.println("Entrou else SetHistorico()");
            setMissComp();
            setBitValidade((Boolean) true);
            setHistorico(palavra, p);
        }
    }

    public Boolean eHit(String palavra, Integer numCol) {
        System.out.println(palavra + "\t" + numCol + "\t" + historico.length
                + "\t" + historico[0].length);
        if (!getBitValidade()) {
            return false;
        } else {
            if(numCol == 0){
                return false;
            }else
                for (int i = 0; i < 1; i++) {
                    if (historico[i][numCol-1] == null) {
                        return false;
                    } else if (historico[i][numCol-1].isEmpty()) {
                        return false;
                    } else {
                        for (int x = i; x < historico.length; x++) {
                            if (historico[x][numCol-1].equalsIgnoreCase(palavra)) {
                                return true;
                            }
                        }

                    }
            }

        }
        return false;
    }

    public Boolean eHistoricoVazio() {
        Integer vazio = 0, cheio = 0;
        Boolean e = false;
        String h;
        for (String[] historico1 : historico) {
            for (String historico11 : historico1) {
                if (historico11.isEmpty()) {
                    vazio++;
                } else {
                    cheio++;
                }
            }
        }
        if (vazio == historico.length) {
            e = true;
        } else if (cheio > 0) {
            e = false;
        }
        return e;
    }

    /**
     * @return the bitValidade
     */
    public Boolean getBitValidade() {
        return bitValidade;
    }

    /**
     * @param bitValidade the bitValidade to set
     */
    public void setBitValidade(Boolean bitValidade) {
        this.bitValidade = bitValidade;
    }

    /**
     * @return the historico
     */
    public String getHistorico() {
        String hist = "";
        for (String[] historico1 : historico) {
            for (String historico11 : historico1) {
                hist += "[" + historico11 + "]";
            }
            hist += "\n";
        }
        return hist;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    private void setId() {
        this.id = getEndereco();
    }

    /**
     * @return the contHistorico
     */
    public Integer getContHistorico() {
        return contHistorico;
    }

    /**
     */
    public void setContHistorico() {
        this.contHistorico++;
    }

    @Override
    public String toString() {
        return "Bloco de memória cache \tEndereço: " + this.getId()
                + "\nBit Validade: " + getBitValidade() + "\nHistórico do bloco:"
                + getHistorico() + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }

    public String toString2() {
        return super.toString();
    }

    /**
     * @return the contPalavra
     */
    public Integer getContPalavra() {
        return contPalavra;
    }

    /**
     * @param contPalavra the contPalavra to set
     */
    public void setContPalavra(Integer contPalavra) {
        this.contPalavra++;
    }

}
