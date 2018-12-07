package interfaces;

import java.util.ArrayList;

import classe.Bares;

public interface InterfaceBar {
	
	public void cadastra(Bares bares) throws Exception ;
	public void remove(Bares bares) throws Exception ;
	public ArrayList<Bares> busca(String nome) throws Exception;
	public Bares busca(int id) throws Exception ;
	
}
