package com.kreativity.studentregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kreativity.studentregister.entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}
