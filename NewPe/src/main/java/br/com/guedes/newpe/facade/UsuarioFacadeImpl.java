package br.com.guedes.newpe.facade;

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

import br.com.guedes.newpe.dao.UsuarioDao;
import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
public class UsuarioFacadeImpl implements UsuarioFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioFacadeImpl.class);
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired 
    private SessionFactory sessionFactory;

	public Usuario efetuarLogin(final String login, final String senha) throws BusinessException, IntegrationException {
		LOGGER.info("Efetuar login de: {}", login);
		usuarioDao.efetuarLogin(login, senha);
		return null;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
