package com.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	
	String Message;

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [Message=" + Message + "]";
	}

	public HelloWorldBean(String message) {
		Message = message;
	}

	public String getMessage() {
		return Message;
	}
	
	
	

}
