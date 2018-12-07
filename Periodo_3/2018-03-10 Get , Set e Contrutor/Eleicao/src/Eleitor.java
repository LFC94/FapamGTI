import java.util.Scanner;

/**
 * 
 */

/**
 * @author Lucas
 *
 */
public class Eleitor {

	int idade;
	String sexo, nome, numerotítulo;
	
	public Eleitor(String nome, int idade, String sexo, String numerotítulo) {
		this.nome = nome;
		this.numerotítulo = numerotítulo;
		this.idade = idade;
		Scanner scanner = new Scanner(System.in);
		while(!verificaSexo(sexo)) {
			System.out.println("Sexo informado invalido.");
			System.out.print("Inform o sexo do "+getNome()+" (M/F):");
			sexo = scanner.nextLine();
		}
		this.sexo = sexo.toUpperCase();

	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	private boolean verificaSexo(String sexo) {
		
		if(!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F"))
			return false;
		
		
		return true;
	}
	
	
	public String getSexo() {
		return sexo;
	}
	public String getNome() {
		return nome;
	}
	public String getNumerotítulo() {
		return numerotítulo;
	}
	
	public void podeVotar() {
		if(idade<16) {
			System.out.println("O "+getNome()+" não pode votar");
		}else {
			if(idade<18 || idade > 65) {
				System.out.println("O "+getNome()+" não é obrigado a votar");
			}else {
				System.out.println("O "+getNome()+" é obrigado a votar");
			}
		}
		
	}
	
}
