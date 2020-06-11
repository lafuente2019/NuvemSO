/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muchachos.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fabio Vieira
 */
public interface Interface<T> {
    
    public void salvar(T object) throws ClassNotFoundException, SQLException;
    public List<T> obterTodos()throws ClassNotFoundException, SQLException;
    public T obterPorID(int id)throws ClassNotFoundException, SQLException;
    public void atualizar(T object)throws ClassNotFoundException, SQLException;
    public void excluir(int id)throws ClassNotFoundException, SQLException;
    
}
