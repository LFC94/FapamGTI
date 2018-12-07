/**
 * @author lucas
 *
 */
public class Elevador {
	private int andarAtual, totalAndares, capacidade, quantasPessoas;

	public Elevador(int totalAndares, int capacidade){
		this.totalAndares = totalAndares;
		this.capacidade = capacidade;
		andarAtual = 0;
		quantasPessoas = 0;
	}

	public boolean entrarPessoa() {
		if (quantasPessoas == getCapacidade())
			return false;

		quantasPessoas++;
		return true;
	}

	public boolean sairPessoa() {
		if (quantasPessoas == 0)
			return false;

		quantasPessoas--;
		return true;
	}

	public boolean sobir() {
		if (andarAtual == getTotalAndares())
			return false;
		andarAtual ++;
		return true;
	}

	public boolean decer() {
		if (andarAtual == 0)
			return false;
		
		andarAtual--;
		return true;
	}

	public int getAndarAtual() {
		return andarAtual;
	}

	public int getTotalAndares() {
		return totalAndares;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public int getQuantasPessoas() {
		return quantasPessoas;
	}

}
