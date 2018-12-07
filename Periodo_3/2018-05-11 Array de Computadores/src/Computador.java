/**
 * @author lucas
 *
 */
public class Computador {
	private double armazenamentoHD, memoriaRAM;
	private String placa_mae;
	private final String mac_rede;
	private boolean ligado;
	private Processador processador;
	static double totalMemoria = 0;

	public Computador(double armazenamentoHD, double memoriaRAM, String placa_mae, String mac_rede,
			Processador processador) {
		this.armazenamentoHD = armazenamentoHD;
		this.memoriaRAM = memoriaRAM;
		this.placa_mae = placa_mae;
		this.mac_rede = mac_rede;
		this.ligado = false;
		this.processador = processador;
		totalMemoria += memoriaRAM;
	}

	public double getArmazenamentoHD() {
		return armazenamentoHD;
	}

	public void setArmazenamentoHD(double armazenamentoHD) {
		this.armazenamentoHD = armazenamentoHD;
	}

	public double getMemoriaRAM() {
		return memoriaRAM;
	}

	public void setMemoriaRAM(double memoriaRAM) {
		this.memoriaRAM = memoriaRAM;
	}

	public String getPlaca_mae() {
		return placa_mae;
	}

	public void setPlaca_mae(String placa_mae) {
		this.placa_mae = placa_mae;
	}

	public boolean estadoComputador() {
		return ligado;
	}

	public void ligar() {
		ligado = true;
	}

	public void desligar() {
		ligado = false;
	}

	public Processador getProcessador() {
		return processador;
	}

	public void setProcessador(Processador processador) {
		this.processador = processador;
	}

	public String getMac_rede() {
		return mac_rede;
	}

	public String toString() {
		return "Computador com a placa mae " + getPlaca_mae() + ", processador " + processador.getModelo() + " com ("
				+ processador.getCore() + " cores e " + processador.getThread() + " thread com clock de "
				+ processador.getClock() + " GHz), memoria Ram de " + getMemoriaRAM() + ", Hd de " + getArmazenamentoHD()
				+ ". Ele está " + (ligado ? "Ligado" : "Desligado");
	}
}
