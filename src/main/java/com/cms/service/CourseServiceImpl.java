package com.cms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.customeexception.CourseNotFoundException;
import com.cms.customeexception.InstructorNotFound;
import com.cms.dto.CourseDTO;
import com.cms.entity.Course;
import com.cms.entity.Instructor;
import com.cms.repository.CourseRepository;
import com.cms.repository.InstructorRepository;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	InstructorRepository instructorRepository;

	@Override
	public CourseDTO createCourse(CourseDTO courseDTO) {
	    Course course = new Course();
	    course.setCourseName(courseDTO.getCourseName());
	    course.setCourseDescription(courseDTO.getCourseDescription());
	    Instructor instructor = instructorRepository.findById(courseDTO.getInstructorId()).orElseThrow(() -> new InstructorNotFound("Instructor not found "));
	    course.setInstructor(instructor);
	    course = courseRepository.save(course);
	    return convertToDTO(course);
	}
	  private CourseDTO convertToDTO(Course course) {
	        return new CourseDTO(
	            course.getCourseId(),
	            course.getCourseName(),
	            course.getCourseDescription(),
	            course.getInstructor().getInstructorId()
	        );
	    }
	  
	@Override
	public CourseDTO updateCourse(long id, CourseDTO courseDTO) {
		    Course course = courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course not found"));
	        course.setCourseName(courseDTO.getCourseName());
	        course.setCourseDescription(courseDTO.getCourseDescription());
	        Instructor instructor = instructorRepository.findById(courseDTO.getInstructorId()).orElseThrow(() -> new RuntimeException("Instructor not found"));
	        course.setInstructor(instructor);
	        course = courseRepository.save(course);
	        return convertToDTO(course);
	}
	@Override
	public CourseDTO getCourseById(long id) {
		 Optional<Course> course = courseRepository.findById(id);
	        return course.map(this::convertToDTO).orElse(null);
	}
	@Override
	public List<CourseDTO> getAllCourses() {
		
		 return courseRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    
	}





}
