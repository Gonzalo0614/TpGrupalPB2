package ar.edu.unlam.pb2.elandria;

public abstract class TransformacionElemental extends CriaturaElemental{

	 protected CriaturaElemental criatura;

	    public TransformacionElemental(CriaturaElemental criatura) {
	        super(criatura.getNombre(),
	              criatura.getNivelEnergia(),
	              criatura.getAfinidadElemental(),
	              criatura.getComportamientoEmocional());
	        this.criatura = criatura;
	    }
	    
	    public abstract TransformacionElemental aplicar(CriaturaElemental criatura);
	}
