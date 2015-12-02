package br.com.guedes.newpe.facade;

import java.util.List;
import br.com.guedes.newpe.model.Paciente;
import br.com.guedes.newpe.model.Pessoa;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

public interface PacienteFacade {
	
	/**
	 * Pesquisar os pacientes.
	 * 
	 * @param paciente Paciente
	 * @return List<Pessoa>
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public List<Pessoa> pesquisar(Paciente paciente) throws BusinessException, IntegrationException;
	
	/**
	 * Obter dados do paciente por ID.
	 * 
	 * @param pesCodigo Integer
	 * @return Paciente
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public Paciente obterDadosDoPaciente(final Integer pesCodigo) throws BusinessException, IntegrationException;
}
