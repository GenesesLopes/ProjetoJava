package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Usuario;
import socket.Cliente;
import visao.PainelArquivo;
import visao.PainelCadastraUsuario;
import visao.PainelCentral;
import visao.PainelLogin;

public class ControladorPainel implements ActionListener {
	
	private PainelCentral painelCentral;
	private PainelCadastraUsuario painelCadastraUsuario;
	private PainelArquivo painelArquivo;
	private PainelLogin painelLogin;
	private Usuario usuario;
	private ControladorUsuario controladorUsuario;
	private ControladorLogin controladorLogin;
	private ControladorArquivo controladorArquivo;
	private Cliente socketCliente;
	
	
	public ControladorPainel(PainelCentral painelCental) {
		this.painelCentral = painelCental;
		addEventos();
	}
	
	//Métodos para adicionar eventos nos botões
	private void addEventos() {
		painelCentral.getBotaoArquivoBaixar().addActionListener(this);
		painelCentral.getBotaoUsuarioCadastrar().addActionListener(this);
		painelCentral.getBotaoMenuSair().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == painelCentral.getBotaoUsuarioCadastrar()) {
			painelCadastraUsuario = new PainelCadastraUsuario();
			controladorUsuario = new ControladorUsuario(painelCadastraUsuario);
			painelCentral.setContentPane(painelCadastraUsuario);
			painelCentral.setTitle("Cadastrar Usuário");
			painelCentral.repaint();
			painelCentral.validate();
		}
		
		if(evento.getSource() == painelCentral.getBotaoArquivoBaixar()) {
			painelArquivo = new PainelArquivo();
			socketCliente = new Cliente(1);
			controladorArquivo = new ControladorArquivo(painelArquivo);
			painelCentral.setContentPane(painelArquivo);
			
			for (int i = 0; i < socketCliente.getArquivos().length; i++) {
				painelArquivo.getArquivos().addItem(socketCliente.getArquivos()[i]);
				
			}
			painelCentral.setTitle("Baixar Arquivos");
			painelCentral.repaint();
			painelCentral.validate();
		}
		
		if(evento.getSource() == painelCentral.getBotaoMenuSair()) {
			painelLogin = new PainelLogin();
			usuario = new Usuario();
			usuario.setNome(null);
			usuario.setSenha(null);
			controladorLogin = new ControladorLogin(painelLogin);
			painelCentral.dispose();
			painelLogin.repaint();
			painelLogin.validate();
			
		}
		
	}

}
