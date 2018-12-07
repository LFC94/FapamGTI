package pessoa;

public class Pessoa {
	private String nome, endereco, telefone;

	public Pessoa() {
	}

	public Pessoa(String nome) {
		setNome(nome);
	}

	public Pessoa(String nome, String endereco) {
		setNome(nome);
		setEndereco(endereco);
	}

	public Pessoa(String nome, String endereco, String telefone) {
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase().trim();
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
