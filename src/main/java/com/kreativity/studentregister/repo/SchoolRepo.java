package com.kreativity.studentregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kreativity.studentregister.entity.School;

public interface SchoolRepo extends JpaRepository<School,Integer>{

}
