
public abstract class Pessoa implements GravarArquivo {
	private String nome;
	private String tipo;
	private String cpfCnpj;

	public Pessoa(String tipo, String cpfcnp, String nome) throws Exception {
		setTipo(tipo);
		setCpfcnpj(cpfcnp);
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (nome.trim().isEmpty() || nome.trim().length() <= 3)
			throw new Exception("Nome não informado ou informado incoretamente.");

		this.nome = nome.toUpperCase().trim();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo.toUpperCase().trim();
	}

	public String getCpfcnpj() {
		return cpfCnpj;
	}

	public void setCpfcnpj(String cpfcnpj) throws Exception {
		if(!CpfCnpjUtils.isValid(cpfcnpj)) {
			throw new Exception("CPF/CNPJ informado Invalido.");
		}
		this.cpfCnpj = cpfcnpj.trim();
	}

	public String gravaPessoa() {
		return getTipo() + ";" + getCpfcnpj() + ";" + getNome();
	}
}
