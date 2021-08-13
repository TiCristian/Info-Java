import java.util.*;

public class Complementarios27 {

    public static void main(String[] args) {
        Scanner nro1 = new Scanner(System.in);
        Scanner nro2 = new Scanner(System.in);
        System.out.println("Ingresa el primer numero entero (Debe ser menor al segundo)");
        int primero = nro1.nextInt();
        System.out.println("Ingresa el segundo numero entero");
        int segundo = nro2.nextInt();
        ArrayList<String> array = new ArrayList<String>();
        nro1.close();
        nro2.close();
        
        for (int i = primero; i < segundo; i++) {
            if (i % 2 != 0 && i % 3 != 0) {
                array.add(i+",");
        } else if (i % 2 == 0 && i % 3 != 0) {
            array.add("“Fizz”,");
        } else if (i % 3 == 0 && i % 2 != 0) {
            array.add("“Buzz”,");
        } else if (i % 2 == 0 && i % 3 == 0) {
            array.add("“Fizz-Buzz”,");
            }
        }
        System.out.print("[");
        for (String j : array) {
            System.out.print(j+ " ");
        }
        System.out.print("]");
    }
}