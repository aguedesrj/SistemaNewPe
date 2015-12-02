package br.com.guedes.newpe.dao;

import java.util.List;
import br.com.guedes.newpe.model.Paciente;
import br.com.guedes.newpe.model.Pessoa;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

public interface PacienteDao {

	/**
	 * Lista de pacientes...
	 * 
	 * @param paciente Paciente
	 * @return List<Pessoa>
	 * @throws BusinessException
	 * @throws IntegrationException
	 */
	public List<Pessoa> pesquisar(final Paciente paciente) throws BusinessException, IntegrationException;
	
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
