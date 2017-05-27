package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

import model.Estado;
import model.Match;

public class MediasCalc {

	public MediasCalc() {

	}

	public ArrayList<Match> CalcularMedia(ArrayList<Match> mats) {

		ArrayList<Match> medias = new ArrayList<>();
		
		HashMap<Match, ArrayList<Match>> grupo = new HashMap<>();
		
		boolean encontrou;
		for (Match match : mats) {
			encontrou = false;
			
			for(Match m : grupo.keySet()){
				if(playersIguais(m, match)){
					grupo.get(m).add(match);
					encontrou = true;
				}
			}
			
			if(!encontrou){
				ArrayList<Match> mTemp = new ArrayList<>();
				mTemp.add(match);
				grupo.put(match, mTemp);
			}
		}
		
		medias = calcularMediaGrupo(grupo);

		return medias;
	}
	
	protected ArrayList<Match> calcularMediaGrupo(HashMap<Match, ArrayList<Match>> grupo){
		ArrayList<Match> med = new ArrayList<>();
		for(Match key : grupo.keySet()){
			Match novoM = new Match();
			novoM.setP1(key.getP1());
			novoM.setP2(key.getP2());
			novoM.setState(new Estado());
			int qtdResult = 0;
			for(Match m2 : grupo.get(key)){
				qtdResult++;
				novoM.setResult(novoM.getResult().add(m2.getResult()));
			}
			novoM.setResult(novoM.getResult().divide(new BigDecimal(qtdResult), RoundingMode.HALF_UP));
			med.add(novoM);
		}
		
		return med;
	}
	
	protected Boolean playersIguais(Match m1, Match m2){
		if(m1.getP1().getAlgoritmo().equals(m2.getP1().getAlgoritmo()) &&
				m1.getP2().getAlgoritmo().equals(m2.getP2().getAlgoritmo())){
			return true;
		}else{
			return false;
		}
	}

}
