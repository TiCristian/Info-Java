import java.util.Scanner;

public class Complementarios19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingresar frase - texto - etc ");
        String texto = scan.nextLine();
        System.out.println("Ingrese letra para realizar conteo ");
        char caracter = scan.next().charAt(0);
        
        char[] cadena = texto.toCharArray();
        int conteo = 0;

        for (int i = 0; i < cadena.length; i++){
            if (cadena[i] == caracter){
                conteo++;
            }
        }
        System.out.println("Repeticiones de letra ingresada: "+conteo);
        scan.close();
    }
}