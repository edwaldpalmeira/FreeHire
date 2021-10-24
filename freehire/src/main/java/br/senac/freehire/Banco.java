package br.senac.freehire;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

	
	public static Connection connect() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/freehire","root","88353566");
	}
	
	public static void main(String[] args) throws Exception{
		
		connect();
		
		System.out.println("Banco Conectado");
		}
}
