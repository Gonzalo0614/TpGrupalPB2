package ar.edu.unlam.pb2.elandria;

<<<<<<< HEAD
import ar.edu.unlam.pb2.criaturas.*;
import ar.edu.unlam.pb2.excepciones.*;
import java.util.*;
=======
import java.util.Map;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;
>>>>>>> 65844f1a4bb778f127a957cad1f78b3cb4d7b42d

public class MaestroElemental {
	
	private String nombre;
	private Integer nivelMaestria;
	private String afinidadElemental;
<<<<<<< HEAD
	private Map<String,CriaturaElemental> criaturas = new HashMap<>();
=======
	private Map<String,CriaturaElemental> criaturas = new HashMap;
>>>>>>> 65844f1a4bb778f127a957cad1f78b3cb4d7b42d
	
	public MaestroElemental(String nombre, Integer nivelMestria, String afinidadElemental) {
		this.nombre = nombre;
		if(nivelMestria < 0) {
			nivelMestria = 0;
		}else if (nivelMestria > 50){
			nivelMestria = 50;
		}
		this.nivelMaestria = nivelMestria;
		if(!afinidadElemental.toUpperCase().equals("FUEGO") &&
		   !afinidadElemental.toUpperCase().equals("AGUA") &&
		   !afinidadElemental.toUpperCase().equals("AIRE") &&
		   !afinidadElemental.toUpperCase().equals("TIERRA")) {
			afinidadElemental = "AGUA";
		}
		this.afinidadElemental = afinidadElemental;
	}
	
	public void agregarCriatura(CriaturaElemental criatura) {
	    criaturas.put(criatura.getNombre(), criatura);
	}
	
<<<<<<< HEAD
	public void entrenarCriatura(String nombreCriatura) throws MaestriaInsuficienteException {

		CriaturaElemental criatura = criaturas.get(nombreCriatura);
		Integer energia = criatura.getNivelDeEnergia();
=======
	public void entrenarCriatura(String nombreCriatura) throws ExcepcionMaestriaInsuficiente {

		CriaturaElemental criatura = criaturas.get(nombreCriatura);
		Integer energia = criatura.getNivelEnergia();
>>>>>>> 65844f1a4bb778f127a957cad1f78b3cb4d7b42d

	    if (criatura == null) {
	        System.out.println("La criatura no existe.");
	        return;
	    }
	    

		if ((nivelMaestria <= 25 && energia >= 100) ||
		    (nivelMaestria > 25 && nivelMaestria <= 50 && energia > 200)) {
		    
<<<<<<< HEAD
		    throw new ExcepcionMaestriaInsuficiente("No tenés suficiente maestría para entrenarla.");
=======
		    throw new ExcepcionMaestriaInsuficiente("No tenï¿½s suficiente maestrï¿½a para entrenarla.");
>>>>>>> 65844f1a4bb778f127a957cad1f78b3cb4d7b42d
		}
		
		criatura.entrenar();
		}
	
	public void calmarCriatura(String nombreCriatura) {
<<<<<<< HEAD
		CriaturaElemental criatura = criaturas.get(nombreCriatura);
		
		if(criatura.getComportamientoEmocional.tolowerCase.equals("Inestable")) {
			criatura.setComportamientoEmocional("Tranquilo");
		}
=======
		
>>>>>>> 65844f1a4bb778f127a957cad1f78b3cb4d7b42d
	}
}
