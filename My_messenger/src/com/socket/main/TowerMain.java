package com.socket.main;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.socket.messager.ReceivedMessage;
import com.socket.messager.TopicSubscriber;

public class TowerMain {
	
	TopicSubscriber ts = null;
	
	public TowerMain() {
		
		this.ts = new TopicSubscriber(this, "maftt");
		//new ReceivedMessage(this);
	}
	
	public void sendMessage(String senderId,String message) {
		try {
			ts.sendMessage(message, senderId);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void  main(String args[]) {

		TowerMain towermain = new TowerMain();

	
	}
	

}
