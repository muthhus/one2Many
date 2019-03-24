package org.telekomatrix.data.service.Simple.data.Service.domain;

public enum RequestSourceType {
	HTTP("HTTP"),
	SSL("SSL"),
	TCP("TCP"),
	UDP("UDP");
	
	private final String requestSourceType;
	
	private RequestSourceType(final String requestSourceType) {
		this.requestSourceType = requestSourceType;
	}
	
	private String getRequestSourceType() {
		return requestSourceType;
	}
	
}
