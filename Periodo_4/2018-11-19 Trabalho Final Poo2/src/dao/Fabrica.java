package dao;

import interfaces.InterfaceBar;
import interfaces.InterfaceBarVendeBebida;
import interfaces.InterfaceBebida;

public class Fabrica {
	public static InterfaceBar criaDAOBar() {
		return new DAOMySQLBar();
	}
	public static InterfaceBebida criaDAOBebida() {
		return new DAOMySQLBebida();
	}
	public static InterfaceBarVendeBebida criaDAOBarVendeBebida() {
		return new DAOMySQLBarVendeBebida();
	}
}
