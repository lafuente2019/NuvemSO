/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muchachos.interfaces;

import com.muchachos.model.ItemVenda;
import java.sql.SQLException;

/**
 *
 * @author Fabio Vieira
 */
public interface ItemVendaInterface {
    public void salvar(ItemVenda itemVenda)throws ClassNotFoundException, SQLException;
}
