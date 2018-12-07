import java.awt.Button;
import java.awt.Component;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class TelaCadastro  extends JFrame implements ActionListener, KeyListener{
	
	private TextField txtId, txtNome, txtMatriclua;
	
	public TelaCadastro() {
		
		setTitle("Cadastro do Aluno");
		setSize(563, 423);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtId = new TextField();
		txtId.setBounds(79, 10, 102, 21);
		txtId.setEnabled(false);
		add(txtId);
		
		Label lblId = new Label();
		lblId.setBounds(63, 13, 15, 15);
		lblId.setText("ID");
		add(lblId);
		
		Button btnMatriculado = new Button();
		btnMatriculado.setBounds(187, 12, 93, 16);
		
		//btnMatriculado.setText("Matriculado");
		
		txtMatriclua = new TextField();
		txtMatriclua.setBounds(355, 10, 114, 21);
		add(txtMatriclua);
		
		Label lblMatricula = new Label();
		lblMatricula.setBounds(300, 13, 55, 15);
		lblMatricula.setText("Matricula");
		add(lblMatricula);
		
		txtNome = new TextField();
		txtNome.setBounds(79, 34, 390, 21);
		add(txtNome);
		
		Label lblNome = new Label();
		lblNome.setBounds(40, 37, 36, 15);
		lblNome.setText("Nome");
		add(lblNome);
		
		repaint();
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Component component = (Component) arg0.getSource();
		if (component.getName() == "a"/*btnCalcular.getName()**/) {
			
		}
		
	}

}
