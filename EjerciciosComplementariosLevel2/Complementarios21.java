import java.util.*;

public class Complementarios21 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        List<String> ciudades = new ArrayList<>();
        System.out.println("Ingresa tus ciudades favoritas de Argentina");
        String ciudad;
        int opcion = 1;

        while (opcion == 1){
            ciudad = scan.nextLine();
            ciudades.add(ciudad);
            System.out.println("Ingresa otra ciudad [1] - Mostrar ranking [0]");
            opcion = scan2.nextInt();
        }
        int puesto = 0;
        for (String i : ciudades) {
            puesto += 1;
            System.out.println("#"+puesto+" - "+i);
        }
        scan.close();
        scan2.close();
    }
}
