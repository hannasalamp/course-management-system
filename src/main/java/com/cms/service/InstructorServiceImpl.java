package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.customeexception.InstructorNotFound;
import com.cms.entity.Instructor;
import com.cms.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{
	@Autowired
	InstructorRepository instructorRepo;

//	logic for creating a new Instructor
	@Override
	public Instructor CreateInstructor(Instructor instr) {
		
		return instructorRepo.save(instr);
	}
	
	
// logic for updating the existing Instructor
	@Override
	public Instructor updateInstructor(Long instructorId, Instructor instructorDetails) {
		 Instructor instructor = instructorRepo.findById(instructorId)
	        		.orElseThrow(() -> new InstructorNotFound("Instructor not found for this id : " + instructorId));
	        instructor.setFirstName(instructorDetails.getFirstName());
	        instructor.setLastName(instructorDetails.getLastName());
	        instructor.setEmail(instructorDetails.getEmail());
	        return instructorRepo.save(instructor);
	
	}

//	logic for fetching the instructor by using id
	@Override
	public Instructor fetchInstructor(Long instructorId) {
		
		return instructorRepo.findById(instructorId)
				.orElseThrow(() -> new InstructorNotFound("Instructor not found for this id : " + instructorId));
		
	}

//	logic for fetching all instructor
	@Override
	public List<Instructor> fetchAllInstructors() {
	
		return instructorRepo.findAll();
	}

}
