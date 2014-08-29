package com.ecuba.domain;

/**
 * Created by rolando on 2014-08-28.
 */
public class BusinessItemType extends PersistentObject<String> {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public BusinessItemType() {
	}
}
