import java.util.Scanner;

/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Controle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Televisao televisao;
		String botao;

		System.out.print("Quantos canais a televisao possui:");
		televisao = new Televisao(scanner.nextInt());

		System.out.println("Botoes:");
		System.out.println("L: Ligar");
		System.out.println("D: Desligar");
		System.out.println("+: Almentar Volume");
		System.out.println("-: Diminuir Volume");
		System.out.println(">: Proximo Canal");
		System.out.println("<: Canal Anterior");
		System.out.println("!: Informação");
		System.out.println("Selcionar o canal de 1 a " + String.valueOf(televisao.getQuantidadeCanais()));
		do {
			System.out.print("Precione um botao: ");
			botao = scanner.next();  

			if (botao.equalsIgnoreCase("L")) {

				if (!televisao.ligar())
					System.out.println("Televisao ja esta ligada");

			} else if (!televisao.estaLigada()) {

				System.out.println("A Televisao ja esta desligada");

			} else if (botao.equalsIgnoreCase("D")) {

				televisao.desligar();

			} else if (botao.equalsIgnoreCase("+")) {

				if (!televisao.aumentarVolume())
					System.out.println("Ja esta no volume Maximo");

			} else if (botao.equalsIgnoreCase("-")) {

				if (!televisao.aumentarVolume())
					System.out.println("Ja esta no mudo");

			} else if (botao.equalsIgnoreCase(">")) {

				televisao.ProximoCanal();

			} else if (botao.equalsIgnoreCase("<")) {

				televisao.canalAnteriro();

			} else if (botao.equalsIgnoreCase("!")) {

				imprimir(televisao);

			} else {
				if(validaInt(botao))
					if(!televisao.selecionarCanal(Integer.parseInt(botao)))
						System.out.println("Canal informado é invalido");
			}

		} while (true);

	}

	public static void imprimir(Televisao televisao) {
		if (televisao.estaLigada())
			System.out.println("A televisao esta Ligada no canal "+String.valueOf(televisao.getCanalAtual())+" com o volume no "+String.valueOf(televisao.getVolumeAtual()));
		else 
			System.out.print("A televisao esta Desligada");
		
	}
	
	
	public static boolean validaInt(String inteiro) {
		
		try {
			Integer.parseInt(inteiro);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
}
