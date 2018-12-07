/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Peixe extends Animal {

	private String caracteristica;

	public Peixe(String nome, String cor, String ambiente, double comprimento, double velocidade_media,
			String caracteristica) {
		super(nome, cor, ambiente, comprimento, velocidade_media,0);
		setCaracteristica(caracteristica);
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public void dadosPeixe() {
		System.out.println(super.toString() + " com a caracteristica " + getCaracteristica());
	}
	
	@Override
	public String emitirSom() {
		return "SOM PEIXE";
	}
}
