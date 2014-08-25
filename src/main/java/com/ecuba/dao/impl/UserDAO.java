package com.ecuba.dao.impl;

import com.ecuba.dao.IUserDAO;
import com.ecuba.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by rolando on 2014-08-22.
 */
@Repository("userDAO")
public class UserDAO extends AbstractHibernateDAO<User,String> implements IUserDAO {

	@Autowired
	protected UserDAO(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
		super(User.class,sessionFactory);
	}
}
