package com.lucas;

public class Privada extends PessoaJuridica implements Tributavel {

	public Privada(String nome, String lagradouro, String bairro, String cidade, int numero, double dinheiro,
			String cnpj, String razaoSocial) {
		super(nome, lagradouro, bairro, cidade, numero, dinheiro, cnpj, razaoSocial);
	}
	public Privada(String nome, String lagradouro, String bairro, String cidade, double dinheiro, String cnpj,
			String razaoSocial) {
		super(nome, lagradouro, bairro, cidade, dinheiro, cnpj, razaoSocial);
	}
	
	@Override
	public void pagrarTributoAnual() {
		alterarValor(saudoAtual()-(saudoAtual()*0.38));;
	}

}
