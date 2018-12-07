import java.util.Scanner;
/**
 * @author Lucas
 *
 */
public class Produtos {
	private String nome;
	private double precoCusto, precoVenda, margemLucro;

	public Produtos(String nome, double precoCusto,double precoVenda) {
		setNome(nome);
		setPrecoCusto(precoCusto);
		setPrecoVenda(precoVenda);
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		boolean continuar = true;
		Scanner scanner = new Scanner(System.in);
		do {
			if (precoCusto < 0) {
				System.out.print("O preco de Custo esta Menor que Zero.");
				System.out.print("Informa o novo valor de custo: ");
				precoCusto = scanner.nextDouble();				
			}else {
				continuar = false;
			}
		} while (continuar);
		
		this.precoCusto = precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {

		boolean continuar = true;
		Scanner scanner = new Scanner(System.in);
		do {
			if (precoVenda <= getPrecoCusto()) {
				System.out.println("O preco de venda esta menor ou igual o preco de venda.");				
				System.out.print("Informa o novo valor de venda: ");
				precoVenda = scanner.nextDouble();
				
			}else {
				continuar = false;
			}
		} while (continuar);

		this.precoVenda = precoVenda;
	}

	public double getMargemLucro() {
		return margemLucro;
	}

	public void calcularMargemLucro() {
		this.margemLucro =getPrecoVenda() - getPrecoCusto();
	}
	public double getMargemLucroPorcentagem() {
		return getMargemLucro()*100/getPrecoCusto();	
	}
}
