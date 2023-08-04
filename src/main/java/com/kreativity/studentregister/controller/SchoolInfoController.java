package com.kreativity.studentregister.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kreativity.studentregister.entity.ExcelResponse;
import com.kreativity.studentregister.service.SchoolInfoService;

@RestController
@RequestMapping("/schoolInfo")
public class SchoolInfoController {
	@Autowired
	private SchoolInfoService schoolInfoService;
	@CrossOrigin
	@PostMapping("/import-excel")
	public ResponseEntity<Object> importExcelData(@RequestParam("file") MultipartFile file) {
        try {
            schoolInfoService.importExcelData(file.getInputStream());
            return ResponseEntity.ok().body(new ExcelResponse(true, "Excel data imported successfully."));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(new ExcelResponse(false, "Failed to import Excel data."));
        }
    }

}
