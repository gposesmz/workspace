package es.personal.jasper.data;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Persona {

	private String nombre;
	private String apellido;
	private Integer numDoc;
	private List<Direccion> direcciones;	
}
