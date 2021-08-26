package es.gposesmz.java8Ejemplos.ejecucion;

import java.util.List;

public interface EjecucionJava {
	List<String> crearListaDatosString();

	void ordernarLista(List<String> datos, boolean ascendente);
	
	void imprimirDatosConsola(List<String> datos);
	
	void filtrarDatos(List<String> datos, String empiezaCon);
	
	void convertirMayusculas(List<String> datos);
	
	void mostrarTopDatos(List<String> datos, int top);
}
