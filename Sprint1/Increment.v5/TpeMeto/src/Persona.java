import java.util.List;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private int dni;
	private String email;
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public int getDni() {
		return dni;
	}
	public String getEmail() {
		return email;
	}
	public Persona(String nombre, String apellido, String direccion, int telefono, int dni, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
		this.email = email;
	}
	
	public abstract void addTurno(Turno t);
}
	
	

