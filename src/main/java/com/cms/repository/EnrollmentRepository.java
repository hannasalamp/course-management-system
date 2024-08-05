package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{

	//List<Enrollment> findByStudentId(Long studentId);
	
	
 
}
