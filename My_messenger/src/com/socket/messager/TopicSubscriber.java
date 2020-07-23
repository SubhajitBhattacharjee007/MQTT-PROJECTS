package com.socket.messager;

import java.util.Random;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.socket.main.TowerMain;

public class TopicSubscriber implements MqttCallback{
	
	
	
	String topic        = "mafft";
    int qos             =  2;
    String broker       = "tcp://mqtt.eclipse.org:1883";
    String clientId     = "JavaSample123" + new Random().nextInt();

    
    MqttClient client;
    ReceivedMessage rm = new ReceivedMessage();
    
    private TowerMain tw= null;
    public TopicSubscriber(TowerMain tw, String topic) {
    	
    	this.tw = tw;
		this.connectClient();
		this.subscribeTopic(topic);
		System.out.println("TopicSubscriber Transaction ID : " + tw);
    }
	
    
	//Connecting to client --------
    public void connectClient()
    {
    	 MemoryPersistence persistence = new MemoryPersistence();

         MqttConnectOptions conOpt = new MqttConnectOptions();
         conOpt.setCleanSession(true);
         try {
 			this.client = new MqttClient(broker, clientId, persistence);
 			System.out.println("ClientId : " + clientId);
 			this.client.setCallback(this);
 			System.out.println("Connecting client ...");
 			while(!client.isConnected()) {
 				client.connect(conOpt);
 				System.out.println("...");
 			}
 			System.out.println("Client Connected!");
 		} catch (MqttException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    }
    
    //Subscribing in Topic -------
    public void subscribeTopic(String topic) {
    	try {
    		this.topic = topic;
    		System.out.println("topic : " + topic +"|| qos : "+qos);
			client.subscribe(topic, qos);
		} catch (MqttException e) {
		
			e.printStackTrace();
		}
    }
    
    public void sendMessage(String payload,String topic) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        System.out.println("Message : "+message +"|| qos : "+qos + "|| topic : "+topic);
        message.setQos(qos);
        this.client.publish(topic, message); // Blocking publish
    }
	
	@Override
	public void connectionLost(Throwable arg0) {
		System.out.println("Connection lost because: " + arg0);
		 // System.exit(1);
			connectClient();
			subscribeTopic(topic);
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		System.out.println("Message Delivered : " + arg0);
		
	}

	
	@Override
	public void messageArrived(String arg0, MqttMessage message) throws Exception {
		System.out.println("testing output : " + message);
		rm.handleMessage(new String(message.getPayload()), this.tw);;
	}

	
	
}
