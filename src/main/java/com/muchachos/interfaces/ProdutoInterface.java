/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muchachos.interfaces;

import com.muchachos.model.Produto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fabio Vieira
 */
public interface ProdutoInterface extends Interface<Produto> {

    public List<Produto> buscarPorNome(String busca) throws SQLException, Exception;
    public List<Produto> obterComPreco() throws SQLException, ClassNotFoundException;
}
