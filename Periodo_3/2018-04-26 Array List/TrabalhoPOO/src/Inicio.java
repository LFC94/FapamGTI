import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author lucas
 *
 */
public class Inicio {

	/**
	 * @param args
	 */
	private static ArrayList<Classe> classes;
	static Scanner scanner = new Scanner(System.in);
	private static int codClasse = -1, codAluno = -1;

	public static void main(String[] args) {
		menuClasse();

	}

	public static void menuClasse() {
		System.out.println(
				"|—————————————————————————————————————————————————————————————————————————————————————————————————————————|");
		System.out.println("|    MENU INICIAL     |");
		System.out.println("|—————————————————————|");
		System.out.println("|N| NOVA CLASSE       |");
		System.out.println("|A| ALTERAR CLASSE    |");
		System.out.println("|E| EXCLUIR CLASSE    |");
		System.out.println("|I| IMPRIMIR CLASSES  |");
		System.out.println("|S| SAIR              |");
		System.out.println("|—————————————————————|");
		System.out.print("Informe sua escolha: ");

		escolherMenuClasse(teclado());
	}

	public static void menuAlterarClasse() {
		System.out.println(
				"|—————————————————————————————————————————————————————————————————————————————————————————————————————————|");
		System.out.println("|   ALTERAR CLASSE    |");
		System.out.println("|" + classes.get(codClasse).getCurso().trim());
		System.out.println("|—————————————————————|");
		System.out.println("|1| NOME DA CLASSE    |");
		System.out.println("|2| ANO INICIAL       |");
		System.out.println("|3| ALUNOS            |");
		System.out.println("|S| SAIR              |");
		System.out.println("|—————————————————————|");
		System.out.print("Informe sua escolha: ");

		escolherAlterarClasse(teclado());
	}

	public static void menuAluno() {
		System.out.println(
				"|—————————————————————————————————————————————————————————————————————————————————————————————————————————|");
		System.out.println("|     MENU ALUNOS     |");
		System.out.println("|—————————————————————|");
		System.out.println("|N| NOVO ALUNO        |");
		System.out.println("|A| ALTERAR ALUNO     |");
		System.out.println("|E| EXCLUIR ALUNO     |");
		System.out.println("|I| IMPRIMIR ALUNOS   |");
		System.out.println("|S| SAIR              |");
		System.out.println("|—————————————————————|");
		System.out.print("Informe sua escolha: ");

		escolherMenuAluno(teclado());
	}

	public static void menuAlterarAlunos() {
		System.out.println(
				"|—————————————————————————————————————————————————————————————————————————————————————————————————————————|");
		System.out.println("|    ALTERAR ALUNO    |");
		System.out.println("|" + classes.get(codClasse).getNomeAlunos(codAluno).trim());
		System.out.println("|—————————————————————|");
		System.out.println("|1| NOME DO ALUNO     |");
		System.out.println("|2| TELEFONE DO ALUNO |");
		System.out.println("|3| SEXO DO ALUNO(M/F)|");
		System.out.println("|4| NOTA DO ALUNO     |");
		System.out.println("|S| SAIR              |");
		System.out.println("|—————————————————————|");
		System.out.print("Informe sua escolha: ");

		escolherAlterarAluno(teclado());
	}

	public static void escolherMenuClasse(String menu) {
		if (menu.trim().equalsIgnoreCase("N")) {
			Classe classe = new Classe();
			System.out.print("Informe o nome da classe:");
			classe.setCurso(teclado());
			System.out.print("Informe o ano incial da classe:");
			classe.setAnoInicial(Integer.parseInt(teclado()));
			classes.add(classe);
			menuClasse();
		} else if (menu.trim().equalsIgnoreCase("A")) {
			if (!imprimirTodasClases())
				return;
			System.out.print("Informe o codigo da Classe para alterar: ");
			codClasse = Integer.parseInt(teclado());
			if (codClasse < 0 || codClasse >= classes.size()) {
				System.out.println("Codigo da classe informada e invalida");
				menuClasse();
				return;
			}
			menuAlterarClasse();
		} else if (menu.trim().equalsIgnoreCase("E")) {
			if (!imprimirTodasClases())
				return;
			System.out.print("Informe o codigo da Classe para excluir: ");
			codClasse = Integer.parseInt(teclado());
			if (codClasse < 0 || codClasse >= classes.size()) {
				System.out.println("Codigo da classe informada e invalida");
				menuClasse();
				return;
			}
			classes.remove(codClasse);
			menuClasse();
		} else if (menu.trim().equalsIgnoreCase("I")) {
			imprimirTodasClases();
			menuClasse();
		} else if (menu.trim().equalsIgnoreCase("S"))
			System.exit(0);
		else {
			System.out.print("Escolha informada é invalida.");
			menuClasse();
		}
	}

	public static void escolherAlterarClasse(String menu) {
		if (menu.trim().equalsIgnoreCase("1")) {
			System.out.print("Informe o nome da Classe:");
			classes.get(codClasse).setCurso(teclado());
			menuClasse();
		} else if (menu.trim().equalsIgnoreCase("2")) {
			System.out.print("Informe o ano incial da classe:");
			classes.get(codClasse).setAnoInicial(Integer.parseInt(teclado()));
			menuClasse();
		} else if (menu.trim().equalsIgnoreCase("3"))
			menuAluno();
		else if (menu.trim().equalsIgnoreCase("S"))
			menuClasse();
		else {
			System.out.print("Escolha informada é invalida.");
			menuClasse();
		}
	}

	public static void escolherMenuAluno(String menu) {
		if (menu.trim().equalsIgnoreCase("N")) {
			System.out.print("Informe o nome do aluno: ");
			String nome = teclado();
			System.out.print("Informe o sexo do aluno: ");
			String sexo = teclado();
			if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
				System.out.println("Sexo informado invalido.");
				sexo = "";
			}
			System.out.print("Informe o telefone do aluno: ");
			String telefone = teclado();

			System.out.print("Informe a media do aluno: ");
			double nota = Double.parseDouble(teclado());

			classes.get(codClasse).adicionaAluno(nome, nota, sexo, telefone);
			menuAluno();

		} else if (menu.trim().equalsIgnoreCase("A")) {
			if (!imprimirTodosAluno())
				return;
			System.out.print("Informe o codigo do aluno para alterar: ");
			codAluno = Integer.parseInt(teclado());
			if (codAluno < 0 || codAluno >= classes.get(codClasse).quantidadeAluno()) {
				System.out.println("Codigo do cliente informado e invalido");
				menuAluno();
				return;
			}
			menuAlterarAlunos();
		} else if (menu.trim().equalsIgnoreCase("A")) {
			if (!imprimirTodosAluno())
				return;
			System.out.print("Informe o codigo do aluno para alterar: ");
			codAluno = Integer.parseInt(teclado());
			if (codAluno < 0 || codAluno >= classes.get(codClasse).quantidadeAluno()) {
				System.out.println("Codigo do cliente informado e invalido");
				menuAluno();
				return;
			}
			classes.get(codClasse).removerAlunos(codAluno);
			menuAluno();
		} else if (menu.trim().equalsIgnoreCase("I")) {
			imprimirTodosAluno();
			menuAluno();
		} else if (menu.trim().equalsIgnoreCase("S"))
			menuClasse();
		else {
			System.out.print("Escolha informada é invalida.");
			menuAluno();
		}

	}

	public static void escolherAlterarAluno(String menu) {
		if (menu.trim().equalsIgnoreCase("1")) {
			System.out.print("Informe o nome do Aluno: ");
			classes.get(codClasse).setNomeAlunos(codAluno, teclado());
			menuAluno();
		} else if (menu.trim().equalsIgnoreCase("2")) {
			System.out.print("Informe o telefone do Aluno: ");
			classes.get(codClasse).setTelefoneAlunos(codAluno, teclado());
			menuAluno();
		} else if (menu.trim().equalsIgnoreCase("3")) {
			System.out.print("Informe o sexo do Aluno: ");
			String sexo = teclado();
			if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
				System.out.println("Sexo informado invalido.");
				sexo = "";
			}
			classes.get(codClasse).setSexoAlunos(codAluno, sexo);
			menuAluno();
		} else if (menu.trim().equalsIgnoreCase("4")) {
			System.out.print("Informe a media do Aluno: ");
			classes.get(codClasse).setNotaAlunos(codAluno, Double.parseDouble(teclado()));
			menuAluno();
		} else if (menu.trim().equalsIgnoreCase("S"))
			menuAluno();
		else {
			System.out.print("Escolha informada é invalida.");
			menuAlterarAlunos();
		}
	}

	public static boolean imprimirTodasClases() {
		if (classes.size() <= 0) {
			System.out.println("Nao a classe para altera.");
			menuClasse();
			return false;
		}
		System.out.println("Codigo | Nome");

		for (int i = 0; i < classes.size(); i++)
			System.out.printf("%6d | %s \n", i, classes.get(i).getCurso());
		return true;
	}

	public static boolean imprimirTodosAluno() {
		if (classes.get(codClasse).quantidadeAluno() <= 0) {
			System.out.println("Nao possui aluno para altera.");
			menuAluno();
			return false;
		}

		System.out.println("Codigo | Nome");
		for (int i = 0; i < classes.get(codClasse).quantidadeAluno(); i++)
			System.out.printf("%6d | %s \n", i, classes.get(codClasse).getNomeAlunos(i));

		return true;
	}

	public static void imprimirAluno(int aluno) {
		System.out.printf("%6d | %s \n", aluno, classes.get(codClasse).getNomeAlunos(aluno));
	}

	public static String teclado() {

		while (scanner.hasNext()) {
			return scanner.nextLine();
		}

		return scanner.nextLine();
	}

}
