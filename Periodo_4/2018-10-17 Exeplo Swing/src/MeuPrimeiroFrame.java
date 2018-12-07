import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MeuPrimeiroFrame extends JFrame {
	public MeuPrimeiroFrame(){
		setTitle("Minha primeira janela");
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static JLabel adicionarLabel(String nome, String caption, int top, int left, int width, int height){
		JLabel label = new JLabel(caption);
		label.setName(nome);
		label.setFont(new Font("Ariel", Font.BOLD, 15));
		label.setBounds(left, top,  width, height);
		label.setForeground(Color.GREEN);
		return label;
	}
	
	public static JTextField adicionarTextField(String nome, String caption, int top, int left, int width, int height){
		JTextField jTextField = new JTextField();
		jTextField.setName(nome);
		jTextField.setText(caption);
		jTextField.setBounds(left, top, width, height);
		return jTextField;
	}
	
	public static JButton adicionarButton(String nome, String caption, int top, int left, int width, int height){
		JButton jButton = new JButton();
		jButton.setName(nome);
		jButton.setText(caption);
		jButton.setBounds(left, top, width, height);
		jButton.addActionListener(new BotaoListener(jButton));
		return jButton;
	}
}
