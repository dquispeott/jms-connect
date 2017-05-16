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
		System.out.println("Received Pojo: " + myPojo.partA + ", " + myPojo.partB);
	}

	@JmsListener(destination = "fooqueuexml", containerFactory = "myFactory")
	public void receiveXmlMessage(String xmlString) {
		try {
			JAXBContext jc = JAXBContext.newInstance(String.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StreamSource xmlSource = new StreamSource(new StringReader(xmlString));
			JAXBElement<String> je = unmarshaller.unmarshal(xmlSource, String.class);
			System.out.println("Received string XML: " + je.getValue());
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}

	@JmsListener(destination = "fooqueuejaxb", containerFactory = "myFactory")
	public void receiveXmlMessageJaxb(String xmlString) {

		try {
			JAXBContext jc = JAXBContext.newInstance(MyPojoXml.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StreamSource xmlSource = new StreamSource(new StringReader(xmlString));
			JAXBElement<MyPojoXml> je = unmarshaller.unmarshal(xmlSource, MyPojoXml.class);
			System.out.println("Received JAXB: " + je.getValue().partA + ", " + je.getValue().partB);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}
	}
}
