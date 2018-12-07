/**
 * 
 */
package classe;

/**
 * @author lucas
 *
 */
public class Bebidas {
	private int id;
	private String nome, info;
	private double volume_emb;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info.toUpperCase();
	}
	public double getVolume_emb() {
		return volume_emb;
	}
	public void setVolume_emb(double volume_emb) {
		this.volume_emb = volume_emb;
	}
	
	
}
