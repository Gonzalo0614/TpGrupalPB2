package ar.edu.unlam.pb2.elandria;

public class AfinidadCompartida implements InteraccionEntreCriaturas{

	@Override
	public void interaccion(CriaturaElemental c1, CriaturaElemental c2) {
		if(c1.getAfinidadElemental().equals(c2.getAfinidadElemental())) {
			c1.aumentarEnergia(10);
			c2.aumentarEnergia(10);
		}
		
	}

}
