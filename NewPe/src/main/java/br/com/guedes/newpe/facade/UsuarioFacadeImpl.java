package br.com.guedes.newpe.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
public class UsuarioFacadeImpl implements UsuarioFacade {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioFacadeImpl.class);

	public Usuario efetuarLogin(final String login, final String senha) throws BusinessException, IntegrationException {
		LOGGER.info("Efetuar login de: {}", login);
		return null;
	}
}
