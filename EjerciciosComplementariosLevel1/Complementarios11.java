import java.util.Scanner;

public class Complementarios11 {

    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa tu nombre de usuario");
        String saludo = ("HOLA");
        String usuario = scan.nextLine();
        System.out.println(saludo + " " +usuario);
        scan.close();
    }
}