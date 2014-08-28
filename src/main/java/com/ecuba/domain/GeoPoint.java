package com.ecuba.domain;

/**
 * Created by rolando on 2014-08-27.
 */
public class GeoPoint extends PersistentObject<String> {

	private Double latitude;
	private Double longitude;

	public GeoPoint() {
	}


	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
