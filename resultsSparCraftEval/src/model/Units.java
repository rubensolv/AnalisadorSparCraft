package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Units {

	private ArrayList<String> tipoUnidades  = new ArrayList<>();
	private HashMap<String, String> unitSiglah = new HashMap<>();
	
	public Units() {
		tipoUnidades.add("Protoss_Dragoon");
		tipoUnidades.add("Protoss_Zealot");
		tipoUnidades.add("Protoss_Archon");
		tipoUnidades.add("Terran_Marine");
		tipoUnidades.add("Terran_Vulture");
		tipoUnidades.add("Terran_Siege_Tank_Tank_Mode");
		tipoUnidades.add("Terran_Firebat");
		tipoUnidades.add("Terran_Goliath");
		tipoUnidades.add("Zerg_Zergling");
		tipoUnidades.add("Zerg_Hydralisk");		
		tipoUnidades.add("Zerg_Mutalisk");
		tipoUnidades.add("Zerg_Ultralisk");
		
		unitSiglah.put("Protoss_Dragoon", "Dg");
		unitSiglah.put("Protoss_Zealot", "Zl");
		unitSiglah.put("Protoss_Archon", "Ar");
		unitSiglah.put("Terran_Marine", "Mr");
		unitSiglah.put("Terran_Vulture", "Vl");
		unitSiglah.put("Terran_Siege_Tank_Tank_Mode", "Tk");
		unitSiglah.put("Terran_Firebat", "Fb");
		unitSiglah.put("Terran_Goliath", "Gl");
		unitSiglah.put("Zerg_Zergling", "Zg");
		unitSiglah.put("Zerg_Hydralisk", "Hd");
		unitSiglah.put("Zerg_Mutalisk", "Mt");
		unitSiglah.put("Zerg_Ultralisk", "Ut");
		
	}
	
	public static UnitType getType(String unitNome){
		
		if(unitNome.equals("Zerg_Ultralisk")){
			return UnitType.ULTRALISK;
		}
		if(unitNome.equals("Zerg_Mutalisk")){
			return UnitType.MUTALISK;
		}
		if(unitNome.equals("Zerg_Hydralisk")){
			return UnitType.HYDRALISK;
		}
		if(unitNome.equals("Zerg_Zergling")){
			return UnitType.ZERGLING;
		}
		if(unitNome.equals("Terran_Goliath")){
			return UnitType.GOLIATH;
		}
		if(unitNome.equals("Terran_Firebat")){
			return UnitType.FIREBAT;
		}
		if(unitNome.equals("Terran_Siege_Tank_Tank_Mode")){
			return UnitType.TANK;
		}
		if(unitNome.equals("Terran_Vulture")){
			return UnitType.VULTURE;
		}
		if(unitNome.equals("Terran_Marine")){
			return UnitType.MARINE;
		}
		if(unitNome.equals("Protoss_Dragoon")){
			return UnitType.DRAGOON;
		}
		if(unitNome.equals("Protoss_Zealot")){
			return UnitType.ZEALOT;
		}
		if(unitNome.equals("Protoss_Archon")){
			return UnitType.ARCHON;
		}
		
		return UnitType.DRAGOON;
	}
	
	public static String getNomeByType(UnitType type){
		if(UnitType.ULTRALISK == type){
			return "Zerg_Ultralisk";
		}
		if(UnitType.MUTALISK == type){
			return "Zerg_Mutalisk";
		}
		if(UnitType.HYDRALISK == type){
			return "Zerg_Hydralisk";
		}
		if(UnitType.ZERGLING == type){
			return "Zerg_Zergling";
		}
		if(UnitType.GOLIATH == type){
			return "Terran_Goliath";
		}
		if(UnitType.FIREBAT == type){
			return "Terran_Firebat";
		}
		if(UnitType.TANK == type){
			return "Terran_Siege_Tank_Tank_Mode";
		}
		if(UnitType.VULTURE == type){
			return "Terran_Vulture";
		}
		if(UnitType.MARINE == type){
			return "Terran_Marine";
		}
		if(UnitType.DRAGOON == type){
			return "Protoss_Dragoon";
		}
		if(UnitType.ZEALOT == type){
			return "Protoss_Zealot";
		}
		if(UnitType.ARCHON == type){
			return "Protoss_Archon";
		}
		
		
		return "Protoss_Dragoon";
	}
	
	public ArrayList<String> getNomeUnits(){
		return this.tipoUnidades;
	}

}
