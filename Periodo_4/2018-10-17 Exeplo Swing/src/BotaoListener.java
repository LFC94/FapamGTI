import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BotaoListener implements ActionListener {

	private Component view;
		
	public BotaoListener(Component view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null,"Voce clicou no botão!"+view.getName());

	}

}
