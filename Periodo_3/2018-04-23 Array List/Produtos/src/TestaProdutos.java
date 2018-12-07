import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author lucas
 *
 */
public class TestaProdutos {

	/**
	 * @param args
	 */
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		boolean continua = true;
		ArrayList<Produtos> produtos = new ArrayList<>();		
		do {
			Produtos produto = new Produtos();
			System.out.print("Informe a decrição do Material: ");
			produto.setDescricao(teclado());
			
			System.out.print("Informe o valor do "+produto.getDescricao().trim()+": ");
			produto.setValor(Double.parseDouble(teclado()));
			
			produtos.add(produto);
			
			System.out.print("Deseja continuar cadadtrando(S/N)?");
			continua = teclado().trim().equalsIgnoreCase("S");
			
		}while(continua);

		System.out.println(produtos.contains("ARROZ")?"Já":"Nao"+" possui o materia Arroz cadastrado");
		for(int i = 0; i<produtos.size();i++) {
			if (produtos.get(i).getDescricao().equalsIgnoreCase("vodka"))
				produtos.remove(i);
		}
		
		double valorTotal = 0;
		System.out.println("\nLista de Materiais");
		for(Produtos produto:produtos) {
			System.out.printf("Material %d - %s de R$ %.2f\n ",produto.getCodigo(),produto.getDescricao(),produto.getValor());
			valorTotal += produto.getValor();
		}
		System.out.printf("\n%s%.2f\n","Valor total dos Materiais é ",valorTotal);
		
	}

	public static String teclado() {
		String s  = "";
		while(scanner.hasNextLine()) {
			 s = scanner.nextLine();
			 break;
		}		
		return s;
	}
}
