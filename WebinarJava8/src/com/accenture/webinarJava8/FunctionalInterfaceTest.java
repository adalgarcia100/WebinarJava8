package com.accenture.webinarJava8;

public class FunctionalInterfaceTest {
	
	public static void main(String args[]) {
		FunctionalInterfaceTest functionalInterfaceTest = new FunctionalInterfaceTest();
		String cadenaValidar = "OK";
		Validador validador = new ValidadorImpl();
		Validador validadorClaseAnonima = new Validador() {
			public boolean esValido(String cadenaValidar) {
				return "OK".equals(cadenaValidar);
			}
		};
		
		Validador validadorLambda = c -> c.equals("OK");
		
		String resultadoClassicImplementation = functionalInterfaceTest.procesar(validador, cadenaValidar);
		String resultadoClaseAnonima = functionalInterfaceTest.procesar(validadorClaseAnonima, cadenaValidar);
		
		String resultadoUsandoLambdaEnLinea = functionalInterfaceTest.procesar(c -> c.equals("OK"), cadenaValidar);
		String resultadoUsandoLambdaEnVariable = functionalInterfaceTest.procesar(validadorLambda, cadenaValidar);
		
		System.out.println("Resultado implementado interfaz: " + resultadoClassicImplementation);
		System.out.println("Resultado clase anonima: " + resultadoClaseAnonima);
		System.out.println("Resultado usando lambda en linea: " + resultadoUsandoLambdaEnLinea);
		System.out.println("Resultado usando lambda en variable: " + resultadoUsandoLambdaEnVariable);
	}
	
	public String procesar(Validador validador, String cadenaValidar) {
		return validador.esValido(cadenaValidar) ? "Es válido" : "No es válido";
	}
}

@FunctionalInterface
interface Validador {
	public boolean esValido(String test);
}

class ValidadorImpl implements Validador {
	public boolean esValido(String cadenaValidar) {
		return "OK".equals(cadenaValidar);
	}
}
