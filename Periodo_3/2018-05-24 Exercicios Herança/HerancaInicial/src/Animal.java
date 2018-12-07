/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Animal {
	private String nome, cor, ambiente;
	private double comprimento, velocidade_media;
	private int numero_patas;

	public Animal(String nome, String cor, String ambiente, double comprimento, double velocidade_media,
			int numero_patas) {
		setNome(nome);
		setCor(cor);
		setAmbiente(ambiente);
		setComprimento(comprimento);
		setVelocidade_media(velocidade_media);
		setNumero_patas(numero_patas);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public double getVelocidade_media() {
		return velocidade_media;
	}

	public void setVelocidade_media(double velocidade_media) {
		this.velocidade_media = velocidade_media;
	}

	public int getNumero_patas() {
		return numero_patas;
	}

	public void setNumero_patas(int numero_patas) {
		this.numero_patas = numero_patas;
	}

	@Override
	public String toString() {
		return "Animal Nome " + getNome() + " de Cor " + getCor() + " em ambiente " + getAmbiente()
				+ " com o comprimento de " + getComprimento() + " com velocidade media " + getVelocidade_media()
				+ " com patas " + getNumero_patas();
	}
	
	public String emitirSom() {
		return "";
	}

}
