import java.util.Scanner;

public class TestePessoa {

	public static void main(String[] args) {
		Pessoa pessoa1, pessoa2;
		Scanner scanner = new Scanner(System.in);
		
		String nome, endereco, telefone;
		System.out.println("Pessoa 1:");		
		System.out.print("Informa nome: ");
		nome = scanner.nextLine();
		System.out.print("Informa Endereco: ");
		endereco =scanner.nextLine();
		System.out.print("Informa Telefone: ");
		telefone = scanner.nextLine();
		
		pessoa1 = new Pessoa(nome,endereco,telefone);
		
		System.out.println("\nPessoa 2:");
		System.out.print("Informa nome: ");
		nome = scanner.nextLine();
		System.out.print("Informa Endereco: ");
		endereco = scanner.nextLine();
		System.out.print("Informa Telefone: ");
		telefone = scanner.nextLine();

		pessoa2 = new Pessoa(nome,endereco,telefone);
		System.out.println("\nDados das Pessoas");
		
		pessoa1.imprimirPessoa();
		System.out.println("");
		pessoa2.imprimirPessoa();
		
		
	}

}
