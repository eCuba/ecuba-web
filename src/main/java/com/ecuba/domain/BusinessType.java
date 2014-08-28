package com.ecuba.domain;

/**
 * Created by rolando on 2014-08-28.
 */
public class BusinessType extends PersistentObject<String> {
	private String name;

	public BusinessType() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
