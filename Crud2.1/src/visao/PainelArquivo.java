package visao;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class PainelArquivo extends JPanel {
	JPanel painel;
	JLabel labelArquivo;
	JButton botaoBaixar;
	JComboBox arquivos;
	public PainelArquivo() {
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		painel = new JPanel();
		this.add(painel);
		
		labelArquivo = new JLabel("Arquivo");
		labelArquivo.setBounds(32, 53, 70, 15);
		this.add(labelArquivo);
		
		this.add(getBotaoBaixar());
		this.add(getArquivos());
		this.setVisible(true);
		this.setBounds(80, 80, 400, 400);
		
	}

	public JLabel getLabelArquivo() {
		return labelArquivo;
	}

	public JButton getBotaoBaixar() {
		if(botaoBaixar == null) {
			botaoBaixar = new JButton("Baixar");
			botaoBaixar.setBounds(154, 110, 92, 25);
		}
		return botaoBaixar;
	}

	public JComboBox getArquivos() {
		if(arquivos == null) {
			arquivos = new JComboBox();
			arquivos.setBounds(103, 48, 210, 24);
		}
		return arquivos;
	}
	
}
