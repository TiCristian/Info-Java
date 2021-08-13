import java.util.Scanner;

public class Complementarios15 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Sumas sucesivas: Ingresa 2 numeros enteros");
        int n = scan.nextInt();
        int m = scan.nextInt();
        int resultado = 0;
        scan.close();
        
        for (int i = 1; i <= m; i++) {
            resultado += n; 
        }
        System.out.println("Resultado: " + resultado);
    }
}
