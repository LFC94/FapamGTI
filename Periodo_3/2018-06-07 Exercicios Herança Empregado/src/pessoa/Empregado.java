package pessoa;

import acoes.Principal;

public class Empregado extends Pessoa {
	public static double salarioMinimo;

	private int codigoSetor = 0;
	private double salarioBase = 0, imposto = 0;

	public Empregado(String nome, String endereco, String telefone, int codigoSetor, double salarioBase,
			double imposto) {
		super(nome, endereco, telefone);
		setCodigoSetor(codigoSetor);
		this.salarioBase = salarioBase < salarioMinimo ? salarioMinimo : salarioBase;
		setImposto(imposto);
	}

	public int getCodigoSetor() {
		return codigoSetor;
	}

	public void setCodigoSetor(int codigoSetor) {
		this.codigoSetor = codigoSetor;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void aumentarSalarioBase(double percentual) {
		percentual = percentual < 0 ? 0 : percentual;
		this.salarioBase += (getSalarioBase() * percentual / 100);
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto < 5 ? 5 : imposto;
	}

	public double calculaSalario() {
		return getSalarioBase() - (getSalarioBase() * getImposto() / 100);
	}

}
