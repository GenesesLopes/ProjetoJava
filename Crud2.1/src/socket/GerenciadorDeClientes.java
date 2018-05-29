package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import modelo.Usuario;

public class GerenciadorDeClientes extends Thread {
	private Socket cliente;
	private String nome;
	
	public GerenciadorDeClientes(Socket ciente) {
		this.cliente = cliente;
		this.start();
	}
	
	@Override
	public void run() {
		try {
			InputStreamReader in = new InputStreamReader(cliente.getInputStream());
			BufferedReader usuario = new BufferedReader(in);
			//BufferedReader usuario = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			PrintWriter saida = new PrintWriter(cliente.getOutputStream(),true);
			saida.println("mensagem do Gerenciador de clientes");
			String mensagem = usuario.readLine();
			this.nome = mensagem;
			
			while(true) {
				mensagem = usuario.readLine();
				saida.println("mensagem de volta "+mensagem);
			}
			
		} catch (IOException e) {
			System.out.println("Conexão fechada lado cliente");
			e.printStackTrace();
		}
	}
}
