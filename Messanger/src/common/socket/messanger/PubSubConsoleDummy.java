package common.socket.messanger;


import java.util.Scanner;

import main.handler.Beginner1;

public class PubSubConsoleDummy {
	Beginner1 hs = null;
    public PubSubConsoleDummy(Beginner1 hs) {

    	this.hs = hs;
    	System.out.println("TRANSACTION ID IN PubSubConsoleDummy : " + hs);
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNextLine()) {
    		String json = sc.nextLine();
    		if(json.equals("end")) {
    			System.out.println("Good bye sir!");
    			break;
    		}
    		if(json!=null && !json.isEmpty())
    			hs.sendMessage("SUBHAJIT22", json);//handleMessage(json);
    	}
    	sc.close();
	}

    
}
