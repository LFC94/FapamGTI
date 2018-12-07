package pessoa;

public class Fornecedor extends Pessoa {
	private double limiteCredito = 0, valorDivida = 0;

	public Fornecedor(String nome, String endereco, String telefone, double limiteCredito) {
		super(nome, endereco, telefone);
		setLimiteCredito(limiteCredito);
	}

	public Fornecedor(String nome, String endereco, double limiteCredito) {
		super(nome, endereco);
		setLimiteCredito(limiteCredito);
	}

	public Fornecedor(String nome, double limiteCredito) {
		super(nome);
		setLimiteCredito(limiteCredito);
	}

	public double limiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito < 0 ? 0 : limiteCredito;
	}

	public double getValorDivida() {
		return valorDivida;
	}

	public void diminuirDivida(double subtrairDivida) {
		this.valorDivida -= subtrairDivida < 0 ? 0 : subtrairDivida;
	}

	public void aumentarDivida(double somarDivida) {
		this.valorDivida += somarDivida < 0 ? 0 : somarDivida;
	}

	public double ObterSaldoRestante() {
		return limiteCredito - valorDivida;
	}

}
