/**
 * 
 */
package telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import classe.Bebidas;
import dao.Fabrica;
import interfaces.InterfaceBebida;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 * @author lucas
 *
 */
public class TelaBebida extends JDialog {
	private JTextField txtId, txtNome;
	private JFormattedTextField txtCapacidade;
	private JTextArea txtInfo;
	private InterfaceBebida interfaceBebida = Fabrica.criaDAOBebida();
	private Bebidas bebidas = null;
	DecimalFormat decimal = new DecimalFormat("#,###,###.00");

	public TelaBebida() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-cerveja-de-trigo-b\u00E1vara-16.png"));
		initComponents();
	}

	private void initComponents() {
		setTitle("Cadastro Bebidas");
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

		JButton btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bebidas = new Bebidas();
				preencherCampos();
			}
		});
		btnNovo.setIcon(new ImageIcon(
				"C:\\Users\\lucas\\Documents\\Codigo Fonte\\Fapam\\poo_lucasfelipecosta\\Periodo_4\\2018-11-19 Trabalho Final Poo2\\imagens\\icons8-arquivo-16.png"));
		btnNovo.setBounds(240, 53, 100, 23);
		getContentPane().add(btnNovo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(50, 85, 75, 14);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setDisabledTextColor(new Color(120, 120, 120));
		txtNome.setBounds(130, 82, 400, 20);
		getContentPane().add(txtNome);

		JLabel lblCapacidade = new JLabel("Capacidade");
		lblCapacidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCapacidade.setBounds(50, 113, 75, 14);
		getContentPane().add(lblCapacidade);

		NumberFormatter numFormatter = new NumberFormatter(decimal);
		numFormatter.setFormat(decimal);
		numFormatter.setAllowsInvalid(false);
		DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatter);

		txtCapacidade = new JFormattedTextField(dfFactory);
		txtCapacidade.setBounds(130, 110, 100, 20);
		getContentPane().add(txtCapacidade);

		JLabel lblInformao = new JLabel("Informação");
		lblInformao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInformao.setBounds(50, 143, 75, 14);
		getContentPane().add(lblInformao);

		txtInfo = new JTextArea();
		txtInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtInfo.setBounds(130, 138, 400, 66);
		getContentPane().add(txtInfo);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					bebidas.setNome(txtNome.getText());
					bebidas.setInfo(txtInfo.getText());
					Number number = decimal.parse(txtCapacidade.getText());
					bebidas.setVolume_emb(number.doubleValue());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Atenção", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				try {
					interfaceBebida.cadastra(bebidas);
					preencherCampos();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao cadastra o Bebidas./n/n log:" + e.getMessage(), "Erro",
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
				if (bebidas == null) {
					JOptionPane.showMessageDialog(null, "Nao possui bebida para excluir", "Atenção",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (JOptionPane.showConfirmDialog(null, "Confirma a exclusão da bebida " + bebidas.getNome() + "?",
						"Confirma", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						interfaceBebida.remove(bebidas);
						bebidas = null;
						preencherCampos();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Erro ao exluir a bebidas./n/n log:" + e.getMessage(), "Erro",
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
				bebidas = null;
				TelaBuscaBebidas b = new TelaBuscaBebidas();
				if (b.retorno() != null) {
					bebidas = (Bebidas) b.retorno();
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

		preencherCampos();
		setModal(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		repaint();
	}

	private void preencherCampos() {
		if (bebidas != null) {
			txtId.setText(String.valueOf(bebidas.getId()));
			txtNome.setText(bebidas.getNome());
			txtNome.setEnabled(true);
			txtInfo.setText(bebidas.getInfo());
			txtInfo.setEnabled(true);
			txtCapacidade.setValue(bebidas.getVolume_emb());
			txtCapacidade.setEnabled(true);
		} else {
			txtId.setText("");
			txtNome.setText("");
			txtNome.setEnabled(false);
			txtInfo.setText("");
			txtInfo.setEnabled(false);
			txtCapacidade.setValue(0.00);
			txtCapacidade.setEnabled(false);
		}
	}
}
