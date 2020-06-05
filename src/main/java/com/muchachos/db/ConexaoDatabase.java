package com.muchachos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * 30/04/2020 22:01
 * @author Ramses
 */
public class ConexaoDatabase {

   
   public static Connection getConexao() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(
		"jdbc:mysql://34.95.243.87:3306/muchacho","root","admin");
	}
}
