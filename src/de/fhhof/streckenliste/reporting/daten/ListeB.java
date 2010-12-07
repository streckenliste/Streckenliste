package de.fhhof.streckenliste.reporting.daten;

import java.util.GregorianCalendar;
import java.util.Vector;

/**
 * Datenklasse mit allen wesentlichen Elementen einer Liste B
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public class ListeB {
	/**
	 * Jagdjahr für das die Liste B geführt wird
	 */
	private GregorianCalendar jJahr;
	/**
	 * Menge von BZeile-EInträgen
	 */
	private Vector<BZeile> bZeile;
	
	/**
	 * Basiskonstruktor
	 * 
	 * Es wird nur der Vektor initialisert
	 */
	public ListeB() {
		bZeile = new Vector<BZeile>();
	}
	/**
	 * Erweiterter Konstruktor
	 * 
	 * Es wird der Vektor mit den BZeilen initialisiert
	 * Greift auf den Basiskonstruktor zu
	 * Das Jagdjahr kann ebenfalls gesetzt werden
	 * 
	 * @param jJahr
	 */
	public ListeB(GregorianCalendar jJahr) {
		this();
		
		this.jJahr = jJahr;
	}
	
	public GregorianCalendar getjJahr() {
		return jJahr;
	}
	public void setjJahr(GregorianCalendar jJahr) {
		this.jJahr = jJahr;
	}
	public Vector<BZeile> getbZeile() {
		return bZeile;
	}
	public void setbZeile(Vector<BZeile> bZeile) {
		this.bZeile = bZeile;
	}
}
