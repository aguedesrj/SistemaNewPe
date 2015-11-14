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
public class PacienteAction extends BasicAction {

	private static final long serialVersionUID = -1432863302674170771L;
	
	@Autowired
	public PacienteFacade pacienteFacade;

	public String exibirTelaPesquisa() {
		return SUCCESS;
	}	
	
	public String exibirTelaManutencaoØ() {
		return SUCCESS;
	}
}
