/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cardioitaim.visao;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import br.com.cardioitaim.beans.BeansUsuario;
import br.com.cardioitaim.beans.ModeloTabela;
import br.com.cardioitaim.conexao.ConexaoBD;
import br.com.cardioitaim.dao.UsuarioDAO;

/**
 *
 * @author rockv
 */
public class FormUsuario extends javax.swing.JFrame {

    int flag = 0;
    String sql = "select * from usuarios order by nome_usuario";

    BeansUsuario beansUsuario = new BeansUsuario();
    ConexaoBD conex = new ConexaoBD();
    UsuarioDAO daoUsuario = new UsuarioDAO();

    public FormUsuario() {
        initComponents();
        preencherTabela(sql);
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
        jTextFieldNome = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelInfoID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelInfoTipo = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabelSenha = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jLabelInfoConfirmSenha = new javax.swing.JLabel();
        jPasswordFieldConfirmSenha = new javax.swing.JPasswordField();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuario = new javax.swing.JTable();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icone_desktop.png")).getImage());
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelInfoNome.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelInfoNome.setText("Nome");

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTextFieldNome.setEnabled(false);

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuario");

        jTextFieldUsuario.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTextFieldUsuario.setEnabled(false);

        jLabelInfoID.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelInfoID.setText("ID");

        jTextFieldID.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTextFieldID.setEnabled(false);

        jLabelInfoTipo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelInfoTipo.setText("Tipo");

        jComboBoxTipo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum", "Administrador", "Enfermeira", "Médico", "Recepcionista", "Usuario" }));
        jComboBoxTipo.setEnabled(false);

        jLabelSenha.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha");

        jPasswordFieldSenha.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jPasswordFieldSenha.setEnabled(false);

        jLabelInfoConfirmSenha.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabelInfoConfirmSenha.setText("Confirmar Senha");

        jPasswordFieldConfirmSenha.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jPasswordFieldConfirmSenha.setEnabled(false);

        jTextFieldBuscar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyPressed(evt);
            }
        });

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_buscar_24.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jButtonBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonBuscarKeyPressed(evt);
            }
        });

        jButtonNovo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone-add_24.png"))); // NOI18N
        jButtonNovo.setText("Novo   ");
        jButtonNovo.setMaximumSize(new java.awt.Dimension(119, 39));
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_editar_24.png"))); // NOI18N
        jButtonEditar.setText("Editar  ");
        jButtonEditar.setEnabled(false);
        jButtonEditar.setMaximumSize(new java.awt.Dimension(119, 39));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_salvar_24x.png"))); // NOI18N
        jButtonSalvar.setText("Salvar   ");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.setMaximumSize(new java.awt.Dimension(119, 39));
        jButtonSalvar.setMinimumSize(new java.awt.Dimension(119, 39));
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_excluir_24_1.png"))); // NOI18N
        jButtonExcluir.setText("Excluir   ");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.setMaximumSize(new java.awt.Dimension(119, 39));
        jButtonExcluir.setMinimumSize(new java.awt.Dimension(119, 39));
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
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

        jTableUsuario.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jTableUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuario);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelInfoNome)
                            .addComponent(jLabelInfoTipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldNome)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInfoID, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxTipo, 0, 263, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelInfoConfirmSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordFieldConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInfoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabelInfoID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelInfoConfirmSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPasswordFieldConfirmSenha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelInfoTipo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxTipo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(206, 206, 206))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 70, 890, 510);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo_cadastro_usuarios.png"))); // NOI18N
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 940, 600);

        setSize(new java.awt.Dimension(948, 636));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        if (jTextFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO NOME!");
            jTextFieldNome.requestFocus();

        } else if (jTextFieldUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO USUÁRIO!");
            jTextFieldUsuario.requestFocus();

        } else if (jPasswordFieldSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO SENHA!");
            jPasswordFieldSenha.requestFocus();

        } else if (jPasswordFieldConfirmSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO CONFIRMA SENHA!");
            jPasswordFieldConfirmSenha.requestFocus();

        } else if (jPasswordFieldSenha.getText().equals(jPasswordFieldConfirmSenha.getText())) {
            if (flag == 1) {
                beansUsuario.setNome(jTextFieldNome.getText());//configurando nome do medico informado pelo usuario.
                beansUsuario.setUsuario(jTextFieldUsuario.getText());//configurando do medico CRM informado pelo usuario.
                beansUsuario.setSenha(jPasswordFieldSenha.getText());//configurando a area do medico indormado pelo usuario.
                beansUsuario.setTipo((String) jComboBoxTipo.getSelectedItem());//salvando 
                daoUsuario.salvarUsuario(beansUsuario);

                //apos salvarMedico limpa os campos 
                jTextFieldNome.setText("");
                jTextFieldUsuario.setText("");
                jTextFieldID.setText("");
                jComboBoxTipo.setSelectedItem("Nenhum");
                jPasswordFieldSenha.setText("");
                jPasswordFieldConfirmSenha.setText("");

                //bloqueia os campos
                jTextFieldNome.setEnabled(false);
                jTextFieldUsuario.setEnabled(false);
                jComboBoxTipo.setEnabled(false);
                jPasswordFieldSenha.setEnabled(false);
                jPasswordFieldConfirmSenha.setEnabled(false);

                //bloqueia os botoes
                jButtonSalvar.setEnabled(false);
                jButtonCancelar.setEnabled(false);
                
                //libera botoes
                 jButtonBuscar.setEnabled(true);
                 
                 //libera campos
                 jTextFieldBuscar.setEnabled(true);
                preencherTabela(sql);
                //else que edita o usuario
            } else {
                beansUsuario.setCodigo(Integer.parseInt(jTextFieldID.getText()));
                beansUsuario.setNome(jTextFieldNome.getText());
                beansUsuario.setUsuario(jTextFieldUsuario.getText());
                beansUsuario.setSenha(jPasswordFieldSenha.getText());
                beansUsuario.setTipo((String) jComboBoxTipo.getSelectedItem());
                daoUsuario.Editar(beansUsuario);

                //apos salvar Medico usando o editar limpa os campos 
                jTextFieldNome.setText("");
                jTextFieldUsuario.setText("");
                jTextFieldID.setText("");
                jTextFieldBuscar.setText("");
                jComboBoxTipo.setSelectedItem("Nenhum");
                jPasswordFieldSenha.setText("");
                jPasswordFieldConfirmSenha.setText("");

                //bloqueia os campos
                jTextFieldNome.setEnabled(false);
                jTextFieldUsuario.setEnabled(false);
                jComboBoxTipo.setEnabled(false);
                jPasswordFieldSenha.setEnabled(false);
                jPasswordFieldConfirmSenha.setEnabled(false);

                //bloqueia os botoes
                jButtonSalvar.setEnabled(false);
                jButtonCancelar.setEnabled(false);
                jButtonExcluir.setEnabled(false);
                jButtonEditar.setEnabled(false);

                //libera botoes
                jButtonNovo.setEnabled(true);
                preencherTabela(sql);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "SENHA E CONFIRMAR SENHA DIFERENTES! \nInforme uma senha igual ao Confirma senha.");
            jPasswordFieldSenha.requestFocus();
            jPasswordFieldSenha.setText("");
            jPasswordFieldConfirmSenha.setText("");
        }

    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag = 1;
        //liberando os campos
        jTextFieldNome.setEnabled(true);
        jTextFieldUsuario.setEnabled(true);
        jComboBoxTipo.setEnabled(true);
        jPasswordFieldSenha.setEnabled(true);
        jPasswordFieldConfirmSenha.setEnabled(true);

        //bloqueando os campos
        jTextFieldBuscar.setEnabled(false);

        //liberando os botoes
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);

        //bloqueando botoes
        jButtonEditar.setEnabled(false);
        jButtonBuscar.setEnabled(false);
        jButtonExcluir.setEnabled(false);

        //limpando os campos
        jTextFieldNome.setText("");
        jTextFieldUsuario.setText("");
        jComboBoxTipo.setSelectedItem("Nenhum");
        jPasswordFieldSenha.setText("");
        jPasswordFieldConfirmSenha.setText("");
        jTextFieldBuscar.setText("");

        preencherTabela(sql);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        beansUsuario.setPesquisa(jTextFieldBuscar.getText());//pegando o valor informado pelo usuario
        BeansUsuario model = daoUsuario.buscarUsuario(beansUsuario);

        //setando os campos com valores do banco de dados.
        jTextFieldID.setText(String.valueOf(model.getCodigo()));
        jTextFieldNome.setText(model.getNome());
        jTextFieldUsuario.setText(model.getUsuario());
        jPasswordFieldSenha.setText(model.getSenha());
        jPasswordFieldConfirmSenha.setText(model.getSenha());
        jComboBoxTipo.setSelectedItem(model.getTipo());

        //liberando os botoes
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonCancelar.setEnabled(true);

        //limpando os campos
        jTextFieldBuscar.setText("");
        preencherTabela("select * from usuarios where nome_usuario ~*'" + beansUsuario.getPesquisa() + "'");
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        flag = 2;
        //leberando os campos
        jTextFieldNome.setEnabled(true);
        jTextFieldUsuario.setEnabled(true);
        jComboBoxTipo.setEnabled(true);
        jPasswordFieldSenha.setEnabled(true);
        jPasswordFieldConfirmSenha.setEnabled(true);

        //liberando os botoes
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);

        //limpando os campos

    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        //limpando os campos
        jTextFieldNome.setText("");
        jTextFieldUsuario.setText("");
        jTextFieldID.setText("");
        jComboBoxTipo.setSelectedItem("Nenhum");
        jPasswordFieldSenha.setText("");
        jPasswordFieldConfirmSenha.setText("");
        jTextFieldBuscar.setText("");

        //libera campos
        jTextFieldBuscar.setEnabled(true);

        //bloqueia os campos
        jTextFieldNome.setEnabled(false);
        jTextFieldUsuario.setEnabled(false);
        jComboBoxTipo.setEnabled(false);
        jPasswordFieldSenha.setEnabled(false);
        jPasswordFieldConfirmSenha.setEnabled(false);

        //bloqueando os botoes
        jButtonEditar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);

        //libera os botoes
        jButtonBuscar.setEnabled(true);
        jButtonNovo.setEnabled(true);
        
        preencherTabela(sql);


    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;//variavel criada para armazenar a resposta do usuario
        resposta = JOptionPane.showConfirmDialog(rootPane, "DESEJA REALMENTE EXCLUIR?");//sera perguntado se realmente deseja excluir
        if (resposta == JOptionPane.YES_OPTION) {//condicao para verificar a resposta eh sim ou nao para exluir.
            beansUsuario.setCodigo(Integer.parseInt(jTextFieldID.getText()));//vai configurar o dado que esta na tela
            daoUsuario.excluir(beansUsuario);//chamando o metodo de excluir.
        }
        preencherTabela(sql);

        //liberando botoes
        jButtonNovo.setEnabled(true);

        //bloqueando botoes
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);

        //limpando os campos
        jTextFieldNome.setText("");
        jTextFieldUsuario.setText("");
        jTextFieldID.setText("");
        jComboBoxTipo.setSelectedItem("Nenhum");
        jPasswordFieldSenha.setText("");
        jPasswordFieldConfirmSenha.setText("");
        jTextFieldBuscar.setText("");
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuarioMouseClicked
        String nome = "" + jTableUsuario.getValueAt(jTableUsuario.getSelectedRow(), 1);
        conex.conectar();
        conex.executaSql("select * from usuarios where nome_usuario ='" + nome + "'");
        try {
            conex.resultSet.first();
            jTextFieldID.setText(String.valueOf(conex.resultSet.getInt("id_usuario")));
            jTextFieldNome.setText(conex.resultSet.getString("nome_usuario"));
            jTextFieldUsuario.setText(conex.resultSet.getString("usuario_usuario"));
            jPasswordFieldSenha.setText(conex.resultSet.getString("senha_usuario"));
            jPasswordFieldConfirmSenha.setText(conex.resultSet.getString("senha_usuario"));
            jComboBoxTipo.setSelectedItem(conex.resultSet.getString("tipo_usuario"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO SELECIONAR OS DADOS!" + ex.getMessage());
        }

        conex.desconecta();

        //liberando os botoes
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonCancelar.setEnabled(true);

        //bloqueando os botoes
        jButtonSalvar.setEnabled(false);
        jButtonNovo.setEnabled(false);

        //bloqueia os campos
        jTextFieldNome.setEnabled(false);
        jTextFieldUsuario.setEnabled(false);
        jComboBoxTipo.setEnabled(false);
        jPasswordFieldSenha.setEnabled(false);
        jPasswordFieldConfirmSenha.setEnabled(false);

    }//GEN-LAST:event_jTableUsuarioMouseClicked

    private void jTextFieldBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            beansUsuario.setPesquisa(jTextFieldBuscar.getText());//pegando o valor informado pelo usuario
            BeansUsuario model = daoUsuario.buscarUsuario(beansUsuario);

            //setando os campos com valores do banco de dados.
            jTextFieldID.setText(String.valueOf(model.getCodigo()));
            jTextFieldNome.setText(model.getNome());
            jTextFieldUsuario.setText(model.getUsuario());
            jPasswordFieldSenha.setText(model.getSenha());
            jPasswordFieldConfirmSenha.setText(model.getSenha());
            jComboBoxTipo.setSelectedItem(model.getTipo());

            //liberando os botoes
            jButtonEditar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonCancelar.setEnabled(true);

            //limpando os campos
            jTextFieldBuscar.setText("");
            preencherTabela("select * from usuarios where nome_usuario ~*'" + beansUsuario.getPesquisa() + "'");
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyPressed

    private void jButtonBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            beansUsuario.setPesquisa(jTextFieldBuscar.getText());//pegando o valor informado pelo usuario
            BeansUsuario model = daoUsuario.buscarUsuario(beansUsuario);

            //setando os campos com valores do banco de dados.
            jTextFieldID.setText(String.valueOf(model.getCodigo()));
            jTextFieldNome.setText(model.getNome());
            jTextFieldUsuario.setText(model.getUsuario());
            jPasswordFieldSenha.setText(model.getSenha());
            jPasswordFieldConfirmSenha.setText(model.getSenha());
            jComboBoxTipo.setSelectedItem(model.getTipo());

            //liberando os botoes
            jButtonEditar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonCancelar.setEnabled(true);

            //limpando os campos
            jTextFieldBuscar.setText("");
            preencherTabela("select * from usuarios where nome_usuario ~*'" + beansUsuario.getPesquisa() + "'");
        }
    }//GEN-LAST:event_jButtonBuscarKeyPressed

    public void preencherTabela(String Sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Id", "Nome", "Usuario", "Tipo"};

        conex.conectar();
        conex.executaSql(Sql);

        try {
            conex.resultSet.first();
            do {//fazendo alteração na tabela          
                dados.add(new Object[]{conex.resultSet.getInt("id_usuario"), conex.resultSet.getString("nome_usuario"),
                    conex.resultSet.getString("usuario_usuario"), conex.resultSet.getString("tipo_usuario")});
            } while (conex.resultSet.next());//enquanto houver dados ele ira percorrer o registro.
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(rootPane, "BUSQUE POR OUTRO MÉDICO PARA PREENCHER A TABELA!");
        }
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableUsuario.setModel(modelotab);
        //coluna 1 ID
        jTableUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableUsuario.getColumnModel().getColumn(0).setResizable(false); //bloqueando o redimencionamento pelo mouse
        //coluna 2 Nome
        jTableUsuario.getColumnModel().getColumn(1).setPreferredWidth(255);
        jTableUsuario.getColumnModel().getColumn(1).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //coluna 3 Area
        jTableUsuario.getColumnModel().getColumn(2).setPreferredWidth(227);
        jTableUsuario.getColumnModel().getColumn(2).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //coluna 4 CRM
        jTableUsuario.getColumnModel().getColumn(3).setPreferredWidth(170);
        jTableUsuario.getColumnModel().getColumn(3).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //bloqueando a reordenação pelo mouse
        jTableUsuario.getTableHeader().setReorderingAllowed(false);
        //bloqueia o redimencionamento automatico.
        jTableUsuario.setAutoResizeMode(jTableUsuario.AUTO_RESIZE_OFF);
        jTableUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.desconecta();
    }

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
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JLabel jLabelInfoConfirmSenha;
    private javax.swing.JLabel jLabelInfoID;
    private javax.swing.JLabel jLabelInfoNome;
    private javax.swing.JLabel jLabelInfoTipo;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldConfirmSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUsuario;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}