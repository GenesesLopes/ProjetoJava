package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visao.PainelArquivo;

public class ControladorArquivo implements ActionListener {
	
	PainelArquivo painelArquivo;
	
	
	public ControladorArquivo(PainelArquivo painelArquivo) {
		this.painelArquivo = painelArquivo;
		addEventos();
	}
	
	public void addEventos() {
		painelArquivo.getBotaoBaixar().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource() == painelArquivo.getBotaoBaixar()) {
			System.out.println("entrou");
		}
		
	}

}
