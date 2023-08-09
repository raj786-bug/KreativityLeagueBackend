package com.kreativity.studentregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kreativity.studentregister.entity.Student;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Integer>{

	Optional<Student> findByEmail(String email);
    Optional<Student> findByEmailAndPassword(String email, String password);

}
