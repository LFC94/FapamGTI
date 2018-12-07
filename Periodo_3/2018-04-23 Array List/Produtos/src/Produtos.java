/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Produtos {
	static int proximoCodigo;
	
	private int codigo;
	private String descricao;
	private double valor;
	public Produtos() {
		codigo = ++proximoCodigo;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase().trim();
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
