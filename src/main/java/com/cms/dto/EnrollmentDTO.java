package com.cms.dto;

import java.time.LocalDate;

public class EnrollmentDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
	public EnrollmentDTO(Long id, Long studentId, Long courseId, LocalDate enrollmentDate) {
		this.id = id;
		this.studentId = studentId;
		this.courseId = courseId;
	}
	
	public EnrollmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	


}
