package ar.edu.unlam.pb2.elandria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReportesDelConsejo {

	
	 private Set<MaestroElemental> maestros;

	    public ReportesDelConsejo(Set<MaestroElemental> maestros) {
	        this.maestros = maestros;
	    }
	    


    public List<CriaturaElemental> listarTodasLasCriaturas() {

        List<CriaturaElemental> lista = new ArrayList<>();

        for (MaestroElemental m : maestros) {
    
            Map<String, CriaturaElemental> mapa = m.getCriaturas();

            for (CriaturaElemental c : mapa.values()) {
                lista.add(c);
            }
        }

        return lista;
    }

   
    public CriaturaElemental obtenerCriaturaConMasEnergia() {

        List<CriaturaElemental> todas = listarTodasLasCriaturas();

        if (todas.isEmpty()) {
            return null;
        }

        CriaturaElemental mayor = todas.get(0);

        for (int i = 1; i < todas.size(); i++) {
            CriaturaElemental actual = todas.get(i);

            if (actual.getNivelEnergia() > mayor.getNivelEnergia()) {
                mayor = actual;
            }
        }

        return mayor;
    }

  
    public MaestroElemental obtenerMaestroConMasCriaturasTransformadas() {

        MaestroElemental mejor = null;
        int maxTransformadas = -1;

        for (MaestroElemental m : maestros) {

            int cantidad = contarTransformadas(m);

            if (cantidad > maxTransformadas) {
                maxTransformadas = cantidad;
                mejor = m;
            }
        }

        return mejor;
    }

    private int contarTransformadas(MaestroElemental m) {

        int total = 0;

        for (CriaturaElemental c : m.getCriaturas().values()) {
            
            if (c.esTransformada()) {
                total++;
            }
        }

        return total;
    }


    public Map<String, Integer> obtenerMapaDeAfinidades() {

        Map<String, Integer> mapa = new HashMap<>();

        List<CriaturaElemental> lista = listarTodasLasCriaturas();

        for (CriaturaElemental c : lista) {

            String afinidad = c.getAfinidadElemental().toUpperCase();

            if (!mapa.containsKey(afinidad)) {
                mapa.put(afinidad, 1);
            } else {
                mapa.put(afinidad, mapa.get(afinidad) + 1);
            }
        }

        return mapa;
    }
}