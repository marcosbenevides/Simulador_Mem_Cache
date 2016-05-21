/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.simulador;

/**
 *
 * @author Henrique Gallis
 */
public class NumeroBinario {

    /**
     * Variáveis
     */
    private char[] numBinTemp, numBin, numMap, numDesl, numTag;
    private Integer numDec, qntBits, qntVal, qntBlc;
    private String[] palavras;

    /**
     * construtor do objeto da classe NumeroBinario
     *
     * @param numDec
     * @param qntBlc
     * @param qntVal
     * @param maior
     */
    public NumeroBinario(Integer numDec, Integer qntBlc, Integer qntVal, Integer maior) {

        /**
         * setando os valores necessarios recebido pelo contrutor
         */
        this.qntBlc = qntBlc;
        this.qntVal = qntVal;
        this.numDec = numDec;

        //antes de qualquer preenchimento, é necessário determinar a quantidade
        //de bits que serão utilizados na conversão
        setQntBits(maior);

        /**
         * preechimento de um vetor temporário
         */
        String bin = Integer.toBinaryString(numDec);
        numBinTemp = bin.toCharArray();

        palavras = new String[qntVal];

        setTamVet();

        if (qntBlc == 1 || qntVal == 1) {
            System.err.println("Entrou if Const. NumeroBinario");
            if (qntVal > 1) {
                setNumDesl();
                numMap = new char[1];
                numMap[0] = '0';
                setPalavra(this);
            } else if (qntBlc > 1) {
                System.err.println("Entrou else if Const. NumeroBinario");
                setNumMap();
                System.err.println("NumMap: " + getNumMap());
                numDesl = new char[1];
                numDesl[0] = '0';
            } else if (qntVal == 1 && qntBlc == 1) {
                numMap = new char[1];
                numMap[0] = '0';
                numDesl = new char[1];
                numDesl[0] = '0';
            }
        } else {
            System.err.println("Entrou else Const. NumeroBinario");

            /**
             * chama função que preeche os vetores
             */
            setTamVet();
            setNumMap();
            setNumDesl();
            setPalavra(this);

//        for (String p : palavras) {
//            System.out.println(p);
//        }
        }
        System.err.println("Entrou setNumTag() NumeroBinario");
        setNumTag();
        System.err.println("NumTag: " + getNumTag());

    }

    private void setPalavra(NumeroBinario b) {
        Integer posicao = Integer.parseInt(b.getNumDesl(), 2);
        Integer raiz = (Integer.parseInt(b.getNumBin(), 2) - posicao);
        for (int i = 0; i < getPalavras().length; i++) {
            palavras[i] = Integer.toBinaryString(raiz + i);
            while (palavras[i].length() < qntBits) {
                palavras[i] = "0" + palavras[i];
            }
        }
    }

    /**
     * Nesta função é feito o preenchimento do vetor definitivo e os campos que
     * sobrar vazio é preenchido com 0
     */
    private void setTamVet() {
        numBin = new char[qntBits];
        int a = 0;
        for (int i = numBinTemp.length - 1; i >= 0; i--) {
            numBin[a] = numBinTemp[i];
            a++;
        }
        if (qntBits > numBinTemp.length) {
            for (int i = 0; i < numBin.length; i++) {
                if (numBin[i] != '1' && numBin[i] != '0') {
                    numBin[i] = '0';
                }
            }
        }
    }

    /**
     * Com o valor recolhido pela quantidade de palavras e blocos subitrai o
     * tamanho do vetor para saber quantos bits o vetor de tag terá. logo depois
     * preenche o vetor com os valores do vetor numBin a partir do ponto
     * (quantidade palavra + quantidade blocos)
     */
    private void setNumTag() {
        if (qntBlc > 1 || qntVal > 1) {
            int temp = 0;
            numTag = new char[(numBin.length) - (log(getQntVal()) + log(getQntBlc()))];
            for (int i = log(getQntVal()) + log(getQntBlc()); i < numBin.length; i++) {
                numTag[temp] = numBin[i];
                temp++;
            }
        } else {
            numTag = new char[numBin.length];
            System.arraycopy(numBin, 0, numTag, 0, numTag.length);
        }
    }

    /**
     * Com o valor recolhido pelo log da quantidade de palavras é setado o
     * tamanho do vetor. Preenche o vetor com os valores do vetor numBin a
     * partir do ponto 0 até o tamanho do vetor numBin - log da quantidade de
     * palavras
     */
    private void setNumDesl() {
        numDesl = new char[log(getQntVal())];
        int nM = 0;
        try {
            for (int i = 0; i < (numBin.length - log(getQntVal())); i++) {
                numDesl[i] = numBin[i];
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }

    /**
     * O numero de mapeamento é calculado a partir do log da quantidade de
     * blocos. com este valor percorre-se o vetor numBin e captura os valores de
     * acordo com a posição inicial que corresponde ao log de quantidade de
     * palavras
     */
    private void setNumMap() {
        numMap = new char[log(getQntBlc())];
        System.err.println("Tamanho numMap: " + numMap.length);
        int mN = 0;
        if(log(getQntVal()) == mN){
            try{
                for(int i=0;i<numMap.length;i++){
                    numMap[i] = numBin[i];
                }
            }catch(ArrayIndexOutOfBoundsException ex){
                
            }
        }
        try {
            for (int i = log(getQntVal()); i > mN; i++) {
                numMap[mN] = numBin[i];
                mN++;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            
        }
    }

    /**
     * metodo para retornar a String do objeto com todos os dados referentes ao
     * mesmo
     *
     * @return
     */
    @Override
    public String toString() {
        return "Número Decimal:" + getNumDec() + "\tNúmero Binário: " + getNumBin()
                + "\nDeslocamento: " + getNumDesl() + "\nMapeamento: "
                + getNumMap() + "\nTag: " + getNumTag() + "\n-----\n";
    }

    /**
     * Metodo para ser usado juntamente a classe TesteMain.java
     */
    public void exibir() {
        System.out.print("Número Binario: ");
        for (int i = numBin.length - 1; i >= 0; i--) {
            System.out.print("[" + numBin[i] + "] ");
        }
        System.out.print("Bit Mapeamento: ");
        for (int i = numMap.length - 1; i >= 0; i--) {
            System.out.print("[" + numMap[i] + "] ");
        }
        System.out.print("Bit Deslocamento: ");
        for (int i = numDesl.length - 1; i >= 0; i--) {
            System.out.print("[" + numDesl[i] + "] ");
        }
        System.out.print("Bit Tag: ");
        for (int i = numTag.length - 1; i >= 0; i--) {
            System.out.print("[" + numTag[i] + "] ");
        }
    }

    /**
     * Metodo para retornar o log de um numero requerido na base 2
     *
     * @param num
     * @return
     */
    private int log(Integer num) {
        for (int i = 0; i < 100000000; i++) {
            if (Math.pow(2, i) == num) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Método para ler um vetor e retornar seu valor em forma de String
     *
     * @param valor
     * @return
     */
    private String trans(char[] valor) {
        String retorno = "";
        for (int i = valor.length - 1; i >= 0; i--) {
            try {
                retorno += valor[i];
            } catch (NullPointerException ex) {
                System.err.println("trans\t" + ex);
            }
        }
        return retorno;
    }

    /**
     * Retorna a quantidade de bits de um numero binario
     *
     * @param num
     */
    private void setQntBits(int num) {
        String maior = Integer.toBinaryString(num);
        qntBits = maior.length();
    }

    /**
     * @return the numBin
     */
    public String getNumBin() {
        return trans(this.numBin);
    }

    /**
     * @return the numMap
     */
    public String getNumMap() {
        return trans(this.numMap);
    }

    /**
     * @return the numDesl
     */
    public String getNumDesl() {
        return trans(this.numDesl);
    }

    /**
     * @return the numDec
     */
    public Integer getNumDec() {
        return numDec;
    }

    /**
     * @return the qntBits
     */
    public Integer getQntBits() {
        return qntBits;
    }

    /**
     * @return the qntVal
     */
    public Integer getQntVal() {
        return qntVal;
    }

    /**
     * @return the qntBlc
     */
    public Integer getQntBlc() {
        return qntBlc;
    }

    private String getNumTag() {
        return trans(this.numTag);
    }

    /**
     * @return the palavras
     */
    public String[] getPalavras() {
        return palavras;
    }

    public String getPalavrasVisinhas() {
        return trans(this.palavras);
    }

    private String trans(String[] palavras) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
