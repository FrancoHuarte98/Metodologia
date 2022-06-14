
public class FiltroMedico implements Filtro {
	private Medico m;
	
	public FiltroMedico (Medico m) {
		m = m;
	}
	
	public boolean cumple (Turno t) {
		return m.equals(t.getMedico());
	}
}
