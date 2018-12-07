/**
 * 
 */

/**
 * @author Lucas
 *
 */
public class Cadastro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Trabalhador trabalhador = new Trabalhador("1","Lucas",1000);
		System.out.println("Trabalhador cadatrado "+Trabalhador.numTrabalhador);
		
		Trabalhador trabalhador2 = new Trabalhador("2","Leticia",990);
		System.out.println("Trabalhador cadatrado "+Trabalhador.numTrabalhador);
		
		Trabalhador trabalhador3 = new Trabalhador("3","Anderson",500);
		System.out.println("Trabalhador cadatrado "+Trabalhador.numTrabalhador);

	}

}
