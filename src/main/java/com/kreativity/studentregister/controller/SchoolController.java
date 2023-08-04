package com.kreativity.studentregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kreativity.studentregister.entity.School;

import com.kreativity.studentregister.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	 private SchoolService schoolService;
	 @CrossOrigin
	 @PostMapping("/send")
	    public ResponseEntity<School> createSchool(@RequestBody School school) {
	        School createdSchool = schoolService.createSchool(school);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdSchool);
	    }
	 @CrossOrigin
	 @GetMapping("/{id}")
	    public ResponseEntity<School> getSchoolById(@PathVariable Integer tId) {
	        School school = schoolService.getSchoolById(tId);
	        if (school != null) {
	            return ResponseEntity.ok(school);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<School>> getAllSchools() {
	        List<School> schools = schoolService.getAllSchools();
	        return ResponseEntity.ok(schools);
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Integer tId) {
	        schoolService.deleteSchool(tId);
	        return ResponseEntity.noContent().build();
	    }

}
