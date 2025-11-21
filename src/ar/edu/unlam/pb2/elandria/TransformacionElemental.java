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
	    
	    @Override
	    public Integer getNivelEnergia() {
	        return criatura.getNivelEnergia();
	    }

	    @Override
	    public String getComportamientoEmocional() {
	        return criatura.getComportamientoEmocional();
	    }

	    @Override
	    public String getAfinidadElemental() {
	        return criatura.getAfinidadElemental();
	    }
	}
