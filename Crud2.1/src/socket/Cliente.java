package socket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;


public class Cliente {
	Socket cliente;
	private int requisicao;
	InputStream conexao;
	ObjectOutputStream saida;
	private String [] arquivos = null;
	
	//Construtor
	public Cliente(int requisicao) {
		
		this.requisicao = requisicao;
		
		if(requisicao == 1) {
			listarArquivosCliente();
		}			
		
	}
	
	//metodos gets e sets
	public String[] getArquivos() {
		return arquivos;
	}

	public void setArquivos(String[] arquivos) {
		this.arquivos = arquivos;
	}
	
	//método para listar arquivos para o cliente
	public void listarArquivosCliente() {
		
		try {
			//conexão com o servidor
			cliente = new Socket("localhost", 2473);
			conexao = cliente.getInputStream();
			ObjectInputStream objeto = new ObjectInputStream(conexao);
			
			//Recebendo a lista de arquivos do servidor
			setArquivos(objeto.readUTF().split(","));
			/*for (int i = 0; i < getArquivos().length; i++) {
				System.out.println(getArquivos()[i]);
			}*/
			
			//fechando conexões
			objeto.close();
			conexao.close();
			cliente.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/*
	public static void main(String[] args) {
		new Cliente(1);
	}*/

}
