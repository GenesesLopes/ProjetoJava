package socket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcessoListaArquivos implements Runnable {
	Socket sv;
	ServerSocket servidor;
	String files = null;
	ObjectOutputStream objeto;
	File caminho;
		
	
	public ProcessoListaArquivos(ServerSocket servidor) {
		this.servidor = servidor;
		
	}
	
	@Override
	public void run() {
		try {			
			while(true) {
				sv = servidor.accept();
				System.out.println("Conexão estabelecida no Servidor pela porta 2473 com o ip "+sv.getInetAddress().getHostAddress());
				objeto = new ObjectOutputStream(sv.getOutputStream());
				
				//Listando arquivos na pasta
				caminho = new File("arquivosServidor");
				File [] lista = caminho.listFiles();
				
					//concatenando lista para passar como string
					for (int i = 0; i < lista.length; i++) {
						if(lista[i].isFile()) {
							if(files == null) {
								files = lista[i].getName()+",";
							}else {
								files += lista[i].getName()+",";
							}
						}
					}
				
				
				
				
				//passando lista de arquivos para o cliente
				objeto.writeUTF(files);
				objeto.flush();
				files = null;
				//fechando conexão
				objeto.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
