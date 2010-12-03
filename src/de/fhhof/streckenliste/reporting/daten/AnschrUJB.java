package de.fhhof.streckenliste.reporting.daten;

public class AnschrUJB {
	private String ujbLRA;
	private String ujbSG;
	private String ujbStr;
	private String ujbPLZ;
	private String ujbOrt;
	
	public AnschrUJB() {
	}
	
	public AnschrUJB(String ujbLRA, String ujbSG, String ujbStr, String ujbPLZ,
			String ujbOrt) {
		this.ujbLRA = ujbLRA;
		this.ujbSG = ujbSG;
		this.ujbStr = ujbStr;
		this.ujbPLZ = ujbPLZ;
		this.ujbOrt = ujbOrt;
	}
	
	public String getUjbLRA() {
		return ujbLRA;
	}
	public void setUjbLRA(String ujbLRA) {
		this.ujbLRA = ujbLRA;
	}
	
	public String getUjbSG() {
		return ujbSG;
	}
	public void setUjbSG(String ujbSG) {
		this.ujbSG = ujbSG;
	}
	
	public String getUjbStr() {
		return ujbStr;
	}
	public void setUjbStr(String ujbStr) {
		this.ujbStr = ujbStr;
	}
	
	public String getUjbPLZ() {
		return ujbPLZ;
	}
	public void setUjbPLZ(String ujbPLZ) {
		this.ujbPLZ = ujbPLZ;
	}
	
	public String getUjbOrt() {
		return ujbOrt;
	}
	public void setUjbOrt(String ujbOrt) {
		this.ujbOrt = ujbOrt;
	}
	
	
}
