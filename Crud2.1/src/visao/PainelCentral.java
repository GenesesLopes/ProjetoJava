package visao;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PainelCentral extends JFrame {
	private JMenuBar menuBar;
	private JMenu menuUsuario;
	private JMenu menuArquivo;
	private JMenuItem botaoUsuarioCadastrar;
	private JMenuItem botaoArquivoBaixar;
	private JMenu menuOpcoes;
	private JMenuItem botaoMenuSair;
	
	//metodos 
	public JMenuItem getBotaoUsuarioCadastrar() {
		if(botaoUsuarioCadastrar == null) {
			botaoUsuarioCadastrar = new JMenuItem("Cadastrar");
		}
		return botaoUsuarioCadastrar;
	}

	public JMenuItem getBotaoArquivoBaixar() {
		if(botaoArquivoBaixar == null) {
			botaoArquivoBaixar = new JMenuItem("Baixar");
		}
		return botaoArquivoBaixar;
	}
	
	
	public JMenuItem getBotaoMenuSair() {
		if(botaoMenuSair == null) {
			botaoMenuSair = new JMenuItem("Sair");
		}
		return botaoMenuSair;
	}

	public PainelCentral() {
		setTitle("Painel");
		getContentPane().setLayout(null);
		this.setBounds(80, 80, 400, 400);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuUsuario = new JMenu("Usuário");
		menuBar.add(menuUsuario);
		
		menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		menuOpcoes = new JMenu("Opções");
		menuBar.add(menuOpcoes);
		
		menuUsuario.add(getBotaoUsuarioCadastrar());
		menuArquivo.add(getBotaoArquivoBaixar());
		menuOpcoes.add(getBotaoMenuSair());
	}
}
