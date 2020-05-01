/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cardioitaim.visao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import br.com.cardioitaim.beans.BeansAgendamento;
import br.com.cardioitaim.beans.ModeloTabela;
import br.com.cardioitaim.conexao.ConexaoBD;
import br.com.cardioitaim.dao.AgendamentoDAO;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author valdo
 */
public class FormAgenda extends javax.swing.JFrame {
    
    Connection conn = ConexaoBD.getConnection();

    String dtHoje;
    String statusAberto = "Aberto";
    String statusFechado = "Fechado";
    String emAtendimento = "Em Atendimento";

    ConexaoBD conex = new ConexaoBD();
    BeansAgendamento agendamentoBeans = new BeansAgendamento();
    BeansAgendamento agen = new BeansAgendamento();//objeto para excluir e alterar
    AgendamentoDAO daoAgendamento = new AgendamentoDAO();

    /**
     * Creates new form FormAgenda
     */
    public FormAgenda() {
        initComponents();

        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        dateFormat.format(d);
        dtHoje = dateFormat.format(d);

    }

    public void preencherTabela(String Sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"Id", "Paciente", "Médico", "Data", "Hora", "Periodo ", "Exame ", "Status"};

        conex.conectar();
        conex.executaSql(Sql);

        try {
            conex.resultSet.first();
            do {//fazendo alteração na tabela          
                dados.add(new Object[]{conex.resultSet.getInt("id_agendam"), conex.resultSet.getString("nome_paciente"),
                    conex.resultSet.getString("nome_medico"), conex.resultSet.getString("data_agendam"), conex.resultSet.getString("horario_agendam"),
                    conex.resultSet.getString("periodo_agendam"), conex.resultSet.getString("exame_agendam"), conex.resultSet.getString("status_agendam")});
            } while (conex.resultSet.next());//enquanto houver dados ele ira percorrer o registro.
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(rootPane, "BUSQUE POR OUTRO MÉDICO PARA PREENCHER A TABELA!");
        }
        ModeloTabela modelotab = new ModeloTabela(dados, colunas);
        jTableAgendamentos.setModel(modelotab);
        //coluna 1 ID
        jTableAgendamentos.getColumnModel().getColumn(0).setPreferredWidth(42);
        jTableAgendamentos.getColumnModel().getColumn(0).setResizable(false); //bloqueando o redimencionamento pelo mouse
        //coluna 2 Nome paciente
        jTableAgendamentos.getColumnModel().getColumn(1).setPreferredWidth(185);
        jTableAgendamentos.getColumnModel().getColumn(1).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //coluna 3 nome medico
        jTableAgendamentos.getColumnModel().getColumn(2).setPreferredWidth(152);
        jTableAgendamentos.getColumnModel().getColumn(2).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //coluna 4 data agendamento
        jTableAgendamentos.getColumnModel().getColumn(3).setPreferredWidth(75);
        jTableAgendamentos.getColumnModel().getColumn(3).setResizable(false);//bloqueando o redimencionamento pelo mouse
        //coluna 5 horario
        jTableAgendamentos.getColumnModel().getColumn(4).setPreferredWidth(45);
        jTableAgendamentos.getColumnModel().getColumn(4).setResizable(false); //bloqueando o redimencionamento pelo mouse
        //coluna 6 periodo
        jTableAgendamentos.getColumnModel().getColumn(5).setPreferredWidth(60);
        jTableAgendamentos.getColumnModel().getColumn(5).setResizable(false); //bloqueando o redimencionamento pelo mouse
        //coluna 7 horario exame
        jTableAgendamentos.getColumnModel().getColumn(6).setPreferredWidth(97);
        jTableAgendamentos.getColumnModel().getColumn(6).setResizable(false); //bloqueando o redimencionamento pelo mouse
        //coluna 8 status
        jTableAgendamentos.getColumnModel().getColumn(7).setPreferredWidth(102);
        jTableAgendamentos.getColumnModel().getColumn(7).setResizable(false); //bloqueando o redimencionamento pelo mouse

        //bloqueando a reordenação pelo mouse
        jTableAgendamentos.getTableHeader().setReorderingAllowed(false);
        //bloqueia o redimencionamento automatico.
        jTableAgendamentos.setAutoResizeMode(jTableAgendamentos.AUTO_RESIZE_OFF);
        jTableAgendamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        conex.desconecta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupTodosHoje = new javax.swing.ButtonGroup();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelEscolha = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jRadioButtonTodos = new javax.swing.JRadioButton();
        jRadioButtonHoje = new javax.swing.JRadioButton();
        jRadioButtonAnteriores = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamentos = new javax.swing.JTable();
        jButtonAtender = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda Cardio Itaim");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/icone_desktop.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelEscolha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_buscar_24.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        buttonGroupTodosHoje.add(jRadioButtonTodos);
        jRadioButtonTodos.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jRadioButtonTodos.setText("Hoje Todos");
        jRadioButtonTodos.setToolTipText("Todos agendamentos ja feito");

        buttonGroupTodosHoje.add(jRadioButtonHoje);
        jRadioButtonHoje.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jRadioButtonHoje.setText("Hoje Abertos");
        jRadioButtonHoje.setToolTipText("Agendamentos de hoje abertos e fechados");

        buttonGroupTodosHoje.add(jRadioButtonAnteriores);
        jRadioButtonAnteriores.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jRadioButtonAnteriores.setText("Anteriores");

        javax.swing.GroupLayout jPanelEscolhaLayout = new javax.swing.GroupLayout(jPanelEscolha);
        jPanelEscolha.setLayout(jPanelEscolhaLayout);
        jPanelEscolhaLayout.setHorizontalGroup(
            jPanelEscolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscolhaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonAnteriores)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonHoje)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelEscolhaLayout.setVerticalGroup(
            jPanelEscolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEscolhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEscolhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonTodos)
                    .addComponent(jRadioButtonHoje)
                    .addComponent(jButtonBuscar)
                    .addComponent(jRadioButtonAnteriores))
                .addContainerGap())
        );

        jTableAgendamentos.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        jTableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgendamentos);

        jButtonAtender.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonAtender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_atender_24.png"))); // NOI18N
        jButtonAtender.setText("Atender");
        jButtonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtenderActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_excluir_24_1.png"))); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSair.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_logout_24.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icone_imprimir_24x_3.png"))); // NOI18N
        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonImprimir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAtender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSair)
                        .addGap(17, 17, 17))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanelEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtender)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelPrincipal);
        jPanelPrincipal.setBounds(10, 70, 780, 430);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo_agenda_800.png"))); // NOI18N
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 800, 510);

        setSize(new java.awt.Dimension(813, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        //condicao para agendamentos ABERTOS
        if (jRadioButtonHoje.isSelected()) {
            preencherTabela("select * from agendamentos inner join pacientes on codpac_nome_agendam = id_paciente inner join medicos on "
                    + "codmed_nome_agendam = id_medico where data_agendam = '" + dtHoje + "' and status_agendam = '" + statusAberto + "'");
        } //condicao para agendamentos TODOS agendamentos
        else if(jRadioButtonTodos.isSelected()){
            preencherTabela("select * from agendamentos inner join pacientes on codpac_nome_agendam = id_paciente inner join medicos on "
                    + "codmed_nome_agendam = id_medico where data_agendam = '" + dtHoje + "'");
        }else{
            preencherTabela("select * from agendamentos inner join pacientes on codpac_nome_agendam = id_paciente inner join medicos on "
                    + "codmed_nome_agendam = id_medico order by nome_paciente");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTableAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendamentosMouseClicked
        
            String agendaCod = "" + jTableAgendamentos.getValueAt(jTableAgendamentos.getSelectedRow(), 0);
            conex.conectar();
            conex.executaSql("select * from agendamentos where id_agendam ='" + agendaCod + "'");
            try {
                conex.resultSet.first();
                agen.setStatus(statusFechado);
                agen.setIdAgenda(conex.resultSet.getInt("id_agendam"));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO AO SELECIONAR OS DADOS!" + ex.getMessage());
            }
    }//GEN-LAST:event_jTableAgendamentosMouseClicked

    private void jButtonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtenderActionPerformed
        
        daoAgendamento.alterar(agen);
        JOptionPane.showMessageDialog(rootPane, "CLIENTE ATENDIDO!");
        if (jRadioButtonHoje.isSelected()) {
            preencherTabela("select * from agendamentos inner join pacientes on codpac_nome_agendam = id_paciente inner join medicos on "
                    + "codmed_nome_agendam = id_medico where data_agendam = '" + dtHoje + "' and status_agendam = '" + statusAberto + "'");
        } //condicao para agendamentos TODOS agendamentos
        else {
            preencherTabela("select * from agendamentos inner join pacientes on codpac_nome_agendam = id_paciente inner join medicos on "
                    + "codmed_nome_agendam = id_medico where data_agendam = '" + dtHoje + "'");
        }
    }//GEN-LAST:event_jButtonAtenderActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;//variavel criada para armazenar a resposta do usuario
         resposta = JOptionPane.showConfirmDialog(rootPane, "DESEJA REALMENTE EXCLUIR?");//sera perguntado se realmente deseja excluir
        if (resposta == JOptionPane.YES_OPTION) {//condicao para verificar a resposta eh sim ou nao para exluir.
            daoAgendamento.excluir(agen);//chamando o metodo de excluir.

            if (jRadioButtonHoje.isSelected()) {
            preencherTabela("select * from agendamentos inner join pacientes on codpac_nome_agendam = id_paciente inner join medicos on "
                    + "codmed_nome_agendam = id_medico where data_agendam = '" + dtHoje + "' and status_agendam = '" + statusAberto + "'");
        } //condicao para agendamentos TODOS agendamentos
        else {
            preencherTabela("select * from agendamentos inner join pacientes on codpac_nome_agendam = id_paciente inner join medicos on "
                    + "codmed_nome_agendam = id_medico where data_agendam = '" + dtHoje + "'");
        }

        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        preencherTabela("select * from agendamentos inner join pacientes on codpac_nome_agendam = id_paciente inner join medicos on codmed_nome_agendam = id_medico "
                + "where data_agendam = '" + dtHoje + "' and status_agendam = '" + statusAberto + "'");
        
        buttonGroupTodosHoje.clearSelection();
    }//GEN-LAST:event_formWindowActivated

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        // DETALHES DE AGENDAMENTOS
        int confirma = JOptionPane.showConfirmDialog(rootPane, "DESEJA REALMENTE IMPRIMIR?", "ATENÇÃO!",JOptionPane.YES_NO_OPTION);//confirmacao de impressao
        if(confirma == JOptionPane.YES_OPTION){
            //imprimindo relatorio com iReport
            
            try {
                String agendaCod = "" + jTableAgendamentos.getValueAt(jTableAgendamentos.getSelectedRow(), 0);
                
                //usando a classe HashMap para criar um filtro
                HashMap filtro = new HashMap();
                filtro.put("id_agendam", Integer.parseInt(agendaCod));
                //Usando a class JasperPrint para preparar a impressao relatorio
                JasperPrint print = JasperFillManager.fillReport("D:/NetBeansProjects/Cardio Itaim/src/br/com/cardioitaim/ireports/agendamentoPac.jasper",filtro,conn);
                //a linha abaixo exibe o relatorio atraves da classe JasperViewer
                JasperViewer.viewReport(print,false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "SELECIONE UM AGENDAMENTO PARA CONTINUAR!");
            }
        }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

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
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupTodosHoje;
    private javax.swing.JButton jButtonAtender;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JPanel jPanelEscolha;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JRadioButton jRadioButtonAnteriores;
    private javax.swing.JRadioButton jRadioButtonHoje;
    private javax.swing.JRadioButton jRadioButtonTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgendamentos;
    // End of variables declaration//GEN-END:variables
}
