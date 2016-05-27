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
    private static Integer controleBloco = 0;

    public Bloco(Integer mt, String tipoMemoria, String politicaSubs, Integer qntPalavra, Integer qntBlocos) {

        MemoriaCache.setTipoCache(tipoMemoria);
        MemoriaCache.setPoliticaSubs(politicaSubs);

        Bloco.criarListaLRU(qntBlocos, qntPalavra);

        historico = new String[qntPalavra][mt];
        bitValidade = false;
        this.qntPalavra = qntPalavra;
        this.setId();
    }

    public void setHistorico(String palavra, String[] p, String politicaSub, Bloco[] bloco) {
        if (getBitValidade()) {
            if (eHit(palavra, getContHistorico(), politicaSub, bloco)) {
                setHit();
                System.err.println("setHit()");
                if (politicaSub.equalsIgnoreCase("LRU") || politicaSub.equalsIgnoreCase("FIFO")) {
                    switch (getControleBloco()) {
                        case 0:
                            System.err.println("if " + getControleBloco());
                            setControleBloco(3);
                            System.err.println("if depois " + getControleBloco());
                            break;
                        default:
                            System.err.println("else " + getControleBloco());
                            setControleBloco(getControleBloco() - 1);
                            System.err.println("else depois " + getControleBloco());
                            break;
                    }
//                    if (getControleBloco() == 0) {
//                        System.err.println("if " + getControleBloco());
//                        setControleBloco(3);
//                        System.err.println("if depois " + getControleBloco());
//                    }else if (getControleBloco() != 0) {
//                        System.err.println("else " + getControleBloco());
//                        setControleBloco(getControleBloco() - 1);
//                        System.err.println("else depois " + getControleBloco());
//                    }
                }
            } else if (qntPalavra > 1) {
                for (int i = 0; i < p.length; i++) {
                    historico[i][getContHistorico()] = p[i];
                    setMiss();
                }
                setContHistorico();
            } else {
                historico[0][getContHistorico()] = palavra;
                setContHistorico();
                setMiss();
            }
        } else {
            setMissComp();
            setBitValidade((Boolean) true);
            setHistorico(palavra, p, politicaSub, bloco);
        }
    }

    public Boolean eHit(String palavra, Integer numCol, String politicaSub, Bloco[] bloco) {
        if (politicaSub.equalsIgnoreCase("FIFO")) {
            for (Bloco bloco1 : bloco) {
                System.err.println("Entrou for bloco.");
                for (int i = 0; i < bloco1.historico.length; i++) {
                    System.err.println("Entrou for histórico.");
                    if (numCol == 0 || bloco1.historico[i][numCol - 1] == null) {
                        System.err.println("Coluna: " + numCol);
                        return false;
                    } else if (historico[i][numCol - 1].equalsIgnoreCase(palavra)) {
                        System.err.println("É hit");
                        return true;
                    }
                }
            }
        } else if (politicaSub.equalsIgnoreCase("LRU")) {
            return taNaLista(palavra) && getNaLista() != 10000;
        } else if (!getBitValidade()) {
            return false;
        } else if (numCol == 0) {
            return false;
        } else {
            for (int i = 0; i < 1; i++) {
                if (historico[i][numCol - 1] == null) {
                    return false;
                } else if (historico[i][numCol - 1].isEmpty()) {
                    return false;
                } else {
                    for (int x = i; x < historico.length; x++) {
                        if (historico[x][numCol - 1].equalsIgnoreCase(palavra)) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }
    
    public void testarBloco(){
        
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
                + "\nBit Validade: " + getBitValidade() + "\nHistórico do bloco:\n"
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

    /**
     * @return the controleBloco
     */
    public Integer getControleBloco() {
        return controleBloco;
    }

    /**
     */
    public void setControleBloco() {
        Bloco.controleBloco++;
    }

    /**
     * @param valor
     */
    public void setControleBloco(Integer valor) {
        Bloco.controleBloco = valor;
    }

}
