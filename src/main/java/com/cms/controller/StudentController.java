package com.cms.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Student;
import com.cms.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
//	method handles POST requests to create a new Student
	    @PostMapping(value="create")
	    public ResponseEntity<String> createStudent(@RequestBody Student student) {
	        Student createdStudent = studentService.CreateStudent(student);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Student created Successfully");
	    }
	    
//	method handles PUT request to update the student
	    @PutMapping(value="update/{studentId}")
	    public ResponseEntity<String> updateStudent(@PathVariable Long studentId, @RequestBody Student studentDetails) {
	        Student updatedStudent = studentService.updateStudent(studentId, studentDetails);
	        return ResponseEntity.status(HttpStatus.OK).body("Student updated successfully");
	    }
	    
//	 method handles GET request to fetch the student by using Id
	    @GetMapping(value="fetch/{studentId}")
	    public ResponseEntity<Student> fetchStudentById(@PathVariable Long studentId){
	    	Student fetchedStudent=studentService.fetchStudentById(studentId);
	    	return ResponseEntity.status(HttpStatus.OK).body(fetchedStudent) ;
	    }
	    
	    
//  method handles GET request to fetch all the students
	    @GetMapping(value="/fetchAll")
	    public ResponseEntity<List<Student>> fetchAllStudents () {
	        List<Student> students = studentService.fetchAllStudents();
	        return ResponseEntity.status(HttpStatus.OK).body(students);
	    }
	    
// method handles DELETE request to delete student by using id
	    @DeleteMapping(value="delete/{studentId}")
	    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) {
	        studentService.deleteStudent(studentId);
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Student deleted successfully");
	    }
	    
}
