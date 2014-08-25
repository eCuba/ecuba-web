package com.ecuba.domain;

/**
 * Created by rolando on 2014-08-22.
 */

public class User extends PersistentObject<String>{

	private String username;
	private String password;
	private Integer active;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getActive() {
		return active;
	}
}
