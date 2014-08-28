package com.ecuba.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

/**
 * Created by rolando on 2014-08-22.
 */

public class User extends PersistentObject<String> implements BusinessOwner{

	private String username;

	private String password;

	private Integer active;

	private List<Business> businesses;

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

	@Override
	public List<Business> getBusinesses() {
		return businesses;
	}

	@Override
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
}
