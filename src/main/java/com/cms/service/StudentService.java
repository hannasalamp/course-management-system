package com.cms.service;

import java.util.List;
import java.util.Optional;

import com.cms.entity.Student;

public interface StudentService {

	Student CreateStudent(Student s);

	Student updateStudent(Long studentId, Student studentDetails);

	Student fetchStudentById(Long studentId);

	List<Student> fetchAllStudents();

	

}
