package com.cms.dto;

public class CourseDTO {
	private  long courseId;
	private  String courseName;
	private String courseDescription;
	private long instructorId;
	public CourseDTO(long courseId, String courseName, String courseDescription, long instructorId) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.instructorId = instructorId;
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
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}
	
	
	
	

}
