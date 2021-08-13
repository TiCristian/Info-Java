public class Ejercicio2 {
    
    public static void main(String[] args){
        System.out.println(factorialRecursivo(6));
    }

    public static long factorialRecursivo(long numero) {
		if (numero <= 1)
			return 1;
		return numero * factorialRecursivo(numero - 1);
	}
}