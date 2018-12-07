import java.util.ArrayList;
import java.util.Scanner;

public class VideoGame {

	private static Scanner scanner;

	public static void main(String[] args) {
		ArrayList<Placar> jogoInterfaces = new ArrayList<>();
		
		scanner = new Scanner(System.in);
		String s="";
		do {
			System.out.println("---------------------------");
			System.out.println("Menu Video Game");
			System.out.println("1 - Maior Menor");
			System.out.println("2 - Cara ou Coroa");
			System.out.println("P - PLACAR");
			System.out.println("S - Sair");		
			System.out.println("---------------------------");
			System.out.println("Escolha: ");		
			s= scanner.nextLine();
			if(s.equalsIgnoreCase("1"))
				jogoInterfaces.add(new MenorMaior().jogar());
			else if(s.equalsIgnoreCase("2"))
				System.out.println("Jogo nao disponivel");
			else if(s.equalsIgnoreCase("P")) {
				System.out.println("Resultado");
				for(Placar p : jogoInterfaces)
					System.out.println(p.Resultado());
			
				System.out.println("---------------------------");
			}
					
		}while(!s.equalsIgnoreCase("S"));

	}

}
