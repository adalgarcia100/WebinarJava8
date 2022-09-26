package com.accenture.webinarJava8;

public class InterfaceDefaultMethodsMultipleInheritance implements Walk, Run {
	public static void main(String[] args) {
		System.out.println(new InterfaceDefaultMethodsMultipleInheritance().getSpeed());
	}

	public int getSpeed() {
		return Walk.super.getSpeed();
	}

//	public int getSpeed() {
//		return 1;
//	}
}

interface Walk {
	public default int getSpeed() {
		return 5;
	}
}

interface Run {
	public default int getSpeed() {
		return 10;
	}
}
