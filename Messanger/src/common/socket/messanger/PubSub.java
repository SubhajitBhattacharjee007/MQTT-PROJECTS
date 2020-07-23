package common.socket.messanger;


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import main.handler.Beginner1;


public class PubSub implements MqttCallback {

	String topic        = "mafft";
    int qos             = 2;
    String broker       = "tcp://mqtt.eclipse.org:1883";
    String clientId     = "JavaSample123";
    MqttClient client;
    
    private Beginner1 hs = null;
    
    public PubSub(Beginner1 hs,String topic) {
    	this.hs = hs;
    	this.connectClient();
		this.subscribeTopic(topic);
		System.out.println("TRANSACTION ID IN PubSub : " + hs);
	}

    
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
	
    public void sendMessage(String payload,String topic) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println(String.format("[%s] %s", topic, new String(message.getPayload())));
		hs.handleMessage(new String(message.getPayload()));
	}

}
