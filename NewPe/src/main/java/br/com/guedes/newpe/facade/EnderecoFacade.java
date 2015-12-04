package br.com.guedes.newpe.facade;

import java.util.List;

import br.com.guedes.newpe.model.Estado;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

public interface EnderecoFacade {
	
	/**
	 * Obter a lista completa dos estados..
	 * 
	 * @return List<Estado>
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public List<Estado> listaEstados() throws BusinessException, IntegrationException;
}
