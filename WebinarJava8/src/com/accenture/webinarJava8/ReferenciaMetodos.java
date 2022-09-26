package com.accenture.webinarJava8;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ReferenciaMetodos {
	
	 public static void main(String args[]) {
		 // Método Estático
		 Comparator<Pato> porPeso = (p1, p2) -> PatoHelper.compararPorPeso(p1, p2);
		 Comparator<Pato> porPesoReferenciaMetodo = PatoHelper::compararPorPeso; 
		 
		 
		 
		 //Método de Instancia en una instancia particular
		 final String str = "abc";
		 Predicate<String> lambdaIntanciaParticular = s -> str.startsWith(s);
		 Predicate<String> referenciaMetodoIntanciaParticular = str::startsWith;
		 
		 
		 
		 //Método de Instancia en una instancia a ser determinada en tiempo de ejecución
		 Predicate<String> lambdaInstanciaTiempoEjecucion = s -> s.isEmpty();
		 Predicate<String> referenciaMetodoInstanciaTiempoEjecucion = String::isEmpty;
		 Comparator<Integer> lambdaInstanciaTiempoEjecucion2 = (i1, i2) -> i1.compareTo(i2);
		 Comparator<Integer> lambdaInstanciaTiempoEjecucion3 = Integer::compareTo;
		 
		 //No compila dado que el primer argumento que se pasa se utilza para hacer la llamada al método
		 //nos hace falta otro parámetro para pasarselo de argumento al método startsWith.
		 //Predicate<String> referenciaMetodoIntanciaParticular2 = String::startsWith; 
		 
		 //El BiPredicate recibe dos argumento de entrada, por lo que uno se utiliza para realizar la llamada al método
		 // y el segundo se pasa como parámetro del método startsWith.
		 BiPredicate<String, String> referenciaMetodoIntanciaParticular2 = String::startsWith; 
		 BiPredicate<String, String> referenciaMetodoIntanciaParticular3 = (s1, s2) -> s1.startsWith(s2);
		 
		 
		 //Constructor
		 Supplier<StringBuilder> lambdaConstructor = () -> new StringBuilder();
		 Supplier<StringBuilder> referenciaMetodoConstructor = StringBuilder::new;
		 Function<Integer, StringBuilder> lambdaConstructor2 = capacity -> new StringBuilder(capacity);
		 Function<Integer, StringBuilder> referenciaMetodoConstructor2 = StringBuilder::new;
	 }
}

class PatoHelper {
	public static int compararPorPeso(Pato p1, Pato p2) {
		 return p1.getPeso() - p2.getPeso();
	}
	public static int compararPorNombre(Pato p1, Pato p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}
}

class Pato {
	private int peso;
	private String nombre;
	
	public Pato(int peso, String nombre) {
		this.peso = peso;
		this.nombre = nombre;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}

//Equivalente a lo que hacemos con los referencia a métodos,solo delegamos la ejecución a otro método.
class PatoComparatorPorPeso implements Comparator<Pato> {
	public int compare(Pato p1, Pato p2) {
		return PatoHelper.compararPorPeso(p1, p2);
	}
}