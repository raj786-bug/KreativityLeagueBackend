package com.kreativity.studentregister.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.twiml.Sms;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {
	private final String ACCOUNT_SID ="AC4c5863a7a9eeea530502d188df111452";
    private final String AUTH_TOKEN = "e0f88fd22a7325efef12e3747f52244c";

    private final String FROM_NUMBER = "+17755215828";
    
    @Autowired
    private OtpVerificationService otpVerificationService;

    public void send(Sms sms) throws ParseException {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    	
    	
    	int number=otpVerificationService.genrateOTP(sms.getTo());
    	
    	String msg="Your otp is:"+number+" please verify this otp in your application";
    	
    	Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), msg)
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }
}
