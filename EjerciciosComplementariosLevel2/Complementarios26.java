import java.util.*;

public class Complementarios26 extends Empleado{
    
    public static void main(String[] args) throws Exception{
        HashSet<Empleado> Empleados = new HashSet<Empleado>();
        Map<String, Integer> Sueldos = new HashMap<String, Integer>();
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        Scanner scan4 = new Scanner(System.in);
        Scanner menu = new Scanner(System.in);
        String dni;
        String nombre;
        int hs;
        int hp;
        int opcion = 1;
        
        while (opcion == 1){
            System.out.println("Datos de Empleados");
            System.out.println("Ingresar DNI - Nombre - Horas Trabajadas - Pago por Hora:");
            dni = scan.nextLine();
            nombre = scan2.nextLine();
            hs = scan3.nextInt();
            hp = scan4.nextInt();
            Empleado nuevo = new Empleado();
            nuevo.dni = dni;
            nuevo.nombre = nombre;
            nuevo.hs = hs;
            nuevo.hp = hp;
            Empleados.add(nuevo);
            System.out.println("Continuar [1] - Finalizar [0]");
            opcion = menu.nextInt();
        }
        scan.close();
        scan2.close();
        scan3.close();
        scan4.close();
        menu.close();
        for ( Empleado i : Empleados){
            int total = i.hs*i.hp;
            Sueldos.put(i.dni, total);
        }
        System.out.println("\nDatos Registrados");
        Empleados.stream().forEach(i -> System.out.println("DNI: "+i.getDni()+" - Empleado: "+i.getNombre()+" - Horas de Trabajo: "+i.getHs()+" - Pago por hora: $"+i.getHp()));
        System.out.println("\nSueldos");
        Sueldos.forEach((key, value) -> System.out.println("DNI: "+key+" - Sueldo: $"+value));
    }
}