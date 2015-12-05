package br.com.guedes.newpe.action;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.guedes.newpe.facade.ContatoFacade;
import br.com.guedes.newpe.facade.EnderecoFacade;
import br.com.guedes.newpe.facade.PacienteFacade;
import br.com.guedes.newpe.model.Contato;
import br.com.guedes.newpe.model.Estado;
import br.com.guedes.newpe.model.Paciente;
import br.com.guedes.newpe.model.Pessoa;
import br.com.guedes.newpe.model.TipoContato;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.Constantes;
import br.com.guedes.newpe.util.IntegrationException;
import br.com.guedes.newpe.util.Util;
import br.com.guedes.newpe.vo.ContatoVO;
import br.com.guedes.newpe.vo.EnderecoVO;
import br.com.guedes.newpe.vo.EstadoVO;
import br.com.guedes.newpe.vo.PacienteVO;
import br.com.guedes.newpe.vo.PessoaVO;
import br.com.guedes.newpe.vo.TipoContatoVO;

@Controller
@Scope("request")
public class PacienteAction extends BasicAction {

	private static final long serialVersionUID = -1432863302674170771L;
	
	@Autowired
	public PacienteFacade pacienteFacade;
	
	@Autowired
	public EnderecoFacade enderecoFacade;
	
	@Autowired
	public ContatoFacade contatoFacade;
	
	private PacienteVO pacienteVO;
	
	private ContatoVO contatoVO;
	
	private List<ContatoVO> listaContatoVO;
	
	private List<PessoaVO> listaPacientes;
	private List<TipoContatoVO> listaTipoContato;
	private List<EstadoVO> listaEstado;
	
	private String mensagemUsuario;

	public String exibirTelaPesquisa() {
		return SUCCESS;
	}	
	
	public String exibirTelaManutencao() {
		try {
			// obter a lista de estados.
			obterListaEstados();
			
			// obter lista de tipos de contatos.
			obterListaTipoContatos();
			
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
	
//	public String novoContato() {
//		return SUCCESS;
//	}
//	
//	public String alterarContato() {
//		
//		return SUCCESS;
//	}
	
	@SuppressWarnings("unchecked")
	public String incluirContato() {
		setListaContatoVO((ArrayList<ContatoVO>) this.getRequest().getSession().getAttribute(Constantes.KEY_LISTA_CONTATOS_SESSION));
		if (getListaContatoVO() == null) {
			setListaContatoVO(new ArrayList<ContatoVO>());
		}
		
		// verifica se é novo contato...
		if (getContatoVO().getConCodigo() == null || getContatoVO().getConCodigo() == 0) {
			getListaContatoVO().add(getContatoVO());
		} else {
			for (ContatoVO contat: getListaContatoVO()) {
				if (contat.getConCodigo() == getContatoVO().getConCodigo()) {
					contat.setConDescricao(getContatoVO().getConDescricao());
					contat.setConResponsavel(getContatoVO().getConResponsavel());
					contat.setTcoCodigo(getContatoVO().getTcoCodigo());
					break;
				}
			}
		}
		this.getRequest().getSession().setAttribute(Constantes.KEY_LISTA_CONTATOS_SESSION, getListaContatoVO());
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String excluirContato() {
		setListaContatoVO((ArrayList<ContatoVO>) this.getRequest().getSession().getAttribute(Constantes.KEY_LISTA_CONTATOS_SESSION));
		for (ContatoVO contat: getListaContatoVO()) {
			if (contat.getConCodigo() == getContatoVO().getConCodigo()) {
				getListaContatoVO().remove(contat);
				break;
			}
		}
		this.getRequest().getSession().setAttribute(Constantes.KEY_LISTA_CONTATOS_SESSION, getListaContatoVO());
		return SUCCESS;
	}
	
	/**
	 * 
	 * @return String
	 */
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
			getPacienteVO().getPessoaVO().setPesDtNascimento(Util.converterCalendarParaString(paciente.getPessoa().getPesDtNascimento(), Util.SIMPLE_DATE_FORMAT_DATA));
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
			
			// obter a lista de estados.
			obterListaEstados();
			
			// obter lista de tipos de contatos.
			obterListaTipoContatos();
			
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
	
	/**
	 * Obter a lista de estados.
	 * 
	 * @throws Exception
	 */
	private void obterListaEstados() throws Exception {
		setListaEstado(new ArrayList<EstadoVO>());
		List<Estado> listaEst = enderecoFacade.listaEstados();
		for (Estado estado: listaEst) {
			EstadoVO estadoVO = new EstadoVO();
			estadoVO.setEstCodigo(estado.getEstCodigo());
			estadoVO.setEstNome(estado.getEstNome());
			estadoVO.setEstSigla(estado.getEstSigla());
			getListaEstado().add(estadoVO);
		}
	}
	
	/**
	 * Obter a lista de tipos de contatos.
	 * 
	 * @throws Exception
	 */
	private void obterListaTipoContatos() throws Exception {
		setListaTipoContato(new ArrayList<TipoContatoVO>());
		List<TipoContato> listaTipoCon = contatoFacade.listaTipoContatos();
		for (TipoContato tipoContato: listaTipoCon) {
			TipoContatoVO tipoContatoVO = new TipoContatoVO();
			tipoContatoVO.setTcoCodigo(tipoContato.getTcoCodigo());
			tipoContatoVO.setTcoDescricao(tipoContato.getTcoDescricao());
			getListaTipoContato().add(tipoContatoVO);
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

	public List<TipoContatoVO> getListaTipoContato() {
		return listaTipoContato;
	}

	public void setListaTipoContato(List<TipoContatoVO> listaTipoContato) {
		this.listaTipoContato = listaTipoContato;
	}

	public List<EstadoVO> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<EstadoVO> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public ContatoVO getContatoVO() {
		return contatoVO;
	}

	public void setContatoVO(ContatoVO contatoVO) {
		this.contatoVO = contatoVO;
	}

	public List<ContatoVO> getListaContatoVO() {
		return listaContatoVO;
	}

	public void setListaContatoVO(List<ContatoVO> listaContatoVO) {
		this.listaContatoVO = listaContatoVO;
	}
}
