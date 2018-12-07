package interfaces;

import java.util.ArrayList;

import classes.Alunos;

public interface InterfaceAluno {
	
	public void cadastra(Alunos alunos) throws Exception ;
	public void remove(Alunos alunos) throws Exception ;
	public ArrayList<Alunos> busca(String nome) throws Exception;
	public Alunos busca(int id) throws Exception ;
	

}
