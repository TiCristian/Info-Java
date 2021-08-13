import java.util.Scanner;

public class Complementarios17 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresar caracteres en letra minúscula");
        String entrada = scan.nextLine();
        char[] caracteres = entrada.toCharArray();
        System.out.println("Caracteres en mayuscula:");
        for (int i = 0; i < caracteres.length; i++){
            if (caracteres[i] >= 'a' && caracteres[i] <= 'z') {
                caracteres[i] = (char)(caracteres[i] - (int) 'a' + (int) 'A');
            }
            System.out.print(caracteres[i]);
        }
        scan.close();
    }
}