/**
 * @author Lucas
 *
 */
 import java.util.Scanner;
public class Cadastro{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Pessoa pessoa1, pessoa2;	
		
		String nome, sexo;
		double peso, altura;
		
		System.out.print("\nPessoa 2\n");
		
		System.out.print("Informe o seu nome: ");
		nome = scanner.nextLine();
		
		System.out.print("Informe o seu sexo(M/F): ");
		sexo = scanner.nextLine();
		
		System.out.print("Informe o sua altura: ");
		altura = scanner.nextDouble();
		
		System.out.print("Informe o seu Peso: ");
		peso = scanner.nextDouble();
		
		pessoa1 = new Pessoa(nome, sexo, peso, altura);
		
		System.out.print("\nPessoa 2\n");
		pessoa2 = new Pessoa();
		
		System.out.print("Informe o seu nome: ");
		pessoa2.setNome(scanner.nextLine());
		
		System.out.print("Informe o seu sexo(M/F): ");
		pessoa2.setSexo(scanner.nextLine());
		
		System.out.print("Informe o sua altura: ");
		pessoa2.setAltura(scanner.nextDouble());
		
		System.out.print("Informe o seu Peso: ");
		pessoa2.setPeso(scanner.nextDouble());
		
		imprimirPessoa(pessoa1);
		imprimirPessoa(pessoa2);
		
	}
	
	public void imprimirPessoa(Pessoa pessoa){
		System.out.print("\nNome "+pessoa.getNome()+" do sexo "+pessoa.getSexo()+" com o peso "+String.valueOf(pessoa.getPeso())+" com a altura "+String.valueOf(pessoa.getAltura())+" com a IMC "+String.valueOf(pessoa.calculaIMC()) );
	}
	
}