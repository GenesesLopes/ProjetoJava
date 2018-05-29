package visao;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PainelCadastraUsuario extends JPanel {
	
	private JLabel labelNome;
	private JLabel labelSenha;
	private JLabel labelRepetirSenha;
	private JTextField textoNomeUsuario;
	private JButton botaoCadastrar;
	private JPasswordField senha1;
	private JPasswordField senha2;
	
	
	public JButton getBotaoCadastrar() {
		if(botaoCadastrar == null){
			botaoCadastrar = new JButton("Cadastrar");
			botaoCadastrar.setBounds(160, 186, 117, 25);
		}
		return botaoCadastrar;
	}

	public JTextField getTextoNomeUsuario() {
		if(textoNomeUsuario == null) {
			textoNomeUsuario = new JTextField();
			textoNomeUsuario.setBounds(191, 74, 114, 19);
			textoNomeUsuario.setColumns(10);
		}
		return textoNomeUsuario;
	}
	

	public JPasswordField getSenha1() {
		if(senha1 == null) {
			senha1 = new JPasswordField();
			senha1.setToolTipText("");
			senha1.setBounds(191, 103, 114, 19);
		}
		return senha1;
	}


	public JPasswordField getSenha2() {
		if(senha2 == null) {
			senha2 = new JPasswordField();
			senha2.setToolTipText("");
			senha2.setBounds(191, 135, 114, 19);
		}
		return senha2;
	}


	public PainelCadastraUsuario() {
		
		setLayout(null);
		
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(132, 76, 70, 15);
		add(labelNome);
		
		labelSenha = new JLabel("Senha: ");
		labelSenha.setBounds(131, 103, 54, 15);
		add(labelSenha);
		
		labelRepetirSenha = new JLabel("Repetir Senha:");
		labelRepetirSenha.setBounds(79, 135, 106, 15);
		add(labelRepetirSenha);
		
		
		this.add(getTextoNomeUsuario());	
		this.add(getBotaoCadastrar());
		this.add(getSenha1());
		this.add(getSenha2());
		
	}
}
