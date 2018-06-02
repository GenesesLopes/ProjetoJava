package socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	Socket sv;
	ServerSocket servidor;
	ServerSocket servidor2;
	ServerSocket servidor3;
	ServerSocket servidor4;
	public String caminho;
	File pasta = null;
	FileWriter arquivoTeste;
	
	//Construtor
	public Servidor() {
		try {
			if(pasta == null)
				pasta = new File("arquivosServidor");
			if(!pasta.exists()) {
				pasta.mkdir();
				caminho = "arquivosServidor";
				arquivoTeste = new FileWriter("arquivosServidor/teste.txt");
				PrintWriter gravaArq = new PrintWriter(arquivoTeste);
				gravaArq.println("Esse arquivo serve para teste");
				arquivoTeste.close();
			}
				
			//lista arquivos
			servidor = new ServerSocket(2473);
			//baixa arquivos
			servidor2 = new ServerSocket(2474);
			//enviar nome do arquivo
			servidor3 = new ServerSocket(2475);
			//Receber arquivos
			servidor4 = new ServerSocket(2476);
			
			
			System.out.println("Servidor em operação...");
			
			//criando threads e passando socket para as classes de cada processo
			Thread listaArquivos = new Thread(new ProcessoListaArquivos(servidor));
			Thread baixandoArquivos = new Thread(new ProcessoBaixaArquivos(servidor2));
			Thread selecionaArquivos = new Thread(new ProcessoSelecionaArquivo(servidor3));
			Thread recebeArquivos = new Thread(new ProcessoRecebeArquivo(servidor4));
			
			//iniciando as threads
			listaArquivos.start();
			baixandoArquivos.start();
			selecionaArquivos.start();
			recebeArquivos.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Servidor();//iniciando servidores
	}

}