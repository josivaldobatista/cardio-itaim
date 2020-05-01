/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cardioitaim.visao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import br.com.cardioitaim.conexao.ConexaoBD;
import br.com.cardioitaim.dao.MedicoDAO;
import br.com.cardioitaim.beans.BeansMedico;
import br.com.cardioitaim.beans.ModeloTabela;

/**
 *
 * @author Valdo Batista
 */
public class FormMedico extends javax.swing.JFrame {

    int flag = 0;//flag para indicar se estou salvando ou editando
    String sql = "select * from medicos order by nome_medico";
    
    BeansMedico beansMedico = new BeansMedico();
    ConexaoBD conex = new ConexaoBD();
    MedicoDAO daoMedico = new MedicoDAO();

    public FormMedico() {
        initComponents();
        preencherTabela(sql);
        //jLabelID.setVisible(false);
        //jTextFieldID.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelInfoNome = new javax.swing.JLabel();
        jTextFieldNomeMedico = new javax.swing.JTextField();
        jLabelInfoCRM = new javax.swing.JLabel();
        jFormattedTextFieldCRM = new javax.swing.JFormattedTextField();
        jLabelInfoArea = new javax.swing.JLabel();
        jComboBoxArea = new javax.swing.JComboBox<>();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonPesquisa = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedico = new javax.swing.JTable();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Cadastro e Consulta Cardio Itaim");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icone_desktop.png")).getImage());
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setEnabled(false);

        jLabelInfoNome.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelInfoNome.setText("Nome");

        jTextFieldNomeMedico.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTextFieldNomeMedico.setEnabled(false);

        jLabelInfoCRM.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelInfoCRM.setText("CRM");

        jFormattedTextFieldCRM.setEnabled(false);

        jLabelInfoArea.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelInfoArea.setText("Área");

        jComboBoxArea.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jComboBoxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Cardiologista", "Cardiologista e Endocrinologista", "Endocrinologista", " " }));
        jComboBoxArea.setEnabled(false);

        jButtonNovo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone-add_24.png"))); // NOI18N
        jButtonNovo.setText("Novo     ");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_cancelar24x.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.setMaximumSize(new java.awt.Dimension(119, 39));
        jButtonCancelar.setMinimumSize(new java.awt.Dimension(119, 39));
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_salvar_24x.png"))); // NOI18N
        jButtonSalvar.setText("Salvar    ");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonPesquisa.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_buscar_24.png"))); // NOI18N
        jButtonPesquisa.setText("Buscar");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTextFieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisaActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_editar_24.png"))); // NOI18N
        jButtonEditar.setText("Editar    ");
        jButtonEditar.setEnabled(false);
        jButtonEditar.setMaximumSize(new java.awt.Dimension(119, 39));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_excluir_24_1.png"))); // NOI18N
        jButtonExcluir.setText("Excluir   ");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.setMaximumSize(new java.awt.Dimension(119, 39));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jLabelID.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelID.setText("ID");

        jTextFieldID.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jTextFieldID.setEnabled(false);

        jTableMedico.setFont(new java.awt.Font("Segoe UI Semilight", 0, 13)); // NOI18N
        jTableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedico);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabelInfoArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelInfoCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelInfoNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNomeMedico)
                .addGap(31, 31, 31)
                .addComponent(jLabelID)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelID)
                            .addComponent(jLabelInfoNome)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPesquisa)
                            .addComponent(jButtonPesquisa)))
                    .addComponent(jLabelInfoArea, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelInfoCRM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 80, 890, 500);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo_cadastro_medicos.png"))); // NOI18N
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 940, 600);

        setSize(new java.awt.Dimension(948, 636));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //SALVANDO OS DADOS INFORMADOS PELO USUARIO (BOTAO).
    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        
        
        if (jTextFieldNomeMedico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO NOME!");
            jTextFieldNomeMedico.requestFocus();
        } else if (jFormattedTextFieldCRM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO CRM!");
            jFormattedTextFieldCRM.requestFocus();
        } else if (flag == 1) {

            beansMedico.setNome(jTextFieldNomeMedico.getText());//configurando nome do beansMedico informado pelo usuario.
            beansMedico.setCrm(Integer.parseInt(jFormattedTextFieldCRM.getText()));//configurando do beansMedico CRM informado pelo usuario.
            beansMedico.setArea(jComboBoxArea.getSelectedItem().toString());//configurando a area do beansMedico indormado pelo usuario.
            daoMedico.salvarMedico(beansMedico);//salvando 

            //apos salvarMedico limpa os campos 
            jTextFieldNomeMedico.setText("");
            jFormattedTextFieldCRM.setText("");

            //bloqueia os campos
            jTextFieldNomeMedico.setEnabled(false);
            jFormattedTextFieldCRM.setEnabled(false);
            jComboBoxArea.setEnabled(false);
            
            //desbloqueio de campos
            jTextFieldPesquisa.setEnabled(true);

            //bloqueia os botoes
            jButtonSalvar.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            
            //liberacao de botoes
            jButtonPesquisa.setEnabled(true);

            preencherTabela(sql);
        } else {
            beansMedico.setCodigo(Integer.parseInt(jTextFieldID.getText()));
            beansMedico.setNome(jTextFieldNomeMedico.getText());
            beansMedico.setArea((String) jComboBoxArea.getSelectedItem());
            beansMedico.setCrm(Integer.parseInt(jFormattedTextFieldCRM.getText()));
            daoMedico.Editar(beansMedico);

            //limpando os campos apos o salvar
            jTextFieldNomeMedico.setText("");
            jTextFieldID.setText("");
            jFormattedTextFieldCRM.setText("");
            jComboBoxArea.setSelectedItem("");

            //desabilitando os campos apos a salvar
            jTextFieldNomeMedico.setEnabled(false);
            jFormattedTextFieldCRM.setEnabled(false);
            jComboBoxArea.setEnabled(false);
            jButtonCancelar.setEnabled(false);

            //habilitando botoes apos salvar os dados editados.
            jButtonNovo.setEnabled(true); //botão novo
            preencherTabela(sql);
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    //BOTAO NOVO (IRA LIBERAR OS CAMPOS PARA E OS BOTOES)
    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag = 1;
        jTextFieldNomeMedico.setEnabled(true);//leberando o campo nome.
        jFormattedTextFieldCRM.setEnabled(true);//liberando o campo crm.
        jComboBoxArea.setEnabled(true);//liberando o campo area.
        jButtonSalvar.setEnabled(true);//liberando o botao salvarMedico.
        jButtonCancelar.setEnabled(true);

        //limpando os campos ao clicar em novo
        jTextFieldNomeMedico.setText("");//nome
        jFormattedTextFieldCRM.setText("");//crm
        jTextFieldPesquisa.setText("");//pesquisa
        jTextFieldID.setText("");

        //bloqueando os botões
        jButtonEditar.setEnabled(false);//editar
        jButtonExcluir.setEnabled(false);//excluir
        jButtonPesquisa.setEnabled(false);

        //bloqueio de campos
        jTextFieldPesquisa.setEnabled(false);


    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        beansMedico.setPesquisa(jTextFieldPesquisa.getText());
        BeansMedico model = daoMedico.buscaMedico(beansMedico);
        jTextFieldNomeMedico.setText(model.getNome());
        jFormattedTextFieldCRM.setText(String.valueOf(model.getCrm()));
        jComboBoxArea.setSelectedItem(model.getArea());
        jTextFieldID.setText(Integer.toString(model.getCodigo()));
     
        //liberando os botoes
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        
        preencherTabela("select * from medicos where nome_medico ~* '"+beansMedico.getPesquisa()+"'");
        
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed

        flag = 2;
        jTextFieldNomeMedico.setEnabled(true);//leberando o campo nome.
        jFormattedTextFieldCRM.setEnabled(true);//liberando o campo crm.
        jComboBoxArea.setEnabled(true);//liberando o campo area.
        jButtonSalvar.setEnabled(true);//liberando o botao salvarMedico.
        jButtonCancelar.setEnabled(true);//liberando o botao editar

        jButtonEditar.setEnabled(false);//boqueio do botao editar
        jButtonNovo.setEnabled(false);
        jButtonExcluir.setEnabled(false);

    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        //limpando os campos
        jTextFieldNomeMedico.setText("");
        jFormattedTextFieldCRM.setText("");
        jTextFieldPesquisa.setText("");

        //bloqueio de campos
        jTextFieldNomeMedico.setEnabled(false);//leberando o campo nome.
        jFormattedTextFieldCRM.setEnabled(false);//liberando o campo crm.
        jComboBoxArea.setEnabled(false);//liberando o campo area.
        //ativação de campos
        jTextFieldPesquisa.setEnabled(true);

        //bloqueio de botões
        jButtonSalvar.setEnabled(false);//liberando o botao salvarMedico.
        jButtonEditar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        //ativação de botões
        jButtonNovo.setEnabled(true);
        jButtonPesquisa.setEnabled(true);
;

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;//variavel criada para armazenar a resposta do usuario
        resposta = JOptionPane.showConfirmDialog(rootPane, "DESEJA REALMENTE EXCLUIR?");//sera perguntado se realmente deseja excluir
        if (resposta == JOptionPane.YES_OPTION) {//condicao para verificar a resposta eh sim ou nao para exluir.
            beansMedico.setCodigo(Integer.parseInt(jTextFieldID.getText()));//vai configurar o dado que esta na tela
            daoMedico.excluir(beansMedico);//chamando o metodo de excluir.

            //limpando os campos apos o salvar
            jTextFieldNomeMedico.setText("");
            jTextFieldID.setText("");
            jFormattedTextFieldCRM.setText("");
            jComboBoxArea.setSelectedItem("");
            jTextFieldPesquisa.setText("");

            //desabilitando os campos apos a edição
            jTextFieldNomeMedico.setEnabled(false);
            jFormattedTextFieldCRM.setEnabled(false);
            jComboBoxArea.setEnabled(false);
            jButtonCancelar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonExcluir.setEnabled(false);

            //habilitando botoes apos salvar os dados editados.
            jButtonNovo.setEnabled(true); //botão novo
            preencherTabela(sql);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedicoMouseClicked
        String nome = "" + jTableMedico.getValueAt(jTableMedico.getSelectedRow(), 1);
        conex.conectar();
        conex.executaSql("select * from medicos where nome_medico ='" + nome + "'");
        try {
            conex.resultSet.first();
            jTextFieldID.setText(String.valueOf(conex.resultSet.getInt("id_medico")));
            jTextFieldNomeMedico.setText(conex.resultSet.getString("nome_medico"));
            jFormattedTextFieldCRM.setText(conex.resultSet.getString("crm_medico"));
            jComboBoxArea.setSelectedItem(conex.resultSet.getString("area_medico"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO SELECIONAR OS DADOS!" + ex.getMessage());
        }

        conex.desconecta();
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
    }//GEN-LAST:event_jTableMedicoMouseClicked

    private void jTextFieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaActionPerformed
        // possivel codigo no futuro.
    }//GEN-LAST:event_jTextFieldPesquisaActionPerformed

    public void preencherTabela(String Sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "Nome", "Area", "CRM",};

        conex.conectar();
        conex.executaSql(Sql);

        try {
            conex.resultSet.first();
            do {//fazendo alteração na tabela          
                dados.add(new Object[]{conex.resultSet.getInt("id_medico"), conex.resultSet.getString("nome_medico"),
                    conex.resultSet.getString("area_medico"), conex.resultSet.getInt("crm_medico")});
                
            } while (conex.resultSet.next());//enquanto houver dados ele ira percorrer o registro.
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(rootPane, "BUSQUE POR OUTRO MÉDICO PARA PREENCHER A TABELA!");
        }
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableMedico.setModel(modelotab);
        //coluna 1 ID
        jTableMedico.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableMedico.getColumnModel().getColumn(0).setResizable(false); //bloqueando o redimencionamento pelo mouse
        //coluna 2 Nome
        jTableMedico.getColumnModel().getColumn(1).setPreferredWidth(255);
        jTableMedico.getColumnModel().getColumn(1).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //coluna 3 Area
        jTableMedico.getColumnModel().getColumn(2).setPreferredWidth(227);
        jTableMedico.getColumnModel().getColumn(2).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //coluna 4 CRM
        jTableMedico.getColumnModel().getColumn(3).setPreferredWidth(170);
        jTableMedico.getColumnModel().getColumn(3).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //bloqueando a reordenação pelo mouse
        jTableMedico.getTableHeader().setReorderingAllowed(false);
        //bloqueia o redimencionamento automatico.
        jTableMedico.setAutoResizeMode(jTableMedico.AUTO_RESIZE_OFF);
        jTableMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.desconecta();
    }

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
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxArea;
    private javax.swing.JFormattedTextField jFormattedTextFieldCRM;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelInfoArea;
    private javax.swing.JLabel jLabelInfoCRM;
    private javax.swing.JLabel jLabelInfoNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMedico;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNomeMedico;
    private javax.swing.JTextField jTextFieldPesquisa;
    // End of variables declaration//GEN-END:variables
}