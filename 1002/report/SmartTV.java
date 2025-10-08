package chapter5;

import chapter5.ColorTV;

public class SmartTV extends ColorTV {
	String ip;
	public SmartTV(String ip ,int size, int color) {
		super(size, color);
		this.ip = ip;
	}
	
	public void printProperty() {
		System.out.println("나의 SmartTV는 " + ip + " 주소의 " + super.getSize() + color + "컬러");
	}
	
	public static void main(String[] args) {
		SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000000);
		smartTV.printProperty();
	}
	
}
