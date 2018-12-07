package telas;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Alunos;
import java.awt.Window.Type;

public class TelaBuscaAluno extends JFrame {

	private static Alunos alunos = null;
	private DefaultTableModel modelo;
	private JTable tabela;

	public static Alunos buscarAlunos() {
		new TelaBuscaAluno();
		return alunos;
	}

	public TelaBuscaAluno() {		
		setTitle("Busca de Aluno");
		setSize(563, 423);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				
		modelo = new DefaultTableModel();

		// constrói a tabela
		tabela = new JTable(modelo);
		tabela.setBounds(5, 5, 560, 390);

		modelo.addColumn("Id");
		modelo.addColumn("Matricula");
		modelo.addColumn("Nome");
		modelo.addRow(new Object[] {});
		JScrollPane scrollPane = new JScrollPane(tabela);
		getContentPane().add(scrollPane);

		repaint();
	}

}
