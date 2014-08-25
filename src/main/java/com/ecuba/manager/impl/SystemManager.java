package com.ecuba.manager.impl;

import com.ecuba.dao.IUserDAO;
import com.ecuba.domain.User;
import com.ecuba.facade.ISystemFacade;
import com.ecuba.manager.ISystemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by rolando on 2014-08-22.
 */
@Service("systemManager")
public class SystemManager implements ISystemManager {

	private IUserDAO userDAO;

	@Autowired
	public void setUserDAO(@Qualifier("userDAO")IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public List<User> getUsers() {
		return userDAO.findAll();
	}

	@Override
	public User registerUser(User user) {

		user.setId(UUID.randomUUID().toString());

		return userDAO.saveOrUpdate(user);
	}
}
