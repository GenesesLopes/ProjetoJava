package socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcessoRecebeArquivo implements Runnable {
	
	Socket sv;
	ServerSocket servidor;
	FileOutputStream arquivo;
	ObjectInputStream objeto;
	public ProcessoRecebeArquivo(ServerSocket servidor) {
		this.servidor = servidor;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				//estabelecendo conexão com o cliente
				sv = servidor.accept();
				System.out.println("Conexão estabelecida no Servidor pela porta 2476 com o ip "+sv.getInetAddress().getHostAddress());
				objeto = new ObjectInputStream(sv.getInputStream());
				//lendo informações do arquivo
				String nome = objeto.readUTF();
				arquivo = new FileOutputStream("arquivosServidor/"+nome);
				int tamanho = (int)objeto.readLong();
				//gravando aqruivo no servidor
				byte[] buffer = new byte[tamanho];
				while(true) {
					int lido = objeto.read(buffer, 0, tamanho);
					if(lido == -1)
						break;
					arquivo.write(buffer, 0, lido);
				}
				arquivo.flush();
				System.out.println("Recebeu o arquivo "+nome);
				//fechando conexão
				objeto.close();
				arquivo.close();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
