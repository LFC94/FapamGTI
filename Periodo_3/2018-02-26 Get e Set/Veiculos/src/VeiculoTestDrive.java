/**
 * @author Lucas
 *
 */
public class VeiculoTestDrive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Veiculo veiculo1 = new Veiculo("Volks", "Fox", 5, 40);
		veiculo1.setCor("Branco");

		Veiculo veiculo2 = new Veiculo("GM", "Spin", 7, 60);
		veiculo2.setCor("Azul");

		veiculo2.setQtdLitosAbastecido(100);

	}

}
