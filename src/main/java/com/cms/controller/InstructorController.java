package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.entity.Instructor;
import com.cms.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorController<Instuctor> {
	@Autowired
	InstructorService instructorServ;
	
//	method handles POST requests to create a new Instructor
    @PostMapping(value="create")
    public ResponseEntity<String> createInstructor(@RequestBody Instructor instr) {
        Instructor createdInstructor = instructorServ.CreateInstructor(instr);
        return ResponseEntity.status(HttpStatus.CREATED).body("Instructor created successfully");
    }
    
    
// method handles PUT requests to update a Instructor 
    @PutMapping(value="update/{instructorId}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long instructorId,@RequestBody Instructor instructorDetails){
    	Instructor updatedInstructor=instructorServ.updateInstructor(instructorId, instructorDetails);
    	return ResponseEntity.status(HttpStatus.OK).body(updatedInstructor);
    }
    
    
// method handles GET requests to fetch Instructor by id
    @GetMapping(value="fetch/{instructorId}")
    public ResponseEntity<Instructor> fetchInstructor(@PathVariable Long instructorId){
    	Instructor fetchedInstructor=instructorServ.fetchInstructor(instructorId);
    	return ResponseEntity.status(HttpStatus.OK).body(fetchedInstructor);
    }
    
// method handles GET requests to fetch all Instructor
    @GetMapping
    public ResponseEntity<List<Instructor>> fetchAllInstructors(){
    	List<Instructor> instructors=instructorServ.fetchAllInstructors();
    	return ResponseEntity.status(HttpStatus.OK).body(instructors);
    }
    

}
