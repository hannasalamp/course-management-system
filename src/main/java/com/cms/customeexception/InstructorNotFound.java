package com.cms.customeexception;

public class InstructorNotFound extends RuntimeException{
	public InstructorNotFound(String msg) {
		super(msg);
	}

}
