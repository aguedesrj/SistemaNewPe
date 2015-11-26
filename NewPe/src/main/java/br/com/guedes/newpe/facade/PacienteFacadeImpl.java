package br.com.guedes.newpe.facade;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.newpe.dao.PacienteDao;
import br.com.guedes.newpe.dao.UsuarioDao;
import br.com.guedes.newpe.model.Paciente;
import br.com.guedes.newpe.model.Pessoa;
import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class PacienteFacadeImpl implements PacienteFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PacienteFacadeImpl.class);
	
	@Autowired
	private PacienteDao pacienteDao;
	
	@Autowired 
    private SessionFactory sessionFactory;
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.newpe.facade.PacienteFacade#pesquisar(br.com.guedes.newpe.model.Paciente)
	 */
	public List<Pessoa> pesquisar(Paciente paciente) throws BusinessException, IntegrationException {
		LOGGER.debug("Pesquisando pacientes...");
		return pacienteDao.pesquisar(paciente);
	}

	public PacienteDao getPacienteDao() {
		return pacienteDao;
	}

	public void setPacienteDao(PacienteDao pacienteDao) {
		this.pacienteDao = pacienteDao;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
