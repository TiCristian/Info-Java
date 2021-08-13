import java.util.*;

public class Complementarios24 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> estudiantes = new ArrayList<>();
        String escaner;
        System.out.println("Ingresar nombre de los 12 estudiantes para agruparlos:");
        while (estudiantes.size() < 12) {
            escaner = scan.nextLine();
            estudiantes.add(escaner);
        }
        scan.close();
        List<String> grupo1 = estudiantes.subList(0, 4);
        List<String> grupo2 = estudiantes.subList(4, 8);
        List<String> grupo3 = estudiantes.subList(8, 12);

        System.out.println("Grupo 1:");
        for (int i = 0; i < grupo1.size(); i++) {
            System.out.print(grupo1.get(i) + " ");
        }
        System.out.println("\nGrupo 2:");
        for (int i = 0; i < grupo2.size(); i++) {
            System.out.print(grupo2.get(i) + " ");
        }
        System.out.println("\nGrupo 3:");
        for (int i = 0; i < grupo3.size(); i++) {
            System.out.print(grupo3.get(i) + " ");
        }
    }
}
