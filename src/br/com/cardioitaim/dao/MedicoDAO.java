/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cardioitaim.dao;

import br.com.cardioitaim.conexao.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.cardioitaim.beans.BeansMedico;

/**
 *
 * @author rockv
 */
public class MedicoDAO {
    
    ConexaoBD conex = new ConexaoBD();//instanciando classe ConexaoBD.
    BeansMedico modMedico = new BeansMedico();//instanciando classe BeansMedico.
    
    public void salvarMedico(BeansMedico mod){
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareStatement
            ("insert into medicos (nome_medico, crm_medico, area_medico) values(?, ?, ?)");//Informando onde sera inserido os dados no BD.
            
            //inserindo os dados no banco de dados
            pst.setString(1, mod.getNome()); //posicao 1 nome
            pst.setInt(2, mod.getCrm());//posicao 2 crm
            pst.setString(3, mod.getArea());//posicao 3 area.
            
            pst.execute();//aqui vai executar o que foi inserido nas linhas acima.
            JOptionPane.showMessageDialog(null, "DADOS INSERIDOS COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DADOS!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    public void Editar(BeansMedico mod){
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareCall("update medicos set nome_medico = ?, crm_medico = ?, area_medico = ? where id_medico = ?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getCrm());
            pst.setString(3, mod.getArea());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "DADOS ALTERADOS COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , "ERRO AO FAZER ALTERAÇÃO"+ex.getMessage());
        }
        
        
        
        conex.desconecta();
    }
    //metodo para exclusao de registro
    public void excluir(BeansMedico mod){
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareStatement("delete from medicos where id_medico = ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "DADOS EXCLUIDOS COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR OS DADOS!"+ex.getMessage());
        }
        
        
        conex.desconecta();
    }
    
    public BeansMedico buscaMedico(BeansMedico mod){
        conex.conectar();
        conex.executaSql("select *from medicos where nome_medico ~*'"+mod.getPesquisa()+"'");
        try {
            conex.resultSet.first();
            mod.setCodigo(conex.resultSet.getInt("id_medico"));
            mod.setNome(conex.resultSet.getString("nome_medico"));
            mod.setCrm(conex.resultSet.getInt("crm_medico"));
            mod.setArea(conex.resultSet.getString("area_medico"));
//            JOptionPane.showMessageDialog(null, "Busca ok");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NAO CADASTRADO!");
        }
        
        conex.desconecta();
        return mod;
        
    }
}
