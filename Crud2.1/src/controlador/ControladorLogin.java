package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.login.LoginContext;
import javax.swing.JOptionPane;

import DAO.DaoUsuario;
import modelo.Usuario;
import visao.PainelArquivo;
import visao.PainelLogin;
import visao.PainelCadastraUsuario;
import visao.PainelCentral;

public class ControladorLogin implements ActionListener {

	private PainelLogin painelLogar;
	private PainelCentral painelCentral;
	private ControladorUsuario controladorUsuario;
	private ControladorPainel controladorPainel;
	private DaoUsuario usuario;
	
	
	
	public ControladorLogin(PainelLogin painelLogin){
		if(painelLogin == null) {
			painelLogar = new PainelLogin();
		}else {
			this.painelLogar = painelLogin;
		}
		usuario = new DaoUsuario();
		painelLogar.repaint();
		painelLogar.validate();
		addEventos();
	}
	private void addEventos() {
		painelLogar.getBotaoLogar().addActionListener(this);
	}
	
	public static void main(String[] args) {
		new ControladorLogin(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == painelLogar.getBotaoLogar()) {
			
			//verificando usuario e senha no banco
			if(usuario.comparaUsuario(painelLogar.getLogin().getText(), painelLogar.getSenha().getText())) {
				//Passando dados para Model
				Usuario usuarioDados = new Usuario();
				usuarioDados.setNome(painelLogar.getLogin().getText());
				usuarioDados.setSenha(painelLogar.getSenha().getText());
				//renderizando para painel Central
				painelCentral = new PainelCentral();
				controladorPainel = new ControladorPainel(painelCentral,usuarioDados);
				/* Não funciona desse jeito
				painelLogar.setContentPane(painelCentral);
				painelLogar.repaint();
				painelLogar.validate();*/
				painelLogar.dispose();
				painelCentral.repaint();
				painelCentral.validate();
				
			}else {
				JOptionPane.showMessageDialog(null, "credenciais não correspondem..");
				painelLogar.getLogin().setText("");
				painelLogar.getSenha().setText("");
			}
			
		}
		
	}

}
