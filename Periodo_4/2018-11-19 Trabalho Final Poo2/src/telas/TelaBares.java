package telas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import classe.Bar_Vende_Vebida;
import classe.Bares;
import classe.Bebidas;
import dao.Fabrica;
import interfaces.InterfaceBar;
import interfaces.InterfaceBarVendeBebida;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;

/**
 * @author lucas
 *
 */
public class TelaBares extends JDialog {
	private JTextField txtId, txtNome, txtFantasia;
	private JSpinner txtCapacidade;
	private JLabel lblCapacidade;
	private JTable tblBebidas;
	private JScrollPane scrollPane;
	private JButton btnAdicionar, btnRemover;
	
	private Bares bar = null;
	
	private InterfaceBar interfaceBar = Fabrica.criaDAOBar();
	private InterfaceBarVendeBebida interfaceBarVendeBebida = Fabrica.criaDAOBarVendeBebida();
	
	private ArrayList<Bar_Vende_Vebida> listBar_Vende_Vebida = new ArrayList<>();

	private DefaultTableModel model = new DefaultTableModel() {

		@Override
		public boolean isCellEditable(int row, int column) {
			if(column == 1)
				return true;
			return false;
		}
	};
	
	public TelaBares() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-mini-bar-16.png"));
		initComponents();
	}

	private void preencherCampos() {
		if (bar != null) {
			txtId.setText(String.valueOf(bar.getId()));
			txtNome.setText(bar.getNome());
			txtNome.setEnabled(true);
			txtFantasia.setText(bar.getFantasias());
			txtFantasia.setEnabled(true);
			txtCapacidade.setValue(bar.getCapacidade());
			txtCapacidade.setEnabled(true);
			btnAdicionar.setEnabled(true);
			btnRemover.setEnabled(true);
		} else {
			txtId.setText("");
			txtNome.setText("");
			txtNome.setEnabled(false);
			txtFantasia.setText("");
			txtFantasia.setEnabled(false);
			txtCapacidade.setValue(1);
			txtCapacidade.setEnabled(false);
			btnAdicionar.setEnabled(false);
			btnRemover.setEnabled(false);
		}
		listaBebidas();
	}

	private void listaBebidas() {
		
		for (int x = model.getRowCount(); x > 0; x--) {
			model.removeRow(x - 1);
		}
		for (Bar_Vende_Vebida vende : listBar_Vende_Vebida) {
			Object[] linha = new Object[] { vende.getBebidas().getNome(),vende.getValor() };
			model.addRow(linha);
		}
		
	}
	
	private void initComponents() {
		setTitle("Cadastro Bares");
		setSize(600, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(50, 57, 75, 14);
		getContentPane().add(lblId);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(130, 54, 100, 20);
		txtId.setDisabledTextColor(new Color(120, 120, 120));
		getContentPane().add(txtId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(50, 85, 75, 14);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setDisabledTextColor(new Color(120, 120, 120));
		txtNome.setBounds(130, 82, 400, 20);
		getContentPane().add(txtNome);

		JLabel lblFantasia = new JLabel("Fantasia");
		lblFantasia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFantasia.setBounds(50, 113, 75, 14);
		getContentPane().add(lblFantasia);

		txtFantasia = new JTextField();
		txtFantasia.setDisabledTextColor(new Color(120, 120, 120));
		txtFantasia.setBounds(130, 110, 400, 20);
		getContentPane().add(txtFantasia);

		lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidade.setBounds(50, 141, 75, 14);
		getContentPane().add(lblCapacidade);

		txtCapacidade = new JSpinner();
		txtCapacidade.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		txtCapacidade.setBounds(130, 138, 50, 20);
		getContentPane().add(txtCapacidade);

		scrollPane = new JScrollPane();
		tblBebidas = new JTable();
		tblBebidas.setColumnSelectionAllowed(true);
		tblBebidas.setRowSelectionAllowed(false);
		tblBebidas.setCellSelectionEnabled(true);
		getContentPane().add(scrollPane);

		scrollPane.setBounds(50, 203, 480, 205);
		scrollPane.setViewportView(tblBebidas);

		tblBebidas.setModel(model);
		
		model.addColumn("Nome");
		model.addColumn("Valor");

		tblBebidas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblBebidas.getColumnModel().getColumn(0).setPreferredWidth(375);
		tblBebidas.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bar.setNome(txtNome.getText());

					bar.setFantasias(txtFantasia.getText());
					bar.setCapacidade((int) txtCapacidade.getValue());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Aten��o", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				for(int x= 0; listBar_Vende_Vebida.size() > x ;x++ ) {
					listBar_Vende_Vebida.get(x).setValor(Double.parseDouble(model.getValueAt(x,1).toString()));
				}
				
				try {
					interfaceBar.cadastra(bar);
					for(Bar_Vende_Vebida bvb:listBar_Vende_Vebida)
						interfaceBarVendeBebida.cadastra(bvb);
					preencherCampos();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastra o bar./n/n log:" + e.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-salvar-16.png"));
		btnSalvar.setBounds(50, 437, 100, 23);
		getContentPane().add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (bar == null) {
					JOptionPane.showMessageDialog(null, "Nao possui bar para excluir", "Aten��o",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (JOptionPane.showConfirmDialog(null, "Confirma a exclus�o do bar " + bar.getNome() + "?", "Confirma",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						interfaceBar.remove(bar);
						bar = null;
						preencherCampos();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro ao excluir o bar./n/n log:" + e.getMessage(), "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnExcluir.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-excluir-16.png"));
		btnExcluir.setBounds(183, 437, 100, 23);
		getContentPane().add(btnExcluir);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bar = null;
				listBar_Vende_Vebida = new ArrayList<>();
				TelaBuscaBar b = new TelaBuscaBar();
				if (b.retorno() != null) {
					bar = (Bares) b.retorno();
					try {
						listBar_Vende_Vebida = interfaceBarVendeBebida.busca(bar);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao buscar Bar Vende Bebida/nErro"+e1.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
					}
				}
				preencherCampos();

			}
		});
		btnBuscar.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-pesquisar-16.png"));
		btnBuscar.setBounds(316, 437, 100, 23);
		getContentPane().add(btnBuscar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-fechar-janela-16.png"));
		btnFechar.setBounds(450, 437, 100, 23);
		getContentPane().add(btnFechar);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bar = new Bares();
				preencherCampos();
			}
		});
		btnNovo.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-arquivo-16.png"));
		btnNovo.setBounds(240, 53, 100, 23);
		getContentPane().add(btnNovo);
		
		JLabel lblBebidas = new JLabel("Bebidas");
		lblBebidas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBebidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBebidas.setBounds(50, 172, 75, 14);
		getContentPane().add(lblBebidas);
		
		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscaBebidas b = new TelaBuscaBebidas();
				if (b.retorno() != null) {
					Bar_Vende_Vebida vende = new Bar_Vende_Vebida();
					vende.setBares(bar);
					vende.setBebidas((Bebidas) b.retorno());
					listBar_Vende_Vebida.add(vende);
				}
				listaBebidas();
			}
		});
		btnAdicionar.setIcon(new ImageIcon("C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-adicionar-a-lista-16.png"));
		btnAdicionar.setBounds(130, 169, 26, 23);
		getContentPane().add(btnAdicionar);
		
		btnRemover = new JButton("");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setIcon(new ImageIcon("C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-excluir-16.png"));
		btnRemover.setBounds(166, 169, 26, 23);
		getContentPane().add(btnRemover);
		preencherCampos();

		setModal(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		repaint();
	}
}
