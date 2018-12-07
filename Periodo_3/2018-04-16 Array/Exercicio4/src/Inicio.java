import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lucas
 *
 */
public class Inicio {
	 static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Jogador[] jogador = new Jogador[2];

		for (int i = 0; i < jogador.length; i++) {
			jogador[i] = new Jogador();
			System.out.printf("%s%d%s", "Nome do ", i + 1, "º Jogador: ");
			jogador[i].setNome(teclado());
			System.out.printf("Possição: ");
			jogador[i].setPossicao(teclado());
			System.out.print("Numero do Jogador: ");
			jogador[i].setNumero(Integer.parseInt(teclado()));
			System.out.print("Numero do gols marcados: ");
			jogador[i].setGols(Integer.parseInt(teclado()));
			System.out.print("Foi expolso(S/N): ");
			jogador[i].setExpolso(teclado().trim().toUpperCase().equals("S"));
		}

		System.out.println("\nJogadores: ");
		for (Jogador j : jogador) {
			System.out.printf("Jogador %s com Nº %d da possição %s com %d gols %s foi expulso\n", j.getNome(),
					j.getNumero(), j.getPossicao(), j.getGols(), j.isExpolso() ? "já" : "não");
		}
		System.out.println("\nArtilheiros: ");

		Arrays.sort(jogador, (a, b) -> Integer.compare(b.getGols(), a.getGols()));
		for (Jogador j : jogador) {
			if (j.getGols() != jogador[0].getGols())
				break;
			System.out.printf("%s %d %s", "Jogador " + j.getNome() + " com o ", j.getGols(), "Gols\n");
		}
	}
	
	public static String teclado() {
		String s  = "";
		while(scanner.hasNextLine()) {
			 s = scanner.nextLine();
			 break;
		}		
		return s;
	}
}
