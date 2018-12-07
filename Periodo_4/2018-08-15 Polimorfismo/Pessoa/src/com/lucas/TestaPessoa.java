package com.lucas;

import java.util.ArrayList;

/**
 * @author Lucas Felipe Costa
 *
 */
public class TestaPessoa {

	public static void main(String[] args) {
		ArrayList<Pessoa> pessoas = new ArrayList<>();

		pessoas.add(new PessoaFisica("Lucas", "Topio", "Centro", "Para de Minas", 30, 100.00, "", 2));

		pessoas.add(new Privada("LFC APP", "Topazio", "Patafufo", "Para de Minas", 36, 100000, "--",
				"Lucas Felipe Costa Aplicativos"));

		pessoas.add(new PessoaFisica("JOSE", "Praca", "Centro", "Para de Minas", 60, 500.00, "", 5));

		pessoas.add(new Publica("Petrobras", "av", "centro", "rio de janeiro", 36, 30000, "--",
				"Lucas Felipe Costa Aplicativos"));
		
		System.out.println(strN('*',100));
		for (Pessoa p : pessoas) {
			System.out.println(p);
			if (p instanceof PessoaFisica)
				System.out.println(
						"A Eranca dos filhos do " + p.getNome() + " é de R$" + ((PessoaFisica) p).verificaHeranca());
		}
		for (Pessoa p : pessoas) {
			p.taxa();
		}
		System.out.println(strN('*',100));
		for (Pessoa p : pessoas) {
			System.out.println(p);
		}

		for (Pessoa p : pessoas) {
			if (p instanceof PessoaFisica)
				((PessoaFisica) p).pagrarTributoAnual();
			if (p instanceof Privada)
				((Privada) p).pagrarTributoAnual();
		}
		System.out.println(strN('*',100));
		for (Pessoa p : pessoas) {
			System.out.println(p);
			if (p instanceof PessoaFisica)
				System.out.println(
						"A Eranca dos filhos do " + p.getNome() + " é de R$" + ((PessoaFisica) p).verificaHeranca());
		}

	}

	public static String strN(char c, int n) {
		String aux = "";
		for (int i = 0; i < n; i++)
			aux += c;
		return aux;
	}

}
