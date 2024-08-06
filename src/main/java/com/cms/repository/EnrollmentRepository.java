package com.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cms.entity.Enrollment;

import jakarta.transaction.Transactional;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{

	@Query("SELECT e FROM Enrollment e WHERE e.student.id = :studentId")
	List<Enrollment> findByStudentId(@Param("studentId") Long studentId);
	
    @Query("SELECT e FROM Enrollment e WHERE e.course.id= :courseId")
	List<Enrollment> findByCourseId(@Param("courseId") Long courseId);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Enrollment e WHERE e.student.id = :studentId")
    void deleteByStudentId(@Param("studentId") Long studentId);

	
	
 
}
