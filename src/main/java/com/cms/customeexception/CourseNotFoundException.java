package com.cms.customeexception;

public class CourseNotFoundException extends RuntimeException{
	public CourseNotFoundException(String msg) {
		super(msg);
	}

}
