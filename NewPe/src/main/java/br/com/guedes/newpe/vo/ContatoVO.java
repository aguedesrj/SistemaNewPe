package br.com.guedes.newpe.vo;

import java.io.Serializable;

public class ContatoVO implements Serializable {

	private static final long serialVersionUID = -1074993420183706486L;

	private Integer conCodigo;
	private String conDescricao;
	private String conResponsavel;
	private boolean novoContato;
	private TipoContatoVO tipoContatoVO;
	
	public Integer getConCodigo() {
		return conCodigo;
	}
	
	public void setConCodigo(Integer conCodigo) {
		this.conCodigo = conCodigo;
	}
	
	public String getConDescricao() {
		return conDescricao;
	}
	
	public void setConDescricao(String conDescricao) {
		this.conDescricao = conDescricao;
	}
	
	public String getConResponsavel() {
		return conResponsavel;
	}
	
	public void setConResponsavel(String conResponsavel) {
		this.conResponsavel = conResponsavel;
	}
	
	public boolean isNovoContato() {
		return novoContato;
	}

	public void setNovoContato(boolean novoContato) {
		this.novoContato = novoContato;
	}

	public TipoContatoVO getTipoContatoVO() {
		return tipoContatoVO;
	}

	public void setTipoContatoVO(TipoContatoVO tipoContatoVO) {
		this.tipoContatoVO = tipoContatoVO;
	}
}
