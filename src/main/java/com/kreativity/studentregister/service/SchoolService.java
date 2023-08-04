package com.kreativity.studentregister.service;

import java.util.List;

import com.kreativity.studentregister.entity.School;




public interface SchoolService {
	public School createSchool(School school);
	public School getSchoolById(Integer tId);
	public List<School> getAllSchool();
	public void deleteSchool(Integer tId);
	public List<School> getAllSchools();
}
