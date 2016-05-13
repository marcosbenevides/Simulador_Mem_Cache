/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.una.simulador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class Simulador extends javax.swing.JFrame {

    //Vetor para coletar o Memory Trace de primeira
    private String[] memoryTrace;
    //Vetor para coletar o Memory Trace depois da conversão
    private Integer[] mT;
    //Vetor para de objetos da Classe NumeroBinario
    private NumeroBinario[] binario;
    //Vetor de blocos de memória
    private Bloco[] blocos;
    //Variáveis para captura de dados do cliente
    private Integer tempoRam, tempoCache, quantBlocos, quantPalavra, endMemoria;
    //Variáveis para captura de dados do cliente
    private String tipoMemCache, politicaSubs;

    /**
     * Construtor, chama o método para criar o Form
     */
    public Simulador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        tiposMemoriaCache = new javax.swing.ButtonGroup();
        politicaDeSubstituicao = new javax.swing.ButtonGroup();
        frameMemoryTrace = new javax.swing.JFrame();
        scrollMemoryTrace = new javax.swing.JScrollPane();
        editorMemoryTrace = new javax.swing.JEditorPane();
        labelMemoryTrace = new javax.swing.JLabel();
        botaoGravarMT = new javax.swing.JButton();
        panelConfig = new javax.swing.JPanel();
        comboBlocos = new javax.swing.JComboBox();
        comboPalavra = new javax.swing.JComboBox();
        radioTipoMD = new javax.swing.JRadioButton();
        radioTipoAC = new javax.swing.JRadioButton();
        radioTipoTA = new javax.swing.JRadioButton();
        labelTipo = new javax.swing.JLabel();
        labelBloco = new javax.swing.JLabel();
        labelPalavra = new javax.swing.JLabel();
        botaoMT = new javax.swing.JButton();
        sliderTempoRam = new javax.swing.JSlider();
        sliderTempoCache = new javax.swing.JSlider();
        labelTempoRam = new javax.swing.JLabel();
        labelTempoCache = new javax.swing.JLabel();
        labelTempoRam1 = new javax.swing.JLabel();
        labelTempoCache1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        radioSubsFIFO = new javax.swing.JRadioButton();
        radioSubsLRU = new javax.swing.JRadioButton();
        panelCommit = new javax.swing.JPanel();
        botaoExecutar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoExportar = new javax.swing.JButton();
        panelStatus = new javax.swing.JPanel();
        scrollStatus = new javax.swing.JScrollPane();
        textStatus = new javax.swing.JTextArea();

        frameMemoryTrace.setTitle("Memory Trace");
        frameMemoryTrace.setMinimumSize(new java.awt.Dimension(350, 260));
        frameMemoryTrace.setName("frameMemoryTrace"); // NOI18N
        frameMemoryTrace.setPreferredSize(new java.awt.Dimension(350, 260));

        editorMemoryTrace.setContentType("memory trace"); // NOI18N
        scrollMemoryTrace.setViewportView(editorMemoryTrace);

        labelMemoryTrace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMemoryTrace.setText("<html>\nPreencha com as palavras que serão executadas pelo CPU<br>\nseparando cada uma por \",\" (vírgula).\n</html>");

        botaoGravarMT.setText("Gravar");
        botaoGravarMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGravarMTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frameMemoryTraceLayout = new javax.swing.GroupLayout(frameMemoryTrace.getContentPane());
        frameMemoryTrace.getContentPane().setLayout(frameMemoryTraceLayout);
        frameMemoryTraceLayout.setHorizontalGroup(
            frameMemoryTraceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frameMemoryTraceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frameMemoryTraceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frameMemoryTraceLayout.createSequentialGroup()
                        .addComponent(scrollMemoryTrace)
                        .addContainerGap())
                    .addGroup(frameMemoryTraceLayout.createSequentialGroup()
                        .addComponent(labelMemoryTrace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 59, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameMemoryTraceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoGravarMT)
                .addGap(140, 140, 140))
        );
        frameMemoryTraceLayout.setVerticalGroup(
            frameMemoryTraceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frameMemoryTraceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMemoryTrace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMemoryTrace, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoGravarMT)
                .addGap(4, 4, 4))
        );

        frameMemoryTrace.getAccessibleContext().setAccessibleDescription("");
        frameMemoryTrace.getAccessibleContext().setAccessibleParent(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador Memória Cache");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(500, 600));
        setName("simuFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 700));

        panelConfig.setBackground(new java.awt.Color(255, 255, 255));

        comboBlocos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "4", "8", "16", "32", "64", "128" }));

        comboPalavra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "4", "8" }));

        tiposMemoriaCache.add(radioTipoMD);
        radioTipoMD.setText("MD");
        radioTipoMD.setActionCommand("MD");
        radioTipoMD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTipoMDActionPerformed(evt);
            }
        });

        tiposMemoriaCache.add(radioTipoAC);
        radioTipoAC.setText("AC");
        radioTipoMD.setActionCommand("AC");
        radioTipoAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTipoACActionPerformed(evt);
            }
        });

        tiposMemoriaCache.add(radioTipoTA);
        radioTipoTA.setText("TA");
        radioTipoMD.setActionCommand("TA");
        radioTipoTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTipoTAActionPerformed(evt);
            }
        });

        labelTipo.setText("Tipo de Memória Cache");

        labelBloco.setText("Quantidade de Blocos");

        labelPalavra.setText("Tamanho do Bloco");

        botaoMT.setText("Preencher Memory Trace");
        botaoMT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMTActionPerformed(evt);
            }
        });

        sliderTempoRam.setMajorTickSpacing(1);
        sliderTempoRam.setToolTipText("");
        sliderTempoRam.setValue(0);
        sliderTempoRam.setInheritsPopupMenu(true);

        sliderTempoCache.setMajorTickSpacing(1);
        sliderTempoCache.setSnapToTicks(true);
        sliderTempoCache.setValue(0);

        labelTempoRam.setText("Tempo de acesso Memoria Ram:");

        labelTempoCache.setText("Tempo de acesso Memoria Cache:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderTempoRam, org.jdesktop.beansbinding.ELProperty.create("${value}"), labelTempoRam1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sliderTempoCache, org.jdesktop.beansbinding.ELProperty.create("${value}"), labelTempoCache1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel1.setText("Política de Substituição");

        politicaDeSubstituicao.add(radioSubsFIFO);
        radioSubsFIFO.setText("FIFO");
        radioTipoMD.setActionCommand("FIFO");
        radioSubsFIFO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSubsFIFOActionPerformed(evt);
            }
        });

        politicaDeSubstituicao.add(radioSubsLRU);
        radioSubsLRU.setText("LRU");
        radioTipoMD.setActionCommand("LRU");
        radioSubsLRU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSubsLRUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConfigLayout = new javax.swing.GroupLayout(panelConfig);
        panelConfig.setLayout(panelConfigLayout);
        panelConfigLayout.setHorizontalGroup(
            panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoMT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelConfigLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelConfigLayout.createSequentialGroup()
                        .addComponent(labelTempoRam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTempoRam1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelConfigLayout.createSequentialGroup()
                        .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addGroup(panelConfigLayout.createSequentialGroup()
                                .addComponent(radioSubsFIFO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioSubsLRU))
                            .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelTipo)
                                .addGroup(panelConfigLayout.createSequentialGroup()
                                    .addComponent(radioTipoMD)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioTipoAC)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(radioTipoTA))))
                        .addGap(20, 20, 20))
                    .addComponent(sliderTempoRam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfigLayout.createSequentialGroup()
                        .addComponent(labelTempoCache)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTempoCache1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelConfigLayout.createSequentialGroup()
                        .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(labelPalavra)
                            .addComponent(labelBloco))
                        .addGap(54, 54, 54))
                    .addComponent(comboBlocos, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPalavra, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sliderTempoCache, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        panelConfigLayout.setVerticalGroup(
            panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfigLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBloco)
                    .addComponent(labelTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioTipoMD)
                        .addComponent(radioTipoAC)
                        .addComponent(radioTipoTA))
                    .addComponent(comboBlocos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConfigLayout.createSequentialGroup()
                        .addComponent(labelPalavra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelConfigLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioSubsFIFO)
                            .addComponent(radioSubsLRU))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTempoCache)
                        .addComponent(labelTempoCache1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelTempoRam)
                    .addComponent(labelTempoRam1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sliderTempoRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sliderTempoCache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botaoMT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        botaoExecutar.setText("Executar");
        botaoExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExecutarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Limpar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoExportar.setText("Exportar para txt");
        botaoExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCommitLayout = new javax.swing.GroupLayout(panelCommit);
        panelCommit.setLayout(panelCommitLayout);
        panelCommitLayout.setHorizontalGroup(
            panelCommitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCommitLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoExecutar)
                .addGap(18, 18, 18)
                .addComponent(botaoCancelar)
                .addGap(18, 18, 18)
                .addComponent(botaoExportar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCommitLayout.setVerticalGroup(
            panelCommitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCommitLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCommitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoExecutar)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoExportar))
                .addContainerGap())
        );

        panelStatus.setBackground(new java.awt.Color(255, 255, 255));

        textStatus.setBackground(new java.awt.Color(0, 0, 0));
        textStatus.setColumns(5);
        textStatus.setFont(new java.awt.Font("Consolas", 1, 10)); // NOI18N
        textStatus.setEditable(false);
        textStatus.setForeground(new java.awt.Color(255, 255, 255));
        textStatus.setLineWrap(true);
        textStatus.setRows(20);
        textStatus.setTabSize(5);
        textStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textStatus.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        scrollStatus.setViewportView(textStatus);

        javax.swing.GroupLayout panelStatusLayout = new javax.swing.GroupLayout(panelStatus);
        panelStatus.setLayout(panelStatusLayout);
        panelStatusLayout.setHorizontalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollStatus)
        );
        panelStatusLayout.setVerticalGroup(
            panelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCommit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(panelConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCommit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Simulador");

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Chama a janela do Memory Trace
     */
    private void botaoMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMTActionPerformed
        frameMemoryTrace.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_botaoMTActionPerformed
    /**
     * Dispensa a janela do Memory Trace
     *
     * @param evt
     */
    private void botaoGravarMTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGravarMTActionPerformed
        frameMemoryTrace.dispose();
    }//GEN-LAST:event_botaoGravarMTActionPerformed
    /**
     * Captura todos os dados de entrada, mostra na tela de status e começa o
     * tratamento
     *
     * @param evt
     */
    private void botaoExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExecutarActionPerformed

        //Captura de dados
        tempoRam = sliderTempoRam.getValue();
        tempoCache = sliderTempoCache.getValue();
        quantBlocos = Integer.parseInt(comboBlocos.getSelectedItem().toString());
        quantPalavra = Integer.parseInt(comboPalavra.getSelectedItem().toString());

        //Mostra na área de Status
        this.atualizarStatus("CONFIGURAÇÃO ESCOLHIDA");
        this.atualizarStatus("------------------------------------------------------------------");
        this.atualizarStatus("Tipo de Memoria Cache: " + tipoMemCache);
        this.atualizarStatus("Tipo de Política de Substituição: " + politicaSubs);
        this.atualizarStatus("Tempo de Acesso a Memória Ram: " + tempoRam);
        this.atualizarStatus("Tempo de Acesso a Memória Cache: " + tempoCache);
        this.atualizarStatus("Quantidade de Blocos: " + quantBlocos);
        this.atualizarStatus("Tamanho da Palavra: " + quantPalavra);
        this.atualizarStatus("------------------------------------------------------------------");
        this.atualizarStatus("MEMORY TRACE DIGITADO:");
        tratarMemorytrace(editorMemoryTrace.getText());
        this.atualizarStatus("\n------------------------------------------------------------------");

        //Com os dados capturados chama método para criação do vetor de objetos
        criarNumBin();

        //Mostra na área de status as informações das palavras do MT
        for (NumeroBinario binario1 : binario) {
            this.atualizarStatus(binario1.toString());
        }

        criarMemoriaCache();
        for (Bloco bloco : blocos) {
            this.atualizarStatus(bloco.toString());
        }

        iniciarLeitura();
    }//GEN-LAST:event_botaoExecutarActionPerformed

    /**
     * Até a linha 496 são métodos para capturar o valor de cada botão de Rádio
     *
     * @param evt
     */
    private void radioTipoMDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTipoMDActionPerformed
        tipoMemCache = radioTipoMD.getActionCommand();

        radioSubsFIFO.setEnabled(false);
        radioSubsLRU.setEnabled(false);
    }//GEN-LAST:event_radioTipoMDActionPerformed

    private void radioTipoACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTipoACActionPerformed
        tipoMemCache = radioTipoAC.getActionCommand();
        radioSubsFIFO.setEnabled(false);
        radioSubsLRU.setEnabled(false);
    }//GEN-LAST:event_radioTipoACActionPerformed

    private void radioTipoTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTipoTAActionPerformed
        tipoMemCache = radioTipoTA.getActionCommand();
        radioSubsFIFO.setEnabled(true);
        radioSubsLRU.setEnabled(true);
    }//GEN-LAST:event_radioTipoTAActionPerformed

    private void radioSubsFIFOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSubsFIFOActionPerformed
        politicaSubs = radioSubsFIFO.getActionCommand();
    }//GEN-LAST:event_radioSubsFIFOActionPerformed

    private void radioSubsLRUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSubsLRUActionPerformed
        politicaSubs = radioSubsLRU.getActionCommand();
    }//GEN-LAST:event_radioSubsLRUActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        limpar();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExportarActionPerformed

        try {
            exportarTxt();
        } catch (IOException ex) {
            Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
            this.atualizarStatus("Erro ao exportar arquivo.");

        }

    }//GEN-LAST:event_botaoExportarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExecutar;
    private javax.swing.JButton botaoExportar;
    private javax.swing.JButton botaoGravarMT;
    private javax.swing.JButton botaoMT;
    private javax.swing.JComboBox comboBlocos;
    private javax.swing.JComboBox comboPalavra;
    private javax.swing.JEditorPane editorMemoryTrace;
    private javax.swing.JFrame frameMemoryTrace;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelBloco;
    private javax.swing.JLabel labelMemoryTrace;
    private javax.swing.JLabel labelPalavra;
    private javax.swing.JLabel labelTempoCache;
    private javax.swing.JLabel labelTempoCache1;
    private javax.swing.JLabel labelTempoRam;
    private javax.swing.JLabel labelTempoRam1;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JPanel panelCommit;
    private javax.swing.JPanel panelConfig;
    private javax.swing.JPanel panelStatus;
    private javax.swing.ButtonGroup politicaDeSubstituicao;
    private javax.swing.JRadioButton radioSubsFIFO;
    private javax.swing.JRadioButton radioSubsLRU;
    private javax.swing.JRadioButton radioTipoAC;
    private javax.swing.JRadioButton radioTipoMD;
    private javax.swing.JRadioButton radioTipoTA;
    private javax.swing.JScrollPane scrollMemoryTrace;
    private javax.swing.JScrollPane scrollStatus;
    private javax.swing.JSlider sliderTempoCache;
    private javax.swing.JSlider sliderTempoRam;
    private javax.swing.JTextArea textStatus;
    private javax.swing.ButtonGroup tiposMemoriaCache;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para limpar a área de Status
     */
    private void limpar() {
        this.textStatus.setText("");
    }

    /**
     * Método para atualizar texto da área de Status
     *
     * @param texto
     */
    public void atualizarStatus(String texto) {
        this.textStatus.append(texto + "\n");
    }

    /**
     * Recebe uma String e faz o tratamento colocando no vetor de String logo
     * depois em um vetor de Inteiros. Faz a captura de Exception caso tenha
     * algum valor no MT que não seja válido.
     *
     * @param texto
     */
    public void tratarMemorytrace(String texto) {

        memoryTrace = texto.split(",");
        mT = new Integer[memoryTrace.length];
        try {
            for (int i = 0; i < memoryTrace.length; i++) {

                this.textStatus.append("[" + memoryTrace[i] + "] ");

                mT[i] = Integer.parseInt(memoryTrace[i]);

            }
        } catch (NumberFormatException ex) {
            this.atualizarStatus("\nATENÇÃO!\nForam digitados números "
                    + "inválidos no Memory Trace, os mesmos foram desconsiderados!");
        }
    }

    /**
     * Captura o valor em cada posição do vetor de inteiros e cria o vetor de
     * objetos
     */
    private void criarNumBin() {
        binario = new NumeroBinario[mT.length];
        for (int i = 0; i < mT.length; i++) {
            binario[i] = new NumeroBinario(mT[i], quantBlocos, quantPalavra, maior());
        }

    }

    /**
     * Determina qual o maior número no vetor para se calcular a quantidade de
     * bits de cada palavra
     *
     * @return
     */
    private int maior() {
        Integer maior = mT[0];
        for (Integer mT1 : mT) {
            if (mT1 > maior) {
                maior = mT1;
            }
        }
        return maior;
    }

    private void criarMemoriaCache() {

        blocos = new Bloco[quantBlocos];
        for (int i = 0; i < blocos.length; i++) {
            blocos[i] = new Bloco(mT.length, tipoMemCache, politicaSubs, quantPalavra);
        }

    }

    private void iniciarLeitura() {
        this.atualizarStatus("-----------\nAtualização de cache\n");
        System.out.println(tipoMemCache + "\t" + politicaSubs);
        if (null != tipoMemCache) {
            switch (tipoMemCache) {
                case "MD":
                    for (NumeroBinario binario1 : binario) {
                        endMemoria = (Integer.parseInt(binario1.getNumMap(), 2));
                        blocos[endMemoria].setHistorico(binario1.getNumBin(), binario1.getPalavras());
                        this.atualizarStatus("Binário: " + binario1.getNumBin()
                                + "\tMapeamento: " + binario1.getNumMap());
                        this.atualizarStatus(blocos[endMemoria].toString());
                    }
                    break;
                case "TA":
                    for (NumeroBinario binario1 : binario) {
                        for (int i = 0; i > blocos.length; i++) {
                            blocos[i].setHistorico(binario1.getNumBin(), binario1.getPalavras());
                            this.atualizarStatus("Binário: " + binario1.getNumBin()
                                    + "\tMapeamento: " + binario1.getNumMap());
                            this.atualizarStatus(blocos[endMemoria].toString());
                            if("LRU".equals(politicaSubs)){
                                Bloco.setListaLRU(binario1.getNumBin());
                                this.atualizarStatus("Lista: " + Bloco.getListaLRU());
                            }
                        }
                    }
                    break;
                case "AC":
                    break;
            }
        }

        this.atualizarStatus(blocos[0].toString2());
        this.atualizarStatus("Tempo médio de acesso: " + Bloco.getTempoMedio(tempoCache, tempoRam));
    }

    private void exportarTxt() throws IOException {
        String line = System.getProperty("line.separator");
        String data = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date(System.currentTimeMillis()));
        System.err.println(System.getProperty("user.dir") + "\\Exporta" + data + ".txt");
        FileWriter arquivo = new FileWriter(System.getProperty("user.dir") + "\\Exporta" + data + ".txt");
        PrintWriter gravarArquivo = new PrintWriter(arquivo);
        gravarArquivo.print(textStatus.getText().replaceAll("(\r\n|\n)", line));
        arquivo.close();

        this.atualizarStatus("Arquivo salvo com sucesso!");
        Runtime.getRuntime().exec("explorer " + System.getProperty("user.dir"));

    }
}
