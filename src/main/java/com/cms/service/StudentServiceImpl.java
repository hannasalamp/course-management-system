package com.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import com.cms.customeexception.NullParameterException;
import com.cms.customeexception.StudentNotFound;
import com.cms.entity.Student;
import com.cms.repository.EnrollmentRepository;
import com.cms.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	EnrollmentRepository enrollmentRepo;

//	Logic for create a new student
	@Override
	public Student CreateStudent(Student s) {

		try {
			Student student=studentRepo.save(s);
			return student;	
		}
		catch(Exception e) {
			throw new NullParameterException("student first name cannot be null ");
		}
	}
	
//logic for update the existing student
	@Override
	public Student updateStudent(Long studentId, Student studentDetails)  {
		        Student student = studentRepo.findById(studentId)
		        		.orElseThrow(() -> new StudentNotFound("Student not found for this id : " + studentId));
		        student.setFirstName(studentDetails.getFirstName());
		        student.setLastName(studentDetails.getLastName());
		        student.setEmail(studentDetails.getEmail());
		        return studentRepo.save(student);
		    }
	
// logic for fetch the existing student by using student id
	@Override
	public Student fetchStudentById(Long studentId) {
		return studentRepo.findById(studentId)
				 .orElseThrow(() -> new StudentNotFound("Student not found for this id : " + studentId));
	}

	 
// logic for fetch all students
	public List<Student> fetchAllStudents() {
        return studentRepo.findAll();
    }

	@Override
	@Transactional
	public void deleteStudent(Long studentId) {
		enrollmentRepo.deleteByStudentId(studentId);
		
		studentRepo.deleteById(studentId);	
	}
	
	
	}
	
   


