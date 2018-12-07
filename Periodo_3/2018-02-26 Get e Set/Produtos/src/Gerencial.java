import java.util.Scanner;

/**
 * 
 */

/**
 * @author Lucas
 *
 */
public class Gerencial {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String nome;
		double precoVenda, precoCusto;

		System.out.print("Infome o nome do Produto: ");
		nome = scanner.nextLine();
		
		System.out.print("Infome o valor de Custo do Produto: ");
		precoCusto = scanner.nextDouble();
		
		System.out.print("Infome o valor de Venda do Produto: ");
		precoVenda = scanner.nextDouble();
		
		Produtos produtos = new Produtos(nome,precoCusto,precoVenda);
		
		produtos.calcularMargemLucro();
		
		System.out.println("O Produto "+produtos.getNome()+" tem uma margem de lucro de R$ "+String.format("%.2f",produtos.getMargemLucro())+" que equivale a " +String.format("%.2f",produtos.getMargemLucroPorcentagem())+"%");
	}

}
