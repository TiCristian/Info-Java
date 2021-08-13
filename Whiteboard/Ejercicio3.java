import java.io.File;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        System.out.println("Lectura del archivo alumnos.txt");
        try {
            Scanner input = new Scanner(new File("D:/Informatorio/Etapa 3/Info-Java/Revision-Whiteboard/alumnos.txt"));
            while (input.hasNextLine()) {
                String linea = input.nextLine();
                System.out.println(linea);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}