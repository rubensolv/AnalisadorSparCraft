package model;

import java.util.HashMap;

public class Estado {
	
	private String Nomestate;
	private Integer qtdMatches;
	private  HashMap<UnitType, Integer> unidades;

	public Estado() {
		// TODO Auto-generated constructor stub
		unidades = new HashMap<>();
	}

	public String getNomestate() {
		return Nomestate;
	}

	public void setNomestate(String nomestate) {
		Nomestate = nomestate;
	}

	public Integer getQtdMatches() {
		return qtdMatches;
	}

	public void setQtdMatches(Integer qtdMatches) {
		this.qtdMatches = qtdMatches;
	}

	public HashMap<UnitType, Integer> getUnidades() {
		return unidades;
	}

	public void setUnidades(HashMap<UnitType, Integer> unidades) {
		this.unidades = unidades;
	}
	
	public void addUnidade(UnitType unidade, Integer quant){
		this.unidades.put(unidade, quant);
	}

	public static Estado criarEstado(String linha){
		
		Estado estado = new Estado();
		String dados[] = linha.split(" ");
		estado.setNomestate(dados[1]);
		estado.setQtdMatches(Integer.valueOf(dados[2]));
		
		for(String unit : UnitType.getNomeUnits()){
			if(linha.contains(unit)){
				int idBegin = linha.indexOf(unit) + unit.length();
				int idEnd = idBegin + 3;
				if(idEnd > linha.length()){
					idEnd = linha.length();
				}
				estado.addUnidade(UnitType.getType(unit), Integer.valueOf(linha.substring( idBegin   , idEnd).trim() ) );
			}
		}
		
		return estado;
	}
	
	public void print(){
		System.out.println(Nomestate+" "+qtdMatches);
		for(UnitType tipo : unidades.keySet()){
			System.out.println(UnitType.getNomeByType(tipo)+" "+unidades.get(tipo));
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nomestate == null) ? 0 : Nomestate.hashCode());
		result = prime * result + ((qtdMatches == null) ? 0 : qtdMatches.hashCode());
		result = prime * result + ((unidades == null) ? 0 : unidades.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (Nomestate == null) {
			if (other.Nomestate != null)
				return false;
		} else if (!Nomestate.equals(other.Nomestate))
			return false;
		if (qtdMatches == null) {
			if (other.qtdMatches != null)
				return false;
		} else if (!qtdMatches.equals(other.qtdMatches))
			return false;
		if (unidades == null) {
			if (other.unidades != null)
				return false;
		} else if (!unidades.equals(other.unidades))
			return false;
		return true;
	}
	
	

}
