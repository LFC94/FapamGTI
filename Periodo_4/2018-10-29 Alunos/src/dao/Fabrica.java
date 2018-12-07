package dao;

import interfaces.InterfaceAluno;

public class Fabrica {
	public static InterfaceAluno criaDAO() {
		return new AlunoDAOMySQL();
	}

}
