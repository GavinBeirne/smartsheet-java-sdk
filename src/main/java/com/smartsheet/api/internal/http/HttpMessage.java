package com.smartsheet.api.internal.http;

import java.util.Map;

/**
 * This is the base class of HTTP messages, it holds headers and an HttpEntity.
 * 
 * Thread Safety: This class is not thread safe since it's mutable.
 */
public abstract class HttpMessage {
	/**
	 * Represents the HTTP headers.
	 * 
	 * It has a pair of setter/getter (not shown on class diagram for brevity).
	 */
	private Map<String, String> headers;

	/**
	 * Represents the HTTP entity.
	 * 
	 * It has a pair of setter/getter (not shown on class diagram for brevity).
	 */
	private HttpEntity entity;
	
	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public HttpEntity getEntity() {
		return entity;
	}

	public void setEntity(HttpEntity entity) {
		this.entity = entity;
	}
}