package com.accenture.webinarJava8;

public class InterfaceDeaultMethods implements Dog {
	
	public double obtenerTemperatura() {
		return 25.0;
	}
	
	public static void main(String args[]) {
		InterfaceDeaultMethods interfaceDeaultMethods = new InterfaceDeaultMethods();
		System.out.println("Temperatura: " + interfaceDeaultMethods.obtenerTemperatura());
		System.out.println("Raza: " + interfaceDeaultMethods.obtenerRazaPerro());
		System.out.println("Altura: " + interfaceDeaultMethods.obtenerAltura());
	}
}

interface Can {
	double obtenerAltura();

	public default double obtenerTemperatura() {
		return 10.0;
	}
}

interface Dog extends Can {
	public default String obtenerRazaPerro() {
		return "Raza default";
	}
	
	public double obtenerTemperatura();
	
	public default double obtenerAltura() {
		return 50.0;
	}
}

// Sobreescribirlo en Interfaz
// Sobreescribirlo en Clase
// Cambiar de default a abstract
// Cambiar de abstract a default.
