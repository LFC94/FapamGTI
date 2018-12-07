import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lucas
 *
 */
public class Inicio {

	public static void main(String[] args) {

		int[] numero = new int[10];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < numero.length; i++) {
			System.out.printf("%s%d%s", "Informa o ", i+1, "º:");
			numero[i] = scanner.nextInt();
		}
		System.out.println("Ordernando os Numeros: ");		
		Arrays.sort(numero);
		for(int x:numero)
			System.out.println(x);			

	}

}
