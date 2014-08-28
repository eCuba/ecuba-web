package com.ecuba.domain;

/**
 * Created by rolando on 2014-08-28.
 */
public interface BusinessItem {

	public Business getBusiness();

	public String getTitle();

	public String getText();

	public void setBusiness(Business business);

	public void setTitle(String title);

	public void setText(String text);
}
