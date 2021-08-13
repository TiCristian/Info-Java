import java.util.*;

public class Complementarios22 {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();
        Integer uno;
        Integer dos;
        Integer tres;
        int lista = 0;
        int lista2 = 0;
        System.out.println("Ingresa 5 numeros enteros");
        while (numeros.size() < 5) {
            uno = scan.nextInt();
            numeros.add(uno);
            lista = +numeros.size();
        }
        System.out.println("Numeros ingresados:");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.print(numeros.get(i) + " ");
        }
        System.out.println("\n" + "Ingresa 1 numero al principio y 1 numero al final");
        dos = scan2.nextInt();
        tres = scan3.nextInt();
        numeros.add(0, dos);
        numeros.add(6, tres);
        lista2 = +numeros.size();
        System.out.println("Numeros ingresados:");
        for (int j = 0; j < numeros.size(); j++) {
            System.out.print(numeros.get(j) + " ");
        }
        System.out.println("\n" + "Tamaño de lista al principio: " + lista);
        System.out.println("Tamaño de lista al final: " + lista2);
        scan.close();
        scan2.close();
        scan3.close();
    }
}
