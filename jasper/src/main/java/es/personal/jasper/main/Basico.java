package es.personal.jasper.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.personal.jasper.data.Persona;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Basico {

	private static final String ARCHIVO_DESTINO = "C:\\Users\\Gonzalo\\Downloads\\Basico.pdf";
	
	public static void main(String[] args) {
		List<Persona> datos = rellenaLista();
		JRBeanCollectionDataSource datosToReport = new JRBeanCollectionDataSource(datos);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("texto1", "Prueba");
		parameters.put("texto2", "otro parametro");

		try {
			//1. Compilando la plantilla
			generateReportWithTemplate(parameters, datosToReport);
			
//			//2.Compilando el .jrxml desde el ireport / jaspersoft y pasarle el archivo .jasper
//			generateReportWithCompiledTemplate(parameters, datosToReport);
			
		} catch (JRException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin");
	}

	private static void generateReportWithTemplate(Map<String, Object> parameters, JRBeanCollectionDataSource datosToReport) throws JRException, FileNotFoundException {
		
		String plantilla = "C:\\Users\\Gonzalo\\eclipse-workspace\\jasper\\src\\main\\resources\\basico\\Basico.jrxml";
		JasperReport jasperReport = JasperCompileManager.compileReport(plantilla);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datosToReport);
		
		OutputStream output = new FileOutputStream(new File(ARCHIVO_DESTINO)); 
		JasperExportManager.exportReportToPdfStream(jasperPrint, output);
	}
	
	private static void generateReportWithCompiledTemplate(Map<String, Object> parameters, JRBeanCollectionDataSource datosToReport) throws JRException, FileNotFoundException {
		String compilado = "C:\\Users\\Gonzalo\\eclipse-workspace\\jasper\\src\\main\\resources\\basico\\Basico.jasper";
		JasperPrint jasperPrint = JasperFillManager.fillReport(compilado, parameters, datosToReport);
		
		OutputStream output = new FileOutputStream(new File(ARCHIVO_DESTINO)); 
		JasperExportManager.exportReportToPdfStream(jasperPrint, output);
	}
	
	private static List<Persona> rellenaLista() {
		List<Persona> personas = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			personas.add(Persona.builder().nombre("Nombre " + i).apellido("Apellido" + i).numDoc(i).build());
		}
		return personas;
	}
	
}