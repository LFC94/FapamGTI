import java.util.Random;

/**
 * @author lucas
 */
public class Inicio {

	public static void main(String[] args) {
		int[] numero = new int[100];
		Random random = new Random();
		for (int i = 0; i < numero.length; i++) {
			numero[i] = (int) (random.nextInt(200000) / 2) * 2;
		}
		System.out.println(posMaiorValor(numero));
		System.out.println(somaArray(numero));
	}

	public static int posMaiorValor(int[] num) {
		int pos = 0;

		for (int i = 0; i < num.length; i++)
			pos = (num[i] > num[pos]) ? i : pos;

		return pos;
	}

	public static int somaArray(int[] num) {
		int soma = 0;
		for (int i = 0; i < num.length; i++)
			soma += num[i];

		return soma;
	}

}
