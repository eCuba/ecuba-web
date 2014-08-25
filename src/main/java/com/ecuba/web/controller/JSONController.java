package com.ecuba.web.controller;

import com.ecuba.domain.Person;
import com.ecuba.domain.User;
import com.ecuba.facade.IEmailFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class JSONController {

	private IEmailFacade emailFacade;

	@Autowired
	public void setEmailFacade(@Qualifier("emailFacade")IEmailFacade emailFacade) {
		this.emailFacade = emailFacade;
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public @ResponseBody String test(){
		return "OK testing!!";
	}

	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public @ResponseBody String getPersonInJSON() {

		User user = new User();
		user.setUsername("test@ecuba.com");

		emailFacade.sendMail(user);

		return "OK";
	}

}
