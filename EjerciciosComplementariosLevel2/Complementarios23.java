import java.util.*;

public class Complementarios23 {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la numeración de cartas de una baraja francesa (solo los valores, no figuras)");
        List<Integer> cartas = new ArrayList<>();
        Integer escaner;

        while (cartas.size() < 9) {
            escaner = scan.nextInt();
            cartas.add(escaner);
        }
        scan.close();
        System.out.println("Cartas ingresadas");
        for (int i = 0; i < cartas.size(); i++) {
            System.out.print(cartas.get(i) + " ");
        }
        System.out.println("\nCartas invertidas");
        Collections.reverse(cartas);
        for (int i = 0; i < cartas.size(); i++) {
            System.out.print(cartas.get(i) + " ");
        }
        System.out.println("\nCartas mezcladas");
        Collections.shuffle(cartas);
        for (int i = 0; i < cartas.size(); i++) {
            System.out.print(cartas.get(i) + " ");
        }
    }
}
