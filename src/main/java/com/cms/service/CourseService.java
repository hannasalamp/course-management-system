package com.cms.service;

import java.util.List;

import com.cms.dto.CourseDTO;
import com.cms.entity.Course;

public interface CourseService {

	CourseDTO createCourse(CourseDTO courseDTO);

	CourseDTO updateCourse(long id, CourseDTO courseDTO);

	CourseDTO getCourseById(long id);

	List<CourseDTO> getAllCourses();

	

}
