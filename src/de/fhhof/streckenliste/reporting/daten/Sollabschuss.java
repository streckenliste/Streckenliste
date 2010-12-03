package de.fhhof.streckenliste.reporting.daten;

public class Sollabschuss {
	private AKlasse AKlasse;
	private int soll;
	
	public Sollabschuss() {
		
	}

	public Sollabschuss(AKlasse AKlasse, int soll) {
		this.AKlasse = AKlasse;
		this.soll = soll;
	}

	public AKlasse getAKlasse() {
		return AKlasse;
	}
	public void setAKlasse(AKlasse AKlasse) {
		this.AKlasse = AKlasse;
	}

	public int getSoll() {
		return soll;
	}
	public void setSoll(int soll) {
		this.soll = soll;
	}
}
