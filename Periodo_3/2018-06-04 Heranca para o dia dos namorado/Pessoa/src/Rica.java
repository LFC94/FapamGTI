/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Rica extends Pessoa {
	private double dinheiro;

	public Rica(String nome, int idade, double dinheiro) {
		super(nome, idade);
		setDinheiro(dinheiro);
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	
	
	
	@Override
	public String toString() {
		return super.toString() + " tem R$" + getDinheiro();
	}

}
