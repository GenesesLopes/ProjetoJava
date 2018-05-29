package modelo;
import com.mysql.*;

import DAO.Conexao;
import controlador.ControladorLogin;

import java.sql.*;

import javax.swing.JOptionPane;

public class Usuario {
	private String nome;
	private String senha;
	
	//Metodos
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
			
	
}
