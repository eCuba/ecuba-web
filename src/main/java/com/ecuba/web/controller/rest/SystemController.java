package com.ecuba.web.controller.rest;

import com.ecuba.domain.User;
import com.ecuba.facade.ISystemFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rolando on 2014-08-22.
 */

@RestController
public class SystemController {

	private ISystemFacade systemFacade;

	@Autowired
	public void setSystemFacade(@Qualifier("systemFacade") ISystemFacade systemFacade) {
		this.systemFacade = systemFacade;
	}

	@RequestMapping(value = "rest/user/register", method = RequestMethod.POST)
	public User registerUser(@RequestBody User user) {
		return systemFacade.registerUser(user);
	}

	@RequestMapping(value = "rest/user/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId){
		return null;
	}

	@RequestMapping(value = "rest/users", method = RequestMethod.GET)
	public List<User> getUsers() {
		return systemFacade.getUsers();
	}

	@RequestMapping(value = "rest/item/{businessItemClass}", method = RequestMethod.POST)
	public Object newBusinessItems(@PathVariable String businessItemClass){

		return null;
	}
}
