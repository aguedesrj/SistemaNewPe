package br.com.guedes.newpe.vo;

import java.io.Serializable;

public class UsuarioVO implements Serializable {

	private static final long serialVersionUID = -1623140261005704857L;
	
	private Integer usuCodigo;
	private Integer pesCodigo;
	private String usuLogin;
	private String usuSenha;
	private String pesNome;
	
	public Integer getUsuCodigo() {
		return usuCodigo;
	}
	
	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}
	
	public Integer getPesCodigo() {
		return pesCodigo;
	}
	
	public void setPesCodigo(Integer pesCodigo) {
		this.pesCodigo = pesCodigo;
	}
	
	public String getUsuLogin() {
		return usuLogin;
	}
	
	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}
	
	public String getUsuSenha() {
		return usuSenha;
	}
	
	public void setUsuSenha(String usuSenha) {
		this.usuSenha = usuSenha;
	}
	
	public String getPesNome() {
		return pesNome;
	}
	
	public void setPesNome(String pesNome) {
		this.pesNome = pesNome;
	}
}
