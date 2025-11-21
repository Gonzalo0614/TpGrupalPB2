 package ar.edu.unlam.pb2.elandria;

import java.util.*;

public class GestorDeInteracciones {

	private Set<InteraccionEntreCriaturas> reglas;
	
    public GestorDeInteracciones() {
        this.reglas = new HashSet<>();
    }

    public void agregarRegla(InteraccionEntreCriaturas regla) {
        reglas.add(regla);
    }

    public void aplicarInteracciones(CriaturaElemental c1, CriaturaElemental c2) {
        for (InteraccionEntreCriaturas regla : reglas) {
            regla.interaccion(c1, c2);
        }
    }
}
