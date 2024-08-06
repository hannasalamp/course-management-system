package com.cms.service;

import java.util.List;

import com.cms.entity.Instructor;

public interface InstructorService {

	Instructor CreateInstructor(Instructor instr);

	Instructor updateInstructor(Long instructorId, Instructor instructorDetails);

	Instructor fetchInstructor(Long instructorId);

	List<Instructor> fetchAllInstructors();

	//void deleteInstructor(Long instructorId);

}
