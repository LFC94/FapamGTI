/**
 * 
 */

/**
 * @author lucas
 *
 */
public class ConverteMoedas {

	
	public static void main(String args[]) {
		
		System.out.println("Valor  100 reais");
		System.out.println("Em dolar EUA � "+String.valueOf(ValorMoeda.coverte(2, 100.00)));
		System.out.println("Em peso Agentino � "+String.valueOf(ValorMoeda.coverte(3, 100.00)));
		System.out.println("Em dolar Canadense � "+String.valueOf(ValorMoeda.coverte(4, 100.00)));
		System.out.println("Em euro � "+String.valueOf(ValorMoeda.coverte(5, 100.00)));
		System.out.println("Em libra � "+String.valueOf(ValorMoeda.coverte(6, 100.00)));
		
	}
}
