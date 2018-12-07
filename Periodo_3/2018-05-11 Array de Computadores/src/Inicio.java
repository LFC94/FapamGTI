import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lucas
 *
 */
public class Inicio {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Computador> computadores = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			String placamae, mac;
			double armazenamentoHD, memoriaRAM;
			Processador processador;
			
			System.out.println("Informe o dados do "+(i+1)+"º Computador: ");
			System.out.print("Placa mâe: ");
			placamae = teclado();
			System.out.print("Tamanho do HD (GB): ");
			armazenamentoHD = Double.parseDouble(teclado());
			System.out.print("Tamanho da memoria RAM(MB): ");
			memoriaRAM = Double.parseDouble(teclado());
			System.out.print("Mac da placa de Rede: ");
			mac = teclado();
			Processador[] pro = Processador.values();
			System.out.println("Processadores Disponiveis: ");
			for(int j = 0;j<pro.length;j++) {
				System.out.printf("%5d - %s\n",j,pro[j].getModelo());
			}
			System.out.print("Informe o processador desejado: ");
			processador = pro[Integer.parseInt(teclado())];
			computadores.add(new Computador(armazenamentoHD, memoriaRAM, placamae, mac, processador));
		}

		for (Computador c : computadores) {
			if (c.getMemoriaRAM() >= 512)
				System.out.println(c.toString());
		}

	}

	public static String teclado() {

		while (scanner.hasNext()) {
			return scanner.nextLine();
		}

		return scanner.nextLine();
	}
	
}
