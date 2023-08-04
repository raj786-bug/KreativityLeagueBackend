package com.kreativity.studentregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kreativity.studentregister.entity.SchoolInfo;

public interface SchoolInfoRepo extends JpaRepository<SchoolInfo,Integer>{

}
