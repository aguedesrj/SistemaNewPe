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
import br.com.guedes.newpe.model.Estado;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class EnderecoFacadeImpl implements EnderecoFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EnderecoFacadeImpl.class);
	
	@Autowired 
    private SessionFactory sessionFactory;
	
	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.newpe.facade.EnderecoFacade#listaEstados()
	 */
	@SuppressWarnings("unchecked")
	public List<Estado> listaEstados() throws BusinessException, IntegrationException {
		LOGGER.debug("Lista de estados...");
		return (ArrayList<Estado>) getSessionFactory().getCurrentSession().find("from Estado");
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
