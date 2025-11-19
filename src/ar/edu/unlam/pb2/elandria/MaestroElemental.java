package ar.edu.unlam.pb2.elandria;

import java.util.Map;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class MaestroElemental {
	
	private String nombre;
	private Integer nivelMaestria;
	private String afinidadElemental;
	private Map<String,CriaturaElemental> criaturas = new HashMap;
	
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
		Integer energia = criatura.getNivelEnergia();

	    if (criatura == null) {
	        System.out.println("La criatura no existe.");
	        return;
	    }
	    

		if ((nivelMaestria <= 25 && energia >= 100) ||
		    (nivelMaestria > 25 && nivelMaestria <= 50 && energia > 200)) {
		    
		    throw new ExcepcionMaestriaInsuficiente("No ten�s suficiente maestr�a para entrenarla.");
		}
		
		criatura.entrenar();
		}
	
	public void calmarCriatura(String nombreCriatura) {
		
	}
}
