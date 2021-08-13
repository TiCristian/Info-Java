import java.util.*;

public class Ejercicio2 {

    private static String solicitud = ("Ingresa 3 numeros por consola");
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int opcion = 1;

        while (opcion == 1){
            
            System.out.println(solicitud);
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();

            printNum(a,b,c);
            System.out.println("Si desea continuar presione 1");
            opcion = scan.nextInt();
        }
        scan.close();
    }

    public static void printNum(int uno, int dos, int tres) {
        
        System.out.println("El primer numero ingresado es: " + uno);
        System.out.println("El segundo numero ingresado es: " + dos);
        System.out.println("El tercer numero ingresado es: " + tres);

    }
}
