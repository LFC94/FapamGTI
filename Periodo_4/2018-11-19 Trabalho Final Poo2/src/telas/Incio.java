/**
 * 
 */
package telas;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * @author lucas
 *
 */
public class Incio extends JFrame {

	public Incio() {
		initComponents();
	}

	private void initComponents() {
		setTitle("Inicio");
		setSize(600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setIcon(new ImageIcon("C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-formato-16.png"));
		menuBar.add(mnCadastro);

		JMenuItem mntmBares = new JMenuItem("Bar");
		mntmBares.setIcon(new ImageIcon("C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-mini-bar-16.png"));
		mntmBares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBares t = new TelaBares();				
			}
		});

		mnCadastro.add(mntmBares);
		
		JMenuItem mntmBebidas = new JMenuItem("Bebidas");
		mntmBebidas.setIcon(new ImageIcon("C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-cerveja-de-trigo-b\u00E1vara-16.png"));
		mntmBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBebida t = new TelaBebida();				
			}
		});
		mnCadastro.add(mntmBebidas);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Incio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Incio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Incio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Incio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Incio().setVisible(true);
			}
		});

	}
}
