/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cardioitaim.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import br.com.cardioitaim.visao.TelaPrincipalAdm;
import br.com.cardioitaim.visao.TelaPrincipalRecep;

/**
 *
 * @author rockv
 */
public class ConexaoBD {
    
    public Statement statement; //responsavel por realizar pesquisas no banco de dados.
    public ResultSet resultSet; //armazenar o resultado da pesquisa (feita pelo o statement).
    private static final String driver = "org.postgresql.Driver"; //identifica o serviço do banco de dados(no caso o padrão do MySql).
    private static final String caminho = "jdbc:postgresql://192.168.1.9/cardioitaim"; //ira idezer o caminho para chegar ao banco de dados.
    private static final String usuario = "postgres"; // usuario do banco de dados
    private static final String senha = "senha432"; // senha do banco de dados.
    public Connection conexao; // responsavel por realizar a conexao com o BD.
    
    public String teste;
    
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(caminho, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            throw  new RuntimeException("ERRO NA CONEXAO: ",ex);
        }
    }
    
    public void conectar(){ //metodo para conectar ao banco de dados.
        
        try {
            //estabelece uma conexao com banco de dados.
            System.setProperty("jdbc.Drivers", driver);
            conexao = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "CONEXAO EFETUADA COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR COM O BD: \n"+ex.getMessage());
            
        }
    }
    
    public void desconecta(){//metodo para desconectar com o banco de daods.
        try {
            conexao.close();
            //JOptionPane.showMessageDialog(null, "DESCONECTADO COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO DESCONECTAR!\n"+ex.getMessage());
        }
    }
    
    public void executaSql(String sql){
        try {
            //ignorar maiuscu/minusc      //percorrer de cima para baixo e baixo para cima.
            statement = conexao.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE, resultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXECUTAR O SQL *** "+ex.getMessage());
        }
    }
    //metodo para logar no sistema fazendo verificação no banco de dados
    public void logar(String usuario, String senha){
        try {
            //buscando no banco de dados pelo usuario
            executaSql("select * from usuarios where usuario_usuario = '" + usuario + "'");
            resultSet.first();
            if (resultSet.getString("senha_usuario").equals(senha)) {//verificando a senha 
                if (resultSet.getString("tipo_usuario").equals("Administrador")) {
                    TelaPrincipalAdm telaPrincipal = new TelaPrincipalAdm(usuario);//instanciando a tela principal
                    telaPrincipal.setVisible(true);//chamando a tela principal
                    
                } else {
                    TelaPrincipalRecep telaPrincipaRE = new TelaPrincipalRecep(usuario);
                    telaPrincipaRE.setVisible(true);
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO OU SENHA INVALIDOS!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUARIO OU SENHA INVALIDOS!");
        }
    }
}
