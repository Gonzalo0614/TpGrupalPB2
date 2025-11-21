package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.elandria.AncestralDomina;
import ar.edu.unlam.pb2.elandria.CriaturaAncestral;
import ar.edu.unlam.pb2.elandria.CriaturaDomesticada;
import ar.edu.unlam.pb2.elandria.CriaturaElemental;
import ar.edu.unlam.pb2.elandria.GestorDeInteracciones;

public class TestGestorDeInteracciones {

	 @Test
	    public void queApliqueVariasInteraccionesCorrectamente() {

	        CriaturaElemental ancestral = 
	                new CriaturaAncestral("Vulcan", 150, "FUEGO", "tranquila");

	        CriaturaElemental otra = 
	                new CriaturaDomesticada("Lirio", 60, "AGUA", "tranquila");

	        GestorDeInteracciones gestor = new GestorDeInteracciones();

	       
	        gestor.agregarRegla(new AncestralDomina());

	        
	        gestor.agregarRegla((c1, c2) -> c1.aumentarEnergia(5));

	        gestor.aplicarInteracciones(ancestral, otra);

	      
	        assertEquals(175, ancestral.getNivelEnergia().intValue());

	        
	        assertEquals(45, otra.getNivelEnergia().intValue());
	    }

	    @Test
	    public void queNoFalleSiNoHayReglas() {

	        CriaturaElemental c1 = new CriaturaDomesticada("Paz", 80, "AGUA", "tranquila");
	        CriaturaElemental c2 = new CriaturaDomesticada("Furia", 80, "FUEGO", "tranquila");

	        GestorDeInteracciones gestor = new GestorDeInteracciones();

	        try {
	            gestor.aplicarInteracciones(c1, c2); 
	        } catch (Exception e) {
	            fail("No debe fallar si no hay reglas.");
	        }

	        assertEquals(80, c1.getNivelEnergia().intValue());
	        assertEquals(80, c2.getNivelEnergia().intValue());
	    }

	    @Test
	    public void queApliqueLaReglaDeFormaBidireccional() {

	        CriaturaElemental a = new CriaturaAncestral("Anc", 140, "FUEGO", "tranquila");
	        CriaturaElemental b = new CriaturaDomesticada("Dom", 100, "AIRE", "tranquila");

	        GestorDeInteracciones gestor = new GestorDeInteracciones();
	        gestor.agregarRegla(new AncestralDomina());

	        gestor.aplicarInteracciones(a, b);

	        assertEquals(160, a.getNivelEnergia().intValue());
	        assertEquals(85, b.getNivelEnergia().intValue());
	    }

	    @Test
	    public void queSePuedaAgregarMultiplesReglas() {

	        CriaturaElemental c1 = new CriaturaDomesticada("Criatura", 80, "AGUA", "tranquila");
	        CriaturaElemental c2 = new CriaturaDomesticada("Criatura2", 90, "TIERRA", "tranquila");

	        GestorDeInteracciones gestor = new GestorDeInteracciones();

	        gestor.agregarRegla((x, y) -> x.aumentarEnergia(10));
	        gestor.agregarRegla((x, y) -> y.setNivelEnergia(y.getNivelEnergia() + 5));

	        gestor.aplicarInteracciones(c1, c2);

	        assertEquals(90, c1.getNivelEnergia().intValue());
	        assertEquals(95, c2.getNivelEnergia().intValue());
	    }

	}

