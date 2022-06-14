import java.util.ArrayList;
import java.time.LocalDate;

public class Secretaria extends Persona {
	private ArrayList<Medico> medicos;


    public Secretaria(String nombre, String apellido, String usuario, String direccion, int telefono, int dni, String email) {
        super(nombre, apellido, direccion, telefono, dni, email);
      this.medicos=new ArrayList<Medico>();

    }
   
    public void Modificar_Fecha (Turno t, LocalDate f) {
    	t.setFecha(f);
    }

    public void addMedico(Medico m) {
        this.medicos.add(m);
    }

    public boolean cancelarTurno(Turno t) {//Devuelve verdadero si lo pudo borrar
        for(Medico m: medicos)
            if(m.equals(t.getMedico()))
                return m.cancelarTurno(t);
        return false;
    }
    
    public void cancelarTurnoPorFiltro (Filtro f) {
    	for (Medico m: medicos)
    		m.cancelar_PorFiltro(f);
    }

    public ArrayList<Medico> getMedicos() {
        return new ArrayList<Medico> (this.medicos);
    }
    
    @Override
    public void addTurno(Turno t) {
        for(Medico m: medicos) {
            if(m.equals(t.getMedico())){
              if (t.getHoraTurno().getHour() >= t.getMedico().getHoraInicio().getHour() && t.getHoraTurno().getHour() < t.getMedico().getHoraFin().getHour()) {
            	m.getTurnos().add(t);
                t.getPaciente().getTurnos().add(t);
              }else
                    System.out.println("La hora del turno no entra en el horario de trabajo del doctor " + t.getMedico().getApellido());              
            }
        }
    }
    
    public ArrayList<Turno> Listar (){
    	ArrayList<Turno> retorno = new ArrayList<Turno>();
    	for (Medico m: medicos)
    		retorno.addAll(m.getTurnos());
    	return retorno;
    }
    
    public ArrayList<Turno> ListarPorFiltro (Filtro f){
    	ArrayList<Turno> retorno = new ArrayList<Turno>();
    	for (Medico m: medicos)
    		{ArrayList<Turno> turnos = m.getTurnos();
    		for (Turno t: turnos)
    			if (f.cumple(t))
    				retorno.add(t);}
    	return retorno;
    }
    
    
}
