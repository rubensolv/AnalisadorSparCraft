package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

import model.Estado;
import model.Match;
import model.Player;

public class MontadorExperimento {

	private File diretorio;

	public MontadorExperimento(File Diretorio) {
		this.diretorio = Diretorio;
	}

	public ArrayList<Match> montar() {

		// busco pelos arquivos de configuração
		ArrayList<String> configuracoes = obtemConfigs();
		HashMap<String, String> data = associarConfig(configuracoes);

		ArrayList<Match> matches = applyMatches(data);

		return matches;
	}

	private ArrayList<Match> applyMatches(HashMap<String, String> data) {
		ArrayList<Match> matches = new ArrayList<>();

		for (String conf : data.keySet()) {
			Match match = new Match();
			lerArqConfig(match, conf);
			lerArqResult(match, data.get(conf));
			//match.print();
			matches.add(match);
		}

		return matches;
	}
	
	private void lerArqResult(Match match, String conf){

		String linha;
		try {
			FileReader arq = new FileReader(conf);
			BufferedReader learArq = new BufferedReader(arq);

			linha = learArq.readLine();

			while (linha != null) {
				
				match.setResult(new BigDecimal(linha.trim()).setScale(2, RoundingMode.HALF_UP) );

				linha = learArq.readLine();
			}
			arq.close();

		} catch (Exception e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			System.out.println(e.toString());
		}
	}
	
	private void lerArqConfig(Match match, String conf){
		
		String linha;
		try {
			FileReader arq = new FileReader(conf);
			BufferedReader learArq = new BufferedReader(arq);

			linha = learArq.readLine();

			while (linha != null) {
				
				if(linha.contains("Player 0")){
					Player p = Player.criarPlayer(linha);
					match.setP1(p);
				}
				if(linha.contains("Player 1")){
					Player p = Player.criarPlayer(linha);
					match.setP2(p);
				}
				
				if(linha.contains("State")){
					//criar o estado
					Estado e = Estado.criarEstado(linha);
					match.setState(e);
				}

				linha = learArq.readLine();
			}
			arq.close();

		} catch (Exception e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage() + " "+ conf);
			System.out.println(e.toString());
		}
	}

	private HashMap<String, String> associarConfig(ArrayList<String> configs) {
		HashMap<String, String> data = new HashMap<>();
		for (String conf : configs) {
			String res = conf;
			res = res.replace("_config.txt", "");
			res = res + "_results_summary.txt";
			data.put(conf, res);
		}
		return data;
	}

	private ArrayList<String> obtemConfigs() {
		ArrayList<String> lista = new ArrayList<>();

		BuscadorArquivos.buscarParcial(diretorio, "_config.txt", lista);
		
		//String temp = lista.get(1);
		//lista.clear();
		//lista.add(temp);

		return lista;
	}

}
