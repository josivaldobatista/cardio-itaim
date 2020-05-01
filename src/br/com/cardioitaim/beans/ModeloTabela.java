/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cardioitaim.beans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rockv
 */
public class ModeloTabela extends AbstractTableModel {
    
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    //Construtor 
    public ModeloTabela(ArrayList lin, String[]col){
        setLinhas(lin);
        setColunas(col);
    }
    //este metodo vai contar o numero de colunas
    public int getColumnCount(){   
        return colunas.length;
    }
    //conta quantas linhas teremos no Array.
    public int  getRowCount(){
        return linhas.size();
    }
    //pegar o valor do nome da coluna.(pegar o nome da coluna)
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    //metodo para montar a tabela... add as linhas na tabela.
    public Object getValueAt(int numLin, int numCol){
        Object [] linha = (Object [])getLinhas().get(numLin);
        return linha[numCol];
    }
    
    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

}
