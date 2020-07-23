package main.handler;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Socket implements MqttCallback{

	String topic        = "mafft";
    int qos             = 2;
    String broker       = "tcp://mqtt.eclipse.org:1883";
    String clientId     = "JavaSample123";
    MqttClient client;
	
    OperationHandler op = new OperationHandler();
    

	
	public void connectClient()
    {
    	 MemoryPersistence persistence = new MemoryPersistence();

         MqttConnectOptions conOpt = new MqttConnectOptions();
         conOpt.setCleanSession(true);
         try {
 			this.client = new MqttClient(broker, clientId, persistence);
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
	
	public void subscribeTopic(String topic) {
    	try {
    		this.topic = topic;
			client.subscribe(topic, qos);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String arg0, MqttMessage arg1) throws Exception {
		System.out.println("Message : " + arg1);
		op.HandleMessage(arg1.toString(), this);
		
	}
	
	public void sendMessage(String payload,String topic) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        message.setQos(qos);
        this.client.publish(topic, message); // Blocking publish
    }
	
	

}
