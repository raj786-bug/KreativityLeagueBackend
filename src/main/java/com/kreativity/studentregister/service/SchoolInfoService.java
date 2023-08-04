package com.kreativity.studentregister.service;

import java.io.IOException;
import java.io.InputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kreativity.studentregister.entity.SchoolInfo;
import com.kreativity.studentregister.repo.SchoolInfoRepo;

@Service
public class SchoolInfoService {
	@Autowired
	private SchoolInfoRepo schoolInfoRepo;

	public void importExcelData(InputStream inputStream) throws IOException {
		Workbook workbook;
		
		// If the file is encrypted, provide the password to decrypt it
		workbook = new XSSFWorkbook(inputStream);

		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		for (Row row : sheet) {
			// Assuming the first column contains the name and the second column contains
			// the age
			String studentName = row.getCell(0).getStringCellValue();
			String DOB = row.getCell(1).getStringCellValue();
			String Email = row.getCell(2).getStringCellValue();
			String SchoolName = row.getCell(3).getStringCellValue();
			String WhatsappNumber =  row.getCell(3).getStringCellValue();

			SchoolInfo schoolInfo = new SchoolInfo();
			schoolInfo.setStudentName(studentName);
			schoolInfo.setDob(DOB);
			schoolInfo.setEmail(Email);
			schoolInfo.setSchoolName(SchoolName);
			schoolInfo.setWhatsappNumber(WhatsappNumber);

			schoolInfoRepo.save(schoolInfo);
		}

		workbook.close();
	}

}
