import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Empleado {
    static List<Empleado> empleados = new ArrayList<>();
    String nombre;
    String apellido;
    LocalDate fechadenacimiento;
    Double sueldo;

    public Empleado(String nombre, String apellido, String fechadenacimiento, String sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechadenacimiento = convertirFecha(fechadenacimiento);
        this.sueldo = convertirSueldo(sueldo);
    }

    public String verNombre() {
        return nombre;
    }

    public String verApellido() {
        return apellido;
    }

    public LocalDate verNacimiento() {
        return fechadenacimiento;
    }

    public double verSueldo() {
        return sueldo;
    }

    public LocalDate convertirFecha(String fechadenacimiento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = fechadenacimiento;
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public Double convertirSueldo(String sueldo) {
        double sueldo_convertido = Double.parseDouble(sueldo);
        return sueldo_convertido;
    }

    public static void cargaEmpleado() {
        String archivo = "D:/Informatorio/Etapa 3/Info-Java/Whiteboard/Ejercicio5/lista.txt";
        try (Stream<String> stream = Files.lines(Paths.get(archivo))) {
            stream.forEach((e) -> {
                String[] lista = e.split(",");
                String nombre = lista[0];
                String apellido = lista[1];
                String fechadenacimiento = lista[2];
                String sueldo = lista[3];
                Empleado persona = new Empleado(nombre, apellido, fechadenacimiento, sueldo);
                empleados.add(persona);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inicialApellido(String letra) {
        List<Empleado> apellidos = new ArrayList<>();
        for (Empleado i : empleados) {
            if (i.verApellido().startsWith(letra)) {
                apellidos.add(i);
            }
        }
        return apellidos.toString().replace("[", "").replace("]", "").replace(",", "");
    }

    public static String mayorSueldo() {
        List<Empleado> alto = new ArrayList<>();
        Double sueldoalto = empleados.get(0).verSueldo();
        for (Empleado i : empleados) {
            if (i.verSueldo() > sueldoalto) {
                sueldoalto = i.verSueldo();
                alto.add(i);
            }
        }
        return alto.get(alto.size()-1).toString() + " $" + sueldoalto;
    }

    public static String menorSueldo() {
        List<Empleado> bajo = new ArrayList<>();
        double sueldobajo = empleados.get(0).verSueldo();
        for (Empleado i : empleados) {
            if (i.verSueldo() < sueldobajo) {
                sueldobajo = i.verSueldo();
                bajo.add(i);
            }
        }
        return bajo.get(bajo.size()-1).toString() + " $" + sueldobajo;
    }
    public int verEdad(String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate hoy = LocalDate.parse(fecha,formatter);
        int anio = hoy.getYear();
        int edad = anio - this.fechadenacimiento.getYear();
        return edad;
    }
    public static int viejo(String fecha){
        int edad = empleados.get(0).verEdad(fecha);
        for (Empleado i : empleados){
            if (i.verEdad(fecha) > edad){
                edad = i.verEdad(fecha);
            }
        }
        return edad;
    }
    public static int joven(String fecha){
        int edad = empleados.get(0).verEdad(fecha);
        for (Empleado i : empleados){
            if (i.verEdad(fecha) < edad){
                edad = i.verEdad(fecha);
            }
        }
        return edad;
    }
    public static String empleadoViejo(String fecha){
        List<Empleado> viejo = new ArrayList<>();
        int anios = viejo(fecha);
        for (Empleado i : empleados){
            if (i.verEdad(fecha) == anios){
                viejo.add(i);
            }
        }
        return viejo.get(viejo.size()-1).toString()+" "+anios;
    }
    public static String empleadoJoven(String fecha){
        List<Empleado> joven = new ArrayList<>();
        int anios = joven(fecha);
        for (Empleado i : empleados){
            if (i.verEdad(fecha) == anios){
                joven.add(i);
            }
        }
        return joven.get(joven.size()-1).toString()+" "+anios;
    }
    @Override
    public String toString() {
        return "\n" + nombre + " " + apellido;
    }
}
