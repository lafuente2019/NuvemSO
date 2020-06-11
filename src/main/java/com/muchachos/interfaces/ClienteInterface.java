/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muchachos.interfaces;

import com.muchachos.model.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fabio Vieira
 */
public interface ClienteInterface extends Interface<Cliente> {
    
    public List<Cliente> procurarPorNome(String nome)throws ClassNotFoundException, SQLException;
    public Cliente obterPorCpf(String cpf) throws ClassNotFoundException, SQLException;
}
