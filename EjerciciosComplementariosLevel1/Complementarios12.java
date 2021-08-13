import java.util.Scanner;

public class Complementarios12 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa 2 numeros enteros");
        
        int uno = scan.nextInt();
        int dos = scan.nextInt();
        
        System.out.println("Resultados");
        System.out.println("Suma" + " " +(uno + dos));
        System.out.println("Resta" + " " +(uno - dos));
        System.out.println("Multiplicacion" + " " +(uno * dos));
        System.out.println("Division" + " " +(uno / dos));
        System.out.println("Modulo" + " " +(uno % dos));
        scan.close();
    }
}
