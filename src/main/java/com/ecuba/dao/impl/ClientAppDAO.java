package com.ecuba.dao.impl;

import com.ecuba.dao.IClientAppDAO;
import com.ecuba.domain.ClientApp;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by rolando on 2014-08-22.
 */
@Repository("clientAppDAO")
public class ClientAppDAO extends AbstractHibernateDAO<ClientApp,String> implements IClientAppDAO{

	@Autowired
	protected ClientAppDAO(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
		super(ClientApp.class, sessionFactory);
	}
}
