package com.lucas;

public class PessoaFisica extends Pessoa  implements Tributavel {
	private String cpf, rg;
	private int filhos;
	
	public PessoaFisica(String nome, String lagradouro, String bairro, String cidade, int numero, double dinheiro,
			String cpf, String rg, int filhos) {
		super(nome, lagradouro, bairro, cidade, numero, dinheiro);
		setCpf(cpf);
		setRg(rg);
		setFilhos(filhos);
	}
	public PessoaFisica(String nome, String lagradouro, String bairro, String cidade, double dinheiro,
			String cpf, String rg, int filhos) {
		super(nome, lagradouro, bairro, cidade, dinheiro);
		setCpf(cpf);
		setRg(rg);
		setFilhos(filhos);
	}
	public PessoaFisica(String nome, String lagradouro, String bairro, String cidade, int numero, double dinheiro,
			String cpf, int filhos) {
		super(nome, lagradouro, bairro, cidade, numero, dinheiro);
		setCpf(cpf);
		setFilhos(filhos);
	}
	public PessoaFisica(String nome, String lagradouro, String bairro, String cidade, double dinheiro,
			String cpf, int filhos) {
		super(nome, lagradouro, bairro, cidade, dinheiro);
		setCpf(cpf);
		setFilhos(filhos);
	}
	
	@Override
	public void taxa() {
		alterarValor(saudoAtual()-(saudoAtual()*0.05));
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getFilhos() {
		return filhos;
	}

	public void setFilhos(int filhos) {
		this.filhos = filhos;
	}

	public double verificaHeranca() {
		return getFilhos() > 0 ? (saudoAtual() - (saudoAtual() * 0.07)) / ((double)getFilhos()) : 0.00;
	}
	@Override
	public void pagrarTributoAnual() {
		alterarValor(saudoAtual()-(saudoAtual()*0.20));;
	}

}
