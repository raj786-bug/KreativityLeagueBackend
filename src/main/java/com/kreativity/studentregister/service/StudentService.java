package com.kreativity.studentregister.service;

import java.util.List;

import com.kreativity.studentregister.entity.Student;

public interface StudentService {
	
	public Student createStudent(Student student);
	public Student getStudentById(Integer stdId);
	public List<Student> getAllStudents();
	
	public void deleteStudent(Integer stdId);

}
