package es.personal.jasper.data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Direccion {

	private String provincia;
	private String concello;
	private String calle;
	private Integer numero;
}
