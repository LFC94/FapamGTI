/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Ingrediente {
	private String nome;
	private double quantidade;

	public Ingrediente(String nome, double quantidade) {
		setNome(nome);
		setQuantidade(quantidade);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.trim().toUpperCase();
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade < 0 ? 0 : quantidade;
	}

}
