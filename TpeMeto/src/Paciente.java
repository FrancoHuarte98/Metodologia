import java.util.ArrayList;

public class Paciente extends Persona{
	private String obraSocial;
	private int nroAfiliado;
	private ArrayList<Turno> turnos;

	
	public Paciente(String nombre, String apellido, String direccion, int telefono, int dni, String email, String obraSocial, int nroAfiliado) {
        super(nombre, apellido, direccion, telefono, dni, email);
        this.turnos=new ArrayList<Turno>();
        this.obraSocial = obraSocial;
        this.nroAfiliado = nroAfiliado;
    }
	
	public int get_Afiliado () {
		return this.nroAfiliado;
	}

    public ArrayList<Turno> getTurnos() {
        return new ArrayList<> (this.turnos);
    }

    public boolean cancelarTurno(Turno t){
        return turnos.remove(t);
    }
    
    @Override
    public void addTurno(Turno t){
      t.getMedico().addTurno(t);
    }

    public ArrayList<Turno> verTurnos() {
    	return new ArrayList<Turno> (this.turnos);	
    }
    
}
