package com.example.jmsconnect;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"partA","partB"})
@XmlRootElement(name = "mypojo")
public class MyPojoXml {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String partA;
	
	String partB;
	
	public MyPojoXml(String partA, String partB){
		this.partA = partA;
		this.partB = partB;
	}
	
	public MyPojoXml(){}

	public String getPartA() {
		return partA;
	}

	public void setPartA(String partA) {
		this.partA = partA;
	}

	public String getPartB() {
		return partB;
	}

	public void setPartB(String partB) {
		this.partB = partB;
	}
}
