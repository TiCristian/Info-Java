import java.util.Scanner;

public class Ejercicio5 {
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        int continuar = 1;
        
        while (continuar == 1)  {
        
            System.out.println("Ingresa un numero");
            int nro = scan.nextInt();
            for (int i=1; i <=10; i++) {
                System.out.println(nro + " * " + i + " = " + nro*i);
            }
            System.out.println("Si desea continuar presione 1, sino cualquier otro numero");
            continuar = scan.nextInt();      
        }
        scan.close();
    }
}
