import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JFrame;

public class TelaInic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Component> comp = new ArrayList<>(); 
		JFrame jFrame = new MeuPrimeiroFrame();
		comp.add(MeuPrimeiroFrame.adicionarLabel("lbl1","Meu Primeiro Label",10,20, 200, 20));
		comp.add(MeuPrimeiroFrame.adicionarTextField("txt1","",10,180, 200, 20));
		comp.add(MeuPrimeiroFrame.adicionarButton("btn1","Meu Botão",300, 150, 100, 40));
		comp.add(MeuPrimeiroFrame.adicionarButton("btn2","Meu Botão1",200, 140, 120, 40));
		for(Component c:comp)
			jFrame.add(c);		
		jFrame.repaint();
	}

}
