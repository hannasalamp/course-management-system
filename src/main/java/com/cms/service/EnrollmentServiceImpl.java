package com.cms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.customeexception.CourseNotFoundException;
import com.cms.customeexception.StudentNotFound;
import com.cms.dto.EnrollCourseDTO;
import com.cms.dto.EnrollStudentDTO;
import com.cms.dto.EnrollmentDTO;
import com.cms.entity.Course;
import com.cms.entity.Enrollment;
import com.cms.entity.Student;
import com.cms.repository.CourseRepository;
import com.cms.repository.EnrollmentRepository;
import com.cms.repository.StudentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{

	@Autowired
    private EnrollmentRepository enrollmentRepository;
	
	 @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public EnrollmentDTO enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFound("Student not found with id " + studentId));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id " + courseId));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return mapToEnrollmentDTO(savedEnrollment);
    }
    
    
    private EnrollmentDTO mapToEnrollmentDTO(Enrollment enrollment) {
        EnrollmentDTO enrollmentDTO = new EnrollmentDTO();
        enrollmentDTO.setId(enrollment.getId());
        enrollmentDTO.setStudentId(enrollment.getStudent().getStudentId());
        enrollmentDTO.setCourseId(enrollment.getCourse().getCourseId());
        return enrollmentDTO;
    }


    @Override
    public List<EnrollCourseDTO> getEnrollmentsByStudentId(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId); 
        return enrollments.stream().map(enrollment -> {
            EnrollCourseDTO dto = new EnrollCourseDTO();
            dto.setId(enrollment.getId());
            dto.setCourseId(enrollment.getCourse().getCourseId());
            dto.setCourseName(enrollment.getCourse().getCourseName());
            return dto;
        }).collect(Collectors.toList());
    }


	@Override
	public List<EnrollStudentDTO> getEnrollmentsByCourseId(Long courseId) {
		List<Enrollment> enrollments=enrollmentRepository.findByCourseId(courseId);
		return enrollments.stream().map(enrollment -> {
            EnrollStudentDTO dto = new EnrollStudentDTO();
            dto.setId(enrollment.getId());
            dto.setStudentId(enrollment.getStudent().getStudentId());
            dto.setStudentName(enrollment.getStudent().getFirstName());
            return dto;
        }).collect(Collectors.toList());
	}
    
	
	
}
