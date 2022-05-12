package com.example.demo.statusInfo;

import org.springframework.http.HttpStatus;

public class ErrorInfo {
	private int statuscode;
	private HttpStatus status;
	private String message;
	private String uri;
	private String httpMethod;

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public ErrorInfo(int statuscode, HttpStatus status, String message, String uri, String httpMethod) {
		super();
		this.statuscode = statuscode;
		this.status = status;
		this.message = message;
		this.uri = uri;
		this.httpMethod = httpMethod;
	}

	public ErrorInfo() {
	}

}
