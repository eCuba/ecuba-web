package com.ecuba.domain;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;
import org.springframework.data.solr.repository.Facet;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;

/**
 * Created by rolando on 2014-08-27.
 */

@SolrDocument(solrCoreName = "collection1")
public class FoodMenuItem extends PersistentObject<String> implements BusinessItem, Priceable, GeoLocated {

	private Float price;
	private GeoPoint point;
	private Business business;


	public FoodMenuItem() {

	}

	@Override
	public GeoPoint getPoint() {
		return point;
	}

	@Override
	public void setPoint(GeoPoint point) {
		this.point = point;
	}

	@Override
	public Float getPrice() {
		return price;
	}

	@Override
	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public Business getBusiness() {
		return business;
	}

	@Override
	public String getTitle() {
		return label;
	}

	@Override
	public String getText() {
		return description;
	}

	@Override
	public void setBusiness(Business business) {
		this.business = business;
	}

	@Override
	public void setTitle(String title) {
		this.label = title;
	}

	@Override
	public void setText(String text) {
		this.description = text;
	}
}
