package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcessoSelecionaArquivo implements Runnable {
	ServerSocket servidor;
	Socket sv;
	ObjectInputStream objeto;
	
	public ProcessoSelecionaArquivo(ServerSocket servidor) {
		this.servidor = servidor;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				sv = servidor.accept();
				System.out.println("Conexão estabelecida no Servidor pela porta 2475 com o ip "+sv.getInetAddress().getHostAddress());
				objeto = new ObjectInputStream(sv.getInputStream());
				//setando o nome na variável
				ProcessoBaixaArquivos.nomeDoArquivo = objeto.readUTF();
				//fechando conexão
				objeto.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
