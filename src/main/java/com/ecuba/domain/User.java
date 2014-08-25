package com.ecuba.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * Created by rolando on 2014-08-22.
 */

@SolrDocument(solrCoreName = "collection1")
public class User extends PersistentObject<String>{

    protected @Id @Indexed String id;

	private @Indexed("username") String username;

	private @Indexed("password") String password;

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
