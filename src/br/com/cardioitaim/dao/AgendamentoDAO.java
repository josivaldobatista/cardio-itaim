/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cardioitaim.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.cardioitaim.beans.BeansAgendamento;
import br.com.cardioitaim.conexao.ConexaoBD;

/**
 *
 * @author valdo
 */
public class AgendamentoDAO {

    BeansAgendamento agendam = new BeansAgendamento();
    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexPaciente = new ConexaoBD(); //conexao para buscar o codigo do paciente.
    ConexaoBD conexMedico = new ConexaoBD(); //conexao para buscar o codigo do medico.

    int codPac;//para armazenar o codigo paciente.
    int codMed;//para armazenar o codigo do medico.

    public void salvar(BeansAgendamento agendamento) {
        buscarMedico(agendamento.getNomeMedico());
        buscarPaciente(agendamento.getNomePaciente());

        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareStatement("insert into agendamentos(codpac_nome_agendam, periodo_agendam, "
                    + "codmed_nome_agendam, data_agendam, motivo_agendam, exame_agendam, status_agendam, horario_agendam) values (?,?,?,?,?,?,?,?)");

            pst.setInt(1, codPac);
            pst.setString(2, agendamento.getPeriodo());
            pst.setInt(3, codMed);
            pst.setDate(4, new java.sql.Date(agendamento.getData().getTime()));
            pst.setString(5, agendamento.getMotivo());
            pst.setString(6, agendamento.getExame());
            pst.setString(7, agendamento.getStatus());
            pst.setString(8, agendamento.getHorario());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "AGENDAMENTO SALVO COM SUCESSO!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir os dados (Agendamento SALVAR) " + ex.getMessage());
        }
        conex.desconecta();
    }

    //metodo para buscar nome do medico
    public void buscarMedico(String nomeMedico) {
        conexMedico.conectar();
        conexMedico.executaSql("select * from medicos where nome_medico='" + nomeMedico + "'");
        try {
            conexMedico.resultSet.first();
            codMed = conexMedico.resultSet.getInt("id_medico");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o medico (Agendamento BUSCAMEDICO) " + ex.getMessage());
        }
    }

    //metodo para buscar nome do paciente.
    public void buscarPaciente(String nomePaciente) {
        conexPaciente.conectar();
        conexPaciente.executaSql("select * from pacientes where nome_paciente='" + nomePaciente + "'");
        try {
            conexPaciente.resultSet.first();
            codPac = conexPaciente.resultSet.getInt("id_paciente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o medico (Agendamento)" + ex.getMessage());
        }
    }
    //metodo para alterar status do agendamnto
    public void alterar(BeansAgendamento agenda){
        conex.conectar();
        
        try{
            PreparedStatement pst = conex.conexao.prepareStatement("update agendamentos set status_agendam = ? where id_agendam = ?");
            pst.setString(1, agenda.getStatus());
            pst.setInt(2, agenda.getIdAgenda());
            pst.execute();
//            JOptionPane.showMessageDialog(null, "STATUS ALTERADO COM SUCESSO!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO AL ALTERAR O STATUS (AgendamentoDAO - Alterar) "+ex.getMessage());
        }
        conex.desconecta();
    }
    //metodo para excluir agendamnto
    public void excluir(BeansAgendamento agenda){
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareStatement("delete from agendamentos where id_agendam = ?");
            pst.setInt(1, agenda.getIdAgenda());
            pst.execute();
            JOptionPane.showMessageDialog(null, "DADOS EXCLUIDOS COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR OS DADOS!"+ex.getMessage());
        }
        conex.desconecta();
    }
}
