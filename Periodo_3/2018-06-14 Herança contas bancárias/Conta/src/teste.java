
public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContaPoupanca poupanca = new ContaPoupanca(123,"145");
		poupanca.setTaxa_rendimento(0.10);
		System.out.println(poupanca.tiraExtrato());
		poupanca.deposita(100);
		System.out.println(poupanca.tiraExtrato());
		poupanca.deposita(100);
		System.out.println(poupanca.tiraExtrato());
		poupanca.deposita(100);
		poupanca.deposita(100);
		System.out.println(poupanca.tiraExtrato());
		poupanca.saca(100);
		poupanca.saca(100);
		poupanca.saca(100);
		System.out.println(poupanca.tiraExtrato());
		poupanca.saca(110);
		System.out.println(poupanca.tiraExtrato());
		
	}

}
