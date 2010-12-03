package de.fhhof.streckenliste.reporting.daten;

import java.util.GregorianCalendar;
import java.util.Vector;

public class ListeB {
	private GregorianCalendar jJahr;
	private Vector<BZeile> bZeile;
	
	public ListeB() {
		bZeile = new Vector<BZeile>();
	}
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
