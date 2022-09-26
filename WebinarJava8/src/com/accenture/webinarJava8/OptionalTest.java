package com.accenture.webinarJava8;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalTest {
	
	private static final int[] calificaciones1 = new int[] {10, 9, 10, 8};
	private static final int[] calificaciones2 = new int[] {};
	
	public static void main(String args[]) {
		System.out.println("\n\nEjemplo Main");
		
		Optional<Double> promedio1 = calcularPromedio(calificaciones1);
		Optional<Double> promedio2 = calcularPromedio(calificaciones2);
		
		System.out.println("Promedio Calificaciones 1: " +  promedio1);
		System.out.println("Promedio Calificaciones 2: " +  promedio2);
		
		//Si queremos obtener el valor, primero es necesario que validemos si no esta vacio.
		if(promedio1.isPresent()) {
			System.out.println("Promedio Calificaciones 1: " +  promedio1.get());
		}
		
		if(promedio2.isPresent()) {
			System.out.println("Promedio Calificaciones 2: " +  promedio2.get());
		}
		
		//Si no validamos primero si el valor esta presente obtendremos una Runtime Exception
		//System.out.println("Promedio Calificaciones 2: " +  promedio2.get());
		
		//Ejemplo Nullable
		ejemploNullable();
		
		//Ejemplo ifPresent
		ejemploIfPresent();
		
		//Ejemplo orElse
		ejemploOrElse();
		
		//Ejemplo orElseGet
		ejemploOrElseGet();
		
		//Ejemplo orElseThrow
		ejemploOrElseThrow();
	}
	
	private static Optional<Double> calcularPromedio(int[] calificaciones) {
		int totalCalificaciones = calificaciones.length;
		
		if (totalCalificaciones == 0) {
			return Optional.empty();
		}
		
		double suma = 0;
		
		for (int calificacion: calificaciones) {
			suma += calificacion;
		}
		
		double resultado = suma / totalCalificaciones;
		
		return Optional.of(resultado);
	}
	
	private static Optional<Double> ejemploNullable() {
		Double doubleObject = null;
		
		//Sentencias equivalentes, en caso de que nuestra variable pueda llegar a ser null, se recomienda la segunda opcion.
		Optional<Double> resultado = doubleObject != null ? Optional.of(doubleObject) : Optional.empty();
		Optional<Double> resultado2 = Optional.ofNullable(doubleObject);
		
		return resultado2;
	}
	
	private static void ejemploIfPresent(){
		System.out.println("\n\nEjemplo ifPresent");
		
		//Equivalente pero creando una variable para la interfaz funcional C
		Consumer<Double> procesarPromedio = promedio -> System.out.println(promedio);
				
		calcularPromedio(calificaciones1).ifPresent(promedio -> System.out.println(promedio));
		calcularPromedio(calificaciones2).ifPresent(promedio -> System.out.println(promedio));
		calcularPromedio(calificaciones1).ifPresent(procesarPromedio);
		
		//Equivalente pero utilizando referencia a metodos
		calcularPromedio(calificaciones1).ifPresent(System.out::println);
		calcularPromedio(calificaciones2).ifPresent(System.out::println);
	}
	
	private static void ejemploOrElse() {
		System.out.println("\n\nEjemplo orElse");
		final Double PROMEDIO_DEFAULT = Double.valueOf(0.0);
		
		Double promedio1 = calcularPromedio(calificaciones1).orElse(PROMEDIO_DEFAULT);
		Double promedio2 =calcularPromedio(calificaciones2).orElse(PROMEDIO_DEFAULT);
				
		System.out.println("Promedio Calificaciones 1: " +  promedio1);
		System.out.println("Promedio Calificaciones 2: " +  promedio2);
	}
	
	private static void ejemploOrElseGet() {
		System.out.println("\n\nEjemplo orElseGet");
		
		Supplier<Double> obtenerValorDefault = () -> Double.valueOf(0.0);
		
		Double promedio1 = calcularPromedio(calificaciones1).orElseGet(() -> Double.valueOf(0.0));
		Double promedio2 =calcularPromedio(calificaciones2).orElseGet(obtenerValorDefault);
				
		System.out.println("Promedio Calificaciones 1: " +  promedio1);
		System.out.println("Promedio Calificaciones 2: " +  promedio2);
	}
	
	private static void ejemploOrElseThrow() {
		System.out.println("\n\nEjemplo orElseThrow");
		
		Supplier<RuntimeException> obtenerException = () -> new RuntimeException("El promedio es requerido");
		
		Double promedio1 = calcularPromedio(calificaciones1).orElseThrow(() -> new RuntimeException("El promedio es requerido"));
		Double promedio2 =calcularPromedio(calificaciones2).orElseThrow(obtenerException);
				
		System.out.println("Promedio Calificaciones 1: " +  promedio1);
		System.out.println("Promedio Calificaciones 2: " +  promedio2);
	}
}
