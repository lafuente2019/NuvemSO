/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muchachos.interfaces;

import com.muchachos.model.Detalhes;
import com.muchachos.model.Relatorio;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Fabio Vieira
 */
public interface RelatorioInterface {
    
    public List<Relatorio> ObterTodosComFiltro(Timestamp dataDe, Timestamp dataPara, String filial, String cliente, String categoria)
            throws ClassNotFoundException, SQLException;
    
    public List<Detalhes> ObterDetalhes(int id, String categoria) throws ClassNotFoundException, SQLException;
    
    public void ObterRank() throws ClassNotFoundException, SQLException;
    
}
