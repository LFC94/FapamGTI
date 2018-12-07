import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
	private String nome;
	private Date dataNascimento;
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public Pessoa(String nome, Date dataNascimento) throws Exception {
		setNome(nome);
		setDataNascimento(dataNascimento);
	}

	public Pessoa(String nome, String dataNascimento) throws Exception {
		setNome(nome);
		setDataNascimento(dataNascimento);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String DataNascimento() {

		return format.format(dataNascimento);
	}

	public void setDataNascimento(Date dataNascimento) throws Exception {

		if (dataNascimento.getTime() > (new Date()).getTime()) {
			throw new Exception("Data de nacimento maior que a data atual");
		}

		this.dataNascimento = dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) throws Exception {
		try {
			setDataNascimento(format.parse(dataNascimento));
		} catch (ParseException e) {
			throw new Exception("Formato da data invalida.");
		}
	}

	@Override
	public String toString() {

		return "Nome: " + getNome() + "\n Data de Nascimento:" + DataNascimento();
	}

}
