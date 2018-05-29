package socket;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	Socket sv;
	ServerSocket servidor;
	String files = null;
	ObjectInputStream entrada;

	//construtor
	public Servidor() {
		listaArquivosServidor();
	}
	
	
	
	//método para listar os arquivos
	public void listaArquivosServidor() {
		
		try {
			
			//Estabelecendo conexão do socket
			servidor = new ServerSocket(2473);
			sv = servidor.accept();
			System.out.println("Conexão estabelecida no Servidor pela porta 2473...");
			ObjectOutputStream objeto = new ObjectOutputStream(sv.getOutputStream());
			
			//Listando arquivos na pasta
			File caminho = new File("arquivosServidor");
			File [] lista = caminho.listFiles();
			
			//concatenando lista para passar como string
			for (int i = 0; i < lista.length; i++) {
				if(files == null)
					files = lista[i].getName()+",";
				else
					files += lista[i].getName()+",";
			}
			
			//passando lista de arquivos para o cliente
			objeto.writeUTF(files);
			objeto.flush();
			
			//fechando conexão
			objeto.close();
			sv.close();
			servidor.close();
			System.out.println("Conexão finalizada na porta 2437");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Servidor();
	}

}
