import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Medico extends Persona {
    private int Matricula;
    private int horaInicio;
    private int horaFin;
    private String especialidad;
    private String obraSocial;
    private List<Turno> turnos;

    public Medico(int Matricula, String nombre, String apellido, String direccion, int telefono, int dni, String email,
                  int horaInicio, int horaFin, String especialidad, String obraSocial) {
        super(nombre, apellido, direccion, telefono, dni, email);
        this.Matricula = Matricula;
        this.turnos = new ArrayList<Turno>();
        this.horaInicio = horaInicio;
        this.horaFin=horaFin;
        this.especialidad = especialidad;
        this.obraSocial = obraSocial;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public int getMatricula() {
        return this.Matricula;
    }

    public void setHoraInicio (int t) {
        this.horaInicio = t;
    }

    public void setHoraFin (int t) {
        this.horaFin = t;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public boolean addTurno(Turno t){
        if ((t.getHoraTurno() >= this.getHoraInicio()) && (t.getHoraTurno() < this.getHoraFin())) {
            for(Turno turno: turnos)
                if(turno.getFechaturno().equals(t.getFechaturno()) && turno.getHoraTurno()==t.getHoraTurno()) {
                    System.out.println("Ya existe otro turno en la fecha y hora elejida");
                    return false;
                }
            turnos.add(t);
            return true;
        }
        else {
            System.out.println("La hora del turno no entra en el horario de trabajo del doctor " + this.getApellido());
            return false;
        }
    }

    public void printTurnos() {
        System.out.println("Turnos del medico: "+getNombre()+" "+getApellido());
        for (Turno turno: turnos) {
            System.out.println(turno.toString());
        }
    }

    public boolean cancelarTurno(LocalDate date, int hora) {
        for(Turno turno: turnos)
            if((turno.getFechaturno().equals(date)) && (turno.getHoraTurno()==hora)){
                turnos.remove(turno);
                System.out.println("El turno "+turno+" se canceló con éxito!");
                return true;
            }
        System.out.println("No se encontro la fecha del turno: "+date.toString()+" hora: "+ hora);
        return false;
    }

    public boolean reagendarTurno(LocalDate date, int hora, LocalDate dateNueva, int horaNueva) {
        for(Turno turno: turnos) {
            if ((turno.getFechaturno().equals(dateNueva)) && (turno.getHoraTurno() == horaNueva)) {
                System.out.println("Ya existe otro turno en la fecha y hora elejida");
                return false;
            }
        }
        for(Turno turno: turnos) {
            if ((turno.getFechaturno().equals(date)) && (turno.getHoraTurno() == hora)) {
                if (horaNueva >= this.getHoraInicio() && horaNueva <= this.getHoraFin()) {
                    turno.setHoraTurno(horaNueva);
                    turno.setFecha(dateNueva);
                    System.out.println("El turno se reagendó con éxito!");
                    return true;
                } else {
                    System.out.println("La hora del turno no entra en el horario de trabajo del doctor " + this.getApellido());
                    return false;
                }
            }
        }
        System.out.println("No se encontro la fecha del turno: "+date.toString()+" hora: "+ hora);
        return false;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public List<Turno> getTurnosDelDia(LocalDate f){
        List<Turno> r = new ArrayList<Turno>();
        for (Turno turno: turnos) {
            if (turno.getFechaturno().equals(f))
                r.add(turno);
        }
        Comparator<Turno> c = new Comparator<Turno>() {
            @Override
            public int compare(Turno o1, Turno o2) {
                if (o1.getHoraTurno() < o2.getHoraTurno())
                    return -1;
                return 1;
            }
        };
        r.sort(c);
        return r;
    }

    public String toString(){
        return("Nombre: " + this.getNombre() + this.getApellido() + " - Especialidad: "+ getEspecialidad()+ " - Obra social: "+getObraSocial());
    }

}