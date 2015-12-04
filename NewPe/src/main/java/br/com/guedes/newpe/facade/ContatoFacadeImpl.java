package br.com.guedes.newpe.facade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.guedes.newpe.model.TipoContato;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ContatoFacadeImpl implements ContatoFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContatoFacadeImpl.class);
	
	@Autowired 
    private SessionFactory sessionFactory;
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.newpe.facade.ContatoFacade#listaTipoContatos()
	 */
	@SuppressWarnings("unchecked")
	public List<TipoContato> listaTipoContatos() throws BusinessException, IntegrationException {
		LOGGER.debug("Lista de tipos de contatos...");
		return (ArrayList<TipoContato>) getSessionFactory().getCurrentSession().find("from TipoContato");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
