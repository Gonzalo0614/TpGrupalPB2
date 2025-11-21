package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class BendicionDelRio extends TransformacionElemental{

	public BendicionDelRio(CriaturaElemental criatura) {
		super(criatura);
		Integer energiaDuplicada = criatura.getNivelEnergia() * 2;
		if(energiaDuplicada > 180) {
			energiaDuplicada = 180;
		}
		criatura.setNivelEnergia(energiaDuplicada);
	}
	
    @Override
    public TransformacionElemental aplicar(CriaturaElemental criatura) {
        return new BendicionDelRio(criatura);
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
