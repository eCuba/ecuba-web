package com.ecuba.facade;

import com.ecuba.domain.User;

/**
 * Created by rolando on 2014-08-23.
 */
public interface IEmailFacade {
	public void sendMail(User user);
}
