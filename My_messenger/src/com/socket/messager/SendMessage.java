package com.socket.messager;

import org.eclipse.paho.client.mqttv3.MqttException;

import com.socket.main.TowerMain;

public class SendMessage {
	
	
	TowerMain tw =  null;
	String message = null;
	String topic = null;
	
	
	public SendMessage(TowerMain tw) {
		
		this.tw = tw;
		
	}
	public void send(String message, String topic) throws MqttException {
		tw.sendMessage(message, topic);
		
		
	}
	
	
}
