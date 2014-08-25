package com.ecuba.facade.impl;

import com.ecuba.domain.User;
import com.ecuba.facade.IEmailFacade;
import com.ecuba.manager.IEmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by rolando on 2014-08-23.
 */
@Service("emailFacade")
public class EmailFacade implements IEmailFacade {

	private IEmailManager emailManager;

	@Autowired
	public void setEmailManager(@Qualifier("emailManager")IEmailManager emailManager) {
		this.emailManager = emailManager;
	}

	@Override
	public void sendMail(User user) {
		emailManager.sendMail(user);
	}
}
