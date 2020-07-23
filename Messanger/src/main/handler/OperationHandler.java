package main.handler;

import org.eclipse.paho.client.mqttv3.MqttException;

public class OperationHandler {
	
	
	public void HandleMessage(String message, Socket socket) {
		
		String msg = "123" + message;
		System.out.println("I GOT MSG : " + message);
		
		
		
		
		try {
			socket.sendMessage(msg, "PIJUS");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
