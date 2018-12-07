package pessoa;

public class Vendedor extends Empregado {
	private double valorVendas = 0, comissao = 0;

	public Vendedor(String nome, String endereco, String telefone, int codigoSetor, double salarioBase,
			double imposto) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
	}

	public Vendedor(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double imposto,
			double comissao) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
		setComissao(comissao);
	}

	public double getValorVendas() {
		return valorVendas;
	}

	public void cancelarVenda(double valor) {
		valor = valor < 0 ? 0 : valor;
		if (getValorVendas() - valor > 0)
			this.valorVendas -= valor;
		else
			this.valorVendas = 0;
	}

	public void vendasEfetuada(double valor) {
		this.valorVendas += valor < 0 ? 0 : valor;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao < 0 ? 0 : comissao;
	}

	@Override
	public double calculaSalario() {
		return super.calculaSalario() + (getValorVendas() * getComissao() / 100);
	}

}
