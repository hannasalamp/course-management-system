package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


import com.cms.entity.Course;

import jakarta.transaction.Transactional;


@Component
public interface CourseRepository  extends JpaRepository<Course,Long>{

//	@Modifying
//    @Transactional
//    @Query("UPDATE Course c SET c.instructor = NULL WHERE c.instructor.id = :instructorId")
//    void dissociateInstructor(@Param("instructorId")Long instructorId);

}
