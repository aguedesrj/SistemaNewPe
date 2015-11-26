package br.com.guedes.newpe.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.guedes.newpe.facade.PacienteFacade;
import br.com.guedes.newpe.facade.UsuarioFacade;
import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.Constantes;
import br.com.guedes.newpe.vo.UsuarioVO;

@Controller
@Scope("request")
public class UsuarioAction extends BasicAction {

	private static final long serialVersionUID = 4637443856156725514L;
	private String mensagemUsuario;
	
	private UsuarioVO usuario = new UsuarioVO();
	
	@Autowired
	public UsuarioFacade usuarioFacade;

	public String exibirTelaLogin() {
		return SUCCESS;
	}
	
	public String efetuarLogin() {
		try {
			Usuario usuario = new Usuario();
			usuario.setUsuLogin(getUsuario().getUsuLogin());
			usuario.setUsuSenha(getUsuario().getUsuSenha());
			
			usuario = usuarioFacade.efetuarLogin(usuario.getUsuLogin().trim(), usuario.getUsuSenha().trim());
			
			// Abrir sessão.
			this.getRequest().getSession().setAttribute(Constantes.KEY_USUARIO_SESSION, usuario);
			
			return SUCCESS;				
		} catch (BusinessException e) {
			LOG.error(e.getMessage(), e);
			addActionError(e.getMessage());
			return ERROR;
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
			addActionError("Serviço de Login indisponível.");
			return ERROR;
		}
	}	
	
	public String exibirTelaHome() {
		return SUCCESS;
	}
	
	public String logout() {
		return SUCCESS;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}
}
