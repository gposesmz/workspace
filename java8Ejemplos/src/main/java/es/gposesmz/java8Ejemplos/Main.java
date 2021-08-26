package es.gposesmz.java8Ejemplos;

import java.util.List;

import es.gposesmz.java8Ejemplos.ejecucion.EjecucionJava;
import es.gposesmz.java8Ejemplos.ejecucion.impl.EjecucionStrategy;
import es.gposesmz.java8Ejemplos.ejecucion.impl.EjecucionVersion;


public class Main {
	public static void main(String[] args) {
		EjecucionJava ejecucion = EjecucionStrategy.getStrategy(EjecucionVersion.JAVA_8);
		List<String> datos = ejecucion.crearListaDatosString();
		
		System.out.println("------------------------------- Imprimir todos los datos -------------------------------");
		ejecucion.imprimirDatosConsola(datos);
		
		System.out.println("------------------------------- Imprimir todos los datos ordenados ascendentemente -------------------------------");
		ejecucion.ordernarLista(datos, true);
		
		System.out.println("------------------------------- Imprimir todos los datos ordenados descendente -------------------------------");
		ejecucion.ordernarLista(datos, false);
		
		String empiezaCon = "S";
		System.out.println("------------------------------- Filtar y mostrar datos que empiecen por la letra "+empiezaCon+" -------------------------------");
		ejecucion.filtrarDatos(datos, empiezaCon);
		
		System.out.println("------------------------------- Convertir a mayusculas -------------------------------");
		ejecucion.convertirMayusculas(datos);
		
		int top = 3;
		System.out.println("------------------------------- TOP " + top + " -------------------------------");
		ejecucion.mostrarTopDatos(datos, top);
	}
}
