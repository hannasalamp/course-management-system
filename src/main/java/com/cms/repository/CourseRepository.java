package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.Course;



public interface CourseRepository  extends JpaRepository<Course,Long>{

}
