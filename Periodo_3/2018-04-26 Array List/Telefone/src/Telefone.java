import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Telefone {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<String> telefone = new ArrayList<String>();

	public static void main(String[] args) {
		do {
			String menu = listaMenu();
			if (menu.equalsIgnoreCase("a"))
				adicionarTelefone();
			else if (menu.equalsIgnoreCase("r"))
				excluirTelefone();
			else if (menu.equalsIgnoreCase("l"))
				listaTelefone();
			else if (menu.equalsIgnoreCase("s"))
				break;
			else
				System.out.println("Opção informada é invalida.");

		} while (true);

		System.out.println("Ate a proxima.");
	}

	public static String listaMenu() {
		String linha = new String(new char[80]).replace("\0", "-");
		System.out.println("\n" + linha);
		System.out.println("MENU");
		System.out.println("(a) adicionar telefone");
		System.out.println("(r) remover telefone");
		System.out.println("(l) listar telefones");
		System.out.println("(s) Sair.");
		System.out.print("Digita a opção desejada: ");

		return scanner.nextLine().trim();
	}

	public static void adicionarTelefone() {
		System.out.print("Informa o numero de telefone:");
		telefone.add(scanner.nextLine().trim());
	}

	public static void listaTelefone() {
		System.out.println("Telefones Cadastrados");
		int i = 0;
		for (String tel : telefone)
			System.out.printf("%3d| %s\n", ++i, tel);
	}

	public static void excluirTelefone() {
		listaTelefone();
		System.out.print("Informe o codigo do telefone que deseja remove: ");
		telefone.remove(Integer.parseInt(scanner.nextLine().trim()) - 1);
	}

}
