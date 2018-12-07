/**
 * @author lucas
 *
 */
public class Jogador {

	private String nome, possicao;
	private int numero, gols;
	private boolean expolso;

	public String getPossicao() {
		return possicao;
	}

	public void setPossicao(String possicao) {
		this.possicao = possicao;
	}

	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public boolean isExpolso() {
		return expolso;
	}

	public void setExpolso(boolean expolso) {
		this.expolso = expolso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
