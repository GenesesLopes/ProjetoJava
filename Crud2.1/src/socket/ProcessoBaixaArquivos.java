package socket;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProcessoBaixaArquivos implements Runnable {

	Socket sv;
	ServerSocket servidor;
	File arquivo;
	ObjectOutputStream out;
	FileInputStream file;
	public static String nomeDoArquivo = null;
	
	//Construtor
	public ProcessoBaixaArquivos(ServerSocket servidor) {
		this.servidor = servidor;
	}
	
	//execução da thread
	@Override
	public void run() {
		try {
			while(true) {
				sv = servidor.accept();//esperando conexão
				System.out.println("Conexão estabelecida no Servidor pela porta 2474 com o ip "+sv.getInetAddress().getHostAddress());
				//preparando arquivo para ser enviado
					arquivo = new File("arquivosServidor/"+nomeDoArquivo);
					out = new ObjectOutputStream(sv.getOutputStream());
					out.writeUTF(arquivo.getName());
					out.writeLong(arquivo.length());
					file = new FileInputStream(arquivo.getAbsolutePath());
					//Enviando arquivo
					byte[] buffe = new byte[(int)arquivo.length()];
					int lido;
					while(true) {
						lido = file.read(buffe, 0, (int)arquivo.length());
						if(lido == -1)
							break;
						out.write(buffe, 0, lido);
					}
					out.flush();
					//fechando Conexão
					file.close();
					out.close();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
