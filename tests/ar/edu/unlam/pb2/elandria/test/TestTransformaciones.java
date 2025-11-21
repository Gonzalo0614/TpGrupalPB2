package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.elandria.AscensoDelViento;
import ar.edu.unlam.pb2.elandria.BendicionDelRio;
import ar.edu.unlam.pb2.elandria.CriaturaDomesticada;
import ar.edu.unlam.pb2.elandria.CriaturaElemental;
import ar.edu.unlam.pb2.elandria.CriaturaSalvaje;
import ar.edu.unlam.pb2.elandria.LlamaInterna;
import ar.edu.unlam.pb2.elandria.TransformacionElemental;
import ar.edu.unlam.pb2.elandria.VinculoTerrestre;

public class TestTransformaciones {

	@Test
	public void queSiLaAfinidadEsInvalidaSeaFuego() {

	    CriaturaElemental c = new CriaturaSalvaje("X", 60, "LAVA", "inestable");

	    assertEquals("fuego", c.getAfinidadElemental());
	}

	@Test
	public void queRespeteAfinidadesValidas() {

	    CriaturaElemental c = new CriaturaSalvaje("X", 60, "AgUa", "tranquila");

	    assertEquals("agua", c.getAfinidadElemental());
	}
	
	@Test
	public void queLaTransformacionMantengaLaIdentidadDeLaCriatura() {

	    CriaturaElemental base = new CriaturaSalvaje("Beast", 70, "AIRE", "inestable");

	    TransformacionElemental transformada = new BendicionDelRio(base);

	    assertEquals(base.getNombre(), transformada.getNombre());
	    assertTrue(transformada.esTransformada());
	}
	@Test
	public void queVinculoTerrestreEleveEnergiaMinimaA50() throws Exception {

	    CriaturaElemental c = new CriaturaDomesticada("Rocky", 20, "TIERRA", "tranquila");

	    TransformacionElemental t = new VinculoTerrestre(c);

	    assertEquals(50, t.getNivelEnergia().intValue());
	}
	
	@Test
	public void queVinculoTerrestreMantengaEnergiasSuperioresA50() throws Exception {

	    CriaturaElemental c = new CriaturaDomesticada("Rocky", 80, "TIERRA", "tranquila");

	    TransformacionElemental t = new VinculoTerrestre(c);

	    assertEquals(80, t.getNivelEnergia().intValue());
	}
	
	@Test
	public void queAscensoDelVientoCambieAfinidadAAire() throws Exception {

	    CriaturaElemental c = new CriaturaSalvaje("Spirit", 80, "FUEGO", "tranquila");

	    AscensoDelViento t = new AscensoDelViento(c);

	    assertEquals("AIRE", t.getAfinidadElemental().toUpperCase());
	    assertEquals("fuego", t.getAfinidadOriginal().toLowerCase());
	}
	
	@Test
	public void queAscensoDelVientoSeaTransformada() {

	    CriaturaElemental c = new CriaturaDomesticada("Luz", 60, "TIERRA", "tranquila");

	    TransformacionElemental t = new AscensoDelViento(c);

	    assertTrue(t.esTransformada());
	}
	
	@Test
	public void queLlamaInternaAumenteEnergiaSiEsDeFuego() throws Exception {

	    CriaturaElemental c = new CriaturaDomesticada("Pyra", 100, "FUEGO", "tranquila");

	    TransformacionElemental t = new LlamaInterna(c);

	    assertEquals(130, t.getNivelEnergia().intValue());
	    assertEquals("tranquila", t.getComportamientoEmocional());
	}
	
	@Test public void queLlamaInternaVuelvaInestableSiNoEsDeFuego() throws Exception { CriaturaElemental c = new CriaturaDomesticada("Brisa", 100, "AIRE", "tranquila"); TransformacionElemental t = new LlamaInterna(c); assertEquals("inestable", t.getComportamientoEmocional()); }
	
	
	
	
	@Test
	public void queBendicionDelRioDupliqueEnergiaSinSuperar180() throws Exception {

	    CriaturaElemental c = new CriaturaSalvaje("Hydra", 100, "AGUA", "tranquila");

	    TransformacionElemental t = new BendicionDelRio(c);

	    assertEquals(180, t.getNivelEnergia().intValue());
	    assertTrue(t.esTransformada());
	}
	
	@Test
	public void queBendicionDelRioDupliqueCorrectamenteSinCapar() throws Exception {

	    CriaturaElemental c = new CriaturaSalvaje("Hydra", 50, "AGUA", "tranquila");

	    TransformacionElemental t = new BendicionDelRio(c);

	    assertEquals(100, t.getNivelEnergia().intValue());
	}


}
