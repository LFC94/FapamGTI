/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Receita {
	private String nome;
	private Ingrediente[] ingredientes;
	
	public Receita(String nome, int quantidadeIgredientes) {
		setNome(nome);
		ingredientes = new Ingrediente[quantidadeIgredientes];
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.trim().toUpperCase();
	}
	public Ingrediente[] getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Ingrediente ingrediente, int posicao) {
		this.ingredientes[posicao] = ingrediente;
	}
}
