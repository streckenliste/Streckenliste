package de.fhhof.streckenliste.reporting.daten;

import java.util.Vector;

public class Sollabschuesse {
	private String jJahr;
	private Vector<Sollabschuss> sollabschusse;
	
	public Sollabschuesse() {
		sollabschusse = new Vector<Sollabschuss>();
	}

	public Sollabschuesse(String jJahr) {
		this();
		
		this.jJahr = jJahr;
	}

	public String getjJahr() {
		return jJahr;
	}
	public void setjJahr(String jJahr) {
		this.jJahr = jJahr;
	}

	public Vector<Sollabschuss> getSollabschusse() {
		return sollabschusse;
	}
	public void setSollabschusse(Vector<Sollabschuss> sollabschusse) {
		this.sollabschusse = sollabschusse;
	}
}
