package br.com.guedes.newpe.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
public class UsuarioFacadeImpl implements UsuarioFacade {
	
//	private static final Logger LOGGER = Logger.getLogger(UsuarioFacadeImpl.class);

	public Usuario efetuarLogin(final String login, final String senha) throws BusinessException, IntegrationException {
//		LOGGER.info("Efetuar login.");
		return null;
	}
}
