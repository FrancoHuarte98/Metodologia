
public class FiltroObraSocial implements Filtro {
	private String os;
	
	public FiltroObraSocial(String obraSocial) {
		this.os = obraSocial;
	}
	
	@Override
	public boolean cumple (Medico m) {
		return m.getObraSocial().equals(os);
	}
	
}
