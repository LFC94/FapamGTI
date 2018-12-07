package pessoa;

public class Administrador extends Empregado {

	private double ajudaDeCusto = 0;

	public Administrador(String nome, String endereco, String telefone, int codigoSetor, double salarioBase,
			double imposto) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
	}

	public Administrador(String nome, String endereco, String telefone, int codigoSetor, double salarioBase,
			double imposto, double ajudaDeCusto) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
		setAjudaDeCusto(ajudaDeCusto);

	}

	public double getAjudaDeCusto() {
		return ajudaDeCusto;
	}

	public void setAjudaDeCusto(double ajudaDeCusto) {
		this.ajudaDeCusto = ajudaDeCusto < 0 ? 0 : ajudaDeCusto;
	}

	@Override
	public double calculaSalario() {
		return super.calculaSalario() + getAjudaDeCusto();
	}

}
