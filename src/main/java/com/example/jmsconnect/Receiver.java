package com.example.jmsconnect;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

   @JmsListener(destination = "fooqueue", containerFactory = "myFactory")
    public void receiveMessage(MyPojo myPojo) {
        System.out.println("Received: " + myPojo.partA + ", " +myPojo.partB);
    }
   
   @JmsListener(destination = "fooqueuexml", containerFactory = "myFactory")
   public void receiveXmlMessage(String xmlString) {            
       try{           
           JAXBContext jc = JAXBContext.newInstance(String.class);
           Unmarshaller unmarshaller = jc.createUnmarshaller();
           StreamSource xmlSource = new StreamSource(new StringReader(xmlString));
           JAXBElement<String> je = unmarshaller.unmarshal(xmlSource, String.class);
           System.out.println("Received: " +je.getValue());
       }catch(JAXBException ex){
       	ex.printStackTrace();
       }
   }
}
