package DAO;
import java.sql.*;

import javax.management.RuntimeErrorException;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class Conexao{
	private static final String DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/login";
	private static final String USER = "root";
	private static final String PASS = "";
	
		
	public static Connection getConexao() throws SQLException {
		try {
			Class.forName(DRIVE);
			return (Connection) DriverManager.getConnection(URL, USER, PASS);
			
		}catch(ClassNotFoundException | SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro na conexão "+ex.getMessage());
			//Fecha Conexão
			getConexao().close();
			return null;
		}
				
	}
	
	
	
}
