package com.kreativity.studentregister.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class OtpVerificationService {
	private static final Integer EXPIRE_MINS=10;
	
	private LoadingCache<String, Integer> otpCache;
	
	public OtpVerificationService() {
		super();
		otpCache=CacheBuilder.newBuilder().
				expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES).build(new CacheLoader<String,Integer>()
				{
			          public Integer load(String Key) {
			        	  return 0;
			          }
				});
	}
	// This method is used to push the otp number against key. Rewrite the otp if it exists 
	// using user id as key
	public int genrateOTP(String key) {
		Random random=new Random();
		int otp=100000+random.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	}
	
	// This method is used to return the OTP number against key-> Key Values is username
	public int getOtp(String key) {
		try {
			return otpCache.get(key);
		}
		catch (Exception e) {
			return 0;
		}
	}
	// this method is used to clear otp cached already
	public void clearOtp(String Key) {
		otpCache.invalidate(Key);
	}
	
}
