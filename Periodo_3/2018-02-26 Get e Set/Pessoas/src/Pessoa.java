/**
 * @author Lucas
 *
 */
public class Pessoa {
	private String nome, endereco, telefone;

	public Pessoa(String nome, String endereco,String telefone) {
		this.nome = nome;
		this.endereco =  endereco;
		this.telefone=telefone;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
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
		String format = telefone.replaceAll("-", "").replaceAll("(","").replaceAll(")","");
				
		this.telefone = format;
	}

	public void imprimirPessoa() {
		System.out.println("Nome: " + getNome());
		System.out.println("Endereco: " + getEndereco());
		System.out.println("Telefone: " + getTelefone());

	}
}
