import java.util.ArrayList;
import java.time.LocalDate;

public class Secretaria extends Persona {
    private ArrayList<Medico> medicos;


    public Secretaria(String nombre, String apellido, String usuario, String direccion, int telefono, int dni, String email){
        super(nombre, apellido, direccion, telefono, dni, email);
        this.medicos=new ArrayList<Medico>();
    }

    public void addMedico(Medico m) {
        this.medicos.add(m);
    }

    public ArrayList<Medico> get_Medicos(){
        return new ArrayList<Medico> (medicos);
    }

    public Medico getMedico(int matricula){
        for(Medico medico: medicos)
            if((medico.getMatricula()==matricula)&& (medico.getMatricula()==matricula))
                return medico;
        return null;
    }


    public boolean modificarFechaTurno(String nombreCompleto, LocalDate date, int hora, LocalDate dateNueva, int horaNueva){
        String nombreCompleto1=null;
        for(Medico m: medicos) {
            nombreCompleto1 = m.getNombre() + m.getApellido();
            if (nombreCompleto1.equals(nombreCompleto)) {
                return(m.reagendarTurno(date, hora, dateNueva, horaNueva));
            }
        }
        System.out.println("No se encontro el medico con el nombre: "+ nombreCompleto);
        return false;
    }

    public boolean cancelarTurno(String nombreCompleto, LocalDate date, int hora) {//Devuelve verdadero si lo pudo borrar
        String nombreCompleto1=null;
        for(Medico m: medicos) {
            nombreCompleto1 = m.getNombre() + m.getApellido();
            if (nombreCompleto1.equals(nombreCompleto)) {
                return(m.cancelarTurno(date, hora));
            }
        }
        System.out.println("No se encontro el medico con el nombre: "+ nombreCompleto);
        return false;
    }

    public boolean addTurno(Turno t) {
        for (Medico m : medicos) {
            if (m.equals(t.getMedico()))
                return(m.addTurno(t));
        }
        System.out.println("No se encontro el medico");
        return false;
    }
    public void printTurnos(){
        System.out.println("Secretaria: "+getNombre()+" "+getApellido());
        for(Medico medico:medicos)
            medico.printTurnos();
    }
}
