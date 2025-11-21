package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.*;
import java.util.*;

public class MaestroElemental {
	
	private String nombre;
	private Integer nivelMaestria;
	private String afinidadElemental;
	private Map<String,CriaturaElemental> criaturas = new HashMap<>();

	
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
	
	public void entrenarCriatura(String nombreCriatura) throws ExcepcionMaestriaInsuficiente {

		CriaturaElemental criatura = criaturas.get(nombreCriatura);

	    if (criatura == null) {
	        return;
	    }
	    
		Integer energia = criatura.getNivelEnergia();

		if (nivelMaestria <= 25 && energia >= 100) {
		    
		    throw new ExcepcionMaestriaInsuficiente("No ten�s suficiente maestr�a para entrenarla.");

		}
		
		criatura.entrenar();
		}
	
	public void calmarCriatura(String nombreCriatura) {
		CriaturaElemental criatura = criaturas.get(nombreCriatura);
		
		if(criatura.getComportamientoEmocional().toLowerCase().equals("inestable")) {
			criatura.pacificar();;
		}

	}
	
	public void transformarCriatura(TransformacionElemental transformacion, String nombreCriatura) {
		CriaturaElemental criatura = criaturas.get(nombreCriatura);
		
		if(criatura == null) {
			return;
		}
		TransformacionElemental criaturaTransformada = transformacion.aplicar(criatura);
		
		criaturas.put(nombreCriatura, criaturaTransformada);
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNivelMaestria() {
		return nivelMaestria;
	}
	
	public Map<String, CriaturaElemental> getCriaturas() {
	    return this.criaturas;
	}
}
