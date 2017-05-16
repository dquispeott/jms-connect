package com.example.jmsconnect;

import java.io.Serializable;

public class MyPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String partA;
	
	String partB;
	
	public MyPojo(String partA, String partB){
		this.partA = partA;
		this.partB = partB;
	}
	
	public MyPojo(){}

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
