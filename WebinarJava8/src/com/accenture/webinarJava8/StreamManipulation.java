package com.accenture.webinarJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamManipulation {
	
	public static void main(String args[]) {
		//Creacion de Streams
		Stream<String> empty = Stream.empty(); // total elementos = 0
		Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5); // total elementos = 3
		List<String> list = Arrays.asList("a", "b", "c"); 
		Stream<String> fromList = list.stream(); //Stream a partir de una lista
		Stream<Double> randoms = Stream.generate(Math::random);//Stream infinito que genera números random.
		Stream<Integer> numerosImpares = Stream.iterate(1, n -> n + 2);//Stream infinito que genera números impares.
		
		terminalOperationsExample();
		
		intermediateOperationsExample();
	}
	
	private static void terminalOperationsExample() {
		//Metodo count
		System.out.println("Metodo count----------------");
		Stream<String> s = Stream.of("mono", "gorila", "chimpance");
		System.out.println(s.count()); // 3
		//System.out.println(s.count()); // java.lang.IllegalStateException: stream has already been operated upon or closed
		
		//Metodos min() y max()
		System.out.println("\nMetodo min----------------");
		Stream<String> s2 = Stream.of("mono", "gorila", "chimpance");
		Optional<String> min = s2.min((e1, e2) -> e1.length( ) - e2.length()); // Recibe un comparator de parametro.
		min.ifPresent(System.out::println); // mono
	
		Optional<String> min2 = new ArrayList<String>().stream().min((e1, e2) -> e1.length( ) - e2.length()); // Recibe un comparator de parametro.
		System.out.println("\nMetodo min stream vacio----------------");
		System.out.println("Min element encontrado: " + min2.isPresent()); //vacio
		
		System.out.println("\nMetodo max----------------");
		Stream<String> s3 = Stream.of("mono", "gorila", "chimpance");
		Optional<String> max = s3.max((e1, e2) -> e1.length( ) - e2.length()); // Recibe un comparator de parametro.
		max.ifPresent(System.out::println); // chimpance
		
		//findAny() y findFirst()
		System.out.println("\nMetodo findAny----------------");
		Stream<String> s4 = Stream.of("mono", "gorila", "chimpance");
		Stream<String> infinite = Stream.generate(() -> "orangutan");
		s4.findAny().ifPresent(System.out::println);
		infinite.findFirst().ifPresent(System.out::println); // orangutan
		
		//allMatch, anyMatch, noneMatch
		System.out.println("\nMetodo allMatch, anyMatch, noneMatch----------------");
		List<String> list = Arrays.asList("mono", "2", "chimpance"); 
		Stream<String> infinite2 = Stream.generate(() -> "chimpance"); 
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0)); 
		System.out.println(list.stream().anyMatch(pred)); 	// true 
		System.out.println(list.stream().allMatch(pred)); 	// false 
		System.out.println(list.stream().noneMatch(pred)); 	// false 
		System.out.println(infinite2.anyMatch(pred)); 		// true 
		
		//forEach
		System.out.println("\nMetodo forEach----------------");
		Stream<String> s5 = Stream.of("mono", "gorila", "chimpance");
		s5.forEach(System.out::println); // Equivalente a s5.forEach(name -> System.out.println(name);
		
		//reduce
		System.out.println("\nMetodo reduce----------------");
		Stream<Integer> stream = Stream.of(3, 5, 6);
		System.out.println(stream.reduce(1, (a, b) -> a*b));
		
		//collect - Principalmente utilizado para agrupar los datos en una nueva estructura una vez procesado el stream.
		System.out.println("\nMetodo collect----------------");
		Stream<Integer> stream2 = Stream.of(3, 5, 6, 6);
		Set<Integer> listNumbersFiltered = stream2.filter(i -> i > 4).collect(Collectors.toSet());
		System.out.println(listNumbersFiltered);
	}
	
	private static void intermediateOperationsExample() {
		//filter
		System.out.println("\nMetodo filter----------------");
		Stream<String> s1 = Stream.of("mono", "gorila", "chimpance", "mAnimal");
		s1.filter(animal -> animal.startsWith("m")).forEach(System.out::println);
		
		//distinct -- Utiliza el metodo equals del objeto para determinar si un elemento es igual o no a otro dentro del Stream
		System.out.println("\nMetodo distinct----------------");
		Stream<String> s2 = Stream.of("duck", "duck", "duck", "goose"); 
		s2.distinct().forEach(System.out::println); // duck, goose
		
		//limit y skip
		System.out.println("\nMetodo limit y skip----------------");
		Stream<Integer> numerosInfinitos = Stream.iterate(1, n -> n + 1);
		numerosInfinitos.skip(5).limit(2).forEach(System.out::println); // 6 y 7
		
		//map -- Crea un mapeo 1 a 1 de los elementos del stream hacia la siguiente operacion del stream
		System.out.println("\nMetodo map----------------");
		Stream<String> s3 = Stream.of("mono", "gorila", "chimpance"); 
		s3.map(nombre -> nombre.length()).forEach(System.out::println); // 4, 6, 9
		
		//sorted - Usa el sorteo natural (Si la clase implementa Compare), en caso de que no, o queramos usar un sorting diferente
		//se le puede pasar un Comparator como parametro. Si la clase no implementa Compare y no se le pasa un Comparator, se
		//lanzara una exception.
		System.out.println("\nMetodo sort----------------");
		Stream<String> s4 = Stream.of("mono-", "gorila-", "chimpance-"); 
		s4.sorted().forEach(System.out::print); // chimpance-gorila-mono-
		
		//peek - Es muy util para debuguear dado que su intencion es no modificar el stream.
		System.out.println("\nMetodo peek----------------");
		Stream<String> s5 = Stream.of("mono", "gorila", "mono2");  
		long count = s5
				.filter(s -> s.startsWith("m"))
				.peek(System.out::println)
				.count();
		 System.out.println(count); // 1
	}
}

