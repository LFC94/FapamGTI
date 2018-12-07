package interfaces;

import java.util.ArrayList;

import classe.Bares;
import classe.Bebidas;

public interface InterfaceBebida {
	
	public void cadastra(Bebidas bebidas) throws Exception ;
	public void remove(Bebidas bebidas) throws Exception ;
	public ArrayList<Bebidas> busca(String nome) throws Exception;
	public Bebidas busca(int id) throws Exception;
	

}
