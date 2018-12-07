package com.lucas;
/**
 * @author Lucas Felipe
 *
 */
public abstract class Pessoa {
	private String nome;
	private Endereco endereco;
	private double dinheiro;

	public abstract void taxa();

	public Pessoa(String nome, String lagradouro, String bairro, String cidade, int numero, double dinheiro) {
		setNome(nome);
		alterarValor(dinheiro);
		cadastraEndereco(lagradouro, bairro, cidade, numero);
	}

	public Pessoa(String nome, String lagradouro, String bairro, String cidade, double dinheiro) {
		setNome(nome);
		alterarValor(dinheiro);
		cadastraEndereco(lagradouro, bairro, cidade);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void cadastraEndereco(String lagradouro, String bairro, String cidade, int numero) {
		endereco = new Endereco(lagradouro, bairro, cidade, numero);
	}

	public void cadastraEndereco(String lagradouro, String bairro, String cidade) {
		cadastraEndereco(lagradouro, bairro, cidade, 0);
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public double saudoAtual() {
		return dinheiro;
	}

	public void alterarValor(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	@Override
	public String toString() {
		return "Nome " + getNome() + " com R$ " + saudoAtual();
	}

}
