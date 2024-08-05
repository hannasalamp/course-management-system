package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.EnrollmentDTO;
import com.cms.entity.Enrollment;
import com.cms.service.EnrollmentService;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
	@Autowired
	private EnrollmentService enrollmentService;
	
//	method handles POST requests to Enrolling a student in a course.
	
	@PostMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<EnrollmentDTO> enrollStudentInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        EnrollmentDTO enrollmentDTO = enrollmentService.enrollStudentInCourse(studentId, courseId);
        return ResponseEntity.ok(enrollmentDTO);
    }

//method handles GET request to Fetching all courses a student is enrolled in.
	
	@GetMapping("/students/{studentId}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        List<EnrollmentDTO> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return ResponseEntity.ok(enrollments);
    }
	
//method handles GET request to  Fetching all students enrolled in a course
	
	 @GetMapping("/courses/{courseId}")
	    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByCourseId(@PathVariable Long courseId) {
	        List<EnrollmentDTO> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
	        return ResponseEntity.ok(enrollments);
	    }
	


}
