package com.cms.dto;

public class EnrollCourseDTO {
	private long id;
	private long courseId;
	private String courseName;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EnrollCourseDTO(long id, long courseId, String courseName) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
	}

	public EnrollCourseDTO() {
		// TODO Auto-generated constructor stub
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	
	
	

}
