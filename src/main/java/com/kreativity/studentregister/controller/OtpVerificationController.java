package com.kreativity.studentregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.kreativity.studentregister.entity.OtpResponse;
import com.kreativity.studentregister.entity.TempOtp;
import com.kreativity.studentregister.service.OtpVerificationService;

@RestController
public class OtpVerificationController {
	@Autowired
	private OtpVerificationService otpVerificationService;
	@CrossOrigin
	@PostMapping("/otp")
	public ResponseEntity<OtpResponse> verifyOtp(@RequestBody TempOtp sms) {
		if(sms.getOtp()==otpVerificationService.getOtp(sms.getto())) {
			otpVerificationService.clearOtp(sms.getto());
			System.out.println("Correct OTP");
            OtpResponse response = new OtpResponse(true, "Correct OTP");
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		}
		else {
			System.out.println("Incorrect OTP");
            OtpResponse response = new OtpResponse(false, "Incorrect OTP");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		
		
	}
	

}
