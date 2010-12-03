package de.fhhof.streckenliste.reporting.daten;

public enum Verwert {
	weitergabe(1), zerwirk(2), erzeugnis(3);
	
	private int value;
	
	private Verwert(int verwert) {
		value = verwert;
	}
	
	public static Verwert getVerwertByID(int ID) {
		switch (ID) {
		case 1: return Verwert.weitergabe;
		case 2: return Verwert.zerwirk;
		case 3: return Verwert.erzeugnis;
		default: return null;
		}
	}
	
	public int getValue() {
		return value;
	}
}
