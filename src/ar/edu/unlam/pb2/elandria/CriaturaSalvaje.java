package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionEnergiaMaximaSuperada;
import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class CriaturaSalvaje extends CriaturaElemental {

	public CriaturaSalvaje(String nombre, Integer nivelDeEnergia, String afinidadElemental,
			String comportamientoEmocional) {
		super(nombre, nivelDeEnergia, afinidadElemental, comportamientoEmocional);

	}

	@Override
	public void entrenar() throws ExcepcionMaestriaInsuficiente {

		int aumentoAleatorio = (int) (Math.random() * 50) + 1;

		int nuevaEnergia = this.getNivelEnergia() + aumentoAleatorio;

		if (nuevaEnergia > 200) {

			throw new ExcepcionEnergiaMaximaSuperada("¡La criatura se descontrola! Supera el limite de 200 de energia.");
		}

		this.setNivelEnergia(nuevaEnergia);
	}

	
		@Override
		public void pacificar() {
		    this.setComportamientoEmocional("tranquila");
		}


}
