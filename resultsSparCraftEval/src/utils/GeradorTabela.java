package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import model.Algoritmo;
import model.Estado;
import model.Match;
import model.UnitType;

public class GeradorTabela {

	public GeradorTabela() {
	}

	public void printTableLatex(ArrayList<Match> matchs) {
		printTop();

		HashMap<Estado, ArrayList<Match>> matches = organizarMatchsbyState(matchs);
		for (Estado e : matches.keySet()) {
			printMatches(matches.get(e), e);
		}

		printBottom();
	}

	protected void printMatches(ArrayList<Match> matchs, Estado e) {
		ArrayList<Algoritmo> algs = getAlgoritmos(matchs);

		System.out.print("\\begin{tabular}{| l ");
		for (Algoritmo algoritmo : algs) {
			System.out.print(" r ");

		}
		System.out.println(" | }");
		System.out.println("\\hline");
		System.out.print("\\multicolumn{" + (algs.size() + 1) + "}{|c|}{");
		if (e.getUnidades().size() == 0) {
			System.out.print("Average");
		} else {
			for (UnitType unt : e.getUnidades().keySet()) {
				System.out.print(UnitType.getSiglaByName(UnitType.getNomeByType(unt)));
				System.out.print("$(" + e.getUnidades().get(unt) + ")$");
			}
		}
		System.out.println("} \\\\");
		System.out.println("\\hline");
		for (Algoritmo algoritmo : algs) {
			System.out.print("\t & \t");
			System.out.print(algoritmo.getSigla());
		}
		System.out.println("\\\\");

		for (Algoritmo alg : algs) {
			System.out.print(alg.getSigla());
			for (Algoritmo alg2 : algs) {
				// System.out.println(alg.getNome() +" vs "+ alg2.getNome());
				System.out.print("\t & \t" + convertValue(getResultMatch(matchs, alg, alg2)));
			}

			System.out.println("\\\\");
		}
		System.out.println("\\hline");
		System.out.println("\\end{tabular}");
	}

	protected String convertValue(BigDecimal value) {
		if (value == null) {
			return " - ";
		}
		return value.setScale(2, RoundingMode.FLOOR).toString();
	}

	protected BigDecimal getResultMatch(ArrayList<Match> matchs, Algoritmo p1, Algoritmo p2) {
		BigDecimal r = null;

		for (Match match : matchs) {
			if (match.getP1().getAlgoritmo().equals(p1) && match.getP2().getAlgoritmo().equals(p2)) {
				r = match.getResult();
			}
		}
		if (r == null) {
			for (Match match : matchs) {
				if (match.getP1().getAlgoritmo().equals(p2) && match.getP2().getAlgoritmo().equals(p1)) {
					r = match.resultContra();
				}
			}
		}

		return r;
	}

	protected ArrayList<Algoritmo> getAlgoritmos(ArrayList<Match> matchs) {
		HashSet<Algoritmo> algs = new HashSet<>();
		for (Match m : matchs) {
			algs.add(m.getP1().getAlgoritmo());
			algs.add(m.getP2().getAlgoritmo());
		}

		ArrayList<Algoritmo> ret = new ArrayList<>(algs);
		Collections.sort(ret);
		return ret;
	}

	protected HashMap<Estado, ArrayList<Match>> organizarMatchsbyState(ArrayList<Match> matchs) {
		// organizar por estado
		HashMap<Estado, ArrayList<Match>> matchesOrganizados = new HashMap<>();
		for (Match m : matchs) {
			if (matchesOrganizados.containsKey(m.getState())) {
				matchesOrganizados.get(m.getState()).add(m);
			} else {
				ArrayList<Match> tempM = new ArrayList<>();
				tempM.add(m);
				matchesOrganizados.put(m.getState(), tempM);
			}
		}

		return matchesOrganizados;
	}

	protected void printTop() {
		System.out.println("\\begin{table*}[t]");
		System.out.println("\\centering");
		System.out.println("\\scriptsize");
		System.out.println("\\setlength{\\tabcolsep}{3.0 pt}");
	}

	protected void printBottom() {
		System.out.println("\\label{tab:}");
		System.out.println("\\caption{}");
		System.out.println("\\end{table*}");
	}
}
