package ar.edu.unlam.pb2.elandria.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.elandria.*;

public class TestInteracciones {

    private GestorDeInteracciones gestor;

    @Before
    public void setup() {
        gestor = new GestorDeInteracciones();
        gestor.agregarRegla(new AfinidadCompartida());
        gestor.agregarRegla(new AfinidadOpuesta());
        gestor.agregarRegla(new AncestralDomina());
    }

    @Test
    public void testAfinidadCompartidaAumentaEnergia() {
        CriaturaElemental c1 = new CriaturaDomesticada("C1", 50, "AGUA", "tranquila");
        CriaturaElemental c2 = new CriaturaDomesticada("C2", 60, "AGUA", "tranquila");
        gestor.aplicarInteracciones(c1, c2);
        assertEquals((Integer)60, c1.getNivelEnergia());
        assertEquals((Integer)70, c2.getNivelEnergia());
    }

    @Test
    public void testAfinidadOpuestaVuelveInestable() {
        CriaturaElemental c1 = new CriaturaDomesticada("C1", 50, "AGUA", "tranquila");
        CriaturaElemental c2 = new CriaturaDomesticada("C2", 50, "FUEGO", "tranquila");
        gestor.aplicarInteracciones(c1, c2);
        assertEquals("inestable", c1.getComportamientoEmocional());
        assertEquals("inestable", c2.getComportamientoEmocional());
    }

    @Test
    public void testAncestralDominaAumentaYReduceEnergia() {
        CriaturaElemental ancestral = new CriaturaAncestral("A", 100, "TIERRA", "tranquila");
        CriaturaElemental normal = new CriaturaDomesticada("N", 50, "AGUA", "tranquila");
        gestor.aplicarInteracciones(ancestral, normal);
        assertEquals((Integer)120, ancestral.getNivelEnergia()); // +20
        assertEquals((Integer)35, normal.getNivelEnergia()); // -15
    }

    @Test
    public void testCombinacionReglas() {
        CriaturaElemental c1 = new CriaturaDomesticada("C1", 50, "AGUA", "tranquila");
        CriaturaElemental c2 = new CriaturaSalvaje("C2", 40, "AGUA", "tranquila");
        CriaturaElemental c3 = new CriaturaAncestral("C3", 150, "FUEGO", "tranquila");

        gestor.aplicarInteracciones(c1, c2);
        gestor.aplicarInteracciones(c2, c3); 

        assertEquals((Integer)60, c1.getNivelEnergia());
        assertEquals((Integer)35, c2.getNivelEnergia());

        assertEquals((Integer)170, c3.getNivelEnergia());
        assertEquals((Integer)35, c2.getNivelEnergia()); 
    }
}
