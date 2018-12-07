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
		System.out.println("Em dolar EUA é "+String.valueOf(ValorMoeda.coverte(2, 100.00)));
		System.out.println("Em peso Agentino é "+String.valueOf(ValorMoeda.coverte(3, 100.00)));
		System.out.println("Em dolar Canadense é "+String.valueOf(ValorMoeda.coverte(4, 100.00)));
		System.out.println("Em euro é "+String.valueOf(ValorMoeda.coverte(5, 100.00)));
		System.out.println("Em libra é "+String.valueOf(ValorMoeda.coverte(6, 100.00)));
		
	}
}
