import java.time.LocalDate;
import java.util.*;


public class Plataforma {

    private static HashMap<Integer , Secretaria> cuentasSecretaria= new HashMap<>();
    private static HashMap<Integer , Paciente> cuentasPaciente= new HashMap<>();

    public static LocalDate ingresarFechaTurno(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese dia del turno: ");
        int dia=scanner.nextInt();
        System.out.println("Ingrese mes del turno:");
        int mes=scanner.nextInt();
        System.out.println("Ingrese año del turno:");
        int anio=scanner.nextInt();
        return LocalDate.of(anio, mes, dia);
    }

    public static int ingresarHoraTurno(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese hora del turno");
        return scanner.nextInt();
    }

    public static String ingresarNombreApellidoMedico(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese primer nombre del medico:");
        String nombre=scanner.next();
        System.out.println("Ingrese apellido del medico:");
        String apellido=scanner.next();
        return (nombre+apellido);
    }
    
    public static String ingresarEspecialidad() {
    	Scanner scanner = new Scanner (System.in);
    	System.out.println("Ingrese especialidad deseada");
    	String especialidad = scanner.next();
    	return especialidad;
    }
    
    public static String ingresarObraSocial() {
    	Scanner scanner = new Scanner (System.in);
    	System.out.println("Ingrese obra social deseada");
    	String obraSocial = scanner.next();
    	return obraSocial;
    }

    
    public static Secretaria login(){
        String opcion="s";
        Scanner scanner = new Scanner(System.in);
        while(opcion.equals("s")){
            System.out.println("Ingrese email");
            String email = scanner.next();
            System.out.println("Ingrese contraseña");
            int contrasena = scanner.nextInt();
            if(cuentasSecretaria.get(contrasena).getEmail().equals(email)) {
                return (cuentasSecretaria.get(contrasena));
            }
            else{
                System.out.println("Email y/o contraseña incorrectos, si desea reintentar precione 's', de lo contrario cualquier otro caracter");
                opcion= scanner.next();
            }
        }
        return null;
    }

    public static Paciente loginPaciente() {
        String opcion = "s";
        Scanner scanner = new Scanner(System.in);
        while (opcion.equals("s")) {
            System.out.println("Ingrese DNI");
            Integer DNI = scanner.nextInt();
            if (cuentasPaciente.containsKey(DNI)){
                return (cuentasPaciente.get(DNI));
            }
            else {
                System.out.println("DNI no encontrado, si desea reintentar precione 's', de lo contrario cualquier otro caracter");
                opcion = scanner.next();
            }
        }
        return null;
    }

    public static void menuSecretaria(Secretaria s){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String nombreCompleto=null;
        LocalDate date = null, date1=null;
        int hora = 0, hora1=0;
        System.out.println("Ingreso con exito!");
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Cancelar turno");
            System.out.println("2. Reagendar turno");
            System.out.println("3. Salir");
            try {

                System.out.println("Escribe una de las opciones");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1: cancelar turno");
                        nombreCompleto= ingresarNombreApellidoMedico();
                        System.out.println("Ingrese fecha y hora del turno a cancelar");
                        date=ingresarFechaTurno();
                        hora=ingresarHoraTurno();
                        s.cancelarTurno(nombreCompleto, date, hora);
                        break;
                    case 2:
                        System.out.println("Elegise la opcion 2: reagendar turno");
                        nombreCompleto= ingresarNombreApellidoMedico();
                        System.out.println("Ingrese fecha y hora del turno a reagendar");
                        date=ingresarFechaTurno();
                        hora=ingresarHoraTurno();
                        System.out.println("Ingrese la nueva fecha y hora");
                        date1=ingresarFechaTurno();
                        hora1=ingresarHoraTurno();
                        s.modificarFechaTurno(nombreCompleto, date, hora, date1, hora1);
                        break;

                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scanner.next();
            }
        }
    }

    public static void verHorariosDelMedico(Medico m) {
    	System.out.println("Medico seleccionado : " + m.getNombre() + " " + m.getApellido());
    	System.out.println(" -Horario de atencion: " + m.getHoraInicio() + " - " + m.getHoraFin());
    }
    
    public static void mostrarMedicosQueCumplen(Filtro filtro) {
        ArrayList<Medico> meds = new ArrayList<>();
        ArrayList<Medico> resultado = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer, Secretaria> entry: cuentasSecretaria.entrySet())
        	meds.addAll(entry.getValue().get_Medicos());
        	for (Medico m: meds) {
            	if ((!resultado.contains(m)) && (filtro.cumple(m)))
            		resultado.add(m);
            	}
        	if (resultado.size()==0)
        		System.out.println("No hay medicos que cumplan con el filtro buscado");
        	else
        		{System.out.println("Los medicos que cumplen con el filtro buscado son");
        		for (Medico m: resultado)
        			System.out.println ("Medico: "+ m.getNombre()+" "+ m.getApellido());
        		System.out.println("Si desea seleccionar alguno de los medicos listados ingrese 's', de lo contrario ingrese cualquier otro caracter");
        		String linea = scanner.next();
        		if (linea.equals("s")) 
        			{ 	System.out.println("Ingrese el nombre del medico con el que desea solicitar un turno");
        				String nombreCompleto = ingresarNombreApellidoMedico(); 
        				for (Medico m: resultado) {
        					String med = m.getNombre() + m.getApellido();
        					if (med.equals(nombreCompleto)) {
        						verHorariosDelMedico(m);
        						//SDT-65: "Se debe mostrar una lista de los próximos 10 turnos disponibles del medico seleccionado."
        					}
        				}
        			}
        		}
    }
    
    public static void menuPaciente(Paciente p){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        Filtro filtro;
        ArrayList <Medico> resultado = new ArrayList<>();
        boolean salir = false;
        while (!salir) {
            System.out.println("1. Buscar medicos segun especialidad");
            System.out.println("2. Buscar medicos segun obra social");
            System.out.println("3. Buscar medicos segun obra social y especialidad");
            System.out.println("4. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1: Buscar medicos segun especialidad");
                        filtro = new FiltroEspecialidad(ingresarEspecialidad());
                        mostrarMedicosQueCumplen(filtro);
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2: Buscar medicos segun obra social");
                        filtro = new FiltroObraSocial(ingresarObraSocial());
                        mostrarMedicosQueCumplen(filtro);
                        break;
                    case 3:
                    	System.out.println("Has seleccionado la opcion 3: Buscar medicos segun obra social y especialidad");
                    	filtro= new FiltroEspecialidad(ingresarEspecialidad());
                    	Filtro filtro2 = new FiltroObraSocial(ingresarObraSocial());
                    	//inicializar filtro and
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 3");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                scanner.next();
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de turnos!");
        System.out.println("Grupo 11");

        Secretaria s1 = new Secretaria("Josefa", "Martinez", "Josefa Martinez", "Alsina 200", 202020, 35012456, "josefa@gmail.com");
        Secretaria s2 = new Secretaria("Lorena", "Martinez", "Lorena Martinez", "San Martin 200", 2020, 12012456, "lorena@gmail.com");
        cuentasSecretaria.put(1, s1);
        cuentasSecretaria.put(2, s2);
        
        
        
        Medico m1 = new Medico(1, "Lucas", "Quiroga", "Colombia 622", 123456, 38178273, "quiroga@gmail.com", 11, 17, "Neurologia", "ioma");
        Medico m2 = new Medico(2, "Alfredo", "Macri", "Garibaldi 1050", 654321, 30123456, "alfredoMacri_doc@gmail.com", 11, 17, "Cardiologia", "osde");
        Medico m3 = new Medico(3, "Paloma", "Isern", "San martin 995", 432564, 17167456, "paloiser_doc@gmail.com", 11, 17, "Dermatologia", "ioma");
        Medico m4 = new Medico(4, "Franco", "Huarte", "Gaucho Rivero 242", 666543, 17221496, "piernaquebrada_doc@gmail.com", 11, 17, "Cirugia", "swiss medical");
        Medico m5 = new Medico(5, "Jorge", "Gogorza", "San lorenzo 323", 324567, 13545423, "jorgegogorza_doc@gmail.com", 11, 17, "Neurologia", "osecac");
        Medico m6 = new Medico(6, "Franco", "Raineri", "Las heras 1368", 876545, 24568798, "francoraineri_doc@gmail.com", 11, 17, "Neumonologia", "ioma");

        s1.addMedico(m1);
        s1.addMedico(m2);
        s1.addMedico(m3);
        s1.addMedico(m4);
        s2.addMedico(m5);
        s2.addMedico(m6);

        Paciente p1=new Paciente("Juan", "ignacio", "Alsina 200", 450450, 400000 , "juani@gmail", "osde", 134545);
        Paciente p2=new Paciente("Juan", "pablo", "Garibaldi 300", 415415, 4001000 , "juanpa@gmail", "osde",131313);

        cuentasPaciente.put(p1.getDni(), p1);
        cuentasPaciente.put(p2.getDni(), p2);
        LocalDate d1= LocalDate.of(2022,1,1);
        LocalDate d2= LocalDate.of(2022,1,2);
        LocalDate d3= LocalDate.of(2022,1,3);
        LocalDate d4= LocalDate.of(2022,1,4);
        LocalDate d5= LocalDate.of(2022,1,5);

        Turno t1= new Turno(p1, m1, d1, 17);
        Turno t2= new Turno(p2, m1, d2, 16);
        Turno t3= new Turno(p1, m2, d3, 14);
        Turno t4= new Turno(p2, m3, d1, 15);
        Turno t5= new Turno(p1, m4, d1, 15);
        Turno t6= new Turno(p1, m5, d4, 11);
        s1.addTurno(t1);
        s1.addTurno(t2);
        s1.addTurno(t3);
        s1.addTurno(t4);
        s1.addTurno(t5);
        s2.addTurno(t6);
        
        		
        
        //System.out.println("Datos del sistema:");
        //System.out.println("-----------------------");
        /*
        for(Map.Entry<Integer, Secretaria> entry: cuentas.entrySet())
            entry.getValue().printTurnos();

        System.out.println("-----------------------");
        */
        
        

        Secretaria s = null;
        Paciente p= null;
        int opcion;
        String nombreCompleto=null;
        LocalDate date = null, date1=null;
        int hora = 0, hora1=0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Identifiquese como secretaria o paciente, ingresando 's' o 'p' respectivamente:");
        String linea = scanner.next();
        if(linea.equals("p")) {
            System.out.println("Identifiquese como paciente registrado o nuevo, ingresando 'r' o 'n'");
            linea = scanner.next();
            if (linea.equals("n")) {
                Scanner entrada = new Scanner(System.in);
                System.out.println("Ingrese su DNI:");
                int dni = entrada.nextInt();
                System.out.println("Ingrese su nombre:");
                String nombre = entrada.next();
                System.out.println("Ingrese su apellido:");
                String apellido = entrada.next();
                System.out.println("Ingrese su direccion:");
                Scanner aux = new Scanner(System.in);
                String direccion = aux.nextLine();
                System.out.println("Ingrese su telefono:");
                long telefono = entrada.nextLong();
                System.out.println("Ingrese su email:");
                String email = entrada.next();
                System.out.println("Ingrese su obra social:");
                String obraSoc = entrada.next();
                System.out.println("Ingrese su numero de afiliado:");
                int nroAfiliado = entrada.nextInt();
                p = new Paciente(nombre,apellido,direccion,telefono,dni,email,obraSoc,nroAfiliado);
                System.out.println("El paciente se registro con exito");
                cuentasPaciente.put(p.getDni(),p);
                menuPaciente(p);
            }else
                {p = loginPaciente();
                if (p != null)
                	menuPaciente(p);}
            	
        }
        if(linea.equals("s"))
            s= login();

        if ((s!=null) && (linea.equals("s")))
            menuSecretaria(s);


    }

}