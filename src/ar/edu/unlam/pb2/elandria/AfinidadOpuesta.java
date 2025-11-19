package ar.edu.unlam.pb2.elandria;

public class AfinidadOpuesta implements InteraccionEntreCriaturas{

	@Override
	public void interaccion(CriaturaElemental c1, CriaturaElemental c2) {
		if((c1.getAfinidadElemental().toUpperCase().equals("AGUA") && c2.getAfinidadElemental().toUpperCase().equals("FUEGO")) ||
		   (c1.getAfinidadElemental().toUpperCase().equals("FUEGO") && c2.getAfinidadElemental().toUpperCase().equals("AGUA")) ||
		   (c1.getAfinidadElemental().toUpperCase().equals("AIRE") && c2.getAfinidadElemental().toUpperCase().equals("TIERRA")) ||
		   (c1.getAfinidadElemental().toUpperCase().equals("TIERRA") && c2.getAfinidadElemental().toUpperCase().equals("AIRE"))){
			
			c1.volverseInestable();
			c2.volverseInestable();
		}
		
	}

}
