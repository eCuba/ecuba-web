package com.ecuba.domain;

import java.util.List;

/**
 * Created by rolando on 2014-08-28.
 */
public interface Business {

	public String getName();

	public User getOwner();

	public void setName(String name);

	public void setOwner(User owner);

	public BusinessType getType();

	public void setType(BusinessType type);

	public List<BusinessItem> getItems();

	public void setItems(List<BusinessItem> items);
}
