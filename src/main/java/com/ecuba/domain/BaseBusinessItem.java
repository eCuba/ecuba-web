package com.ecuba.domain;

import java.util.Date;

/**
 * Created by rolando on 2014-08-28.
 */
public class BaseBusinessItem implements BusinessItem, GeoLocated, Priceable, Timeable {

	private Business business;

	private String title;

	private BusinessItemType type;

	@Override
	public Business getBusiness() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public String getText() {
		return null;
	}

	@Override
	public void setBusiness(Business business) {

	}

	@Override
	public void setTitle(String title) {

	}

	@Override
	public void setText(String text) {

	}

	@Override
	public GeoPoint getPoint() {
		return null;
	}

	@Override
	public void setPoint(GeoPoint point) {

	}

	@Override
	public Float getPrice() {
		return null;
	}

	@Override
	public void setPrice(Float price) {

	}

	@Override
	public Date getStart() {
		return null;
	}

	@Override
	public Date getEnd() {
		return null;
	}

	@Override
	public void setStart(Date start) {

	}

	@Override
	public void setEnd(Date end) {

	}
}
