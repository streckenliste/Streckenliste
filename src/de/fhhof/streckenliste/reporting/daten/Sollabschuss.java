package de.fhhof.streckenliste.reporting.daten;

public class Sollabschuss {
	private AKlasse aKlasse;
	private int pJahre;
	private int jahr;
	private int soll;
	
	public Sollabschuss() {
		this(null, 0, 0);
	}

	public Sollabschuss(AKlasse aKlasse, int soll) {
		this(aKlasse, soll, 0);
	}
	public Sollabschuss(AKlasse aKlasse, int soll, int pJahre) {
		this(aKlasse, soll, pJahre, 0);
	}
	public Sollabschuss(AKlasse aKlasse, int soll, int pJahre, int jahr) {
		this.aKlasse = aKlasse;
		this.soll = soll;
		this.pJahre = pJahre;
		this.jahr = jahr;
	}

	public AKlasse getAKlasse() {
		return aKlasse;
	}
	public void setAKlasse(AKlasse aKlasse) {
		this.aKlasse = aKlasse;
	}

	public int getSoll() {
		return soll;
	}
	public void setSoll(int soll) {
		this.soll = soll;
	}

	public int getPJahre() {
		return pJahre;
	}
	public void setPJahre(int pJahre) {
		this.pJahre = pJahre;
	}

	public int getJahr() {
		return jahr;
	}
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	
}
