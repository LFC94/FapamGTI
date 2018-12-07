/**
 * @author Lucas
 *
 */
public class Veiculo {
	private String cor, marca, modelo;
	private int nPass;
	private double qtdLtMax, qtdLtAtu;

	public Veiculo(String marca, String modelo, int nPass, double qtdLtMax) {
		this.marca = marca;
		this.modelo = modelo;
		this.nPass = nPass;
		this.qtdLtMax = qtdLtMax;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setQtdLitosAbastecido(double qtdLtAbast) {
		double abast = 0, qtdatu = getQtdLitrosAtual() + qtdLtAbast;
		if (qtdatu > getQtdLitrosMax()) {
			abast = getQtdLitrosMax() - getQtdLitrosAtual();
			System.out.println("Foi abasteciod apenas " + String.valueOf(abast) + " litros");
		} else {
			abast = qtdLtAbast;
		}
		this.qtdLtAtu = abast;
	}

	public String getCor() {
		return cor;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getNPass() {
		return nPass;
	}

	public double getQtdLitrosAtual() {
		return qtdLtAtu;
	}

	public double getQtdLitrosMax() {
		return qtdLtMax;
	}
}
