package de.fhhof.streckenliste.reporting.daten;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

/**
 * Datenklasse die s�mtliche Elemente einer Liste A umfasst.
 * 
 * Achtung: In der V4 vom Datendesign gibt es jJahr als Attribute f�r jJahr und als Element * 
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public class ListeA {
	/**
	 * Jagdjahr, f�r das die Liste A gef�hrt wird
	 */
	private String jJahr;
	/**
	 * Meldedatum der Liste; ist es gesetzt d�rfen keine Eintr�ge mehr vorgenommen werden
	 */
	private GregorianCalendar abgDatum;
	/**
	 * Ort
	 */
	private String ort;
	/**
	 * Unterschriftsfeld; flexibel f�r jedem Input; wird derzeit nicht besonders behandelt
	 */
	private Object abgUnterschrift;
	/**
	 * Eintr�ge der Liste A
	 */
	private Vector<AZeile> aZeile;
	/**
	 * Summen aller erlegten Tiere mit Zugeh�rigkeit zu einer AKlasse
	 */
	private HashMap<AKlasse, Integer> sumErl;
	/**
	 * Summe aller Tiere die Fallwild sind mit Zugeh�rigkeit zu einer AKlasse
	 */
	private HashMap<AKlasse, Integer> sumFall;
	/**
	 * Gesamtsumme von Fallwild und erlegtem Wild mit Zugeh�rigkeit zu einer AKlasse
	 * Die Summe wird nicht automatisch gebildet
	 */
	private HashMap<AKlasse, Integer> sumGes;
	
	private boolean inSecureMode = false;
	
	/**
	 * Basiskonstruktor
	 * 
	 * Es wird nur der Vektor initialisiert
	 * Alle anderen Attribute bleiben unber�hrt
	 */
	public ListeA() {
		aZeile = new Vector<AZeile>();
	}
	/**
	 * Erweiterter Konstruktor
	 * 
	 * Es wird der Vektor initialisiert und die Werte aus den Parametern �bernommen
	 * Alle anderen Attribute bleiben unber�hrt
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
	 * Getter f�r das jJahr
	 * 
	 * Direktes Lesen
	 * @return Jagdjahr der Liste
	 */
	public String getJJahr() {
		return jJahr;
	}
	/**
	 * Setter f�r jJahr
	 * 
	 * Kann nur geschrieben werden wenn die Liste bisher kein Abgabedatum hat
	 * Direktes Schreiben
	 * @param jJahr Jagdjahr das gesetzt werden soll
	 */
	public void setJJahr(String jJahr) {
		if (abgDatum == null || !inSecureMode)
			this.jJahr = jJahr;
	}
	
	/**
	 * Getter f�r abgDatum
	 * 
	 * Direktes Lesen
	 * @return Datum der Meldung der Liste A
	 */
	public GregorianCalendar getAbgDatum() {
		return abgDatum;
	}
	/**
	 * Setter f�r abgDatum
	 * 
	 * Kann immer geschrieben werden
	 * Direktes Schreiben
	 * @param abgDatum Datum der Abgabe von Liste A (Abschlussmeldung)
	 */
	public void setAbgDatum(GregorianCalendar abgDatum) {
		this.abgDatum = abgDatum;
	}
	
	/**
	 * Getter f�r Ort
	 * 
	 * Direktes Lesen
	 * @return �rtliche Zugeh�rigkeit der Liste A
	 */
	public String getOrt() {
		return ort;
	}
	/**
	 * Setter f�r Ort
	 * 
	 * Kann nur geschrieben werden wenn noch kein Abgabedatum gesetzt ist
	 * Direktes Schreiben
	 * @param ort �rtliche Zugeh�rigkeit der Liste A
	 */
	public void setOrt(String ort) {
		if (abgDatum == null || !inSecureMode)
			this.ort = ort;
	}
	
	/**
	 * Getter f�r abgUnterschrift
	 * 
	 * Direktes Lesen
	 * @return Abgabeunterschrift-Objekt
	 */
	public Object getAbgUnterschrift() {
		return abgUnterschrift;
	}
	/**
	 * Setter f�r abgUnterschrift
	 * 
	 * Kann nur geschrieben werden wenn noch kein Abgabedatum gesetzt ist
	 * Direktes Schreiben
	 * @param abgUnterschrift Zu setzdes Unterschriftobjekt
	 */
	public void setAbgUnterschrift(Object abgUnterschrift) {
		if (abgDatum == null || !inSecureMode)
			this.abgUnterschrift = abgUnterschrift;
	}
	
	/**
	 * Getter f�r aZeile
	 * 
	 * Direktes Lesen
	 * @return Komplette Liste mit allen Eintr�gen in Liste A
	 */
	public Vector<AZeile> getAZeile() {
		return aZeile;
	}
	/**
	 * Setter f�r aZeile
	 * 
	 * Kann nur geschrieben werden wenn noch kein abgDatum gesetzt ist
	 * Direktes Schreiben
	 * @param aZeile Vektor mit Eintr�gen der Liste A
	 */
	public void setAZeile(Vector<AZeile> aZeile) {
		if (abgDatum == null || !inSecureMode)
			this.aZeile = aZeile;
	}
	
	/**
	 * Getter f�r sumErl
	 * 
	 * Direktes Lesen
	 * @return Summen erlegter Tiere in Abh�ngigkeit einer AKlasse
	 */
	public HashMap<AKlasse, Integer> getSumErl() {
		return sumErl;
	}
	/**
	 * Setter f�r sumErl
	 * 
	 * Kann nur geschrieben werden wenn noch kein abgDatum gesetzt ist
	 * Direktes Schreiben
	 * @param sumErl HashMap mit Summen von erlegten Tieren mit Zugeh�rigkeit zu einer AKlasse
	 */
	public void setSumErl(HashMap<AKlasse, Integer> sumErl) {
		if (abgDatum == null || !inSecureMode)
			this.sumErl = sumErl;
	}
	
	/**
	 * Getter f�r sumFall
	 * 
	 * Direktes Lesen
	 * @return Summe an Fallwidld in Abh�ngigkeit einer AKlasse
	 */
	public HashMap<AKlasse, Integer> getSumFall() {
		return sumFall;
	}
	/**
	 * Setter f�r sumFall
	 * 
	 * Kann nur geschrieben werden wenn noch kein abgDatum gesetzt ist
	 * Direktes Schreiben
	 * @param sumFall HashMap mit Summen von Fallwildtieren mit Zugeh�rigkeit zu einer AKlasse
	 */
	public void setSumFall(HashMap<AKlasse, Integer> sumFall) {
		if (abgDatum == null || !inSecureMode)
			this.sumFall = sumFall;
	}
	
	/**
	 * Getter f�r sumGes
	 * 
	 * Direktes Lesen
	 * @return Summe an gefallenen und erlegtem Wildtieren insgesamt 
	 */
	public HashMap<AKlasse, Integer> getSumGes() {
		return sumGes;
	}
	/**
	 * Setter f�r sumGes
	 * 
	 * Kann nur geschrieben werden wenn noch kein abgDatum gesetzt ist
	 * Direktes Schreiben
	 * @param sumGes HashMap mit Gesamtsummen von Tieren mit Zugeh�rigkeit zu einer AKlasse
	 */
	public void setSumGes(HashMap<AKlasse, Integer> sumGes) {
		if (abgDatum == null || !inSecureMode)
			this.sumGes = sumGes;
	}
	
	public boolean isInSecureMode() {
		return inSecureMode;
	}
	public void setInSecureMode(boolean inSecureMode) {
		this.inSecureMode = inSecureMode;
	}
}