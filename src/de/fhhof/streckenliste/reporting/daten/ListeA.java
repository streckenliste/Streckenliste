package de.fhhof.streckenliste.reporting.daten;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

/**
 * Datenklasse die sämtliche Elemente einer Liste A umfasst.
 * 
 * Achtung: In der V4 vom Datendesign gibt es jJahr als Attribute für jJahr und als Element * 
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public class ListeA {
	/**
	 * Jagdjahr, für das die Liste A geführt wird
	 */
	private String jJahr;
	/**
	 * Meldedatum der Liste; ist es gesetzt dürfen keine Einträge mehr vorgenommen werden
	 */
	private GregorianCalendar abgDatum;
	/**
	 * Ort
	 */
	private String ort;
	/**
	 * Unterschriftsfeld; flexibel für jedem Input; wird derzeit nicht besonders behandelt
	 */
	private Object abgUnterschrift;
	/**
	 * Einträge der Liste A
	 */
	private Vector<AZeile> aZeile;
	/**
	 * Summen aller erlegten Tiere mit Zugehörigkeit zu einer AKlasse
	 */
	private HashMap<AKlasse, Integer> sumErl;
	/**
	 * Summe aller Tiere die Fallwild sind mit Zugehörigkeit zu einer AKlasse
	 */
	private HashMap<AKlasse, Integer> sumFall;
	/**
	 * Gesamtsumme von Fallwild und erlegtem Wild mit Zugehörigkeit zu einer AKlasse
	 * Die Summe wird nicht automatisch gebildet
	 */
	private HashMap<AKlasse, Integer> sumGes;
	
	/**
	 * Basiskonstruktor
	 * 
	 * Es wird nur der Vektor initialisiert
	 * Alle anderen Attribute bleiben unberührt
	 */
	public ListeA() {
		aZeile = new Vector<AZeile>();
	}
	/**
	 * Erweiterter Konstruktor
	 * 
	 * Es wird der Vektor initialisiert und die Werte aus den Parametern übernommen
	 * Alle anderen Attribute bleiben unberührt
	 * 
	 * @param jJahr {@link #jJahr}
	 * @param abgDatum {@link #abgDatum}
	 * @param ort {@link #ort}
	 * @param abgUnterschrift {@link #abgUnterschrift}
	 */
	public ListeA(String jJahr, GregorianCalendar abgDatum, String ort, Object abgUnterschrift) {
		aZeile = new Vector<AZeile>();
		
		this.jJahr = jJahr;
		this.abgDatum = abgDatum;
		this.ort = ort;
		this.abgUnterschrift = abgUnterschrift;
	}
	/**
	 * Erweiterter Konstruktor
	 * 
	 * Es werden alle Attribute anhand der Parameter gesetzt
	 * @param jJahr {@link #jJahr}
	 * @param abgDatum {@link #abgDatum}
	 * @param ort {@link #ort}
	 * @param abgUnterschrift {@link #abgUnterschrift}
	 * @param aZeile {@link #aZeile}
	 * @param sumErl {@link #sumErl}
	 * @param sumFall {@link #sumFall}
	 * @param sumGes {@link #sumGes}
	 */
	public ListeA(String jJahr, GregorianCalendar abgDatum, String ort,
			Object abgUnterschrift, Vector<AZeile> aZeile,
			HashMap<AKlasse, Integer> sumErl,
			HashMap<AKlasse, Integer> sumFall,
			HashMap<AKlasse, Integer> sumGes) {
		this.jJahr = jJahr;
		this.abgDatum = abgDatum;
		this.ort = ort;
		this.abgUnterschrift = abgUnterschrift;
		this.aZeile = aZeile;
		this.sumErl = sumErl;
		this.sumFall = sumFall;
		this.sumGes = sumGes;
	}
	
	/**
	 * Getter für das jJahr
	 * 
	 * Direktes Lesen
	 * @return Jagdjahr der Liste
	 */
	public String getJJahr() {
		return jJahr;
	}
	/**
	 * Setter für jJahr
	 * 
	 * Kann nur geschrieben werden wenn die Liste bisher kein Abgabedatum hat
	 * Direktes Schreiben
	 * @param jJahr Jagdjahr das gesetzt werden soll
	 */
	public void setJJahr(String jJahr) {
		if (abgDatum == null)
			this.jJahr = jJahr;
	}
	
	/**
	 * Getter für abgDatum
	 * 
	 * Direktes Lesen
	 * @return Datum der Meldung der Liste A
	 */
	public GregorianCalendar getAbgDatum() {
		return abgDatum;
	}
	/**
	 * Setter für abgDatum
	 * 
	 * Kann immer geschrieben werden
	 * Direktes Schreiben
	 * @param abgDatum Datum der Abgabe von Liste A (Abschlussmeldung)
	 */
	public void setAbgDatum(GregorianCalendar abgDatum) {
		this.abgDatum = abgDatum;
	}
	
	/**
	 * Getter für Ort
	 * 
	 * Direktes Lesen
	 * @return Örtliche Zugehörigkeit der Liste A
	 */
	public String getOrt() {
		return ort;
	}
	/**
	 * Setter für Ort
	 * 
	 * Kann nur geschrieben werden wenn noch kein Abgabedatum gesetzt ist
	 * Direktes Schreiben
	 * @param ort Örtliche Zugehörigkeit der Liste A
	 */
	public void setOrt(String ort) {
		if (abgDatum == null)
			this.ort = ort;
	}
	
	/**
	 * Getter für abgUnterschrift
	 * 
	 * Direktes Lesen
	 * @return Abgabeunterschrift-Objekt
	 */
	public Object getAbgUnterschrift() {
		return abgUnterschrift;
	}
	/**
	 * Setter für abgUnterschrift
	 * 
	 * Kann nur geschrieben werden wenn noch kein Abgabedatum gesetzt ist
	 * Direktes Schreiben
	 * @param abgUnterschrift Zu setzdes Unterschriftobjekt
	 */
	public void setAbgUnterschrift(Object abgUnterschrift) {
		if (abgDatum == null)
			this.abgUnterschrift = abgUnterschrift;
	}
	
	/**
	 * Getter für aZeile
	 * 
	 * Direktes Lesen
	 * @return Komplette Liste mit allen Einträgen in Liste A
	 */
	public Vector<AZeile> getAZeile() {
		return aZeile;
	}
	/**
	 * Setter für aZeile
	 * 
	 * Kann nur geschrieben werden wenn noch kein abgDatum gesetzt ist
	 * Direktes Schreiben
	 * @param aZeile Vektor mit Einträgen der Liste A
	 */
	public void setAZeile(Vector<AZeile> aZeile) {
		if (abgDatum == null)
			this.aZeile = aZeile;
	}
	
	/**
	 * Getter für sumErl
	 * 
	 * Direktes Lesen
	 * @return Summen erlegter Tiere in Abhängigkeit einer AKlasse
	 */
	public HashMap<AKlasse, Integer> getSumErl() {
		return sumErl;
	}
	/**
	 * Setter für sumErl
	 * 
	 * Kann nur geschrieben werden wenn noch kein abgDatum gesetzt ist
	 * Direktes Schreiben
	 * @param sumErl HashMap mit Summen von erlegten Tieren mit Zugehörigkeit zu einer AKlasse
	 */
	public void setSumErl(HashMap<AKlasse, Integer> sumErl) {
		if (abgDatum == null)
			this.sumErl = sumErl;
	}
	
	/**
	 * Getter für sumFall
	 * 
	 * Direktes Lesen
	 * @return Summe an Fallwidld in Abhängigkeit einer AKlasse
	 */
	public HashMap<AKlasse, Integer> getSumFall() {
		return sumFall;
	}
	/**
	 * Setter für sumFall
	 * 
	 * Kann nur geschrieben werden wenn noch kein abgDatum gesetzt ist
	 * Direktes Schreiben
	 * @param sumFall HashMap mit Summen von Fallwildtieren mit Zugehörigkeit zu einer AKlasse
	 */
	public void setSumFall(HashMap<AKlasse, Integer> sumFall) {
		if (abgDatum == null)
			this.sumFall = sumFall;
	}
	
	/**
	 * Getter für sumGes
	 * 
	 * Direktes Lesen
	 * @return Summe an gefallenen und erlegtem Wildtieren insgesamt 
	 */
	public HashMap<AKlasse, Integer> getSumGes() {
		return sumGes;
	}
	/**
	 * Setter für sumGes
	 * 
	 * Kann nur geschrieben werden wenn noch kein abgDatum gesetzt ist
	 * Direktes Schreiben
	 * @param sumGes HashMap mit Gesamtsummen von Tieren mit Zugehörigkeit zu einer AKlasse
	 */
	public void setSumGes(HashMap<AKlasse, Integer> sumGes) {
		if (abgDatum == null)
			this.sumGes = sumGes;
	}	
}