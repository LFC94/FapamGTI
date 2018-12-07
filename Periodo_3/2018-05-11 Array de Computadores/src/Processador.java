/**
 * 
 */

/**
 * @author lucas
 *
 */
public enum Processador {

	RYZEN_1950x("RYZEN THREADRIPPER 1950x", 16, 32, 3.4), RYZEN_1920x("RYZEN THREADRIPPER 1920x", 12, 24, 3.5),
	RYZEN_1900x("RYZEN THREADRIPPER 1900x", 8, 16, 3.8), INTEL_I9_7900X("INTEL CORE I9 7900X", 10, 20, 3.3),
	INTEL_I9_7920X("INTEL CORE I9 7920X", 12, 24, 2.9);
	private String modelo;
	private int core;
	private int thread;
	private double clock;

	Processador(String modelo, int core, int thread, double clock) {
		this.modelo = modelo;
		this.core = core;
		this.thread = thread;
		this.clock = clock;

	}

	public String getModelo() {
		return modelo;
	}

	public int getCore() {
		return core;
	}

	public int getThread() {
		return thread;
	}

	public double getClock() {
		return clock;
	}
}
