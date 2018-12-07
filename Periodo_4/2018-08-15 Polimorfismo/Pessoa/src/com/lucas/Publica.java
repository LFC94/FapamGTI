package com.lucas;

public class Publica extends PessoaJuridica {

	public Publica(String nome, String lagradouro, String bairro, String cidade, double dinheiro, String cnpj,
			String razaoSocial) {
		super(nome, lagradouro, bairro, cidade, dinheiro, cnpj, razaoSocial);
	}
	public Publica(String nome, String lagradouro, String bairro, String cidade, int numero, double dinheiro,
			String cnpj, String razaoSocial) {
		super(nome, lagradouro, bairro, cidade, numero, dinheiro, cnpj, razaoSocial);
	}

}
