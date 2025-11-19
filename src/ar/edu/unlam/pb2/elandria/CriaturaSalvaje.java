package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionEnergiaMaximaSuperada;
import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class CriaturaSalvaje extends CriaturaElemental {

	public CriaturaSalvaje(String nombre, Integer nivelDeEnergia, String afinidadElemental,
			String comportamientoEmocional) {
		super(nombre, nivelDeEnergia, afinidadElemental, comportamientoEmocional);

	}

	@Override
	public void entrenar(MaestroElemental maestro) throws ExcepcionMaestriaInsuficiente {
		if (maestro.getNivelMaestria() < 20) {
			throw new ExcepcionMaestriaInsuficiente("El maestro " + maestro.getNombre()
					+ " no tiene la maestría suficiente para entrenar a una criatura salvaje.");
		}

		int aumentoAleatorio = (int) (Math.random() * 50) + 1;

		int nuevaEnergia = this.getNivelEnergia() + aumentoAleatorio;

		if (nuevaEnergia > 200) {

			throw new ExcepcionEnergiaMaximaSuperada(
					"¡La criatura se descontroló! Superó el límite de 200 de energía.");
		}

		this.setNivelEnergia(nuevaEnergia);
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
