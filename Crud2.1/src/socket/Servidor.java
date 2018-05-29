package socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	/*Socket sv;
	ServerSocket servidor;
	String files = null;
	ObjectInputStream entrada;
	boolean flag = true;

	//construtor
	public Servidor() {
		listaArquivosServidor();
		baixaArquivosServidor();
	}
	
	public void baixaArquivosServidor() {
		try {
			servidor = new ServerSocket(2474);
			sv = servidor.accept();
			System.out.println("Conexão estabelecida no Servidor pela porta 2474...");
			InputStream in = sv.getInputStream();
			OutputStream out = sv.getOutputStream();
			InputStreamReader isr = new InputStreamReader(in);
			OutputStreamWriter iwr = new OutputStreamWriter(out);
			BufferedReader reader = new BufferedReader(isr);
			BufferedWriter write = new BufferedWriter(iwr);
			while(reader.ready()) {
				String resposta = reader.readLine();
				System.out.println(resposta);
				write.write("Mensagem do servidor");
			}
			
			reader.close();
			write.close();
			sv.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
	}*/
	
	
	
	public static void main(String[] args) {
		ServerSocket servidor = null;
		try {
			System.out.println("Iniciando o servidor");
			servidor =  new ServerSocket(2473);
			System.out.println("Servidor iniciado");
			while(true) {
				Socket cliente = servidor.accept();
				new GerenciadorDeClientes(cliente);
			}
		} catch (IOException e) {
			try {
				if(servidor != null)
					 servidor.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
