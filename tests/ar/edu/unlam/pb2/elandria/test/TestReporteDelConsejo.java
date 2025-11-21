package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

import ar.edu.unlam.pb2.elandria.AscensoDelViento;
import ar.edu.unlam.pb2.elandria.CriaturaDomesticada;
import ar.edu.unlam.pb2.elandria.CriaturaElemental;
import ar.edu.unlam.pb2.elandria.CriaturaSalvaje;
import ar.edu.unlam.pb2.elandria.LlamaInterna;
import ar.edu.unlam.pb2.elandria.MaestroElemental;
import ar.edu.unlam.pb2.elandria.ReportesDelConsejo;
import ar.edu.unlam.pb2.elandria.TransformacionElemental;

public class TestReporteDelConsejo {

	 private MaestroElemental crearMaestro(String nombre, int maestria, String afinidad) {
	        return new MaestroElemental(nombre, maestria, afinidad);
	    }

	 @Test
	    public void queListeTodasLasCriaturasDelConsejo() {

	        MaestroElemental m1 = crearMaestro("Aang", 30, "AIRE");
	        MaestroElemental m2 = crearMaestro("Korra", 40, "AGUA");

	        m1.agregarCriatura(new CriaturaDomesticada("Paz", 50, "AGUA", "tranquila"));
	        m2.agregarCriatura(new CriaturaSalvaje("Furia", 70, "AIRE", "inestable"));

	        Set<MaestroElemental> maestros = new HashSet<>();
	        maestros.add(m1);
	        maestros.add(m2);

	        ReportesDelConsejo r = new ReportesDelConsejo(maestros);

	        List<CriaturaElemental> lista = r.listarTodasLasCriaturas();

	        assertEquals(2, lista.size());
	    }

	    @Test
	    public void queDevuelvaLaCriaturaConMasEnergia() {

	        MaestroElemental m = crearMaestro("Zuko", 50, "FUEGO");

	        CriaturaElemental baja = new CriaturaDomesticada("Tortuga", 20, "AGUA", "tranquila");
	        CriaturaElemental alta = new CriaturaDomesticada("Dragón", 150, "FUEGO", "tranquila");

	        m.agregarCriatura(baja);
	        m.agregarCriatura(alta);

	        ReportesDelConsejo r = new ReportesDelConsejo(Set.of(m));

	        assertEquals("Dragón", r.obtenerCriaturaConMasEnergia().getNombre());
	    }

	    @Test
	    public void queDevuelvaNullSiNoHayCriaturas() {

	        MaestroElemental m = crearMaestro("Katara", 20, "AGUA");

	        ReportesDelConsejo r = new ReportesDelConsejo(Set.of(m));

	        assertNull(r.obtenerCriaturaConMasEnergia());
	    }


	    @Test
	    public void queDevuelvaAlMaestroConMasTransformadas() {

	        MaestroElemental m1 = crearMaestro("Iroh", 50, "FUEGO");
	        MaestroElemental m2 = crearMaestro("Toph", 50, "TIERRA");

	        CriaturaElemental c1 = new CriaturaDomesticada("Draco", 80, "FUEGO", "tranquila");
	        CriaturaElemental c2 = new CriaturaDomesticada("Topo", 40, "TIERRA", "tranquila");

	        m1.agregarCriatura(c1);
	        m2.agregarCriatura(c2);

	     
	        TransformacionElemental t = new LlamaInterna(c1);
	        m1.transformarCriatura(t, "Draco");

	        ReportesDelConsejo r = new ReportesDelConsejo(Set.of(m1, m2));

	        assertEquals("Iroh", r.obtenerMaestroConMasCriaturasTransformadas().getNombre());
	    }

	    @Test
	    public void queSiNadieTieneTransformadasDevuelvaAlPrimero() {

	        MaestroElemental m1 = crearMaestro("A", 10, "AGUA");
	        MaestroElemental m2 = crearMaestro("B", 20, "FUEGO");

	        ReportesDelConsejo r = new ReportesDelConsejo(Set.of(m1, m2));

	        MaestroElemental res = r.obtenerMaestroConMasCriaturasTransformadas();

	        assertNotNull(res);  
	    }

	 
	    @Test
	    public void queGenereMapaDeAfinidadesCorrectamente() {

	        MaestroElemental m = crearMaestro("Aang", 40, "AIRE");

	        m.agregarCriatura(new CriaturaDomesticada("Paz", 50, "AGUA", "tranquila"));
	        m.agregarCriatura(new CriaturaDomesticada("Flama", 120, "FUEGO", "tranquila"));
	        m.agregarCriatura(new CriaturaSalvaje("Tornado", 80, "AIRE", "inestable"));

	        ReportesDelConsejo r = new ReportesDelConsejo(Set.of(m));

	        Map<String, Integer> mapa = r.obtenerMapaDeAfinidades();

	        assertEquals(Integer.valueOf(1), mapa.get("AGUA"));
	        assertEquals(Integer.valueOf(1), mapa.get("FUEGO"));
	        assertEquals(Integer.valueOf(1), mapa.get("AIRE"));
	    }

	    @Test
	    public void queRetorneMapaVacioSiNoHayCriaturas() {

	        MaestroElemental m = crearMaestro("Korra", 40, "AGUA");

	        ReportesDelConsejo r = new ReportesDelConsejo(Set.of(m));

	        Map<String, Integer> mapa = r.obtenerMapaDeAfinidades();

	        assertTrue(mapa.isEmpty());
	    }
	}