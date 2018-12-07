import java.util.Date;

public abstract class PessoaIMC extends Pessoa {
	private double peso, altura;

	public PessoaIMC(String nome, Date dataNascimento, double peso, double altura) throws Exception {
		super(nome, dataNascimento);
		setAltura(altura);
		setPeso(peso);
	}

	public PessoaIMC(String nome, String dataNascimento, double peso, double altura) throws Exception {
		super(nome, dataNascimento);
		setAltura(altura);
		setPeso(peso);
	}

	private void setPeso(double peso) throws Exception {
		if(peso <=0) {
			throw new Exception("Peso não informado ou informada zerada");
		}
		
		this.peso = peso;
	}

	private void setAltura(double altura) throws Exception {
		if(altura <=0) {
			throw new Exception("Altura não informado ou informada zerada");
		}
		
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

	public double calculaIMC() {
		return peso / (altura * altura);
	}

	abstract String resultIMC();

	@Override
	public String toString() {
		return super.toString() + "\n Peso: " + getPeso() + "\n Altura: " + getAltura()+"\n IMC: "+calculaIMC()+" "+resultIMC();
	}

}
