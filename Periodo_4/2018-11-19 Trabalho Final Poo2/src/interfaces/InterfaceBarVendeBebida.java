package interfaces;

import java.util.ArrayList;

import classe.Bar_Vende_Vebida;
import classe.Bares;
import classe.Bebidas;

public interface InterfaceBarVendeBebida {
	
	public void cadastra(Bar_Vende_Vebida bvb) throws Exception ;
	public void remove(Bar_Vende_Vebida bvb) throws Exception ;
	public ArrayList<Bar_Vende_Vebida> busca(Bares bares) throws Exception;
	public ArrayList<Bar_Vende_Vebida> busca(Bebidas bebidas) throws Exception;
	public ArrayList<Bar_Vende_Vebida> busca() throws Exception;
	
}
