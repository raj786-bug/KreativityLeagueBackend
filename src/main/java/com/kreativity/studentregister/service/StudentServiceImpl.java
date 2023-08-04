package com.kreativity.studentregister.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kreativity.studentregister.entity.Student;
import com.kreativity.studentregister.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
    private StudentRepo studentRepo;
	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
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
		studentRepo.deleteById(stdId);
	}

}
