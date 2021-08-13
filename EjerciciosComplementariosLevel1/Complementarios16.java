import java.util.Scanner;

public class Complementarios16 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Potencia: Ingresa el numero y el valor a elevar");
        int n = scan.nextInt();
        int m = scan.nextInt();
        int resultado = 1;
        scan.close();
        
        for (int i = 1; i <= m; i++) {
            resultado *= n; 
        }
        System.out.println("Resultado: " + resultado);
    }
}