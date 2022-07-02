public abstract class Persona {
    private String nombre;
    private String apellido;
    private String direccion;
    private long telefono;
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
    public long getTelefono() {
        return telefono;
    }
    public int getDni() {
        return dni;
    }
    public String getEmail() {
        return email;
    }
    public Persona(String nombre, String apellido, String direccion, long telefono, int dni, String email) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.dni = dni;
        this.email = email;
    }

}
	