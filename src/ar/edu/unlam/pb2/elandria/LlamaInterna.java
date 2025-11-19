package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class LlamaInterna extends TransformacionElemental{

	public LlamaInterna(CriaturaElemental criatura) {
		super(criatura);
		if(this.criatura.getAfinidadElemental().toUpperCase().equals("FUEGO")){
			this.criatura.setNivelEnergia(criatura.getNivelEnergia() +30);
		}else {
			this.criatura.volverseInestable();
		}
	}
	
    @Override
    public TransformacionElemental aplicar(CriaturaElemental criatura) {
        return new LlamaInterna(criatura);
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
