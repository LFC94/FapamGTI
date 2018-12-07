/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Mamifero extends Animal {
	
	private String alimento;

	public Mamifero(String nome, String cor, String ambiente, double comprimento, double velocidade_media,
			int numero_patas, String alimento) {
		super(nome, cor, ambiente, comprimento, velocidade_media, numero_patas);
		setAlimento(alimento);
	}

	public String getAlimento() {
		return alimento;
	}	
	
	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
	
	public void dadosMamifero() {
		System.out.println(super.toString() + " se Alimenta de " + getAlimento());
	}
	@Override
	public String emitirSom() {
		return "SOM MAMIFERO";
	}
}
