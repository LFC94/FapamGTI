import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivos {

	public static ArrayList<String> lerArquivos(String nomeArquivo) throws Exception {
		if (nomeArquivo.trim().isEmpty()) {
			throw new Exception("Não foi selecionado nenhum arquivo.");
		}

		FileReader arq = null;
		try {
			arq = new FileReader(nomeArquivo);
		} catch (FileNotFoundException e) {
			throw new Exception("Arquivo informa não pode ser aberto.");
		}

		BufferedReader reader = new BufferedReader(arq);
		String ler = null;

		try {
			ler = reader.readLine();
			if (ler == null)
				throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Arquivo esta vazio");
		}

		ArrayList<String> ret = new ArrayList<>();
		ret.add(ler);
		while ((ler = reader.readLine()) != null) {
			ret.add(ler);
		}

		reader.close();

		return ret;
	}

	public static int linhasArquivo(BufferedReader reader) {
		int lines = 0;
		try {
			while (reader.readLine() != null)
				lines++;
		} catch (IOException e) {
		}
		return lines;

	}

	public static void deletarArquivo(String nomeArquivo) {
		(new File(nomeArquivo)).delete();
	}

	public static void gravarArquivo(String nomeArquivo, GravarArquivo[] objects) throws Exception {

		BufferedWriter buffWrite = null;
		try {
			buffWrite = new BufferedWriter(new FileWriter(nomeArquivo));

			for (GravarArquivo d : objects) {
				buffWrite.write(d.gravaPessoa());
				buffWrite.newLine();
			}
		} catch (Exception e) {
			throw new Exception("Erro ao gravar arquivo");
		}
		try {
			buffWrite.close();
		} catch (IOException e) {
		}
	}
	public static void gravarArquivoLinha(String nomeArquivo, String objects) throws Exception {

		BufferedWriter buffWrite = null;
		try {
			buffWrite = new BufferedWriter(new FileWriter(nomeArquivo,true));

			buffWrite.write(objects);
			
		} catch (Exception e) {
			throw new Exception("Erro ao gravar arquivo");
		}
		try {
			buffWrite.close();
		} catch (IOException e) {
		}
	}

}
