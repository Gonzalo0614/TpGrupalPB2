package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.elandria.BendicionDelRio;
import ar.edu.unlam.pb2.elandria.CriaturaAncestral;
import ar.edu.unlam.pb2.elandria.CriaturaDomesticada;
import ar.edu.unlam.pb2.elandria.CriaturaElemental;
import ar.edu.unlam.pb2.elandria.CriaturaSalvaje;
import ar.edu.unlam.pb2.elandria.TransformacionElemental;
import ar.edu.unlam.pb2.excepciones.ExcepcionEnergiaMaximaSuperada;

public class TestCriatura {

	@Test
    public void queLaCriaturaSalvajeAumenteEnergiaAlEntrenar() {

        CriaturaElemental c = new CriaturaSalvaje("Bestia", 50, "AGUA", "tranquila");

        int energiaAntes = c.getNivelEnergia();

        try {
            c.entrenar();
        } catch (Exception e) {
           
        }

        assertTrue(c.getNivelEnergia() >= energiaAntes);
    }

  
    @Test
    public void queLaCriaturaAncestralNuncaBajeDe100() {

        CriaturaElemental a = new CriaturaAncestral("anciano", 120, "TIERRA", "tranquila");

    
        a.pacificar();
        a.pacificar();

        assertTrue(a.getNivelEnergia() >= 100);
    }


   
    @Test
    public void queUnaCriaturaNormalNoSeaTransformada() {

        CriaturaElemental c = new CriaturaDomesticada("Normal", 60, "AGUA", "tranquila");

        assertFalse(c.esTransformada());
    }

    @Test
    public void queUnaCriaturaTransformadaSeaDetectadaComoTransformada() {

        CriaturaElemental base = new CriaturaDomesticada("Base", 70, "FUEGO", "tranquila");

        TransformacionElemental decorada = new BendicionDelRio(base);

        assertTrue(decorada.esTransformada());
    }

   
    @Test
    public void quePacificarBajeLaEnergiaDeUnaSalvajeYLaVuelvaTranquila() {

        CriaturaElemental s = new CriaturaSalvaje("Loba", 80, "AIRE", "inestable");

        s.pacificar();

        assertEquals("tranquila", s.getComportamientoEmocional().toLowerCase());
        assertTrue(s.getNivelEnergia() <= 80);
    }

    @Test
    public void quePacificarEnAncestralNuncaLaLleveDebajoDe100() {

        CriaturaElemental a = new CriaturaAncestral("Antigua", 140, "TIERRA", "inestable");

        a.pacificar();

        assertTrue(a.getNivelEnergia() >= 100);
        assertEquals("tranquila", a.getComportamientoEmocional().toLowerCase());
    }

/*
@Test
public void queLaCriaturaAncestralNuncaTengaMenosDe100DeEnergia() {

    CriaturaElemental a = new CriaturaAncestral("Vulcan", 50, "FUEGO", "tranquila");

    assertEquals(100, a.getNivelEnergia().intValue());
}


@Test
public void queLaCriaturaDomesticadaNuncaSeaInestable() throws Exception {

    CriaturaElemental d = new CriaturaDomesticada("tranquilidad", 120, "TIERRA", "inestable");

    d.entrenar();

    assertEquals("tranquila", d.getComportamientoEmocional());
}
*/
@Test
public void queLaCriaturaSalvajeAumenteEnergiaDeFormaAleatoria() throws Exception {

    CriaturaElemental c = new CriaturaSalvaje("Furia", 50, "AIRE", "tranquila");

    int antes = c.getNivelEnergia();

    c.entrenar(); 

    int despues = c.getNivelEnergia();

    assertTrue(despues > antes);
    assertTrue(despues <= 200);
}

@Test(expected = ExcepcionEnergiaMaximaSuperada.class)
public void queLanceExcepcionSiSuperaEnergiaMaxima() throws Exception {

    CriaturaElemental c = new CriaturaSalvaje("Rex", 195, "FUEGO", "tranquila");

    
    c.entrenar();
}
}

