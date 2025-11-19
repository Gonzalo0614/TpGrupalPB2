package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class CriaturaDomesticada extends CriaturaElemental {

	public CriaturaDomesticada(String nombre, Integer nivelDeEnergia, String afinidadElemental,
			String comportamientoEmocional) {
		super(nombre, nivelDeEnergia, afinidadElemental, "tranquila");

	}

	@Override
	public void entrenar() throws ExcepcionMaestriaInsuficiente {

		int aumentoEstable = 10;

		int nuevaEnergia = this.getNivelEnergia() + aumentoEstable;

		if (nuevaEnergia > 200) {
			this.setNivelEnergia(200);
		} else {
			this.setNivelEnergia(nuevaEnergia);
		}

	}

	@Override
	public void pacificar() {
		this.setComportamientoEmocional("tranquila");
	}


}
