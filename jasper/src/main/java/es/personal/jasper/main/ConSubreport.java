package es.personal.jasper.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.personal.jasper.data.Direccion;
import es.personal.jasper.data.Persona;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ConSubreport {

	private static final String ARCHIVO_DESTINO = "C:\\Users\\Gonzalo\\Downloads\\ConSubreport.pdf";
	private static final String SUBREPORT_COMPILADO = "C:\\Users\\Gonzalo\\eclipse-workspace\\jasper\\src\\main\\resources\\ConSubreport\\direccionesSubreport.jasper";
	private static final String SUBREPORT_PLANTILLA = "C:\\Users\\Gonzalo\\eclipse-workspace\\jasper\\src\\main\\resources\\ConSubreport\\direccionesSubreport.jrxml";
	
	public static void main(String[] args) {
		List<Persona> datos = rellenaLista();
		JRBeanCollectionDataSource datosToReport = new JRBeanCollectionDataSource(datos);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("texto1", "Prueba");
		parameters.put("texto2", "otro parametro");
		//Se puede pasar como parametro la ruta de subreport, o puede hacerse desde el propio ireport
		parameters.put("rutaDireccionesSubreport", SUBREPORT_COMPILADO);
		//En los subreports, para hacer mas facil el diseño y el encaje dentro del report padre, es mejor quitar los margenes

		try {
			//1. Compilando la plantilla
			generateReportWithTemplate(parameters, datosToReport);
			
////			//2.Compilando el .jrxml desde el ireport / jaspersoft y pasarle el archivo .jasper
//			generateReportWithCompiledTemplate(parameters, datosToReport);
			
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin");
	}

	private static void generateReportWithTemplate(Map<String, Object> parameters, JRBeanCollectionDataSource datosToReport) throws JRException, FileNotFoundException {
		
		String plantilla = "C:\\Users\\Gonzalo\\eclipse-workspace\\jasper\\src\\main\\resources\\ConSubreport\\ConSubreport.jrxml";
		JasperReport jasperReport = JasperCompileManager.compileReport(plantilla);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datosToReport);
		
		OutputStream output = new FileOutputStream(new File(ARCHIVO_DESTINO)); 
		JasperExportManager.exportReportToPdfStream(jasperPrint, output);
	}
	
//	private static void generateReportWithCompiledTemplate(Map<String, Object> parameters, JRBeanCollectionDataSource datosToReport) throws JRException, FileNotFoundException {
//		
//		JasperReport compileSubreport = JasperCompileManager.compileReport(SUBREPORT_PLANTILLA);
//		parameters.put("rutaDireccionesSubreport", compileSubreport);
//		
//		String compilado = "C:\\Users\\Gonzalo\\eclipse-workspace\\jasper\\src\\main\\resources\\ConSubreport\\ConSubreport.jasper";
//		JasperPrint jasperPrint = JasperFillManager.fillReport(compilado, parameters, datosToReport);
//		
//		OutputStream output = new FileOutputStream(new File(ARCHIVO_DESTINO)); 
//		JasperExportManager.exportReportToPdfStream(jasperPrint, output);
//	}
	
	private static List<Persona> rellenaLista() {
		List<Direccion> direcciones = new ArrayList<Direccion>();
		int num = 1;
		for(int i = 0; i<=2;i++) {
			direcciones.add(Direccion.builder().provincia("Provincia").concello("Concello").calle("calle").numero(num++).build());
		}
		
		List<Persona> personas = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			personas.add(Persona.builder().nombre("Nombre " + i).apellido("Apellido" + i).numDoc(i).direcciones(direcciones).build());
		}
		return personas;
	}
	
}