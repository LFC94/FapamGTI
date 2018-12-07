import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Teste {
	static BufferedReader reader;
	static ArrayList<String> arq;
	static ArrayList<Pessoa> pessoas;
	static boolean aberto = false;
	static Scanner tecla = new Scanner(System.in);
	static int idbusca;
	static String nomeArquivo = "dados.txt";

	public static void main(String[] args) {

		String c = "";
		do {
			String mes = "1| BUSCAR\n";
			mes += "2| CADASTRA\n";
			mes += "3| MOSTRAR TODOS\n";
			mes += "0| SAIR\n";
			mes += strN('*', 100);
			mes += "\nInforma uma opção: ";
			c = teclado(mes);
			c = (c == null ? "0" : c);
			try {

				switch (c) {
				case "1":
					abrirArq();
					menuBuscar();
					break;
				case "2":
					abrirArq();
					cadastra();
					break;
				case "3":
					abrirArq();
					mes = "";
					String sempess = "Não Possui ninguem cadastrado";
					for (Pessoa p : pessoas) {
						sempess = "";
						mes += p + "\n";
					}
					menssagem(mes + sempess);
					break;

				}

			} catch (Exception e) {
				menssagem(e.getMessage());
				c = "";
			}
		} while (!c.equalsIgnoreCase("0"));

	}

	public static void menuBuscar() {
		do {
			try {
				idbusca = -1;
				String bus = teclado("Informa o CNPJ/CPF ou o Nome: ");
				if (bus == null) {
					break;
				}

				idbusca = buscar(bus);
				if (idbusca < 0)
					throw new Exception("Não foi localizado nenhuma pessoa");

				break;
			} catch (Exception e) {
				menssagem(e.getMessage());
			}
		} while (true);
		if (idbusca < 0) {
			return;
		}
		do {
			try {
				String mess = "Localizado " + pessoas.get(idbusca).toString();
				int res = JOptionPane.showConfirmDialog(null, mess + "\nDeseja alterar Nome ?", "",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					mess = "\nInforma o novo nome:";
					String nome = teclado(mess);
					if (nome != null)
						pessoas.get(idbusca).setNome(nome);

				}
				if (pessoas.get(idbusca) instanceof PessoaFisica) {
					res = JOptionPane.showConfirmDialog(null, mess + "\nDeseja alterar Estado Civil?", "",
							JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {
						mess = "Informa o novo Estado Civil:";

						String estadociv = teclado(mess);
						if (estadociv != null)
							((PessoaFisica) pessoas.get(idbusca)).setEstadoCivil(estadociv);

					}
				}
				//Arquivos.deletarArquivo(nomeArquivo);

				Arquivos.gravarArquivo(nomeArquivo, pessoas.toArray(new GravarArquivo[pessoas.size()]));
				break;
			} catch (Exception e) {
				menssagem(e.getMessage());
			}

		} while (true);

	}

	public static void cadastra() {
		do {
			try {
				String cgc = teclado("Informa o CPF/CNPJ:");
				String nome = teclado("Informa o Nome:");
				if (cgc.trim().replace(".", "").replace("-", "").length() == 11) {
					String sexo = teclado("Informa o sexo (M/F):");

					String estadoCivil = teclado("Informa o Estado civil:");
					pessoas.add(new PessoaFisica(nome, cgc, sexo, estadoCivil));
				} else {
					pessoas.add(new PessoaJuridica(nome, cgc));
				}
				
				Arquivos.gravarArquivoLinha(nomeArquivo, pessoas.get(pessoas.size()-1).gravaPessoa());

				break;
			} catch (Exception e) {
				menssagem(e.getMessage());
			}
		} while (true);
	}

	public static void abrirArq() throws Exception {
		pessoas = new ArrayList<>();
		arq = Arquivos.lerArquivos(nomeArquivo);
		for (int i = 0; i < arq.size(); i++) {
			String[] a = arq.get(i).split(";");
			if (a[0].equalsIgnoreCase("pf"))
				pessoas.add(new PessoaFisica(a[2], a[1], a[3], a[4]));
			else
				pessoas.add(new PessoaJuridica(a[2], a[1]));
		}
	}

	public static String strN(char c, int n) {
		String aux = "";
		for (int i = 0; i < n; i++)
			aux += c;
		return aux;
	}

	public static int buscar(String busca) throws Exception {
		int ret = -1;
		if (busca.trim().isEmpty()) {
			throw new Exception("Busca não informada");
		}
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getNome().contains(busca.trim().toUpperCase())
					|| pessoas.get(i).getCpfcnpj().equals(busca)) {
				if (ret > 0) {
					throw new Exception("Foi encontrado mais de uma busca seja mais especifico");
				}
				ret = i;
			}
		}

		return ret;
	}

	public static String teclado(String mess) {
		String ret = JOptionPane.showInputDialog(mess);
		return ret;
	}

	public static void menssagem(String mess) {
		JOptionPane.showMessageDialog(null, mess);
	}
}
