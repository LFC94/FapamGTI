/**
 * 
 */
package telas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classe.Bares;
import dao.Fabrica;
import interfaces.InterfaceBar;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author lucas
 *
 */
public class TelaBuscaBar extends JDialog {

	private Object retorno = null;
	private JTable tblBusca;
	private JScrollPane scrollPane;

	private JTextField txtPesquisa;
	private InterfaceBar interfaceBar = Fabrica.criaDAOBar();

	private ArrayList<Bares> listBares;

	private DefaultTableModel model = new DefaultTableModel() {

		@Override
		public boolean isCellEditable(int row, int column) {
			// all cells false
			return false;
		}
	};

	public TelaBuscaBar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-mini-bar-16.png"));
		initComponents();
	}

	private void initComponents() {
		setTitle("Cadastro Bares");
		setSize(600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		tblBusca = new JTable();
		tblBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !e.isConsumed()) {
					if (tblBusca.getSelectedRow() != -1) {
						retorno = listBares.get(tblBusca.getSelectedRow());
					}
					dispose();
				}
			}
		});
		tblBusca.setColumnSelectionAllowed(true);
		tblBusca.setRowSelectionAllowed(false);
		tblBusca.setCellSelectionEnabled(true);
		// tblBusca.setBounds(0, 0, 594, 430);
		getContentPane().add(scrollPane);

		scrollPane.setBounds(0, 0, 594, 402);
		scrollPane.setViewportView(tblBusca);

		tblBusca.setModel(model);

		model.addColumn("Id");
		model.addColumn("Nome");
		model.addColumn("Capacidade");

		tblBusca.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblBusca.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblBusca.getColumnModel().getColumn(1).setPreferredWidth(420);
		tblBusca.getColumnModel().getColumn(2).setPreferredWidth(100);

		JLabel lblPesquisar = new JLabel("Pesquisar");
		lblPesquisar.setBounds(10, 417, 46, 14);
		getContentPane().add(lblPesquisar);

		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
					buscar();
				}
			}
		});
		txtPesquisa.setBounds(63, 414, 422, 20);
		getContentPane().add(txtPesquisa);
		txtPesquisa.setColumns(10);

		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscar();
			}
		});
		button.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-filtro-16.png"));
		button.setBounds(490, 413, 100, 23);
		getContentPane().add(button);

		JButton button_1 = new JButton("Abrir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblBusca.getSelectedRow() != -1) {
					retorno = listBares.get(tblBusca.getSelectedRow());
				}
				dispose();
			}
		});
		button_1.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-selecionado-16.png"));
		button_1.setBounds(385, 442, 100, 23);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("Fechar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-fechar-janela-16.png"));
		button_2.setBounds(490, 442, 100, 23);
		getContentPane().add(button_2);

		setModal(true);
		setVisible(true);
		setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		repaint();
	}

	private void buscar() {
		if (listBares != null)
			for (int x = listBares.size(); x > 0; x--) {
				model.removeRow(x - 1);
			}
		try {
			listBares = interfaceBar.busca(txtPesquisa.getText().toUpperCase().trim());
			for (Bares bar : listBares) {
				Object[] linha = new Object[] { bar.getId(), bar.getNome(), bar.getCapacidade() };
				model.addRow(linha);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar os bares. \n\nLog: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public Object retorno() {
		return retorno;
	}
}
