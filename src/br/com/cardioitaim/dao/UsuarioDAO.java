/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cardioitaim.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import br.com.cardioitaim.beans.BeansUsuario;
import br.com.cardioitaim.conexao.ConexaoBD;

/**
 *
 * @author Valdo Batista
 */
public class UsuarioDAO {
    ConexaoBD conex = new ConexaoBD();//instanciando classe ConexaoBD.
    BeansUsuario modUsuario = new BeansUsuario();//instanciando classe BeansMedico.

    public void salvarUsuario(BeansUsuario mod){
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareStatement
            ("insert into usuarios (nome_usuario, usuario_usuario, senha_usuario, tipo_usuario) values(?, ?, ?, ?)");//Informando onde sera inserido os dados no BD.
            
            //inserindo os dados no banco de dados
            pst.setString(1, mod.getNome()); //posicao 1 nome
            pst.setString(2, mod.getUsuario());//posicao 2 crm
            pst.setString(3, mod.getSenha());//posicao 3 area.
            pst.setString(4, mod.getTipo());
            
            pst.execute();//aqui vai executar o que foi inserido nas linhas acima.
            JOptionPane.showMessageDialog(null, "DADOS INSERIDOS COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR OS DADOS!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    public BeansUsuario buscarUsuario(BeansUsuario mod){
        conex.conectar();
        
        try {
            conex.executaSql("select * from usuarios where nome_usuario ~*'"+mod.getPesquisa()+"'");
            conex.resultSet.first();
            mod.setCodigo(conex.resultSet.getInt("id_usuario"));
            mod.setNome(conex.resultSet.getString("nome_usuario"));
            mod.setUsuario(conex.resultSet.getString("usuario_usuario"));
            mod.setSenha(conex.resultSet.getString("senha_usuario"));
            mod.setTipo(conex.resultSet.getString("tipo_usuario"));
//            JOptionPane.showMessageDialog(null, "Busca ok");//teste de verificacao se a busca esta correta
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUÁRIO NAO CADASTRADO!");
        }
        
        conex.desconecta();
        return mod;
        
    }
    public void Editar(BeansUsuario mod){
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareCall("update usuarios set nome_usuario = ?, usuario_usuario = ?, senha_usuario = ?, tipo_usuario = ? where id_usuario = ?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getUsuario());
            pst.setString(3, mod.getSenha());
            pst.setString(4, mod.getTipo());
            pst.setInt(5, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "DADOS ALTERADOS COM SUCESSO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null , "ERRO AO FAZER ALTERAÇÃO"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    public void excluir(BeansUsuario mod){
        conex.conectar();
        try {
            PreparedStatement pst = conex.conexao.prepareStatement("delete from usuarios where id_usuario = ?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "USUARIO EXCLUIDOS COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR O USUARIO!"+ex.getMessage());
        }

        conex.desconecta();
    }
}
