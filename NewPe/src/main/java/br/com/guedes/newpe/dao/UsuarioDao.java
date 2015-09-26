package br.com.guedes.newpe.dao;

import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

public interface UsuarioDao {

	/**
	 * Efetuar Login do Usu�rio.
	 * 
	 * @param login String
	 * @param senha String
	 * @return Usuario
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public Usuario efetuarLogin(final String login, final String senha) throws BusinessException, IntegrationException;
}
