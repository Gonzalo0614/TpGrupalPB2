package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class CriaturaDomesticada extends CriaturaElemental {

	public CriaturaDomesticada(String nombre, Integer nivelDeEnergia, String afinidadElemental,
			String comportamientoEmocional) {
		super(nombre, nivelDeEnergia, afinidadElemental, "tranquila");

	}

	@Override
	public void entrenar(MaestroElemental maestro) throws ExcepcionMaestriaInsuficiente {
		if (maestro.getNivelMaestria() < 5) {
			throw new ExcepcionMaestriaInsuficiente("El maestro " + maestro.getNombre()
					+ " no tiene la maestría suficiente para entrenar esta criatura domesticada.");
		}

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

	@Override
	protected void entrenar() {
		// TODO Auto-generated method stub
		
	}

}
