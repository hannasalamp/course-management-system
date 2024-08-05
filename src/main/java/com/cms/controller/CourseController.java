package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.CourseDTO;
import com.cms.entity.Course;
import com.cms.entity.Instructor;
import com.cms.service.CourseService;
import com.cms.service.InstructorService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired 
	CourseService courseService;
//	method handles POST requests to create a new Course
	 @PostMapping("/create")
	    public ResponseEntity<String> createCourse(@RequestBody CourseDTO courseDTO) {
	        CourseDTO createdCourse = courseService.createCourse(courseDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Course created successfully");
	    }
	
//		method handles PUT requests to update course	
	 @PutMapping("update/{id}")
	    public ResponseEntity<String> updateCourse(@PathVariable long id, @RequestBody CourseDTO courseDTO) {
	        CourseDTO updatedCourse = courseService.updateCourse(id, courseDTO);
	        if (updatedCourse == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.status(HttpStatus.CREATED).body("Course updated successfully");
	    }
	 
//		method handles GET requests to fetch a  Student by using Id
	 @GetMapping("/{id}")
	    public ResponseEntity<CourseDTO> getCourseById(@PathVariable long id) {
	        CourseDTO course = courseService.getCourseById(id);
	        if (course == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(course);
	    }
	 
//		method handles GET requests to fetch all course 
	 @GetMapping
	    public List<CourseDTO> getAllCourses() {
	        return courseService.getAllCourses();
	    }
	

}
