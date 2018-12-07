import java.util.Scanner;

/**
 * @author lucas
 *
 */
public class Teste {

	static Receita receita[];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Numero de Receitas que você possui:");
		receita = new Receita[Integer.parseInt(teclado())];
		menuInical();

	}

	public static void menuInical() {
		String res = "";
		do {
			System.out.println("-------------MENU--------------------");
			System.out.println("1) Criar/Alterar Ingediente");
			System.out.println("S) SAIR");
			System.out.println("Informe a opcao desejada");
			res = teclado();
			if (res.equalsIgnoreCase("1"))
				menuReceita();

		} while (!res.equalsIgnoreCase("S"));
		System.out.println("FIM DO SISTEMAS");

	}

	public static void menuReceita() {
		listaReceitas();
		System.out.print("Informa a receita que deseja altear ou S(SAIR):");
		String inf = teclado();
		if (inf.trim().equalsIgnoreCase("S"))
			return;

		int rec = Integer.parseInt(inf);

		if (rec >= receita.length) {
			System.out.println("Numero da receira invalido");
			menuReceita();
			return;
		}

		if (receita[rec] == null) {
			System.out.println("Receita Nova");
			System.out.print("Informe o nome da Receita:");
			String nome = teclado();
			System.out.print("Informe a quantidade de Ingredientes:");
			int quant = Integer.parseInt(teclado());
			receita[rec] = new Receita(nome, quant);
		} else {
			String res = "";
			do {
				System.out.println("Receita " + receita[rec].getNome());
				System.out.println("1) Alterar ingedientes");
				System.out.println("2) Alterar Nome");
				System.out.println("S) SAIR");
				System.out.println("Informe a opcao desejada");
				res = teclado();
				if (res.equalsIgnoreCase("1"))
					menuIngerdientes(rec);

				if (res.trim().equalsIgnoreCase("2")) {
					System.out.print("Informe o nome da Receita");
					String nome = teclado();
					receita[rec].setNome(nome);
				}

			} while (!res.equalsIgnoreCase("S"));
		}

	}

	public static void menuIngerdientes(int rece) {
		System.out.println("INGREDIENTE JA CADASTRADAS");
		Ingrediente[] ing = receita[rece].getIngredientes();
		for (int i = 0; i < ing.length; i++) {
			if (ing[i] != null)
				System.out.println("Codigo: " + i + " Nome " + ing[i].getNome());
		}
		System.out.println("INGREDIENTE DISPONVEIS");
		for (int i = 0; i < ing.length; i++) {
			if (ing[i] == null)
				System.out.println("Codigo: " + i);
		}
		System.out.print("Informa a ingrediente que deseja altear ou S(SAIR):");

		String inf = teclado();
		if (inf.trim().equalsIgnoreCase("S"))
			return;

		int ingre = Integer.parseInt(inf);
		if (ing[ingre] == null) {
			System.out.print("Nome do ingediente: ");
			String nome = teclado();
			System.out.print("Quantidade de ingediente: ");
			double q = Double.parseDouble(teclado());
			Ingrediente in = new Ingrediente(nome, q);
			receita[rece].setIngredientes(in, ingre);
		}

	}

	public static void listaReceitas() {
		System.out.println("RECEITAS JA CADASTRADAS");
		for (int i = 0; i < receita.length; i++) {
			if (receita[i] != null)
				System.out.println("Codigo: " + i + " Nome " + receita[i].getNome());
		}
		System.out.println("RECEITAS DISPONVEIS");
		for (int i = 0; i < receita.length; i++) {
			if (receita[i] == null)
				System.out.println("Codigo: " + i);
		}
	}

	public static String teclado() {

		while (scanner.hasNext()) {
			return scanner.nextLine();
		}

		return scanner.nextLine();
	}

}
