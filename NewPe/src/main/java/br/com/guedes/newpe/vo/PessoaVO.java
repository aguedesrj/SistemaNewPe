package br.com.guedes.newpe.vo;

import java.io.Serializable;
import java.util.List;

public class PessoaVO implements Serializable {

	private static final long serialVersionUID = 1478785122548694710L;

	private Integer pesCodigo;
	private String pesNome;	
	private String pesCpf;
	private String pesSexo;	
	private String pesDtNascimento;
	private String pesObs;
	private EnderecoVO enderecoVO;
	private ContatoVO contatoVO;
	private List<ContatoVO> listaContatos;
	
	public Integer getPesCodigo() {
		return pesCodigo;
	}
	
	public void setPesCodigo(Integer pesCodigo) {
		this.pesCodigo = pesCodigo;
	}
	
	public String getPesNome() {
		return pesNome;
	}
	
	public void setPesNome(String pesNome) {
		this.pesNome = pesNome;
	}
	
	public String getPesSexo() {
		return pesSexo;
	}
	
	public void setPesSexo(String pesSexo) {
		this.pesSexo = pesSexo;
	}
	
	public String getPesDtNascimento() {
		return pesDtNascimento;
	}
	
	public void setPesDtNascimento(String pesDtNascimento) {
		this.pesDtNascimento = pesDtNascimento;
	}
	
	public String getPesObs() {
		return pesObs;
	}
	
	public void setPesObs(String pesObs) {
		this.pesObs = pesObs;
	}

	public String getPesCpf() {
		return pesCpf;
	}

	public void setPesCpf(String pesCpf) {
		this.pesCpf = pesCpf;
	}

	public EnderecoVO getEnderecoVO() {
		return enderecoVO;
	}

	public void setEnderecoVO(EnderecoVO enderecoVO) {
		this.enderecoVO = enderecoVO;
	}

	public ContatoVO getContatoVO() {
		return contatoVO;
	}

	public void setContatoVO(ContatoVO contatoVO) {
		this.contatoVO = contatoVO;
	}

	public List<ContatoVO> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<ContatoVO> listaContatos) {
		this.listaContatos = listaContatos;
	}
}
