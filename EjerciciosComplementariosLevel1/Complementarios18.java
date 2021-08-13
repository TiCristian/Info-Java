import java.util.Scanner;

public class Complementarios18 {

    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    System.out.println("Nombre y Apellido:");
    String nombrecompleto = scan.nextLine();
    System.out.println("Edad:");
    String edad = scan.nextLine();
    System.out.println("Direccion:");
    String direccion = scan.nextLine();
    System.out.println("Ciudad:");
    String ciudad = scan.nextLine();
    scan.close();
    
    System.out.println(ciudad+" - "+direccion+" - "+edad+" - "+nombrecompleto);
    }
}
