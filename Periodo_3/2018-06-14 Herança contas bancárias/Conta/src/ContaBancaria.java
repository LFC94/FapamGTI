
public class ContaBancaria {
	private String senha;
	private int numero, quantTransRea = 0;
	private double saldo;

	public ContaBancaria(int numero, String senha) {
		this.numero = numero;
		setSenha(senha);
	}

	public void alteraSenha(String senhaAnt, String senhaAtu) {
		if(validaSenha(senhaAnt)) 
			setSenha(senhaAtu);			
	}
	
	public boolean validaSenha(String senha) {
		return this.senha.equals(senha);
	}
	
	private void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getQuantTransRea() {
		return quantTransRea;
	}

	public void saca(double valor) {
		saldo -= valor <= getSaldo() ? valor : 0;
		quantTransRea++;
	}

	public void deposita(double valor) {
		saldo += valor >= 0 ? valor : 0;
		quantTransRea++;
	}

	public String tiraExtrato() {
		return "SALDO ATUAL:R$" + getSaldo() + "\n" +
				"Quantidade de Transações Realizadas:" + getQuantTransRea();
	}

}
