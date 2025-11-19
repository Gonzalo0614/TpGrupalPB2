package ar.edu.unlam.pb2.elandria;

import ar.edu.unlam.pb2.excepciones.ExcepcionMaestriaInsuficiente;

public class AscensoDelViento extends TransformacionElemental{
	
	private String afinidadOriginal;

	public AscensoDelViento(CriaturaElemental criatura) {
		super(criatura);
		this.afinidadOriginal = criatura.getAfinidadElemental().toUpperCase();
		this.criatura.setAfinidadElemental("AIRE");
	}
	
    @Override
    public String getAfinidadElemental() {
        return "AIRE";
    }

    @Override
    public TransformacionElemental aplicar(CriaturaElemental criatura) {
        return new AscensoDelViento(criatura);
    }

	@Override
	public void entrenar() throws ExcepcionMaestriaInsuficiente {
		criatura.entrenar();
		
	}

	@Override
	public void pacificar() {
		criatura.pacificar();
	}
	

    public String getAfinidadOriginal() {
        return afinidadOriginal;
    }
}
