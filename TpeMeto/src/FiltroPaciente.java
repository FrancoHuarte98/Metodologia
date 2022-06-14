
public class FiltroPaciente implements Filtro{
	private Paciente p;
	
	public FiltroPaciente (Paciente p) {
		this.p = p;
	}
	
	public boolean cumple (Turno t) {
		return p.get_Afiliado() == t.getPaciente().get_Afiliado(); //Lo compara por Numero de Afiliado
	}
}
