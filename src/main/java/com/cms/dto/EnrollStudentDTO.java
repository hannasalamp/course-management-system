package com.cms.dto;

public class EnrollStudentDTO {
	private long id;
	private long studentId;
	private String StudentName;
	
	public EnrollStudentDTO(long id, long studentId, String studentName) {
		this.id = id;
		this.studentId = studentId;
		StudentName = studentName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public EnrollStudentDTO() {
		// TODO Auto-generated constructor stub
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	

}
