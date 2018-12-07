import java.util.Date;

public class Feminino extends PessoaIMC {

	public Feminino(String nome, Date dataNascimento, double peso, double altura) throws Exception {
		super(nome, dataNascimento, peso, altura);
	}
	public Feminino(String nome, String dataNascimento, double peso, double altura) throws Exception {
		super(nome, dataNascimento, peso, altura);
	}

	@Override
	String resultIMC() {
		double imc = calculaIMC();
		if (imc < 19)
			return "Abaixo do peso ideal";
		else if (imc < 25.8)
			return "Peso ideal";
		else
			return "Acima do peso ideal";
	}

}
