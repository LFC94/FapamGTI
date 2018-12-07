
public class ContaPoupanca extends ContaBancaria {
	private double taxa_rendimento;

	public ContaPoupanca(int numero, String senha) {
		super(numero, senha);
	}

	public double getTaxa_rendimento() {
		return taxa_rendimento;
	}

	public void setTaxa_rendimento(double taxa_rendimento) {
		this.taxa_rendimento = taxa_rendimento;
	}

	private double rendimento(double valor) {
		return (valor * getTaxa_rendimento() / 100);
	}

	@Override
	public void deposita(double valor) {
		super.deposita(valor + rendimento(valor));
	}

	@Override
	public String tiraExtrato() {
		return super.tiraExtrato();
	}

}
