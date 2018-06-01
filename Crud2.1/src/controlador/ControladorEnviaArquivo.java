package controlador;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import socket.Cliente;
import visao.PainelEnviaArquivo;

public class ControladorEnviaArquivo implements ActionListener {
	JFileChooser file;
	private int resposta;
	File arquivo;
	File dadosArquivo;
	PainelEnviaArquivo painelEnviaArquivo;
	Cliente cliente;
	
	public ControladorEnviaArquivo(PainelEnviaArquivo painelEnviaArquivo) {
		this.painelEnviaArquivo = painelEnviaArquivo;
		if(cliente == null)
			cliente = new Cliente();
		addEventos();
	}

	private void addEventos() {
		painelEnviaArquivo.getBotaoBuscar().addActionListener(this);
		painelEnviaArquivo.getBotaoEnviar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
	
		if(evento.getSource() == painelEnviaArquivo.getBotaoBuscar()) {
			dadosArquivo = selecionaArquivo();
			if(dadosArquivo != null) {
				painelEnviaArquivo.getNomeArquivo().setText(dadosArquivo.getName());
				painelEnviaArquivo.getTamanhoArquivo().setText(String.valueOf(dadosArquivo.length()));
				painelEnviaArquivo.getCaminhoArquivo().setText(dadosArquivo.getAbsolutePath());
				painelEnviaArquivo.getBotaoEnviar().setEnabled(true);
			}
			
		}
		if(evento.getSource() == painelEnviaArquivo.getBotaoEnviar()) {
			cliente.enviaArquivo(dadosArquivo);
		}
		
	}
	//selecionar arquivo
	public File selecionaArquivo() {
		file = new JFileChooser();
		resposta = file.showOpenDialog(new JDialog());
		arquivo = new File("");
		
		if(resposta == JFileChooser.APPROVE_OPTION) {
			arquivo = file.getSelectedFile();
			return arquivo;
		}else if(resposta == JFileChooser.CANCEL_OPTION) {
			return null;
		}
		return null;
	}

}
