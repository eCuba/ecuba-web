/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecuba.dao.impl;

import com.ecuba.dao.IBaseDAO;
import org.hibernate.*;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Wanted (Alien GR).
 * @author Rolando Bermúdez.
 */
public abstract class AbstractHibernateDAO<T, ID extends Serializable> extends
		HibernateDaoSupport implements IBaseDAO<T, ID> {

	private Class<T> entityClass;

	protected AbstractHibernateDAO(Class<T> entityClass, SessionFactory sessionFactory) {
		this.entityClass = entityClass;
		this.setSessionFactory(sessionFactory);
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	@Override
	public T findById(ID id) {
		return (T) getHibernateTemplate().get(getEntityClass(), id);
	}

	@Override
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public T saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		return entity;
	}

	@Override
	public Integer countAll() {
	    /*String stringClass =  entityClass.getSimpleName();
        String query = "select count(tipo) from " + stringClass + " tipo";
        List<Integer> values = getHibernateTemplate().find(query);
        return ((values == null || values.isEmpty()) ? 0 : values.get(0));*/
		@SuppressWarnings({"unchecked", "rawtypes"})
		List results = (List) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException{
				return session.createCriteria(entityClass)
						.setProjection(Projections.rowCount()).list();
			}
		});
		return DataAccessUtils.intResult(results);
	}

	@Override
	public List<T> findAll() throws DataAccessException {
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public List<T> doInHibernate(Session session)
					throws HibernateException {
				Criteria crit = session.createCriteria(getEntityClass());
				return crit.list();
			}
		});
	}

	@Override
	public List<T> findAllCache() throws DataAccessException {
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				Criteria crit = session.createCriteria(getEntityClass());
				crit.setCacheable(true);
				return crit.list();
			}
		});
	}

	@Override
	public T findByIdLock(ID id) throws DataAccessException {
		return (T) getHibernateTemplate().get(getEntityClass(), id,
				LockMode.UPGRADE_NOWAIT);
	}

	@Override
	public List<T> findByExample(final T exampleInstance,
	                             final String... excludeProperty) throws DataAccessException {
		return (List<T>) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				Criteria crit = session.createCriteria(getEntityClass());
				Example example = Example.create(exampleInstance);
				for (String exclude : excludeProperty) {
					example.excludeProperty(exclude);
				}
				crit.add(example);
				return crit.list();
			}
		});

	}

	@Override
	public List findPaginatedQuery(final Integer startIndex,
	                               final Integer fetchSize, final String query,
	                               final Object... parametersValues) throws DataAccessException {
		return (List) getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query q = session.createQuery(query);
				if (q.getNamedParameters().length != parametersValues.length) {
					throw new HibernateException("Error, la cantidad de parametros de la Query no concuerdan con la cantidad de nombres de estos parametros");
				}
				q.setFirstResult(startIndex);
				q.setMaxResults(fetchSize);
				for (int i = 0; i < parametersValues.length; i++) {
					q.setParameter(i, parametersValues[i]);
				}
				return q.list();
			}
		});
	}

}
