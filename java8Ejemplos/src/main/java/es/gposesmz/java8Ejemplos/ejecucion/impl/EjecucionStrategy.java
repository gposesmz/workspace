package es.gposesmz.java8Ejemplos.ejecucion.impl;

import es.gposesmz.java8Ejemplos.ejecucion.EjecucionJava;

public class EjecucionStrategy {

	public static final EjecucionJava getStrategy(EjecucionVersion version) {
		if(EjecucionVersion.JAVA_7.equals(version)) {
			return new EjecucionJava7();
		}
		return new EjecucionJava8();
	}
}
