/**
 * @author lucas
 *
 */
public class ValorMoeda {
	// Valores em Reais do dia 24/03/18
	private static double real = 1.00;// Moeda 1
	private static double dolarEUA = 0.301709;// Moeda 2
	private static double pesoAgentino = 6.088114;// Moeda 3
	private static double dolarCanadense = 0.388879;// Moeda 4
	private static double euro = 0.244163;// Moeda 5
	private static double libra = 0.213415;// Moeda 6

	public static double coverte(int moedaPara, double valor) {

		double valorMoedaPara;

		switch (moedaPara) {
		case 1:
			valorMoedaPara = real;
			break;
		case 2:
			valorMoedaPara = dolarEUA;
			break;
		case 3:
			valorMoedaPara = pesoAgentino;
			break;
		case 4:
			valorMoedaPara = dolarCanadense;
			break;
		case 5:
			valorMoedaPara = euro;
			break;
		case 6:
			valorMoedaPara = libra;
			break;
		default:
			valorMoedaPara = 1.00;
		}
		return  arredondar(valor*valorMoedaPara,2);
	}
	
	public static double arredondar(double valor, int casas) {
	    double arredondado = valor;
	    arredondado *= (Math.pow(10, casas));
	    arredondado = Math.ceil(arredondado);
	    arredondado /= (Math.pow(10, casas));
	    return arredondado;
	}

}
