package main.handler;

public class Main {
	
	public static void  main(String args[]) {
		
		Socket socket = new Socket();
		socket.connectClient();
		socket.subscribeTopic("SUBHAJIT");
		
		
		//Beginner1 bg = new Beginner1();
		//bg.sendMessage("sender_id", "Hello world");// Sending a message
	}

}
