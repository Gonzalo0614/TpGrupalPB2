package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class CriaturaAncestral extends CriaturaElemental {

	public CriaturaAncestral(String nombre, Integer nivelDeEnergia, String afinidadElemental,
			String comportamientoEmocional) {

	super(nombre, (nivelDeEnergia == null || nivelDeEnergia < 100) ? 100 : nivelDeEnergia ,afinidadElemental , comportamientoEmocional);
		
	}

	@Override
	public void entrenar(MaestroElemental maestro) throws ExcepcionMaestriaInsuficiente {
		if (maestro.getNivelMaestria() < 40) { 
            throw new ExcepcionMaestriaInsuficiente("El maestro no tiene la maestría suficiente para entrenar esta criatura ancestral.");
        }
        
        int nuevaEnergia = this.getNivelEnergia() + 10; 
        
        
        this.setNivelEnergia(nuevaEnergia);
	}

	@Override
	public void pacificar() {
		this.setComportamientoEmocional("tranquila");

	}

	@Override
	protected void entrenar() {
		// TODO Auto-generated method stub
		
	}
	
	
    

}
