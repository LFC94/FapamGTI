import java.util.Scanner;

/**
 * @author lucas
 *
 */
public class Comandos {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Elevador elevador = null;
		int cap, andares;

		System.out.print("Quantos andares possui o elevador: ");
		andares = scanner.nextInt();
		System.out.print("Qual a capacidade do elevador: ");
		cap = scanner.nextInt();
		
		elevador = new Elevador(andares, cap);
		

		boolean sair = false;
		String resporta;
		do {
			System.out.print("Elevador no "
					+ (elevador.getAndarAtual() == 0 ? "térreo" : String.valueOf(elevador.getAndarAtual()) + "º"));
			System.out.println(" Com "
					+ (elevador.getQuantasPessoas() == 0 ? "nenhuma" : String.valueOf(elevador.getQuantasPessoas()))
					+ " pessoa");
			System.out.println("Escolha uma opção");
			System.out.println("1:Entrar no elevador");
			System.out.println("2:Sair do elevado");
			System.out.println("3:Subir");
			System.out.println("4:Decer");
			System.out.println("9:Sair do Sistema");

			resporta = scanner.nextLine();

			if (resporta.equalsIgnoreCase("1")) {
				if (!elevador.entrarPessoa())
					System.out.println("Capacidade maxima do elevador ja atingida");
			} else if (resporta.equalsIgnoreCase("2")) {
				if (!elevador.sairPessoa())
					System.out.println("Nao possui pessoa para sair.");
			} else if (resporta.equalsIgnoreCase("3")) {
				if (!elevador.sobir())
					System.out.println("Ja esta na cobertura.");
			} else if (resporta.equalsIgnoreCase("4")) {
				if (!elevador.decer())
					System.out.println("Ja esta no térreo.");
			} else if (resporta.equalsIgnoreCase("9")) {
				sair = true;
			}

		} while (!sair);

	}

}
