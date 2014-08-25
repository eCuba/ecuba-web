package com.ecuba.facade.impl;

import com.ecuba.domain.User;
import com.ecuba.facade.ISystemFacade;
import com.ecuba.manager.ISystemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rolando on 2014-08-22.
 */
@Service("systemFacade")
public class SystemFacade implements ISystemFacade {

	private ISystemManager systemManager;

	@Autowired
	public void setSystemManager(@Qualifier("systemManager")ISystemManager systemManager) {
		this.systemManager = systemManager;
	}

	@Override
	public List<User> getUsers() {
		return systemManager.getUsers();
	}

	@Override
	public User registerUser(User user) {
		return systemManager.registerUser(user);
	}
}
