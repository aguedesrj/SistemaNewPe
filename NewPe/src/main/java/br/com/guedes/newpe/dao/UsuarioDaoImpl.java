package br.com.guedes.newpe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

/**
 * 
 * @author Andr�Lessa
 *
 */ 
@Repository
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {

//	private static final Logger LOGGER = Logger.getLogger(UsuarioDaoImpl.class);
	
	/*
	 * (non-Javadoc)
	 * @see br.com.sistemacomercial.guedes.dao.UsuarioDao#efetuarLogin(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Usuario efetuarLogin(final String login, final String senha) throws BusinessException, IntegrationException {
		try {
			StringBuilder hql = new StringBuilder();
			hql.append("from Usuario ");
			hql.append(" where usuLogin = '" + login + "'");
//			hql.append(" and usuSenha = '" + senha + "'");
			
			ArrayList<Usuario> listaUsuarios = (ArrayList<Usuario>) getHibernateTemplate().find(hql.toString());
			if(listaUsuarios != null && !listaUsuarios.isEmpty()) {
				return listaUsuarios.get(0);
			}
			
			throw new BusinessException("Login ou senha inválidos.");
		} catch (Exception e) {
			if (e instanceof BusinessException) {
				throw new BusinessException(e.getMessage());
			} else {
				throw new IntegrationException("Não foi possível efetuar login do Usuário.");
			}
		}
	}
}
