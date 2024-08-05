package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import com.cms.entity.Course;


@Component
public interface CourseRepository  extends JpaRepository<Course,Long>{

}
