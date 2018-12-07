import java.util.ArrayList;

import classes.Alunos;
import dao.Fabrica;
import interfaces.InterfaceAluno;
import telas.TelaCadastro;

public class Teste {

	public static void main(String[] args) {
		new TelaCadastro();
		/*
		Alunos alunos = new Alunos();
		InterfaceAluno x = Fabrica.criaDAO();		
		
		try {
			alunos.setMatricula("123456");
			alunos.setNome("LLL");
			alunos.setMatriculado(false);
			x.cadastra(alunos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			alunos = new Alunos();
			alunos.setMatricula("1236");
			alunos.setNome("JJL");
			alunos.setMatriculado(true);
			x.cadastra(alunos);
		} catch (Exception e) {
			System.out.println("Erro ao cadastra aluno JJL");
		}
		ArrayList<Alunos> a = new ArrayList<>();
		try {
			
			a = x.busca("LLL");
			if (a.size() <= 0)
				System.out.println("Naoo retornou nenhum aluno");
			else
				for (Alunos al : a)
					System.out.println(al.getNome());
		} catch (Exception e) {
			System.out.println("Erro ao buscar aluno LLL");
		}
		try {
		//	x.remove(a.get(0));
		} catch (Exception e) {
			System.out.println("Erro ao deletar aluno LLL");
		}*/
	}

}
