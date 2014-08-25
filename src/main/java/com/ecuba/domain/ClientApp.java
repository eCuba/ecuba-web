package com.ecuba.domain;

/**
 * Created by rolando on 2014-08-22.
 */
public class ClientApp extends PersistentObject<String> {
	private String clientId;
	private String clientSecret;

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientSecret() {
		return clientSecret;
	}
}
