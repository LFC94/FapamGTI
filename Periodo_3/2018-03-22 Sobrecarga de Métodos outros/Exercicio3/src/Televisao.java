/**
 * 
 */

/**
 * @author lucas
 *
 */
public class Televisao {

	private int quantidadeCanais, canalAtual, volumeAtual;
	private boolean ligada;
	
	public Televisao(int quantidadeCanais) {
		this.quantidadeCanais = quantidadeCanais;
		canalAtual = 1;
		volumeAtual = 0;
		ligada = false;
	}

	public boolean ligar() {		
		if(ligada)
			return false;
		
		ligada = true;
		return true;
	}

	public boolean desligar() {		
		if(!ligada)
			return false;
		
		ligada = false;
		return true;
	}
	
	public boolean estaLigada() {
		return ligada;
	}
	
	public boolean aumentarVolume() {
		if (volumeAtual == 100)
			return false;

		volumeAtual++;
		return true;
	}

	public boolean diminuirVolume() {
		if (volumeAtual == 0)
			return false;

		volumeAtual--;
		return true;
	}
	
	public void ProximoCanal() {
		canalAtual = (canalAtual % quantidadeCanais)+1;	
	}
	
	public void canalAnteriro() {
		if (canalAtual == 1)
			canalAtual = quantidadeCanais;
		else
			canalAtual--;		
	}
	
	public boolean selecionarCanal(int canal) {
		if (canal < 0 || canal > quantidadeCanais)
			return false;
		
		canalAtual = canal;			
		return true;
	}
	
	public int getQuantidadeCanais() {
		return quantidadeCanais;
	}

	public int getCanalAtual() {
		return canalAtual;
	}

	public int getVolumeAtual() {
		return volumeAtual;
	}

	
	
	
}
