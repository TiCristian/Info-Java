import java.util.Scanner;

public class Ejercicio4 {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int opcion = 1;

        while (opcion == 1) {
            
            System.out.println("Ingresa el dia de la semana:");
            int numdia = scan.nextInt();
            
            Fecha(numdia);
            System.out.println("Si desea continuar presione 1, sino cualquier otro numero");
            opcion = scan.nextInt();
        }
        scan.close();
    }

    public static void Fecha(int dia){
        switch (dia){
            case 1:
                System.out.println("Domingo");
                break;
            case 2:
                System.out.println("Lunes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
        }
    }
}