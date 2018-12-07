package telas;

import java.awt.Button;
import java.awt.Component;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import classes.Alunos;
import classes.Libs;
import dao.Fabrica;
import interfaces.InterfaceAluno;

public class TelaCadastro extends JFrame implements ActionListener, KeyListener {

	private TextField txtId, txtNome, txtMatriclua;
	private Label lblId, lblMatricula, lblNome;
	private JCheckBox ckbMatriculado;
	private Button btnSalvar, btnExcluir, btnFechar;

	private InterfaceAluno interfaceAluno = Fabrica.criaDAO();
	private Alunos alunos;

	public TelaCadastro() {

		setTitle("Cadastro do Aluno");
		setSize(563, 423);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 1 Linha
		lblId = new Label();
		lblId.setBounds(5, 13, 50, 15);
		lblId.setText("ID");
		lblId.setAlignment(Label.RIGHT);
		add(lblId);

		txtId = new TextField();
		txtId.setName("txtId");
		txtId.setBounds(60, 10, 100, 21);
		// txtId.setEnabled(false);
		txtId.addKeyListener(this);
		add(txtId);

		ckbMatriculado = new JCheckBox();
		ckbMatriculado.setBounds(170, 12, 120, 16);
		ckbMatriculado.setText("Matriculado");
		add(ckbMatriculado);

		lblMatricula = new Label();
		lblMatricula.setBounds(280, 13, 70, 15);
		lblMatricula.setAlignment(Label.RIGHT);
		lblMatricula.setText("Matricula");
		add(lblMatricula);

		txtMatriclua = new TextField();
		txtMatriclua.setBounds(355, 10, 100, 21);
		txtMatriclua.setName("txtMatriclua");
		txtMatriclua.addKeyListener(this);
		add(txtMatriclua);
		// 2 Linha
		lblNome = new Label();
		lblNome.setBounds(5, 37, 50, 15);
		lblNome.setText("Nome");
		lblNome.setAlignment(Label.RIGHT);
		add(lblNome);

		txtNome = new TextField();
		txtNome.setBounds(60, 34, 395, 21);
		txtNome.setName("txtNome");
		txtNome.addKeyListener(this);
		add(txtNome);
		// 3 Linha
		btnSalvar = new Button();
		btnSalvar.setBounds(60, 80, 100, 25);
		btnSalvar.setName("btnSalvar");
		btnSalvar.setLabel("Salvar");
		btnSalvar.addActionListener(this);
		add(btnSalvar);

		btnExcluir = new Button();
		btnExcluir.setBounds(207, 80, 100, 25);
		btnExcluir.setName("btnExcluir");
		btnExcluir.setLabel("Excluir");
		btnExcluir.addActionListener(this);
		add(btnExcluir);

		btnFechar = new Button();
		btnFechar.setBounds(354, 80, 100, 25);
		btnFechar.setName("btnFechar");
		btnFechar.setLabel("Fechar");
		btnFechar.addActionListener(this);
		add(btnFechar);
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		Component component = (Component) arg0.getSource();
		if (component.getName() == txtId.getName()) {
			alunos = null;
		}
		if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
			if (component.getName() == txtId.getName()) {
				alunos = null;
				txtMatriclua.setText("");
				txtNome.setText("");
				ckbMatriculado.setSelected(false);

				if (txtId.getText().trim().isEmpty()) {
					TelaBuscaAluno.buscarAlunos();
					component.nextFocus();
				} else {
					try {
						alunos = interfaceAluno.busca(Libs.StringToInt(txtId.getText()));
					} catch (Exception e) {
						Libs.Mensagem("Erro ao conectar na base de dados", "Erro", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}

				if (alunos == null || alunos.getId() <= 0) {
					Libs.Mensagem("Nenhum aluno cadastrado com esta informacÃ£o", "Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}

				txtId.setText(String.valueOf(alunos.getId()));
				txtMatriclua.setText(alunos.getMatricula());
				txtNome.setText(alunos.getNome());
				ckbMatriculado.setSelected(alunos.isMatriculado());
			}
			component.nextFocus();
		}
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

		if (component.getName() == btnFechar.getName()) {
			System.exit(0);
		} else if (component.getName() == btnSalvar.getName()) {
			if (alunos == null || alunos.getId() <= 0) {
				alunos = new Alunos();
			}
			alunos.setMatricula(txtMatriclua.getText());
			alunos.setNome(txtNome.getText());
			alunos.setMatriculado(ckbMatriculado.isSelected());
			try {
				interfaceAluno.cadastra(alunos);
				txtId.setText(String.valueOf(alunos.getId()));
				Libs.Mensagem("Aluno cadatrado com sucesso", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				Libs.Mensagem("Erro ao cadastra o aluno /n " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

		} else if (component.getName() == btnExcluir.getName()) {
			if (alunos == null || alunos.getId() <= 0) {
				Libs.Mensagem("Não possui aluno para ser excluido", "Excluir", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			if (JOptionPane.showConfirmDialog(null, "Confirma a exclusão do aluno " + alunos.getNome(), "Excluir",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					interfaceAluno.remove(alunos);
					alunos = null;
					txtId.setText("");
					txtMatriclua.setText("");
					txtNome.setText("");
					ckbMatriculado.setSelected(false);
					txtId.requestFocus();
				} catch (Exception e) {
					Libs.Mensagem("Erro ao exluir o aluno /n " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
