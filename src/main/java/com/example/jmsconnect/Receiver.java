package com.example.jmsconnect;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox2", containerFactory = "myFactory")
    public void receiveMessage(MyPojo myPojo) {
        System.out.println("Received <" + myPojo + ">");
    }
}
