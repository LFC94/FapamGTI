package com.lucas;
/**
 * @author Lucas Felipe
 *
 */
public class Endereco {

	private String lagradouro, bairro, cidade;
	private int numero;

	public Endereco(String lagradouro, String bairro, String cidade, int numero) {
		setLagradouro(lagradouro);
		setBairro(bairro);
		setCidade(cidade);
		setNumero(numero);
	}

	public Endereco(String lagradouro, String bairro, String cidade) {
		setLagradouro(lagradouro);
		setBairro(bairro);
		setCidade(cidade);
	}

	public String getLagradouro() {
		return lagradouro;
	}

	public void setLagradouro(String lagradouro) {
		this.lagradouro = lagradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
