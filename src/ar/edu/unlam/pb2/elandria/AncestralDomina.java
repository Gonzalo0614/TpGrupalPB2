package ar.edu.unlam.pb2.elandria;

public class AncestralDomina implements InteraccionEntreCriaturas{

	@Override
	public void interaccion(CriaturaElemental c1, CriaturaElemental c2) {
	    if(c1 instanceof CriaturaAncestral && !(c2 instanceof CriaturaAncestral)) {
	        c1.aumentarEnergia(20);  // Ancestral gana 20
	        c2.setNivelEnergia(Math.max(0, c2.getNivelEnergia() - 15)); // Otro pierde 15
	    } else if(c2 instanceof CriaturaAncestral && !(c1 instanceof CriaturaAncestral)) {
	        c2.aumentarEnergia(20);  // Ancestral gana 20
	        c1.setNivelEnergia(Math.max(0, c1.getNivelEnergia() - 15)); // Otro pierde 15
	    }
	}


}
