package visao;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelEnviaArquivo extends JPanel {
	private JPanel painel;
	private JLabel labelNome;
	private JLabel labelTamanho;
	private JLabel labelCaminho;
	private JButton botaoEnviar;
	private JButton botaoBuscar;
	private JTextField nomeArquivo;
	private JTextField tamanhoArquivo;
	private JTextField caminhoArquivo;
	
	public PainelEnviaArquivo() {
		
		this.setLayout(null);
		
		painel = new JPanel();
		this.add(painel);
		
		labelNome = new JLabel("Nome: ");
		labelNome.setBounds(32, 53, 70, 15);
		this.add(labelNome);
		
		labelTamanho = new JLabel("Tamanho:");
		labelTamanho.setBounds(32, 96, 70, 15);
		this.add(labelTamanho);
		
		labelCaminho = new JLabel("Caminho:");
		labelCaminho.setBounds(32, 137, 70, 15);
		this.add(labelCaminho);
		
		this.add(getBotaoEnviar());
		this.setVisible(true);
		this.setBounds(80, 80, 400, 400);
		
		
		this.add(getNomeArquivo());
		this.add(getBotaoBuscar());
		this.add(getTamanhoArquivo());
		this.add(getCaminhoArquivo());
		
	}

	
	
	public JButton getBotaoBuscar() {
		if(botaoBuscar == null) {
			botaoBuscar = new JButton("Buscar");
			botaoBuscar.setBounds(50, 208, 92, 25);
		}
		return botaoBuscar;
	}



	public JTextField getNomeArquivo() {
		if(nomeArquivo == null) {
			nomeArquivo = new JTextField();
			nomeArquivo.setEditable(false);
			nomeArquivo.setBounds(103, 51, 200, 19);
			nomeArquivo.setColumns(10);
		}
		return nomeArquivo;
	}



	public JTextField getTamanhoArquivo() {
		if(tamanhoArquivo == null) {
			tamanhoArquivo = new JTextField();
			tamanhoArquivo.setEditable(false);
			tamanhoArquivo.setBounds(103, 94, 114, 19);
			tamanhoArquivo.setColumns(10);
		}
		return tamanhoArquivo;
	}



	public JTextField getCaminhoArquivo() {
		if(caminhoArquivo == null) {
			caminhoArquivo = new JTextField();
			caminhoArquivo.setEditable(false);
			caminhoArquivo.setColumns(10);
			caminhoArquivo.setBounds(103, 135, 200, 19);
		}
		return caminhoArquivo;
	}



	public JButton getBotaoEnviar() {
		if(botaoEnviar == null) {
			botaoEnviar = new JButton("Enviar");
			botaoEnviar.setEnabled(false);
			botaoEnviar.setBounds(154, 208, 92, 25);
		}
		return botaoEnviar;
	}
}
