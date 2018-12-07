package classes;

import javax.swing.JOptionPane;

public class Libs {

	public static int StringToInt(String valor) {
		try {
			return Integer.parseInt(valor.trim());
		} catch (Exception e) {
			return 0;
		}
	}

	public static void Mensagem(String mensagem, String titulo, int icone) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, icone);
	}

}
