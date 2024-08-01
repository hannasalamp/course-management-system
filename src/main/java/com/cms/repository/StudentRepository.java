package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>
{
 
}
