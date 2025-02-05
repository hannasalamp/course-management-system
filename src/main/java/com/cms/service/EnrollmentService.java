package com.cms.service;

import java.time.LocalDate;
import java.util.List;

import com.cms.dto.EnrollCourseDTO;
import com.cms.dto.EnrollStudentDTO;
import com.cms.dto.EnrollmentDTO;
import com.cms.entity.Course;
import com.cms.entity.Enrollment;
import com.cms.entity.Student;

public interface EnrollmentService {

	EnrollmentDTO enrollStudentInCourse(Long studentId, Long courseId);

	List<EnrollCourseDTO> getEnrollmentsByStudentId(Long studentId);

	List<EnrollStudentDTO> getEnrollmentsByCourseId(Long courseId);

	


	

}
