package ar.edu.unlam.pb2.elandria.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ar.edu.unlam.pb2.elandria.*;

public class MaestroElementalTest {


    private MaestroElemental maestro;
    private CriaturaDomesticada cDom;
    private CriaturaSalvaje cSalvaje;
    private CriaturaAncestral cAncestral;
    private GestorDeInteracciones gestor;
    
    @Before
    public void setUp() throws Exception{
        maestro = new MaestroElemental("Gandalf", 30, "AGUA");

        cDom = new CriaturaDomesticada("Firo", 50, "FUEGO", "tranquila");
        cSalvaje = new CriaturaSalvaje("Tigre", 80, "AGUA", "inestable");
        cAncestral = new CriaturaAncestral("Fenix", 150, "AIRE", "tranquila");

        maestro.agregarCriatura(cDom);
        maestro.agregarCriatura(cSalvaje);
        maestro.agregarCriatura(cAncestral);

        gestor = new GestorDeInteracciones();
        gestor.agregarRegla(new AfinidadCompartida());
        gestor.agregarRegla(new AfinidadOpuesta());
        gestor.agregarRegla(new AncestralDomina());
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
