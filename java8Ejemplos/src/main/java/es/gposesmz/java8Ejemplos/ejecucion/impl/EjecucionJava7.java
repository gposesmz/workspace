package es.gposesmz.java8Ejemplos.ejecucion.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import es.gposesmz.java8Ejemplos.ejecucion.EjecucionJava;

public class EjecucionJava7 implements EjecucionJava {

	@Override
	public List<String> crearListaDatosString() {
		return Arrays.asList("España", "Venezuela", "Suiza", "Islandia", "Rusia", "Suecia");
	}

	@Override
	public void ordernarLista(List<String> datos, boolean ascendente) {
		Collections.sort(datos, new Comparator<String>() {

			public int compare(String o1, String o2) {
				if(ascendente){
					return o1.compareTo(o2);
				} 
				return o2.compareTo(o1);
			}
		});
		imprimirDatosConsola(datos);
	}

	@Override
	public void imprimirDatosConsola(List<String> datos) {
		for (String dato : datos) {
			System.out.println(dato);
		}
	}

	@Override
	public void filtrarDatos(List<String> datos, String empiezaCon) {
		for (String dato : datos) {
			if (dato.startsWith(empiezaCon)) {
				System.out.println(dato);
			}
		}
	}

	@Override
	public void convertirMayusculas(List<String> datos) {
		for (String dato : datos) {
			System.out.println(dato.toUpperCase());
		}
	}
	
	@Override
	public void mostrarTopDatos(List<String> datos, int top) {
		for(int i = 0; i<top;i++) {
			System.out.println(datos.get(i));
		}
	}
}
