import java.util.*;

public class Complementarios25 {
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        List<Integer> horas = new ArrayList<>();
        List<Integer> cobro = new ArrayList<>();
        List<Integer> dia = new ArrayList<>();
        int semana = 0;
        Integer hs;
        Integer monto;
        System.out.println("Ingresar horas y pago por hora");

        while (horas.size() < 5){
            System.out.println("Horas trabajadas:");
            hs = scan.nextInt();
            horas.add(hs);
            System.out.println("Monto por hora:");
            monto = scan2.nextInt();
            cobro.add(monto);
        }
        for (int i = 0 ; i < horas.size() ; i++ ){
            dia.add(horas.get(i)*cobro.get(i));
            semana += dia.get(i);
        }
        System.out.println("Pagos lunes a viernes:");
        for (int i = 0 ; i < dia.size() ; i++ ){
            System.out.print(dia.get(i) + " ");
        }
        System.out.println("\nTotal Final: "+semana);
        scan.close();
        scan2.close();
    }
}
