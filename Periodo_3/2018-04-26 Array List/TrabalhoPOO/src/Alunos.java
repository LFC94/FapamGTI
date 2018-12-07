import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lucas
 *
 */
public class Alunos {

	private String nome, sexo, telefone;
	private double nota;
	private Date dataNascimento;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyyy");
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
	
		try {
			this.dataNascimento = dateFormat.parse(dataNascimento);
		} catch (Exception e) {
		}
	}
	
	
}
