import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class MenorMaior implements JogoInterface {

	private int numeroSorte;

	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void resetar() {
		Random random = new Random();
		numeroSorte = random.nextInt((int) (new Date()).getTime()) % 100 + 1;
	}

	@Override
	public Placar jogar() {
		resetar();
		String result = "";
		int tent = 0;
		System.out.println("O jogo Maior Menos comecou... ");
		System.out.println("Informe um numero de 1 a 100.");
		System.out.println("Informe 0 para resetar.");
		System.out.println("Informe -1 para sair do jogo.");
		do {
			tent++;
			System.out.print("Digite um numero: ");
			int num = scanner.nextInt();
			if(num == 0) {
				return jogar();				
			}else if(num == -1) {
				result = "Game Over";
				abortar();
			}else if(num == numeroSorte) {
				result = "Acerto numero sorteado "+numeroSorte+" com "+tent+" tentativas";
				break;
			}else if(num < numeroSorte) 
				System.out.println("O numero fornecido eh MENOR que o sorteado.");
			else 
				System.out.println("O numero fornecido eh MAIOR que o sorteado.");
		} while(true);		
		
		return (new Placar(result));
	}

	@Override
	public void abortar() {
		System.exit(0);
	}

}