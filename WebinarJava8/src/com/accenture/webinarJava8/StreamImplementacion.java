package com.accenture.webinarJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class StreamImplementacion {

	/*
	 *  Requerimiento: Imprimir los primeros dos nombres en orden alfabetico que tienen una longitud de 4 letras de una lista de elementos.
	 * 
	 *  1. Filtrar los nombres y dejar solo los que tengan 4 letras.
	 *  2. Ordenar la lista alfabeticamente.
	 *  3. Obtener los primeros dos elementos.
	 *  4. Imprimir los nombres.
	 * */
	
	public static void main(String args[]) {
		beforeStreamImplementation();
		
		usingStreamImplementation();
	}
	
	private static void beforeStreamImplementation() {
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		List<String> filtered = new ArrayList<>();
		
		//1. Filtramos la lista
		for (String name: list) {
			if (name.length() == 4) {
				filtered.add(name); 
			} 
		}
		
		//2. Ordenamos la lista
		Collections.sort(filtered);

		//3. Obtenemos e imprimimos los primeros dos elementos
		Iterator<String> iter = filtered.iterator();
		if (iter.hasNext()) System.out.println(iter.next());
		if (iter.hasNext()) System.out.println(iter.next());
	}
	
	private static void usingStreamImplementation() {
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
		
		list.stream()
			.filter(name -> name.length() == 4) 	// 1. Filtramos la lista
			.sorted()								// 2. Ordenamos la lista
		 	.limit(2)								// 3. Obtenemos los primeros dos elementos.
		 	.forEach(System.out::println);			// 4. Imprimimos los primeros dos elementos.
	}
}
