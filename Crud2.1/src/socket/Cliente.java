package socket;

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
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Cliente {
	/*Socket cliente;
	private int requisicao;
	InputStream conexao;
	ObjectOutputStream saida;
	private String [] arquivos = null;
	
	//Construtor
	public Cliente(int requisicao) {
		
		this.requisicao = requisicao;
		
		if(requisicao == 1) {
			listarArquivosCliente();
		}else if(requisicao == 2) {
			baixarArquivosCliente();
		}
		
	}
	

	//metodos gets e sets
	public String[] getArquivos() {
		return arquivos;
	}

	public void setArquivos(String[] arquivos) {
		this.arquivos = arquivos;
	}
	
	public void baixarArquivosCliente() {
		try {
			String teste = null;
			cliente = new Socket("localhost",2474);
			OutputStream out = cliente.getOutputStream();
			InputStream in = cliente.getInputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out);
			InputStreamReader isw = new InputStreamReader(in);
			BufferedWriter writer = new BufferedWriter(osw);
			BufferedReader reader = new BufferedReader(isw);
			writer.write("Enviando esse texto do cliente");
			writer.flush();
			if(reader.ready())
				teste = reader.readLine();
			System.out.println(teste);
			reader.close();
			writer.close();
			cliente.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
				antigo ate aqui
			}
			
			//fechando conexões
			objeto.close();
			conexao.close();
			cliente.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}*/
	
	public static void main(String[] args) {
		try {
			final Socket cliente = new Socket("localhost",2473);
			//lendo mensagens do servidor
			new Thread() {
				@Override
				public void run() {
					try {
						BufferedReader leitor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
						
						
						while(true) {
							String mensagem = leitor.readLine();
							System.out.println("O servidor disse: "+mensagem);
						}
						
					}  
					catch (IOException e) {
						System.out.println("impossivel ler a mensagem do servidor");
						e.printStackTrace();
					}
				}
			}.start();
			//escrevendo para o servidor
			PrintWriter escreveServidor = new PrintWriter(cliente.getOutputStream());
			BufferedReader leitorTerminal = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				String mensagemTerminal = leitorTerminal.readLine();
				escreveServidor.println(mensagemTerminal);
			}
			
		} catch (UnknownHostException e) {
			System.out.println("Endereço inválido");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Servidor Fora do ar");
			e.printStackTrace();
		}
		
	}

}
