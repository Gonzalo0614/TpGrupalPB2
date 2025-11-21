package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public abstract class CriaturaElemental {

	private String nombre;
	private Integer nivelDeEnergia;
	private String afinidadElemental;
	private String comportamientoEmocional;
	
	
	public CriaturaElemental(String nombre , Integer nivelDeEnergia , String afinidadElemental , String comportamientoEmocional) {
		this.nombre = nombre;
		
		if (nivelDeEnergia != null && nivelDeEnergia >= 0 && nivelDeEnergia <= 200 ) {
			this.nivelDeEnergia = nivelDeEnergia;
		} else {
			this.nivelDeEnergia = 10;
		}
		
		if (afinidadElemental != null && (afinidadElemental.equalsIgnoreCase("agua")
				|| afinidadElemental.equalsIgnoreCase("fuego") || afinidadElemental.equalsIgnoreCase("aire") || afinidadElemental.equalsIgnoreCase("tierra"))) {
			this.afinidadElemental = afinidadElemental.toLowerCase();
		} else {
			this.afinidadElemental = "fuego";
		}
		if (comportamientoEmocional!= null && (comportamientoEmocional.equalsIgnoreCase("tranquila")
				|| comportamientoEmocional.equalsIgnoreCase("inestable"))) {
			this.comportamientoEmocional = comportamientoEmocional.toLowerCase();
		}else {
			this.comportamientoEmocional = "tranquila";
		}
	}
	
	
   public abstract void entrenar() throws ExcepcionMaestriaInsuficiente; 
    
	public abstract void pacificar();
	
	
	public String getComportamientoEmocional() {
        return comportamientoEmocional;
    }

    
    public void volverseInestable() {
        this.comportamientoEmocional = "inestable";
    }
    
   
    public Integer getNivelEnergia() {
        return nivelDeEnergia;
    }

    public void setNivelEnergia(Integer nuevoNivel) {
        
        this.nivelDeEnergia = nuevoNivel;
    }
    
    
    public String getAfinidadElemental() {
        return afinidadElemental;
    }
    
    public void setAfinidadElemental(String afinidadElemental) {
		this.afinidadElemental = afinidadElemental;
	}


	public void aumentarEnergia(int cantidad) {
        this.nivelDeEnergia += cantidad;
    }


	public String getNombre() {
		return nombre;
	}


	public void setComportamientoEmocional(String comportamientoEmocional) {
		this.comportamientoEmocional = comportamientoEmocional;
	}

	public boolean esTransformada() {
	    return this instanceof TransformacionElemental;
	}
    
}


