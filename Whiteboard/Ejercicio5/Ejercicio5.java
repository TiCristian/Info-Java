import java.nio.*;
import java.util.*;

public class Ejercicio5 extends Empleado {
    public static void main(String[] args) {
        cargaEmpleado();
        String letra = "R";
        System.out.println("Empleados con inicial "+letra+" en su apellido:"+inicialApellido(letra));
        System.out.println("\n"+"Empleado/a con el sueldo mas alto: "+mayorSueldo());
        System.out.println("\n"+"Empleado/a con el sueldo mas bajo: "+menorSueldo());
        System.out.println("\n"+"Empleado/a mas viejo: "+empleadoViejo("15-06-2021")+" años");
        System.out.println("\n"+"Empleado/a mas joven: "+empleadoJoven("15-06-2021")+" años");
    }
}