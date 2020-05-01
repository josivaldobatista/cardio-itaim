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
import br.com.cardioitaim.beans.BeansPaciente;
import br.com.cardioitaim.conexao.ConexaoBD;

/**
 *
 * @author valdo
 */
public class PacienteDAO {
    
   // BeansPaciente paciente = new BeansPaciente();
    ConexaoBD conex = new ConexaoBD();
    ConexaoBD conexBairro = new ConexaoBD();
    
    String nomeBairro; 
    int codBairro;
    
    public void salvar(BeansPaciente modPaciente){
        buscaBairroCodigo(modPaciente.getBairroPaciente());
        conex.conectar();
        
        try {
            PreparedStatement pst = conex.conexao.prepareStatement("insert into pacientes (nome_paciente, rg_paciente, "
                    + "cpf_paciente, email_paciente, convenio_paciente, telefone_paciente, celular_paciente, contato_paciente, obs_paciente,"
                    + "rua_paciente, numrua_paciente, cep_paciente, compl_paciente, id_bairro_paciente, nasc_paciente, "
                    + "fumante_paciente, sexo_paciente)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
                    pst.setString(1, modPaciente.getNomePaciente());
                    pst.setString(2, modPaciente.getRGPaciente());
                    pst.setString(3, modPaciente.getCPFPaciente());
                    pst.setString(4, modPaciente.getEmailPaciente());
                    pst.setString(5, modPaciente.getConvenioPaciente());
                    pst.setString(6, modPaciente.getTelefonePaciente());
                    pst.setString(7, modPaciente.getCelularPaciente());
                    pst.setString(8, modPaciente.getContatoPaciente());
                    pst.setString(9, modPaciente.getObsPaciente());
                    pst.setString(10, modPaciente.getRuaPaciente());
                    pst.setString(11, modPaciente.getNumeroCasaPaciente());
                    pst.setString(12, modPaciente.getCEPPaciente());
                    pst.setString(13, modPaciente.getComplPaciente());
                    pst.setInt(14, codBairro);
                    pst.setString(15, modPaciente.getNascPaciente());
                    pst.setString(16, modPaciente.getFumante());
                    pst.setString(17, modPaciente.getSexoPaciente());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "PACIENTE SALVO COM SUCESSO!");
                            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR OS DADOS"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    public void editar(BeansPaciente modPaciente){
        buscaBairroCodigo(modPaciente.getBairroPaciente());
        conex.conectar();
        
        try {
            PreparedStatement pst = conex.conexao.prepareStatement("update pacientes set nome_paciente = ?, rg_paciente = ?, "
                    + "cpf_paciente = ?, email_paciente = ?, convenio_paciente = ?, telefone_paciente = ?, celular_paciente = ?, contato_paciente = ?, obs_paciente = ?,"
                    + "rua_paciente = ?, numrua_paciente = ?, cep_paciente = ?, compl_paciente = ?, id_bairro_paciente = ?, nasc_paciente = ?, "
                    + "fumante_paciente = ?, sexo_paciente = ? where id_paciente = ?");
            
                    pst.setString(1, modPaciente.getNomePaciente());
                    pst.setString(2, modPaciente.getRGPaciente());
                    pst.setString(3, modPaciente.getCPFPaciente());
                    pst.setString(4, modPaciente.getEmailPaciente());
                    pst.setString(5, modPaciente.getConvenioPaciente());
                    pst.setString(6, modPaciente.getTelefonePaciente());
                    pst.setString(7, modPaciente.getCelularPaciente());
                    pst.setString(8, modPaciente.getContatoPaciente());
                    pst.setString(9, modPaciente.getObsPaciente());
                    pst.setString(10, modPaciente.getRuaPaciente());
                    pst.setString(11, modPaciente.getNumeroCasaPaciente());
                    pst.setString(12, modPaciente.getCEPPaciente());
                    pst.setString(13, modPaciente.getComplPaciente());
                    pst.setInt(14, codBairro);
                    pst.setString(15, modPaciente.getNascPaciente());
                    pst.setString(16, modPaciente.getFumante());
                    pst.setString(17, modPaciente.getSexoPaciente());
                    pst.setInt(18, modPaciente.getCodPaciente());
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "PACIENTE ALTERADO COM SUCESSO!");
                            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR OS DADOS"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    
    //BUSCA O CODIGO DO BAIRRO NO BANCO DE DADOS
    public void buscaBairroCodigo(String nome){
        conex.conectar();
        conex.executaSql("select * from bairros where nome_bairro like '"+nome+"'");
        try {
            conex.resultSet.first();
            codBairro = conex.resultSet.getInt("id_bairro");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o  bairro"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    
    public BeansPaciente buscaPacienteCPF(BeansPaciente paciente){
        conex.conectar();
            
        try {
            conex.executaSql("select * from pacientes where cpf_paciente like '%"+paciente.getPesquisaCPF()+"%'");
            conex.resultSet.first();
            
             paciente.setCodPaciente(conex.resultSet.getInt("id_paciente"));
             paciente.setNomePaciente(conex.resultSet.getString("nome_paciente"));
             paciente.setRGPaciente(conex.resultSet.getString("rg_paciente"));
             paciente.setCPFPaciente(conex.resultSet.getString("cpf_paciente"));
             paciente.setEmailPaciente(conex.resultSet.getString("email_paciente"));
             paciente.setConvenioPaciente(conex.resultSet.getString("convenio_paciente"));
             paciente.setTelefonePaciente(conex.resultSet.getString("telefone_paciente"));
             paciente.setCelularPaciente(conex.resultSet.getString("celular_paciente"));
             paciente.setContatoPaciente(conex.resultSet.getString("contato_paciente"));
             paciente.setObsPaciente(conex.resultSet.getString("obs_paciente"));
             paciente.setRuaPaciente(conex.resultSet.getString("rua_paciente"));
             paciente.setNumeroCasaPaciente(conex.resultSet.getString("numrua_paciente"));
             paciente.setCEPPaciente(conex.resultSet.getString("cep_paciente"));
             paciente.setComplPaciente(conex.resultSet.getString("compl_paciente"));
             buscaNomeBairro(conex.resultSet.getInt("id_bairro_paciente"));
             paciente.setNascPaciente(conex.resultSet.getString("nasc_paciente"));
             paciente.setFumante(conex.resultSet.getString("fumante_paciente"));
             paciente.setSexoPaciente(conex.resultSet.getString("sexo_paciente"));
             paciente.setBairroPaciente(nomeBairro);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o  paciente "+ex.getMessage());
        }
        conex.desconecta();
        
        return paciente;
        
    }
    
    public BeansPaciente buscaPacienteNome(BeansPaciente paciente){
        conex.conectar();
            
        try {
            conex.executaSql("select * from pacientes where nome_paciente ~*'"+paciente.getPesquisarNome()+"'");
            conex.resultSet.first();
            
             paciente.setCodPaciente(conex.resultSet.getInt("id_paciente"));
             paciente.setNomePaciente(conex.resultSet.getString("nome_paciente"));
             paciente.setRGPaciente(conex.resultSet.getString("rg_paciente"));
             paciente.setCPFPaciente(conex.resultSet.getString("cpf_paciente"));
             paciente.setEmailPaciente(conex.resultSet.getString("email_paciente"));
             paciente.setConvenioPaciente(conex.resultSet.getString("convenio_paciente"));
             paciente.setTelefonePaciente(conex.resultSet.getString("telefone_paciente"));
             paciente.setCelularPaciente(conex.resultSet.getString("celular_paciente"));
             paciente.setContatoPaciente(conex.resultSet.getString("contato_paciente"));
             paciente.setObsPaciente(conex.resultSet.getString("obs_paciente"));
             paciente.setRuaPaciente(conex.resultSet.getString("rua_paciente"));
             paciente.setNumeroCasaPaciente(conex.resultSet.getString("numrua_paciente"));
             paciente.setCEPPaciente(conex.resultSet.getString("cep_paciente"));
             paciente.setComplPaciente(conex.resultSet.getString("compl_paciente"));
             buscaNomeBairro(conex.resultSet.getInt("id_bairro_paciente"));
             paciente.setNascPaciente(conex.resultSet.getString("nasc_paciente"));
             paciente.setFumante(conex.resultSet.getString("fumante_paciente"));
             paciente.setSexoPaciente(conex.resultSet.getString("sexo_paciente"));
             paciente.setBairroPaciente(nomeBairro);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o  paciente "+ex.getMessage());
        }
        conex.desconecta();
        
        return paciente;
        
    }
    public void buscaNomeBairro(int codBairro){
        conexBairro.conectar();
        try {
            conexBairro.executaSql("select * from bairros where id_bairro="+codBairro);
            conexBairro.resultSet.first();
            nomeBairro = conexBairro.resultSet.getString("nome_bairro");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o bairro"+ex.getMessage());
        }
        conexBairro.desconecta();
    }
    
    public void excluir(BeansPaciente paciente){
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareStatement("delete from pacientes where id_paciente=?");
            pst.setInt(1, paciente.getCodPaciente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "PACIENTE EXCLUIDO COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir os dados!"+ex);
        }
        
        conex.desconecta();
    }
}
