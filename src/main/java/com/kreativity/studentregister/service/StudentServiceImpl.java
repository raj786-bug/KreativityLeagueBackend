package com.kreativity.studentregister.service;

import java.util.List;
import java.util.Optional;

import com.kreativity.studentregister.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kreativity.studentregister.entity.LoginResponse;
import com.kreativity.studentregister.entity.OtpResponse;
import com.kreativity.studentregister.entity.Student;
import com.kreativity.studentregister.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
    private StudentRepo studentRepo;
	@Override
	public Student createStudent(Student student) {
		Student alreadyStudent = studentRepo.findByEmail(student.getEmail()).orElse(null);
		if (alreadyStudent==null) {
			// TODO Auto-generated method stub
			return studentRepo.save(student);
		}else
			return null;
	}

	@Override
	public Student getStudentById(Integer stdId) {
		// TODO Auto-generated method stub
		 Optional<Student> student = studentRepo.findById(stdId);
	        return student.orElse(null);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	

	@Override
	public void deleteStudent(Integer stdId) {
		// TODO Auto-generated method stub

	}

	public ResponseEntity<?> login(LoginDto student){
		Student data = studentRepo.findByEmailAndPassword(student.getEmail(),student.getPassword()).orElse(null);
		System.out.println(data+" DATA VALUES .");
		if (data!=null) {
			LoginResponse response=new LoginResponse(true,"Login Successfull");
			return ResponseEntity.ok().body(response);
		}
		else  {
			LoginResponse response=new LoginResponse(false,"Login Unsuccessfull");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}
	}
	
	
}
