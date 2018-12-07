/**
 * 
 */
package classe;

/**
 * @author lucas
 *
 */
public class Bar_Vende_Vebida {
	private Double valor;
	private Bares bares = new Bares();
	private Bebidas bebidas = new Bebidas();
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Bares getBares() {
		return bares;
	}
	public void setBares(Bares bares) {
		this.bares = bares;
	}
	public Bebidas getBebidas() {
		return bebidas;
	}
	public void setBebidas(Bebidas bebidas) {
		this.bebidas = bebidas;
	}
	
}
