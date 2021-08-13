import java.util.*;

public class Complementarios14 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa un numero para calcular su factorial");
        int numero = scan.nextInt();
        int factorial = 1;

        for (int i = 2; i <= numero; i++) {
            factorial = factorial * i;
        }
        System.out.println("Resultado:" + factorial);
        scan.close();
    }
}
