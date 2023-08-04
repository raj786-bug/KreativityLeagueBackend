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
	private final String ACCOUNT_SID ="AC41800ed0d29510bac485afbdcb9d53b4";

    private final String AUTH_TOKEN = "b4d93396e1eb3290a56359a6235a1299";

    private final String FROM_NUMBER = "+13187502981";
    
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
