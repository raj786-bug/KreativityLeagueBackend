package com.kreativity.studentregister.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService.Work;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/school")
public class TeacherFileDownload {

	    @CrossOrigin
		@GetMapping("/downloadExcel")
		    public void downloadExcel(HttpServletResponse response) throws IOException, GeneralSecurityException {
		        // Sample data for the Excel sheet
		        String[][] data = {
		            {"StudentName","DOB","Email","SchoolName","WhatsappNumber",},
		            
		            // Add more data as needed
		        };
		        
		     
	            

		        // Create the Excel workbook and sheet
		        Workbook workbook = new XSSFWorkbook();
		        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("School_Name");

		        // Create a fixed header row (first row)
		        Row headerRow = sheet.createRow(0);
		        CellStyle headerCellStyle = workbook.createCellStyle();
		        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		        
		        // Set the header values and style
		        for (int col = 0; col < data[0].length; col++) {
		        	Cell cell = headerRow.createCell(col);
		            cell.setCellValue(data[0][col]);
		            cell.setCellStyle(headerCellStyle);
		         // Apply data validation to make the cells in the header row read-only
		            DataValidationHelper validationHelper = sheet.getDataValidationHelper();
		            DataValidationConstraint validationConstraint = validationHelper.createCustomConstraint("1=0");
		            CellRangeAddressList cellRangeAddressList = new CellRangeAddressList(0, 0, col, col);
		            DataValidation dataValidation = validationHelper.createValidation(validationConstraint, cellRangeAddressList);
		            sheet.addValidationData(dataValidation);
		            
		        }

		        // Add data rows to the sheet
		        for (int rowIdx = 1; rowIdx < data.length; rowIdx++) {
		            Row row = sheet.createRow(rowIdx);
		            for (int colIdx = 0; colIdx < data[rowIdx].length; colIdx++) {
		                row.createCell(colIdx).setCellValue(data[rowIdx][colIdx]);
		            }
		        }
		        // Freeze the header row
		        sheet.createFreezePane(0, 1);
		     // Set workbook password
		        String password = "ableducation";
		        POIFSFileSystem fs = new POIFSFileSystem();
		        EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
		        Encryptor enc = info.getEncryptor();
		        enc.confirmPassword(password);
		        OutputStream os = enc.getDataStream(fs);

		        // Write the workbook data to the encrypted output stream
		        workbook.write(os);
		        os.close();
		       
		        // Set the response headers for downloading the Excel file
		        response.setContentType("application/octet-stream");
		        response.setHeader("Content-Disposition", "attachment; filename=school.xls");
		        
		     // Write the encrypted data to the response output stream
		        fs.writeFilesystem(response.getOutputStream());

		        // Write the workbook content to the response stream
		        workbook.write(response.getOutputStream());
		        workbook.close();
		        
		    }
		 
		 

}
