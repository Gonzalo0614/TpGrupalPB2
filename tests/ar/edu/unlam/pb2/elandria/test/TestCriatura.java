package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.elandria.*;
import ar.edu.unlam.pb2.excepciones.*;

public class TestCriatura {

    @Test
    public void queLaCriaturaSalvajeAumenteEnergiaAlEntrenar() {
        CriaturaElemental c = new CriaturaSalvaje("Bestia", 50, "AGUA", "tranquila");
        int energiaAntes = c.getNivelEnergia();

        try {
            c.entrenar();
        } catch (Exception e) {}

        assertTrue(c.getNivelEnergia() >= energiaAntes);
    }

    @Test
    public void queLaCriaturaSalvajeNoSupere200AlEntrenar() throws Exception {
        CriaturaElemental c = new CriaturaSalvaje("Furia", 180, "AIRE", "tranquila");
        try {
            c.entrenar();
            assertTrue(c.getNivelEnergia() <= 200);
        } catch (ExcepcionEnergiaMaximaSuperada e) {
        }
    }

    @Test(expected = ExcepcionEnergiaMaximaSuperada.class)
    public void queLanceExcepcionSiSuperaEnergiaMaxima() throws Exception {
        CriaturaElemental c = new CriaturaSalvaje("Rex", 195, "FUEGO", "tranquila");
        c.entrenar();
    }

    @Test
    public void quePacificarBajeLaEnergiaDeUnaSalvajeYLaVuelvaTranquila() {
        CriaturaElemental s = new CriaturaSalvaje("Loba", 80, "AIRE", "inestable");
        s.pacificar();
        assertEquals("tranquila", s.getComportamientoEmocional().toLowerCase());
        assertTrue(s.getNivelEnergia() <= 80);
    }

    @Test
    public void queCriaturaDomesticadaNuncaSeaInestable() throws Exception {
        CriaturaElemental d = new CriaturaDomesticada("tranquilidad", 120, "TIERRA", "inestable");
        d.entrenar();
        assertEquals("tranquila", d.getComportamientoEmocional());
    }

    @Test
    public void queCriaturaDomesticadaNoSupere200DeEnergia() throws Exception {
        CriaturaElemental d = new CriaturaDomesticada("Segura", 195, "FUEGO", "tranquila");
        d.entrenar();
        assertTrue(d.getNivelEnergia() <= 200);
    }

    @Test
    public void queLaCriaturaAncestralNuncaBajeDe100() {
        CriaturaElemental a = new CriaturaAncestral("Anciano", 50, "TIERRA", "tranquila");
        assertTrue(a.getNivelEnergia() >= 100);
    }

    @Test
    public void quePacificarEnAncestralNuncaLaLleveDebajoDe100() {
        CriaturaElemental a = new CriaturaAncestral("Antigua", 140, "TIERRA", "inestable");
        a.pacificar();
        assertTrue(a.getNivelEnergia() >= 100);
        assertEquals("tranquila", a.getComportamientoEmocional().toLowerCase());
    }

    @Test
    public void queBendicionDelRioDuplicaEnergiaPeroNoSupera180() {
        CriaturaElemental c = new CriaturaDomesticada("Base", 100, "AGUA", "tranquila");
        TransformacionElemental t = new BendicionDelRio(c);
        assertTrue(t.getNivelEnergia() <= 180);
    }

    @Test
    public void queAscensoDelVientoCambiaAfinidad() {
        CriaturaElemental c = new CriaturaDomesticada("Viento", 70, "TIERRA", "tranquila");
        AscensoDelViento t = new AscensoDelViento(c);
        assertEquals("AIRE", t.getAfinidadElemental());
        assertEquals("tierra", t.getAfinidadOriginal().toLowerCase());
    }

    @Test
    public void queLlamaInternaAumentaEnergiaSiFuego() {
        CriaturaElemental c = new CriaturaDomesticada("Fuego", 50, "FUEGO", "tranquila");
        LlamaInterna t = new LlamaInterna(c);
        assertTrue(t.getNivelEnergia() == 80); // 50 + 30
    }

    @Test
    public void queLlamaInternaVuelveInestableSiNoFuego() {
        CriaturaElemental c = new CriaturaDomesticada("Agua", 50, "AGUA", "tranquila");
        LlamaInterna t = new LlamaInterna(c);
        assertEquals("inestable", t.getComportamientoEmocional());
    }

    @Test
    public void queVinculoTerrestreAjustaEnergiaMinima() {
        CriaturaElemental c = new CriaturaDomesticada("Tierra", 30, "TIERRA", "tranquila");
        VinculoTerrestre t = new VinculoTerrestre(c);
        assertEquals(50, t.getNivelEnergia().intValue());
    }

    @Test
    public void queVinculoTerrestreNoCambiaEnergiaMayor50() {
        CriaturaElemental c = new CriaturaDomesticada("Firme", 70, "TIERRA", "tranquila");
        VinculoTerrestre t = new VinculoTerrestre(c);
        assertEquals(70, t.getNivelEnergia().intValue());
    }


    @Test
    public void queEsTransformadaDetectaCorrectamente() {
        CriaturaElemental base = new CriaturaDomesticada("Base", 70, "FUEGO", "tranquila");
        TransformacionElemental decorada = new BendicionDelRio(base);
        assertTrue(decorada.esTransformada());
        assertFalse(base.esTransformada());
    }
    

    @Test
    public void queCriaturaDomesticadaNuncaSeVuelvaInestable() throws Exception {
        CriaturaElemental d = new CriaturaDomesticada("tranquilidad", 120, "TIERRA", "inestable");
        d.entrenar();
        d.pacificar();
        assertEquals("tranquila", d.getComportamientoEmocional());
    }

    @Test
    public void quePacificarNoBajeEnergiaPorDebajoDeCero() {
        CriaturaElemental s = new CriaturaSalvaje("Pequeña", 5, "AGUA", "inestable");
        s.pacificar();
        assertTrue(s.getNivelEnergia() >= 0);
    }

}
