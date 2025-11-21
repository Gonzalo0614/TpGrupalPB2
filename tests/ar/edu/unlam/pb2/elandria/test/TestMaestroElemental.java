package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.elandria.AscensoDelViento;
import ar.edu.unlam.pb2.elandria.BendicionDelRio;
import ar.edu.unlam.pb2.elandria.CriaturaAncestral;
import ar.edu.unlam.pb2.elandria.CriaturaDomesticada;
import ar.edu.unlam.pb2.elandria.CriaturaElemental;
import ar.edu.unlam.pb2.elandria.CriaturaSalvaje;
import ar.edu.unlam.pb2.elandria.MaestroElemental;
import ar.edu.unlam.pb2.elandria.TransformacionElemental;
import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class TestMaestroElemental {

	@Test
    public void queUnMaestroPuedaAgregarCriaturas() {

        MaestroElemental maestro = new MaestroElemental("pepe", 20, "AGUA");

        CriaturaElemental c1 = new CriaturaSalvaje("aguita", 80, "AGUA", "tranquila");

        maestro.agregarCriatura(c1);

        assertEquals(1, maestro.getCriaturas().size());
        assertTrue(maestro.getCriaturas().containsKey("aguita"));
    }


    @Test
    public void queUnMaestroPuedaEntrenarUnaCriaturaCuandoTieneMaestria() throws Exception {

        MaestroElemental maestro = new MaestroElemental("Jose", 30, "FUEGO");

        CriaturaElemental c = new CriaturaDomesticada("Fueguito", 50, "FUEGO", "tranquila");

        maestro.agregarCriatura(c);

        maestro.entrenarCriatura("Fueguito"); 

        assertTrue(c.getNivelEnergia() > 50);
    }


    @Test(expected = ExcepcionMaestriaInsuficiente.class)
    public void queLanceExcepcionAlEntrenarCriaturaMuyPoderosaConPocaMaestria() throws Exception {

        MaestroElemental maestro = new MaestroElemental("Nico", 10, "TIERRA");

        CriaturaElemental c = new CriaturaAncestral("Anciano", 150, "TIERRA", "tranquila");

        maestro.agregarCriatura(c);

        maestro.entrenarCriatura("Anciano"); 
    }

  
    @Test
    public void queElMaestroPuedaCalmarUnaCriaturaInestable() {

        MaestroElemental maestro = new MaestroElemental("Juan", 40, "AIRE");

        CriaturaElemental c = new CriaturaSalvaje("Huracan", 60, "AIRE", "inestable");

        maestro.agregarCriatura(c);

        maestro.calmarCriatura("Huracan");

        assertEquals("tranquila", c.getComportamientoEmocional().toLowerCase());
    }


    @Test
    public void queNoCambieUnaCriaturaQueYaEstaTranquila() {

        MaestroElemental maestro = new MaestroElemental("Marcos", 25, "TIERRA");

        CriaturaElemental c = new CriaturaSalvaje("Rocoso", 40, "TIERRA", "tranquila");

        maestro.agregarCriatura(c);

        maestro.calmarCriatura("Rocoso");

        assertEquals("tranquila", c.getComportamientoEmocional().toLowerCase());
    }

  
    @Test
    public void queElMaestroPuedaTransformarUnaCriatura() {

        MaestroElemental maestro = new MaestroElemental("Manu", 40, "FUEGO");

        CriaturaElemental base = new CriaturaDomesticada("Llama", 70, "FUEGO", "tranquila");

        maestro.agregarCriatura(base);

       
        TransformacionElemental transformacion = new BendicionDelRio(base);

        maestro.transformarCriatura(transformacion, "Llama");

        CriaturaElemental despues = maestro.getCriaturas().get("Llama");

        assertTrue(despues instanceof TransformacionElemental);
    }


    @Test
    public void entrenarCriaturaInexistenteNoGeneraExcepcion() throws Exception {

        MaestroElemental maestro = new MaestroElemental("Vacuo", 20, "AGUA");

        maestro.entrenarCriatura("NoExiste"); 

        assertTrue(true); 
    }

 
    @Test
    public void transformarCriaturaInexistenteNoGeneraCambios() {

        MaestroElemental maestro = new MaestroElemental("Void", 40, "AIRE");

        TransformacionElemental t = new BendicionDelRio(
                new CriaturaDomesticada("Fake", 50, "AGUA", "tranquila")
        );

        maestro.transformarCriatura(t, "Inexistente");

        assertEquals(0, maestro.getCriaturas().size());
    }
    
}

