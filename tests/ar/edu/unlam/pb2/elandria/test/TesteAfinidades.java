package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.elandria.AscensoDelViento;
import ar.edu.unlam.pb2.elandria.BendicionDelRio;
import ar.edu.unlam.pb2.elandria.CriaturaDomesticada;
import ar.edu.unlam.pb2.elandria.CriaturaElemental;
import ar.edu.unlam.pb2.elandria.CriaturaSalvaje;
import ar.edu.unlam.pb2.elandria.TransformacionElemental;

public class TesteAfinidades {

	@Test
	public void queAfinidadOriginalSeMantengaEnAscensoDelVientoAunqueSeTransformeVariasVeces() {
	
	    CriaturaElemental base = new CriaturaSalvaje("Aero", 90, "FUEGO", "tranquila");
	
	    AscensoDelViento t1 = new AscensoDelViento(base);
	    AscensoDelViento t2 = new AscensoDelViento(t1);
	
	    assertEquals("fuego", t2.getAfinidadOriginal().toLowerCase());
	}

	@Test
	public void queTransformacionesAnidadasMantenganAfinidadDeLaUltima() {

	    CriaturaElemental base = new CriaturaDomesticada("Ayla", 100, "TIERRA", "tranquila");

	    TransformacionElemental ascenso = new AscensoDelViento(base); 
	    TransformacionElemental bendicion = new BendicionDelRio(ascenso); 

	    assertEquals("aire", bendicion.getAfinidadElemental().toLowerCase());
	}

	@Test
	public void queAscensoDelVientoGuardeAfinidadOriginal() {

	    AscensoDelViento t = new AscensoDelViento(
	            new CriaturaDomesticada("Venti", 80, "TIERRA", "tranquila")
	    );

	    assertEquals("tierra", t.getAfinidadOriginal().toLowerCase());
	}
	
	@Test
	public void queAscensoDelVientoCambieAfinidadAAire() {

	    CriaturaElemental c = new CriaturaSalvaje("Spirit", 120, "FUEGO", "tranquila");

	    TransformacionElemental t = new AscensoDelViento(c);

	    assertEquals("aire", t.getAfinidadElemental().toLowerCase());
	}
	
	@Test
	public void queLaAfinidadSeMantengaEnTransformacionesQueNoLaCambian() {
	    CriaturaElemental c = new CriaturaDomesticada("Pyra", 100, "TIERRA", "tranquila");

	    TransformacionElemental t = new BendicionDelRio(c);

	    assertEquals("tierra", t.getAfinidadElemental()); 
	}
	
	@Test
	public void queAfinidadNulaSeConviertaEnFuego() {
	    CriaturaElemental c = new CriaturaDomesticada("Nula", 100, null, "tranquila");
	    assertEquals("fuego", c.getAfinidadElemental());
	}
	
	@Test
	public void queAfinidadInvalidaSeConviertaEnFuego() {
	    CriaturaElemental c = new CriaturaSalvaje("Bestia", 100, "LAVA", "inestable");
	    assertEquals("fuego", c.getAfinidadElemental());
	}
	
	@Test
	public void queLaAfinidadValidaSeGuardeEnMinuscula() {
	    CriaturaElemental c = new CriaturaSalvaje("Bestia", 100, "AgUa", "tranquila");
	    assertEquals("agua", c.getAfinidadElemental());
	}
	
	
}
