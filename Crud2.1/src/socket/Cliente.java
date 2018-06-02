package socket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;


public class Cliente {
	Socket cliente;
	private int requisicao;
	InputStream conexao;
	ObjectOutputStream objeto;
	FileInputStream file;
	private String [] arquivos = null;
	private String nomeDoArquivo;
	private File nomePastas;
	private String caminho = null;
	
	
	public Cliente() {
		if(nomePastas==null)
			nomePastas = new File("baixados");
		
		if(!nomePastas.exists()) 
			nomePastas.mkdir();
					
	}
	
	//metodos gets e sets
	public String[] getArquivos() {
		return arquivos;
	}

	public void setArquivos(String[] arquivos) {
		this.arquivos = arquivos;
	}
	
	//Método para enviar arquivos ao servidor
	public void enviaArquivo(File arquivoCliente) {
		try {
			//Estabelecendo conexão com o servidor
			cliente = new Socket("localhost",2476);
			objeto = new ObjectOutputStream(cliente.getOutputStream());
			//enviando informações do aqruivo
			objeto.writeUTF(arquivoCliente.getName());
			objeto.writeLong(arquivoCliente.length());
			//enviando o arquivo
			file = new FileInputStream(arquivoCliente.getAbsoluteFile());
			byte[] buffer = new byte[(int)arquivoCliente.length()];
			int lido;
			while(true) {
				lido = file.read(buffer, 0, (int)arquivoCliente.length());
				if(lido == -1)
					break;
				objeto.write(buffer, 0, lido);
			}
			objeto.flush();
			//fechando conexão
			objeto.close();
			file.close();
			cliente.close();
			JOptionPane.showMessageDialog(null, "Arquivo Enviado com sucesso...");
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Problema ao enviar arquivo para o servidor");
			e.printStackTrace();
		}
	}
	
	//Método para selecionar arquivo
	public void selecionaArquivo(String nomeDoArquivo) {
		try {
			//estabelecendo conexão com o servidor
			cliente = new Socket("localhost",2475);
			ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
			//enviando nome do arquivo
			out.writeUTF(nomeDoArquivo);
			out.flush();
			//fechando conexão
			out.close();
			cliente.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Metodo para baixar os arquivos do servidor
	public void baixarArquivosCliente() {
		try {
			//estabelecendo conexão com o servidor
			cliente = new Socket("localhost",2474);
			ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
			//recuperando nome do arquivo 
			FileOutputStream file = new FileOutputStream("baixados/"+in.readUTF());
			//recuperando tamanho do arquivo
			int tamanho = (int)in.readLong();
			
			//recebendo o arquivo
			byte[] buffe = new byte[tamanho];
			while(true) {
				int lido = in.read(buffe,0,tamanho);
				if(lido == -1)
					break;
				file.write(buffe, 0, lido);
			}
			//fechando conexão
			in.close();
			file.close();
			cliente.close();
			JOptionPane.showMessageDialog(null, "Arquivo baixado com sucesso...");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Problema ao baixar o arquivo");
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
						
			//fechando conexões
			objeto.close();
			conexao.close();
			cliente.close();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Problema na comunicação com o servidor");
			e.printStackTrace();
		}
	}

}