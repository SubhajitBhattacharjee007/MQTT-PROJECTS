package com.socket.messager;


import com.google.gson.Gson;
import com.socket.bean.OtpBean;
import com.socket.bean.User;
import com.socket.main.TowerMain;
import com.socket.service.OtpGenerateServiceProvider;


public class ReceivedMessage {
	
	private TowerMain tw =null;
	

	//Empty constructor
	public ReceivedMessage() {
		
	}
	
	public void handleMessage(String message, TowerMain tw) {
		this.tw = tw;
		System.out.println("RECEIVED TRANSACTION ID2 : " + tw);
	
		Gson g = new Gson();
		OtpBean otpbean = g.fromJson(message, OtpBean.class);
		
	    System.out.println("Operator : " 		+ otpbean.getO());
	    System.out.println("Topic : " 			+ otpbean.getT());
	    System.out.println("Mobile Number : " 	+ otpbean.getM());
	    System.out.println("Password : " 		+ otpbean.getP());
	 
	    System.out.println("RECEIVED TRANSACTION ID : " + tw);
	    String Operator = otpbean.getO();
	    int Otp = 0;
	    
	    switch(Operator) {
	    	
	    	case "R": 
	    		
	    		// Registration 
	    		OtpGenerateServiceProvider otpGenerateServiceProvider = new OtpGenerateServiceProvider();
	    		Otp 	 		= otpGenerateServiceProvider.OtpGenerator();
	    		String topic 		= otpbean.getT();
	    		tw.sendMessage(topic, String.valueOf(Otp));
	    		break;
	        		
	       case "V": 
	    	   
	    	    //User Validation
	    	    System.out.println("User Validation : OTP || " + Otp);
	    	    
	    	    String valid = "{\"V\":\"F\"}";
	    	    tw.sendMessage(otpbean.getT(), valid);
	    	    
	    	    
	    	    break;
	    }
	  
	}

	
}
