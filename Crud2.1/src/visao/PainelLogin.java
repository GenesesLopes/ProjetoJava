package visao;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PainelLogin extends JFrame {
	private JTextField login;
	private JLabel labelLogin;
	private JLabel labelSenha;
	private JButton botaoLogar;
	private JPasswordField senha;
	
	public PainelLogin() {
		super();
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Tela de Login");
		this.setBounds(80, 80, 400, 400);
				
		
		labelLogin = new JLabel("Login: ");
		labelLogin.setBounds(64, 87, 70, 15);
		getContentPane().add(labelLogin);
		
		labelSenha = new JLabel("Senha: ");
		labelSenha.setBounds(64, 141, 70, 15);
		getContentPane().add(labelSenha);
		
		getContentPane().add(getBotaoLogar());
		getContentPane().add(getLogin());
		getContentPane().add(getSenha());
		
		
	}

	public JPasswordField getSenha() {
		if(senha == null) {
			senha = new JPasswordField();
			senha.setBounds(152, 139, 130, 19);
			getContentPane().add(senha);
		}
		return senha;
	}


	public JTextField getLogin() {
		if(login == null) {
			login = new JTextField();
			login.setBounds(152, 85, 130, 19);
			login.setColumns(10);
		}
		return login;
	}

	public JButton getBotaoLogar() {
		if(botaoLogar == null) {
			botaoLogar = new JButton("Logar");
			botaoLogar.setBounds(128, 194, 117, 25);
		}
		return botaoLogar;
	}
}
