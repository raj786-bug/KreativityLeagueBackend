package com.kreativity.studentregister.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kreativity.studentregister.entity.School;

import com.kreativity.studentregister.repo.SchoolRepo;

@Service
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolRepo schoolRepo;
	@Override
	public School createSchool(School school) {
		// TODO Auto-generated method stub
		return schoolRepo.save(school);
	}

	@Override
	public School getSchoolById(Integer tId) {
		// TODO Auto-generated method stub
		 Optional<School> school = schoolRepo.findById(tId);
		return school.orElse(null);
	}

	@Override
	public List<School> getAllSchool() {
		// TODO Auto-generated method stub
		return schoolRepo.findAll();
	}

	@Override
	public void deleteSchool(Integer tId) {
		// TODO Auto-generated method stub
		schoolRepo.deleteById(tId);
	}

	@Override
	public List<School> getAllSchools() {
		// TODO Auto-generated method stub
		return schoolRepo.findAll();
	}

	

}
