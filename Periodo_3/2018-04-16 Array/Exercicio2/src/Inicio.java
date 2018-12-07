import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author lucas
 *
 */
public class Inicio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numero = new int[100];
		Random random = new Random();
		for (int i=0;i<numero.length;i++) {			
			numero[i]= random.nextInt(9)+1;			
		}

		System.out.print("Informa um numero de 1 a 10:");
		int escolha = new Scanner(System.in).nextInt();
		
		int countador =0;
		for(int i:numero)
			if(i==escolha)
				countador++;
		
		System.out.printf("%s%d%s%d%s","Possui ",countador," numeros ",escolha,"\n");
		System.out.print("Na sequencia : ");
		for(int i:numero)
			System.out.printf("%d%s",i,", ");
		
		
		System.out.println("\nNa sequencia ordernada: ");
		Arrays.sort(numero);
		for(int i:numero)
			System.out.printf("%d%s",i,", ");
	}

}
