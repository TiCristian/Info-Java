import java.util.*;
import java.io.FileWriter;

public class Ejercicio4 {
    public static void main(String[] args) {
        List<String> Empleados = new ArrayList<>();
        String empleado = "German Rodriguez - 42848669 - $45000";
        String empleado2 = "Cecilia Mohni - 42345201 - $45000";
        String empleado3 = "Marcelo Palacios - 43899475 - $45000";
        String empleado4 = "Paula Cañete - 42382609 - $45000";
        String empleado5 = "Karen Silva - 42345671 - $45000";
        Empleados.add(empleado);
        Empleados.add(empleado2);
        Empleados.add(empleado3);
        Empleados.add(empleado4);
        Empleados.add(empleado5);
        
        System.out.println("Empleados cargados en el archivo:");
        for (String i : Empleados) {
            System.out.println(i);
        }
        FileWriter fichero = null;
        try {
            fichero = new FileWriter("Revision-Whiteboard/empleado.txt");
            for (String i : Empleados) {
                fichero.write(i + "\n");
            }
            fichero.close();
        } catch (Exception ex) {
            System.out.println("Mensaje de excepción: " + ex.getMessage());
        }
    }
}
