package com.socket.service;

public class OtpGenerateServiceProvider {
	
	public int OtpGenerator() {
	int max = 10000;
	int min = 1000;
	int OTP = (int) (Math.random()*(max - min)+min);
	System.out.println("OTP Generated : " + OTP);
	return OTP;
	}
	
}
