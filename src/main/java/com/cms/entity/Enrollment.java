package com.cms.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
//
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
//import jakarta.persistence.Index;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//@Setter
//@Getter
//@AllArgsConstructor
@Entity
public class Enrollment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
    
    private LocalDate enrollmentDate;

	

	public Enrollment(Long id, Student student, Course course, LocalDate enrollmentDate) {
		this.id = id;
		this.student = student;
		this.course = course;
		this.enrollmentDate = enrollmentDate;
	}

	public Enrollment() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	


	
	

    
	    
	    
	    

}
