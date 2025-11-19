package ar.edu.unlam.pb2.criaturas;

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
			this.nivelDeEnergia = 50;
		}
		
		if (afinidadElemental != null && (afinidadElemental.equalsIgnoreCase("agua")
				|| afinidadElemental.equalsIgnoreCase("fuego") || afinidadElemental.equalsIgnoreCase("aire") || afinidadElemental.equalsIgnoreCase("tierra"))) {
			this.afinidadElemental = afinidadElemental.toLowerCase();
		} else {
			this.afinidadElemental = "fuego";
		}
		if (comportamientoEmocional!= null && (comportamientoEmocional.equalsIgnoreCase("tranquila")
				|| afinidadElemental.equalsIgnoreCase("inestable"))) {
			this.comportamientoEmocional = comportamientoEmocional.toLowerCase();
		}else {
			this.comportamientoEmocional = "tranquilo";
		}
	}

}
