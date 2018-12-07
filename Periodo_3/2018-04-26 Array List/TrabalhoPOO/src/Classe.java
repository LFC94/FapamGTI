import java.util.ArrayList;

/**
 * @author lucas
 */
public class Classe {

	private ArrayList<Alunos> alunos = new ArrayList<>();
	private String curso;
	private int anoInicial;

	public String getNomeAlunos(int index) {
		return alunos.get(index).getNome();
	}

	public String getTelefoneAlunos(int index) {
		return alunos.get(index).getTelefone();
	}

	public String getSexoAlunos(int index) {
		return alunos.get(index).getSexo();
	}

	public double getNotaAlunos(int index) {
		return alunos.get(index).getNota();
	}
	
	public void setNomeAlunos(int index,String nome) {
		alunos.get(index).setNome(nome);
	}

	public void setTelefoneAlunos(int index,String telefone) {
		alunos.get(index).setTelefone(telefone);
	}

	public void setSexoAlunos(int index,String sexo) {
		alunos.get(index).setSexo(sexo);
	}

	public void setNotaAlunos(int index,double nota) {
		alunos.get(index).setNota(nota);
	}
	
	public void removerAlunos(int index) {
		alunos.remove(index);
	}

	public void adicionaAluno(String nome, double nota) {
		adicionaAluno(nome, nota, "", "");
	}

	public void adicionaAluno(String nome, double nota, String sexo) {
		adicionaAluno(nome, nota, sexo, "");
	}

	public void adicionaAluno(String nome, double nota, String sexo, String telefone) {
		Alunos aluno = new Alunos();
		aluno.setNome(nome);
		aluno.setNota(nota);
		aluno.setSexo(sexo);
		aluno.setTelefone(telefone);
		alunos.add(aluno);
	}
	public int quantidadeAluno() {
		return alunos.size();
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getAnoInicial() {
		return anoInicial;
	}

	public void setAnoInicial(int anoInicial) {
		this.anoInicial = anoInicial;
	}
}
