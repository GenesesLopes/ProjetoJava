package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class DaoUsuario {
	
	private String consulta;
	private PreparedStatement prepare;
	private ResultSet resultado;
	private boolean linhas = false;

	//metodo para inserir usuario
	public void inserirUsuario(String nome, String senha) {
		//Consulta sql
		consulta = "INSERT INTO usuario VALUES ('"+nome+"',"+"md5('"+senha+
				"'))";
		try {
			//preparando consulta e encaminhar requisições para o servidor 
			prepare =  Conexao.getConexao().prepareStatement(consulta);
			//Executando a consulta no banco
			prepare.executeUpdate();
			prepare.close();
			JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso...");
			Conexao.getConexao().close();
		}catch(MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "Usuaŕio já existente");
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "problema na inserção");
			e.printStackTrace();
		}
	}
	
	public boolean comparaUsuario(String nome, String senha) {
		try {
			
			consulta = "SELECT * FROM usuario WHERE nome = '"+nome+"' AND senha = md5('"+
			senha+"')";
			//preparando consulta e encaminhar requisições para o servidor 
			prepare = Conexao.getConexao().prepareStatement(consulta);
			//Executando a consulta no banco
			 resultado = prepare.executeQuery();
			 boolean linhas = resultado.next();
			 return linhas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Problema na comparação de usuário"+e.getMessage());
			e.printStackTrace();
			return linhas;
		}
	}


}
