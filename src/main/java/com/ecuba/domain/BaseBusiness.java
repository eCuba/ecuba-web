package com.ecuba.domain;

import java.util.List;

/**
 * Created by rolando on 2014-08-27.
 */
public class BaseBusiness extends PersistentObject<String> implements Business, GeoLocated {

	private String name;

	private GeoPoint location;

	private User owner;

	private BusinessType type;

	private List<BusinessItem> items;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public User getOwner() {
		return owner;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public BusinessType getType() {
		return null;
	}

	@Override
	public void setType(BusinessType type) {

	}

	@Override
	public List<BusinessItem> getItems() {
		return null;
	}

	@Override
	public void setItems(List<BusinessItem> items) {

	}

	@Override
	public GeoPoint getPoint() {
		return location;
	}

	@Override
	public void setPoint(GeoPoint point) {
		this.location = point;
	}
}
