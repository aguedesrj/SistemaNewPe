package br.com.guedes.newpe.facade;

import java.util.List;
import br.com.guedes.newpe.model.TipoContato;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

public interface ContatoFacade {
	
	/**
	 * Obter a lista completa dos tipos de contatos.
	 * 
	 * @return List<TipoContato>
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public List<TipoContato> listaTipoContatos() throws BusinessException, IntegrationException;
}
