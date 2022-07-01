
public class FiltroEspecialidad implements Filtro {
	private String e;
	
	public FiltroEspecialidad(String especialidad) {
		this.e = especialidad;
	}
	
	@Override
	public boolean cumple (Medico m) {
		return m.getEspecialidad().equals(e);
	}
	
}
