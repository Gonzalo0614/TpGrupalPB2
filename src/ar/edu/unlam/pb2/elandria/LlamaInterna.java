package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class LlamaInterna extends TransformacionElemental{

	public LlamaInterna(CriaturaElemental criatura) {
		 super(criatura);

		    if (criatura.getAfinidadElemental().equalsIgnoreCase("FUEGO")) {
		        int nuevaEnergia = criatura.getNivelEnergia() + 30;
		        criatura.setNivelEnergia(nuevaEnergia);
		        this.setNivelEnergia(nuevaEnergia); 
		    } else {
		        criatura.volverseInestable();
		        this.setComportamientoEmocional("inestable"); 
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
