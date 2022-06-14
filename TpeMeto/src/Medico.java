
import java.util.ArrayList;

import java.time.LocalTime;


public class Medico extends Persona {
	private Secretaria secretaria;
	private int Matricula;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private ArrayList<Turno> turnos;

    public Medico(int Matricula, String nombre, String apellido, String direccion, int telefono, int dni, String email,
                  Secretaria secretaria, LocalTime horaInicio, LocalTime horaFin) {
        super(nombre, apellido, direccion, telefono, dni, email);
        this.Matricula = Matricula;
        this.secretaria = secretaria;
        this.secretaria.addMedico(this);
        this.turnos = new ArrayList<Turno>();
        this.horaInicio = horaInicio;
        this.horaFin=horaFin;
    }

    public int get_Matricula() {
    	return this.Matricula;
    }
    
    public void addTurno(Turno t) {
        secretaria.addTurno(t);
    }
    
    public void set_HoraInicio (LocalTime t) {
    	this.horaInicio = t;
    }
    
    public void set_HoraFin (LocalTime t) {
    	this.horaFin = t;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public ArrayList<Turno> getTurnos() {
        return this.turnos;
    }
    
    public void printTurno() {
        for (int i=0; i<this.getTurnos().size();i++) {
            System.out.println(this.getTurnos().get(i));
        }
    }
    
    public void cancelar_PorFiltro (Filtro f) {
    	for (Turno t: turnos)
    		{if (f.cumple(t))
    			turnos.remove(t);}
    }

    public boolean cancelarTurno(Turno t) {
        return turnos.remove(t);
    }
	
}
