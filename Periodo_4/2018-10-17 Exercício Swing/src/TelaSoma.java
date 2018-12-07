import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaSoma extends JFrame implements ActionListener, KeyListener, FocusListener {

	private JLabel lblNota1, lblNota2, lblNota3, lblTotal;
	private JTextField txtNota1, txtNota2, txtNota3, txtTotal;
	private JButton btnCalcular, btnFechar;

	public TelaSoma() {
		setTitle("Nota do Aluno");
		setSize(200, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lblNota1 = adicionarLabel("lblNota1", "Nota 1:", 20, 5, 50, 20, SwingConstants.RIGHT);
		add(lblNota1);
		lblNota2 = adicionarLabel("lblNota2", "Nota 2:", 50, 5, 50, 20, SwingConstants.RIGHT);
		add(lblNota2);
		lblNota3 = adicionarLabel("lblNota3", "Nota 3:", 80, 5, 50, 20, SwingConstants.RIGHT);
		add(lblNota3);
		lblTotal = adicionarLabel("lblTotal", "Total", 110, 5, 50, 20, SwingConstants.RIGHT);
		add(lblTotal);

		txtNota1 = adicionarTextField("txtNota1", "0.00", 18, 60, 100, 25, true);
		txtNota1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(txtNota1);

		txtNota2 = adicionarTextField("txtNota2", "0.00", 48, 60, 100, 25, true);
		txtNota2.setHorizontalAlignment(SwingConstants.RIGHT);
		add(txtNota2);

		txtNota3 = adicionarTextField("txtNota3", "0.00", 78, 60, 100, 25, true);
		txtNota3.setHorizontalAlignment(SwingConstants.RIGHT);
		add(txtNota3);

		txtTotal = adicionarTextField("txtTotal", "0.00", 108, 60, 100, 25, false);
		txtTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		add(txtTotal);

		btnCalcular = adicionarButton("btnCalcular", "Calcular", 150, 60, 100, 25);
		add(btnCalcular);
		repaint();
	}

	public JLabel adicionarLabel(String nome, String caption, int top, int left, int width, int height, int align) {
		return adicionarLabel(nome, caption, top, left, width, height, null, null, align);
	}

	public JLabel adicionarLabel(String nome, String caption, int top, int left, int width, int height, Font font,
			Color color, int align) {
		JLabel label = new JLabel(caption);
		label.setName(nome);
		label.setBounds(left, top, width, height);
		label.setFont(font == null ? new Font("Ariel", Font.PLAIN, 12) : font);
		label.setHorizontalAlignment(align);
		label.setForeground(color == null ? Color.BLACK : color);
		return label;
	}

	public JTextField adicionarTextField(String nome, String text, int top, int left, int width, int height,
			boolean enable) {
		JTextField jTextField = new JTextField();
		jTextField.setName(nome);
		jTextField.setText(text);
		jTextField.setEnabled(enable);
		jTextField.setBounds(left, top, width, height);
		jTextField.addKeyListener(this);
		jTextField.addFocusListener(this);
		return jTextField;
	}

	public JButton adicionarButton(String nome, String caption, int top, int left, int width, int height) {
		JButton jButton = new JButton();
		jButton.setName(nome);
		jButton.setText(caption);
		jButton.setBounds(left, top, width, height);
		jButton.addActionListener(this);
		return jButton;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Component component = (Component) arg0.getSource();
		if (component.getName() == btnCalcular.getName()) {
			txtTotal.setText(String.valueOf(converteValor(txtNota1.getText()) + converteValor(txtNota2.getText())
					+ converteValor(txtNota3.getText())));
			
			if(converteValor(txtTotal.getText())<60) {
				JOptionPane.showMessageDialog(null,"O Aluno esta REPROVADO","Nota", JOptionPane.ERROR_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null,"O Aluno esta APROVADO","Nota", JOptionPane.QUESTION_MESSAGE);
			}
			
		}
	}

	public double converteValor(String valor) {
		try {
			return Float.parseFloat(valor);
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		Component component = (Component) arg0.getSource();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		Component component = (Component) arg0.getSource();

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		Component component = (Component) arg0.getSource();
		char c = arg0.getKeyChar();
		if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
			arg0.consume();
		}
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		Component component = (Component) arg0.getSource();

		if (component instanceof JTextField)
			((JTextField) component).selectAll();
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		Component component = (Component) arg0.getSource();
		

	}

}
