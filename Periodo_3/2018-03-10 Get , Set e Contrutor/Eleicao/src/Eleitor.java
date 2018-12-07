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
	String sexo, nome, numerot�tulo;
	
	public Eleitor(String nome, int idade, String sexo, String numerot�tulo) {
		this.nome = nome;
		this.numerot�tulo = numerot�tulo;
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
	public String getNumerot�tulo() {
		return numerot�tulo;
	}
	
	public void podeVotar() {
		if(idade<16) {
			System.out.println("O "+getNome()+" n�o pode votar");
		}else {
			if(idade<18 || idade > 65) {
				System.out.println("O "+getNome()+" n�o � obrigado a votar");
			}else {
				System.out.println("O "+getNome()+" � obrigado a votar");
			}
		}
		
	}
	
}
