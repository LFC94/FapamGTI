
public class PessoaJuridica extends Pessoa {

	public PessoaJuridica( String nome, String cpfcnp) throws Exception {
		super("PJ", cpfcnp, nome);
	}

	@Override
	public String toString() {
		return "A Empresa " + getNome() + " de CNPJ " + getCpfcnpj();
	}

}
