package main.handler;

import org.eclipse.paho.client.mqttv3.MqttException;

import common.socket.messanger.PubSub;
import common.socket.messanger.PubSubConsoleDummy;

/*
 * You can send & receive message through this app
 */
public class Beginner1 {
	
	public PubSub ps = null;
	
	public Beginner1() {
		/*
		 * To receive data over socket, keep bellow line uncomment
		 */
		this.ps = new PubSub(this,"subhojit");//------------I am listing in this Id
		System.out.println("TRANSACTION ID IN MAIN : " + this.ps);
		/*
		 * To test through console-uncomment bellow line and comment above line---[Dummy input]---------------
		 */
		new PubSubConsoleDummy(this);

	}
	
	public void handleMessage(String json) {
		System.out.println("Message Received: "+json);
		//handle this message from here
		
		sendMessage("pijus","Hello");
		
	}
	public void sendMessage(String senderId,String message) {
		try {
			ps.sendMessage(message, senderId);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
