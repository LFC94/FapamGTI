import java.util.Scanner;

/**
 * 
 */

/**
 * @author Lucas
 *
 */
public class Trabalhador {
	public static int numTrabalhador = 0;
	private double salarioMinimo = 981;
	private String matricula, nome;
	private double salario;	
	Scanner scanner;  
	public Trabalhador(String matricula,String nome, double salario) {	
		numTrabalhador ++;
		scanner = new Scanner(System.in);
		setMatricula(matricula);
		setNome(nome);
		setSalario(salario);		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		while(salario<salarioMinimo){
			System.out.println("Valor do salario do(a) "+getNome()+" nao pode ser inferior a "+String.format("R$%.2f",salarioMinimo));
			System.out.print("Informe o salario: ");
			salario = scanner.nextDouble();
		}
		this.salario = salario;
	}
	
	
}
