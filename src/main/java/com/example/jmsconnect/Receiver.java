package com.example.jmsconnect;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

   @JmsListener(destination = "fooqueue", containerFactory = "myFactory")
    public void receiveMessage(MyPojo myPojo) {
        System.out.println("Received: " + myPojo.partA + ", " +myPojo.partB);
    }
}
