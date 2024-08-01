package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {

}
