package com.ecuba.manager;

import com.ecuba.domain.User;

import java.util.List;

/**
 * Created by rolando on 2014-08-22.
 */
public interface ISystemManager {
	public List<User> getUsers();
	public User registerUser(User user);
}
