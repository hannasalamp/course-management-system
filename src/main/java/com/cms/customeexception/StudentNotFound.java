package com.cms.customeexception;

public class StudentNotFound extends RuntimeException{
	public StudentNotFound(String msg) {
		super(msg);
	}

}
