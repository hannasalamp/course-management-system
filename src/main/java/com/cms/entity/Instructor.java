package com.cms.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

//
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Instructor {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long instructorId;
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String email;
	@OneToOne(mappedBy="instructor")
	@JsonIgnore
	private Course course;
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Instructor(long instructorId, String firstName, String lastName, String email, Course course) {
		super();
		this.instructorId = instructorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.course = course;
	}

	public long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	

}
