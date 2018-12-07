import java.util.Date;

public class Masculino extends PessoaIMC {

	public Masculino(String nome, Date dataNascimento, double peso, double altura) throws Exception {
		super(nome, dataNascimento, peso, altura);
	}

	public Masculino(String nome, String dataNascimento, double peso, double altura) throws Exception {
		super(nome, dataNascimento, peso, altura);
	}

	@Override
	public String resultIMC() {
		double imc = calculaIMC();
		if (imc < 20.7)
			return "Abaixo do peso ideal";
		else if (imc < 26.4)
			return "Peso ideal";
		else
			return "Acima do peso ideal";
	}

}
