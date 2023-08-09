package com.kreativity.studentregister.controller;


import java.util.List;


import com.kreativity.studentregister.dto.LoginDto;
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

import com.kreativity.studentregister.entity.Student;
import com.kreativity.studentregister.service.StudentService;



@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
	 @Autowired
	 private StudentService studentService;
	 @CrossOrigin
	 @PostMapping("/std")
	    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	        Student createdStudent = studentService.createStudent(student);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	    }
	 @CrossOrigin
	 @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable Integer stdId) {
	        Student student = studentService.getStudentById(stdId);
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<Student>> getAllStudents() {
	        List<Student> students = studentService.getAllStudents();
	        return ResponseEntity.ok(students);
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Integer stdId) {
	        studentService.deleteStudent(stdId);
	        return ResponseEntity.noContent().build();
	    }
	    @CrossOrigin
		@PostMapping("/login")
		public ResponseEntity<?> login(@RequestBody LoginDto student) throws Exception {
		 return studentService.login(student);
		}

}
