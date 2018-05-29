package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.DaoUsuario;
import modelo.Usuario;
import visao.PainelCadastraUsuario;
import visao.PainelLogin;

public class ControladorUsuario implements ActionListener {

	PainelCadastraUsuario painelCadastraUsuario;
	Usuario usuario;
	DaoUsuario banco;
	
	public ControladorUsuario(PainelCadastraUsuario painelCadastraUsuario) {
		this.painelCadastraUsuario = painelCadastraUsuario;
		addEventos();
	}
	
	private void addEventos() {
		painelCadastraUsuario.getBotaoCadastrar().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == painelCadastraUsuario.getBotaoCadastrar()) {
			usuario = new Usuario();
			if((!painelCadastraUsuario.getSenha1().getText().equals(painelCadastraUsuario.getSenha2().getText()))) {
				JOptionPane.showMessageDialog(painelCadastraUsuario, "Senhas não correspondem");
				painelCadastraUsuario.getSenha1().setText(null);
				painelCadastraUsuario.getSenha2().setText(null);
				
			}else {
				banco = new DaoUsuario();
				banco.inserirUsuario(painelCadastraUsuario.getTextoNomeUsuario().getText(), painelCadastraUsuario.getSenha1().getText());
				JOptionPane.showMessageDialog(painelCadastraUsuario, "Usuário inserido com Sucesso");
				painelCadastraUsuario.getTextoNomeUsuario().setText(null);
				painelCadastraUsuario.getSenha1().setText(null);
				painelCadastraUsuario.getSenha2().setText(null);
			}
			
			
		}
	}

}
