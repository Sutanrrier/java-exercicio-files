package br.com.sutanrrier.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		String path = "C:\\teste\\itens.csv";
		
		//Criar um novo diretório
		File diretorio = new File("C:\\teste\\out");
		diretorio.mkdir();
		
		//Ler arquivo itens.csv
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			File out = new File(diretorio, "summary.csv");
			
			String linha = br.readLine();
			while(linha != null) {
				//Gerando arquivo summary.csv
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(out.getPath(), true))){
					String[] linhas = linha.split(",");
					bw.write(linhas[0] + ", " + (Double.parseDouble(linhas[1]) * Double.parseDouble(linhas[2])));
					bw.newLine();
				}
				linha = br.readLine();
			}
			System.out.println("Criação de summary.csv feita com sucesso!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
