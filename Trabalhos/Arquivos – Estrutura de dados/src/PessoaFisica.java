public class PessoaFisica extends Pessoa {
	String sexo, estadoCivil;

	public PessoaFisica(String nome, String cpfCnpj, String sexo, String estadoCivil) throws Exception {
		super("PF", cpfCnpj, nome);
		setSexo(sexo);
		setEstadoCivil(estadoCivil);
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) throws Exception {
		if (!sexo.equalsIgnoreCase("f") && !sexo.equalsIgnoreCase("m"))
			throw new Exception("Sexo informado e invalido. Permitido apenas F(Feminino)/M(Masculino)");

		this.sexo = sexo.toUpperCase().trim();
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil.toUpperCase().trim();
	}

	@Override
	public String toString() {
		return (getSexo().trim().equalsIgnoreCase("f") ? "Sra. " : "Sr. ") + getNome() + " de CPF " + getCpfcnpj() + " "
				+ getEstadoCivil();
	}

	@Override
	public String gravaPessoa() {
		return super.gravaPessoa() + ";" + getSexo() + ";" + getEstadoCivil();
	}

}
