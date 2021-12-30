package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {
	public static void main(String[] args) {

		/*
		 * Na contagem de votos de uma eleição, são gerados vários registros de votação
		 * contendo o nome do candidato e a quantidade de votos (formato .csv) que ele
		 * obteve em uma urna de votação. Você deve fazer um programa para ler os
		 * registros de votação a partir de um arquivo, e daí gerar um relatório
		 * consolidado com os totais de cada candidato.
		 * 
		 */
		String path = System.getProperty("user.dir") + "//src//in.txt";
		Map<String, Integer>  votingMachines = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			 String line =br.readLine();
			 
			 while(line!=null) {
				 String fields[]= line.split(",");
				 String name=fields[0];
				 Integer countVotes=Integer.parseInt(fields[1]);
				 
				 if(votingMachines.containsKey(name)) {
					 int totalVotes =votingMachines.get(name);
					 votingMachines.put(name, totalVotes+countVotes);
				 }else {
					 votingMachines.put(name, countVotes);
				 }
				
				 line=br.readLine();
			 }
			 
			 for(String key : votingMachines.keySet()) {
				 System.out.println(key+": " +votingMachines.get(key));
			 }
		} catch (IOException e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

}
