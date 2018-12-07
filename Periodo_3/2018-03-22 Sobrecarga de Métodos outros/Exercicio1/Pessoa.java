/**
 * @author Lucas
 *
 */
public class Pessoa{
	
	private String nome, sexo;
	private double peso, altura;
	
	public Pessoa(){
		
	}
	
	public Pessoa(String nome, String sexo, double peso, double altura){
		setAltura(altura);
		setNome(nome);
		setPeso(peso);
		setSexo(sexo);
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getSexo(){
		return sexo;
	}
	
	public double getPeso(){
		return peso;
	}
	
	public double getAltura(){
		return altura;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	
	public void setPeso(double peso){
		this.peso = peso;
	}
	
	public void setAltura(double altura){
		this.altura = altura;
	}
	
	public double calculaIMC(){
		return getPeso()/(getAltura()*getAltura());
	}
	
}