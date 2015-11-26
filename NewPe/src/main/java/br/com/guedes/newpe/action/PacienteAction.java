package br.com.guedes.newpe.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.guedes.newpe.facade.PacienteFacade;
import br.com.guedes.newpe.facade.UsuarioFacade;
import br.com.guedes.newpe.model.Paciente;
import br.com.guedes.newpe.model.Pessoa;
import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.Constantes;
import br.com.guedes.newpe.vo.PacienteVO;
import br.com.guedes.newpe.vo.PessoaVO;
import br.com.guedes.newpe.vo.UsuarioVO;

@Controller
@Scope("request")
public class PacienteAction extends BasicAction {

	private static final long serialVersionUID = -1432863302674170771L;
	
	@Autowired
	public PacienteFacade pacienteFacade;
	
	private PacienteVO pacienteVO;
	private List<PessoaVO> listaPacientes;
	private String mensagemUsuario;

	public String exibirTelaPesquisa() {
		return SUCCESS;
	}	
	
	public String exibirTelaManutencao() {
		return SUCCESS;
	}
	
	public String pesquisarPacientes() {
		try {
			Paciente paciente = new Paciente();
			Pessoa pessoa = new Pessoa();
			
			pessoa.setPesNome(getPacienteVO().getPessoaVO().getPesNome());
			paciente.setPessoa(pessoa);
			
			List<Pessoa> listaRetorno = pacienteFacade.pesquisar(paciente);
			if (listaRetorno != null && listaRetorno.size() > 0) {
				setListaPacientes(new ArrayList<PessoaVO>());
				for (Pessoa pes: listaRetorno) {
					PessoaVO pessoaVO = new PessoaVO();
					pessoaVO.setPesCodigo(pes.getPesCodigo());
					pessoaVO.setPesNome(pes.getPesNome());
					
					getListaPacientes().add(pessoaVO);
				}
			}
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}

	public PacienteVO getPacienteVO() {
		return pacienteVO;
	}

	public void setPacienteVO(PacienteVO pacienteVO) {
		this.pacienteVO = pacienteVO;
	}

	public List<PessoaVO> getListaPacientes() {
		return listaPacientes;
	}

	public void setListaPacientes(List<PessoaVO> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}
}
