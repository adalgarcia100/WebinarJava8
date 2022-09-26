package com.accenture.webinarJava8;

public class InterfaceStaticMethods {

}

//Ejemplo 1
interface Hop {
	
	int TEST = 1;
	
	static int getJumpHeight() {
		return 8;
	}
	
	static int getOtherHeight() {
		return getJumpHeight() + TEST;
	}
	
	default int testStaticWitinDefault() {
		return getJumpHeight() + 5;
	}
}

class Bunny implements Hop {
	public void printDetails() {
		Hop hop = new Bunny();
		System.out.println(Hop.getJumpHeight()); // No compila. Se tiene que acceder utilizando el nombre de la interfaz.
		System.out.println(Hop.TEST); //Las constantes static si son heredadas.
		System.out.println(hop.TEST); //Las constantes static si pueden accederse desde variables.
	}
}


//Ejemplo 2
interface Persona {
	int INT_VAR = 0;
	static void comer() {}
}

interface Animal {
	int INT_VAR = 3;
	int INT_VAR_ANIMAL = 5;
	static void comer() {}
}

class TestStatic implements Persona, Animal { // Compila sin problema, los metodos estaticos no son heredados.
	public void test() {
		System.out.println(Persona.INT_VAR);
		System.out.println(Animal.INT_VAR);
		//System.out.println(INT_VAR); // No compila es ambiguo.
		System.out.println(INT_VAR_ANIMAL);
	}
}

