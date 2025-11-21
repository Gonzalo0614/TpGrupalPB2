package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class VinculoTerrestre extends TransformacionElemental{

	public VinculoTerrestre(CriaturaElemental criatura) {
		super(criatura);
	    if (criatura.getNivelEnergia() < 50) {
	        criatura.setNivelEnergia(50);
	        this.setNivelEnergia(50); 
	    }
	}
	
    @Override
    public TransformacionElemental aplicar(CriaturaElemental criatura) {
        return new VinculoTerrestre(criatura);
    }

	@Override
	public void entrenar() throws ExcepcionMaestriaInsuficiente {
		criatura.entrenar();
		
	}

	@Override
	public void pacificar() {
		criatura.pacificar();
	}

}
