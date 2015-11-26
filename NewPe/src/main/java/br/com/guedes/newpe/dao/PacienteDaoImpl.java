package br.com.guedes.newpe.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import br.com.guedes.newpe.model.Paciente;
import br.com.guedes.newpe.model.Pessoa;
import br.com.guedes.newpe.model.Usuario;
import br.com.guedes.newpe.util.BusinessException;
import br.com.guedes.newpe.util.IntegrationException;

/**
 * 
 * @author Andr�Lessa
 *
 */ 
@Repository
public class PacienteDaoImpl extends HibernateDaoSupport implements PacienteDao {

	/*
	 * (non-Javadoc)
	 * @see br.com.guedes.newpe.dao.PacienteDao#pesquisar(br.com.guedes.newpe.model.Paciente)
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> pesquisar(final Paciente paciente) throws BusinessException, IntegrationException {
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select pes_codigo, pes_nome from tb_pessoa ");
			sql.append("where UPPER(pes_nome) LIKE UPPER('%" + paciente.getPessoa().getPesNome() + "%') ");
			sql.append("order by pes_nome");
			
			Query query = getSession().createSQLQuery(sql.toString());
			List<Object[]> result = query.list();
			if (result.size() > 0) {
				List<Pessoa> lista = new ArrayList<Pessoa>();
				for (Object[] object: result) {
					Pessoa pessoa = new Pessoa();
					pessoa.setPesCodigo((Integer) object[0]);
					pessoa.setPesNome((String) object[1]);
					lista.add(pessoa);
				}
				return lista;
			}
			return null;
			
//			StringBuilder hql = new StringBuilder();
//			hql.append("from Paciente ");
//			hql.append(" where UPPER(pessoa.pesNome) LIKE '%" + paciente.getPessoa().getPesNome().toUpperCase() + "%'");
//			hql.append(" order by pessoa.pesNome");
//			
//			ArrayList<Paciente> lista = (ArrayList<Paciente>) getHibernateTemplate().find(hql.toString());
//			return lista;
			
//			throw new BusinessException("Nenhum registro encontrado.");
		} catch (Exception e) {
			if (e instanceof BusinessException) {
				throw new BusinessException(e.getMessage());
			} else {
				throw new IntegrationException("Não foi possível efetuar a pesquisa dos pacientes.");
			}
		}
	}
}
