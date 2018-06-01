package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import socket.Cliente;
import visao.PainelArquivo;
import visao.PainelCadastraUsuario;
import visao.PainelCentral;
import visao.PainelEnviaArquivo;
import visao.PainelLogin;

public class ControladorPainel implements ActionListener {
	
	private PainelCentral painelCentral;
	private PainelCadastraUsuario painelCadastraUsuario;
	private PainelArquivo painelArquivo;
	private PainelLogin painelLogin;
	private PainelEnviaArquivo painelEnviaArquivo;
	private Usuario usuario;
	private ControladorUsuario controladorUsuario;
	private ControladorLogin controladorLogin;
	private ControladorArquivo controladorArquivo;
	private ControladorEnviaArquivo controladorEnviaArquivo;
	private Cliente socketCliente;
	
	
	public ControladorPainel(PainelCentral painelCental, Usuario usuario) {
		this.painelCentral = painelCental;
		this.usuario = usuario;
		addEventos();
	}
	
	//Métodos para adicionar eventos nos botões
	private void addEventos() {
		painelCentral.getBotaoArquivoBaixar().addActionListener(this);
		painelCentral.getBotaoUsuarioCadastrar().addActionListener(this);
		painelCentral.getBotaoMenuSair().addActionListener(this);
		painelCentral.getBotaoArquivoEnviar().addActionListener(this);
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
			socketCliente = new Cliente();
			socketCliente.listarArquivosCliente();
			painelArquivo = new PainelArquivo();

			//listando os arquivos presentes no servidor e adicionando no combox 
			for (int i = 0; i < socketCliente.getArquivos().length; i++) {
				painelArquivo.getArquivos().addItem(socketCliente.getArquivos()[i]);
			}
			controladorArquivo = new ControladorArquivo(painelArquivo);
			painelCentral.setContentPane(painelArquivo);
			painelCentral.setTitle("Baixar Arquivos");
			painelCentral.repaint();
			painelCentral.validate();
			
		}
		
		if(evento.getSource() == painelCentral.getBotaoArquivoEnviar()) {
			painelEnviaArquivo = new PainelEnviaArquivo();
			controladorEnviaArquivo = new ControladorEnviaArquivo(painelEnviaArquivo);
			painelCentral.setContentPane(painelEnviaArquivo);
			painelCentral.setTitle("Enviar Arquivo");
			painelCentral.repaint();
			painelCentral.validate();
		}
		
		if(evento.getSource() == painelCentral.getBotaoMenuSair()) {
			painelLogin = new PainelLogin();
			usuario.setNome(null);
			usuario.setSenha(null);
			controladorLogin = new ControladorLogin(painelLogin);
			painelCentral.dispose();
			painelLogin.repaint();
			painelLogin.validate();
			
		}
		
	}

}
