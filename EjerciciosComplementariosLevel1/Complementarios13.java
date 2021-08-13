import java.util.Scanner;

public class Complementarios13 {
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa un numero");
        int numero = scan.nextInt();
        
        for(int i=1;i<=numero;i++) {
            for(int j=1; j<=i;j++) {
                System.out.print(j +" ");
            }
            System.out.println("");
            scan.close();
        }
    }
}
