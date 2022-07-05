import java.time.LocalDate;

public class Turno {
    private Paciente paciente;
    private Medico medico;
    private LocalDate fechaturno;
    private int horaTurno;
    public Turno(Paciente paciente, Medico medico, LocalDate fechaturno, int horaTurno){
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

    public int getHoraTurno() {
        return horaTurno;
    }

    public void setHoraTurno(int hora) {
        this.horaTurno = hora;
    }

    public void setFecha(LocalDate fecha) {
        this.fechaturno = fecha;
    }

    public void setPaciente(Paciente p){
        this.paciente=p;
    }
    @Override
    public String toString() {
        return "Turno de [paciente=" + paciente.getNombre() + " "+ paciente.getApellido() + ", medico=" + medico.getNombre() + " " + medico.getApellido() + ", fechaturno=" + fechaturno +", horaturno: " + horaTurno +" hs"+"]";
    }
}
