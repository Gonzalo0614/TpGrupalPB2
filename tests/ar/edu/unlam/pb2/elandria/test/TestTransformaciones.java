package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.elandria.*;

public class TestTransformaciones {

    @Test
    public void testBendicionDelRioDuplicaEnergiaSinSuperar180() {
        CriaturaElemental c = new CriaturaDomesticada("Llama", 100, "FUEGO", "tranquila");
        TransformacionElemental t = new BendicionDelRio(c);
        assertEquals((Integer)180, t.getNivelEnergia());
    }

    @Test
    public void testLlamaInternaAumentaEnergiaSiFuego() {
        CriaturaElemental c = new CriaturaDomesticada("Fuego", 50, "FUEGO", "tranquila");
        TransformacionElemental t = new LlamaInterna(c);
        assertEquals((Integer)80, t.getNivelEnergia()); // 50 + 30
    }

    @Test
    public void testLlamaInternaHaceInestableSiNoFuego() {
        CriaturaElemental c = new CriaturaDomesticada("Agua", 50, "AGUA", "tranquila");
        TransformacionElemental t = new LlamaInterna(c);
        assertEquals("inestable", t.getComportamientoEmocional());
    }

    @Test
    public void testVinculoTerrestreElevaEnergiaMinima50() {
        CriaturaElemental c = new CriaturaDomesticada("Baja", 30, "TIERRA", "tranquila");
        TransformacionElemental t = new VinculoTerrestre(c);
        assertTrue(t.getNivelEnergia() >= 50);
    }

    @Test
    public void testAscensoDelVientoCambiaAfinidadTemporal() {
        CriaturaElemental c = new CriaturaDomesticada("Normal", 60, "FUEGO", "tranquila");
        AscensoDelViento t = new AscensoDelViento(c);
        assertEquals("AIRE", t.getAfinidadElemental());
        assertEquals("FUEGO", t.getAfinidadOriginal());
    }

    @Test
    public void testTransformacionEsDecorador() {
        CriaturaElemental c = new CriaturaDomesticada("Base", 50, "AGUA", "tranquila");
        TransformacionElemental t = new BendicionDelRio(c);
        assertTrue(t.esTransformada());
    }
    
    @Test
    public void testTransformacionEntrenamientoYPacificacionDeCriaturaTransformada() throws Exception {
        MaestroElemental maestro = new MaestroElemental("Gonzalo", 50, "FUEGO");

        CriaturaElemental c = new CriaturaDomesticada("Fenix", 60, "FUEGO", "tranquila");
        maestro.agregarCriatura(c);

        TransformacionElemental t = new LlamaInterna(c);
        maestro.transformarCriatura(t, "Fenix");

        CriaturaElemental transformada = maestro.getCriaturas().get("Fenix");
        assertTrue(transformada instanceof TransformacionElemental);

        assertEquals((Integer)90, transformada.getNivelEnergia());

        maestro.entrenarCriatura("Fenix");
        assertTrue(transformada.getNivelEnergia() > 90);

        transformada.volverseInestable();
        assertEquals("inestable", transformada.getComportamientoEmocional());

        maestro.calmarCriatura("Fenix");
        assertEquals("tranquila", transformada.getComportamientoEmocional());
    }
}
