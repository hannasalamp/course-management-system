package com.cms.entity;
import jakarta.persistence.CascadeType;
//
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Index;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//@Setter
//@Getter
//@AllArgsConstructor
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  long courseId;
	private String courseName;
	private String courseDescription;
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_Id",referencedColumnName="instructorId")
	private Instructor instructor;
	public Course() {
		super();
		
	}
	public Course(long courseId, String courseName, String courseDescription, Instructor instructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.instructor = instructor;
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
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	
	
	
	

}
