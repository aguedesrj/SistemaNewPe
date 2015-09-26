package br.com.guedes.newpe.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.guedes.newpe.facade.UsuarioFacade;

@Controller
@Scope("request")
public class UsuarioAction extends BasicAction {

	private static final long serialVersionUID = 4637443856156725514L;
	private String mensagemUsuario;
	
	@Autowired
	private UsuarioFacade usuarioFacade;

	public String exibirTelaLogin() {
		return SUCCESS;
	}
	
	public String efetuarLogin() {
		return SUCCESS;
	}	
	
	public String exibirTelaHome() {
		return SUCCESS;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}
}
