package principal;

import java.io.File;
import java.util.ArrayList;

import model.Match;
import utils.GeradorTabela;
import utils.MediasCalc;
import utils.MontadorExperimento;

public class Main {

	public static void main(String[] args) {
		File diretorio = new File("/home/rubens/Experimentos/Experimentacao/Timevariants/time10ms/");
		
		MontadorExperimento montador = new MontadorExperimento(diretorio);
		GeradorTabela gerador = new GeradorTabela();
		MediasCalc calcMedias = new MediasCalc();
		
		ArrayList<Match> matchs = montador.montar();
		//Aplicar filtros se necessário
		
		//
		
		//gerador.printTableLatex(matchs);
		
		//*************
		//GerarMedia
		//*************
		
		ArrayList<Match> medias = calcMedias.CalcularMedia(matchs);
		gerador.printTableLatex(medias);

	}

}
