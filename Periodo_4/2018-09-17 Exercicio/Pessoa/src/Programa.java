import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite o numero de pessoas:");
		int n_pessoas = scanner.nextInt();
		int i = 0; 
		
		PessoaIMC[] pessoaIMC = new PessoaIMC[n_pessoas];
		
		do {
			try {
				System.out.print("Inserir Feminino (f) ou Masculino(m)? ");
				String tipo = scanner.nextLine();
				if(!tipo.equalsIgnoreCase("F")&&!tipo.equalsIgnoreCase("M"))
					throw new Exception("--- Opcao Invalida!!!");
				
				System.out.print("Digite o nome:");
				String nome = scanner.nextLine();
				
				System.out.print("Digite a data de nascimento(DD/MM/AAAA):");
				String data = scanner.nextLine();
				
				System.out.print("Digite o peso:"); 
				Double peso = convertDou(scanner.nextLine());
				
				System.out.print("Digite a altura (em metros)"); 
				Double altura = convertDou(scanner.nextLine());
				
				if(tipo.equalsIgnoreCase("F"))
					pessoaIMC[i] = new Feminino(nome, data, peso, altura);
				else
					pessoaIMC[i] = new Masculino(nome, data, peso, altura);
				
				System.out.println("--------");
				i++;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}while(i < n_pessoas);
		for(int j = 0; j <n_pessoas; j++) {
			System.out.println("--------");
			System.out.println(pessoaIMC[j].toString());
		}
	}
	
	
	public static double convertDou(String con) throws Exception {
		try {
			return Double.parseDouble(con);
		}catch (Exception e) {
			throw new Exception("--- Deve ser informado um numero real!!!");
		}
	}

}
