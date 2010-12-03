package de.fhhof.streckenliste.reporting.daten;

import java.util.GregorianCalendar;

public class AZeile {
	private GregorianCalendar aDatum;
	private float aGewicht;
	private AWildart aWildart;
	private AKlasse aKlasse;
	private String aBemerk;
	private AEintragArt aEintragArt;
	private GregorianCalendar aMeldedatum;
	private int id;
	
	public AZeile() {
		this(null, 0, null, null, "", null, null, 0);
	}
	
	public AZeile(GregorianCalendar aDatum, float aGewicht, AWildart aWildart,
			AKlasse aKlasse, String aBemerk, AEintragArt aEintragArt,
			GregorianCalendar aMeldedatum) {
		this(aDatum, aGewicht, aWildart, aKlasse, aBemerk, aEintragArt, aMeldedatum, 0);
	}	
	public AZeile(GregorianCalendar aDatum, float aGewicht, AWildart aWildart,
			AKlasse aKlasse, String aBemerk, AEintragArt aEintragArt,
			GregorianCalendar aMeldedatum, int id) {
		this.aDatum = aDatum;
		this.aGewicht = aGewicht;
		this.aWildart = aWildart;
		this.aKlasse = aKlasse;
		this.aBemerk = aBemerk;
		this.aEintragArt = aEintragArt;
		this.aMeldedatum = aMeldedatum;
		this.id = id;
	}

	public GregorianCalendar getaDatum() {
		return aDatum;
	}
	public void setaDatum(GregorianCalendar aDatum) {
		this.aDatum = aDatum;
	}
	
	public float getaGewicht() {
		return aGewicht;
	}
	public void setaGewicht(float aGewicht) {
		this.aGewicht = aGewicht;
	}
	
	public AWildart getaWildart() {
		return aWildart;
	}
	public void setaWildart(AWildart aWildart) {
		this.aWildart = aWildart;
	}
	
	public AKlasse getaKlasse() {
		return aKlasse;
	}
	public void setaKlasse(AKlasse aKlasse) {
		this.aKlasse = aKlasse;
	}
	
	public String getaBemerk() {
		return aBemerk;
	}
	public void setaBemerk(String aBemerk) {
		this.aBemerk = aBemerk;
	}
	
	public AEintragArt getaEintragArt() {
		return aEintragArt;
	}
	public void setaEintragArt(AEintragArt aEintragArt) {
		this.aEintragArt = aEintragArt;
	}
	
	public GregorianCalendar getaMeldedatum() {
		return aMeldedatum;
	}
	public void setaMeldedatum(GregorianCalendar aMeldedatum) {
		this.aMeldedatum = aMeldedatum;
	}
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
}
