package com.lucas;

public abstract class PessoaJuridica extends Pessoa {
	private String cnpj, razaoSocial;

	@Override
	public void taxa() {
		alterarValor(saudoAtual() - (saudoAtual() * 0.1));
	}

	public PessoaJuridica(String nome, String lagradouro, String bairro, String cidade, int numero, double dinheiro,
			String cnpj, String razaoSocial) {
		super(nome, lagradouro, bairro, cidade, numero, dinheiro);		
		setCnpj(cnpj);
		setRazaoSocial(razaoSocial);
	}
	public PessoaJuridica(String nome, String lagradouro, String bairro, String cidade, double dinheiro,
			String cnpj, String razaoSocial) {
		super(nome, lagradouro, bairro, cidade, dinheiro);		
		setCnpj(cnpj);
		setRazaoSocial(razaoSocial);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
