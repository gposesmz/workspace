package es.gposesmz.java8Ejemplos.ejecucion.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import es.gposesmz.java8Ejemplos.ejecucion.EjecucionJava;

public class EjecucionJava8 implements EjecucionJava {
	
	@Override
	public List<String> crearListaDatosString() {
		return Stream.of("España", "Venezuela", "Suiza", "Islandia", "Rusia", "Suecia").collect(Collectors.toList());
	}

	@Override
	public void ordernarLista(List<String> datos, boolean ascendente) {
		//A traves de Lambda
//		Collections.sort(datos, (String o1, String o2) -> ascendente ? o1.compareTo(o2) : o2.compareTo(o1));
//		imprimirDatosConsola(datos);
		
		//A traves de Stream
		//datos.stream().sorted().forEach(System.out::println);
		//o
		datos.stream().sorted((o1, o2) -> ascendente ? o1.compareTo(o2): o2.compareTo(o1)).forEach(System.out::println);
	}

	@Override
	public void imprimirDatosConsola(List<String> datos) {
		datos.stream().forEach(System.out::println); //Referencia a metodo.
		//Tambien se puede hacer
		//datos.stream().forEach(dato -> System.out.println(dato));
	}

	@Override
	public void filtrarDatos(List<String> datos, String empiezaCon) {
		datos.stream().filter(dato -> dato.startsWith(empiezaCon)).forEach(System.out::println);
	}
	
	@Override
	public void convertirMayusculas(List<String> datos) {
		datos.stream().map(String::toUpperCase).forEach(System.out::println);
	}
	
	@Override
	public void mostrarTopDatos(List<String> datos, int top) {
		datos.stream().limit(top).forEach(System.out::println);
	}
}
