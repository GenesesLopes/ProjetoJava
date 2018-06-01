package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import socket.Cliente;
import visao.PainelArquivo;
import visao.PainelCentral;

public class ControladorArquivo implements ActionListener {
	
	PainelArquivo painelArquivo;
	PainelCentral painelCentral;
	String nome;
	Cliente cliente;
	
	public ControladorArquivo(PainelArquivo painelArquivo) {
		this.painelArquivo = painelArquivo;
		if(cliente == null)
			cliente = new Cliente();
		addEventos();
	}
	
	public void addEventos() {
		painelArquivo.getBotaoBaixar().addActionListener(this);
		painelArquivo.getArquivos().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		//ação no botão Baixar
		if(evento.getSource() == painelArquivo.getBotaoBaixar()) {
			cliente.baixarArquivosCliente(); //Iniciando download do arquivo 
		}
		//ação no combox
		if(evento.getSource() == painelArquivo.getArquivos()) {
			nome = painelArquivo.getArquivos().getSelectedItem().toString();
			cliente.selecionaArquivo(nome);//enviar via socket o nome do aquivo que sera baixado
		
		}
		
		
	}

}
