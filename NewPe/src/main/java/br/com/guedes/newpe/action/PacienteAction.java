package br.com.guedes.newpe.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.guedes.newpe.facade.PacienteFacade;
import br.com.guedes.newpe.facade.UsuarioFacade;
import br.com.guedes.newpe.model.Contato;
import br.com.guedes.newpe.model.Paciente;
import br.com.guedes.newpe.model.Pessoa;
import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.Constantes;
import br.com.guedes.newpe.util.IntegrationException;
import br.com.guedes.newpe.vo.ContatoVO;
import br.com.guedes.newpe.vo.EnderecoVO;
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
	
	/**
	 * 
	 * @return String
	 */
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
	
	public String obterDadosDoPaciente() {
		try {
			Paciente paciente = pacienteFacade.obterDadosDoPaciente(getPacienteVO().getPessoaVO().getPesCodigo());
			
			setPacienteVO(new PacienteVO());
			getPacienteVO().setPacCodigo(paciente.getPacCodigo());
			getPacienteVO().setPacLabora(paciente.getPacLabora());
			getPacienteVO().setPacAndaDescalco(paciente.getPacAndaDescalco());
			getPacienteVO().setPacUnhaEngravada(paciente.getPacUnhaEngravada());
			getPacienteVO().setPacCirurgiaPes(paciente.getPacCirurgiaPes());
			getPacienteVO().setPacCirurgiaMotivo(paciente.getPacCirurgiaMotivo());
			getPacienteVO().setPacCalcadoUtiliza(paciente.getPacCalcadoUtiliza());
			getPacienteVO().setPacVisitaPedicuro(paciente.getPacVisitaPedicuro());
			getPacienteVO().setPacNumeroCalcado(paciente.getPacNumeroCalcado());
			getPacienteVO().setPacAlergicoMedicamentos(paciente.getPacAlergicoMedicamentos());
			getPacienteVO().setPacAlergicoQuais(paciente.getPacAlergicoQuais());
			getPacienteVO().setPacDiabetes(paciente.getPacDiabetes());
			getPacienteVO().setPacHipertensao(paciente.getPacHipertensao());
			getPacienteVO().setPacTabagismo(paciente.getPacTabagismo());
			getPacienteVO().setPacPeso(paciente.getPacPeso());
			getPacienteVO().setPacAltura(paciente.getPacAltura());
			
			getPacienteVO().setPessoaVO(new PessoaVO());
			getPacienteVO().getPessoaVO().setPesCodigo(paciente.getPessoa().getPesCodigo());
			getPacienteVO().getPessoaVO().setPesNome(paciente.getPessoa().getPesNome());
			getPacienteVO().getPessoaVO().setPesCpf(paciente.getPessoa().getPesCpf());
			getPacienteVO().getPessoaVO().setPesSexo(paciente.getPessoa().getPesSexo());
//			getPacienteVO().getPessoaVO().setPesDtNascimento(paciente.getPessoa().getPesDtNascimento());
			getPacienteVO().getPessoaVO().setPesObs(paciente.getPessoa().getPesObs());
			
			getPacienteVO().getPessoaVO().setEnderecoVO(new EnderecoVO());
			getPacienteVO().getPessoaVO().getEnderecoVO().setEndCodigo(paciente.getPessoa().getEndereco().getEndCodigo());
			getPacienteVO().getPessoaVO().getEnderecoVO().setEndLogadouro(paciente.getPessoa().getEndereco().getEndLogadouro());
			getPacienteVO().getPessoaVO().getEnderecoVO().setEndNumero(paciente.getPessoa().getEndereco().getEndNumero());
			getPacienteVO().getPessoaVO().getEnderecoVO().setEndBairro(paciente.getPessoa().getEndereco().getEndBairro());
			getPacienteVO().getPessoaVO().getEnderecoVO().setEndCidade(paciente.getPessoa().getEndereco().getEndCidade());
			getPacienteVO().getPessoaVO().getEnderecoVO().setEndCep(paciente.getPessoa().getEndereco().getEndCep());
			
			if (paciente.getPessoa().getEndereco().getEstado() != null) {
				getPacienteVO().getPessoaVO().getEnderecoVO().setEstCodigo(paciente.getPessoa().getEndereco().getEstado().getEstCodigo());
			}
			
			if (paciente.getPessoa().getListaContato() != null && paciente.getPessoa().getListaContato().size() > 0) {
				getPacienteVO().getPessoaVO().setListaContatos(new ArrayList<ContatoVO>());
				for (Contato contato: paciente.getPessoa().getListaContato()) {
					ContatoVO contatoVO = new ContatoVO();
					contatoVO.setConCodigo(contato.getConCodigo());
					contatoVO.setConDescricao(contato.getConDescricao());
					contatoVO.setConResponsavel(contato.getConResponsavel());
					contatoVO.setTcoCodigo(contato.getTipoContato().getTcoCodigo());
					
					getPacienteVO().getPessoaVO().getListaContatos().add(contatoVO);
				}
			}
			
			return SUCCESS;
		} catch (Exception e) {
			if (e instanceof BusinessException || e instanceof IntegrationException) {
				addActionError(e.getMessage());
			} else {
				addActionError("Serviço de busca indisponível.");
			}
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
