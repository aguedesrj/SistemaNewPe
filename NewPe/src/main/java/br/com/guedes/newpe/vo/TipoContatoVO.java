package br.com.guedes.newpe.vo;

import java.io.Serializable;

public class TipoContatoVO implements Serializable {

	private static final long serialVersionUID = 4166584025803470697L;
	
	private Integer tcoCodigo;
	private String tcoDescricao;

	public Integer getTcoCodigo() {
		return tcoCodigo;
	}

	public void setTcoCodigo(Integer tcoCodigo) {
		this.tcoCodigo = tcoCodigo;
	}

	public String getTcoDescricao() {
		return tcoDescricao;
	}

	public void setTcoDescricao(String tcoDescricao) {
		this.tcoDescricao = tcoDescricao;
	}
}
