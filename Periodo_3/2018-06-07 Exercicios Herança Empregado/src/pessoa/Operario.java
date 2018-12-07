package pessoa;

public class Operario extends Empregado {
	private double valorProducao = 0, comissao = 0;

	public Operario(String nome, String endereco, String telefone, int codigoSetor, double salarioBase,
			double imposto) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);

	}

	public Operario(String nome, String endereco, String telefone, int codigoSetor, double salarioBase, double imposto,
			double comissao) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
		setComissao(comissao);
	}

	public double getValorProducao() {
		return valorProducao;
	}

	public void producaoDefeito(double producao) {
		producao = producao < 0 ? 0 : producao;
		if ((this.valorProducao = producao) > 0)
			this.valorProducao -= producao;
		else
			this.valorProducao = 0;
	}

	public void somarProducao(double producao) {
		this.valorProducao += producao < 0 ? 0 : producao;
	}

	public void zerarProducao() {
		this.valorProducao = 0;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao < 0 ? 0 : comissao;
	}

	@Override
	public double calculaSalario() {
		return super.calculaSalario() + (getValorProducao() * getComissao() / 100);
	}

}
