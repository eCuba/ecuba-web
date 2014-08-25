package com.ecuba.manager;

import com.ecuba.domain.User;

/**
 * Created by rolando on 2014-08-23.
 */
public interface IEmailManager {
	public void sendMail(User user);
}
