import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.util.Scanner;

public class Plataforma {

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de turnos!");
        System.out.println("Grupo 11!");


        //inicializo secretaria perteneciente a la institucion
        Secretaria s = new Secretaria("Josefa","Martinez","Josefa Martinez","Alsina 200",202020,35012456,"josefa@gmail.com");
        //inicializo medicos perteneciente a cargo de la secretaria
        System.out.println("Se carga un medico al sistema");
        Medico m1 = new Medico(1, "Maximo", "Gonzalez", "Garibaldi 1000", 123456, 30123456, "maximogonzalez_doc@gmail.com",s, LocalTime.of(11, 00), LocalTime.of(17, 00));
        //en el constructor de medico ya tiene una secretaria precargada, y ésta lo tiene agregado como medico, asi que a no ser q se quiera agragar otra secretaria no hay q hacer nada
        Medico m2 = new Medico(1, "Alfredo", "Macri", "Garibaldi 1000", 654321, 30123456, "alfredoMacri_doc@gmail.com",s, LocalTime.of(11, 00), LocalTime.of(17, 00));
        Medico m3 = new Medico(2, "Paloma", "Isern", "San martin 995", 432564, 17167456, "paloiser_doc@gmail.com",s, LocalTime.of(11, 00), LocalTime.of(17, 00));
        Medico m4 = new Medico(3, "Franco", "Huarte", "Gaucho Rivero 242", 666543,17221496 , "piernaquebrada_doc@gmail.com",s, LocalTime.of(11, 00), LocalTime.of(17, 00));
        Medico m5 = new Medico(4, "Jorge", "Gogorza", "San lorenzo 323", 324567, 13545423, "jorgegogorza_doc@gmail.com",s, LocalTime.of(11, 00), LocalTime.of(17, 00));
        Medico m6 = new Medico(5, "Franco", "Ranieri", "Las heras 1368", 876545, 24568798, "francoraineri_doc@gmail.com",s, LocalTime.of(11, 00), LocalTime.of(17, 00));
        ArrayList<Medico> medicos= new ArrayList<>();
        s.addMedico(m2);
        s.addMedico(m3);
        s.addMedico(m4);
        s.addMedico(m5);
        s.addMedico(m6);



        //carga de paciente

        Scanner valorTexto = new Scanner(System.in);
        Scanner valorInt = new Scanner(System.in);
        System.out.println("ingrese su nombre por favor");
        String nombre = valorTexto.nextLine();
        System.out.println("ingrese su apellido por favor");
        String apellido = valorTexto.nextLine();
        System.out.println("ingrese su direccion por favor");
        String direccion = valorTexto.nextLine();
        System.out.println("ingrese su telefono por favor");
        int telefono = valorInt.nextInt();
        System.out.println("ingrese su dni por favor");
        int dni = valorInt.nextInt();
        System.out.println("ingrese su mail por favor");
        String email = valorTexto.nextLine();
        System.out.println("ingrese su obra social por favor");
        String obraSocial = valorTexto.nextLine();
        System.out.println("ingrese su numero de afiliado por favor");
        int nroAfiliado = valorInt.nextInt();

        Paciente p = new Paciente(nombre,apellido,direccion,telefono,dni,email, obraSocial, nroAfiliado);
        System.out.println("Para solicitar turno");
        System.out.println("Ingrese nombre del doctor");



        System.out.println("Ingrese la fecha, año mes  y dia en ese orden ");
        int anio = valorInt.nextInt();
        int mes = valorInt.nextInt();
        int dia = valorInt.nextInt();

        System.out.println("Ingrese la hora");
        int hora = valorInt.nextInt();

        Turno t = new Turno(p,m1,LocalDate.of(anio,mes,dia),LocalTime.of(hora, 00));
        s.addTurno(t); //este es el que va,que lo agregue la secretaria al turno
        m1.printTurno();


    }
}
