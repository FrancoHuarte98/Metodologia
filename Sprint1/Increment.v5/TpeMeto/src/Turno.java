import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
	 private Paciente paciente;
	    private Medico medico;
	    private LocalDate fechaturno;
	    private LocalTime horaTurno;
	    
	    public Turno(Paciente paciente, Medico medico, LocalDate fechaturno, LocalTime horaTurno) {
	        this.paciente = paciente;
	        this.medico = medico;
	        this.fechaturno = fechaturno;
	        this.horaTurno= horaTurno;
	    }
	    
	    public Paciente getPaciente() {
	        return paciente;
	    }
	    
	    public Medico getMedico() {
	        return medico;
	    }
	    
	    public LocalDate getFechaturno() {
	        return fechaturno;
	    }


	    public LocalTime getHoraTurno() {
	        return horaTurno;
	    }

	    public void setHoraTurno(LocalTime horaTurno) {
	        if (horaTurno.getHour() >= this.getMedico().getHoraInicio().getHour() && horaTurno.getHour() <= this.getMedico().getHoraFin().getHour()) { //en otra release implementar un comparador 
	            this.horaTurno = horaTurno;
	        }
	    }
	    
	    public void setFecha (LocalDate fecha) {
	    	this.fechaturno = fecha;
	    }
	    
	    @Override
	    public String toString() {
	        return "Turno de [paciente=" + paciente.getNombre() + " "+ paciente.getApellido() + ", medico=" + medico.getNombre() + " " + medico.getApellido() + ", fechaturno=" + fechaturno + "]";
	    }


}
