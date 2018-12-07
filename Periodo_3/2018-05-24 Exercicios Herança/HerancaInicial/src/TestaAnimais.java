/**
 * 
 */

/**
 * @author lucas
 *
 */
public class TestaAnimais {

	public static void main(String[] args) {
		Mamifero mamifero1 = new Mamifero("Camelo", "Amarelo", "Terra", 150, 2, 4, "Grama");
		Peixe peixe = new Peixe("Tubarão", "Cinzento", "Mar", 300, 1.5, "Barbatanas e cauda");
		Mamifero mamifero2 = new Mamifero("Urso-do-canadá", "Amarelo", "Terra", 180, 0.5, 4, "Mel");

		mamifero1.dadosMamifero();
		peixe.dadosPeixe();
		mamifero2.dadosMamifero();
	}
}
