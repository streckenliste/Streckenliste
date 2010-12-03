package de.fhhof.streckenliste.reporting.daten;

import java.util.Vector;

public class Sollabschuesse {
	private String jJahr;
	private int pJahre;
	private Vector<Sollabschuss> sollabschusse;
	
	public Sollabschuesse() {
		sollabschusse = new Vector<Sollabschuss>();
	}

	public Sollabschuesse(String jJahr, int pJahre) {
		this();
		
		this.jJahr = jJahr;
		this.pJahre = pJahre;
	}

	public String getjJahr() {
		return jJahr;
	}
	public void setjJahr(String jJahr) {
		this.jJahr = jJahr;
	}

	public int getpJahre() {
		return pJahre;
	}
	public void setpJahre(int pJahre) {
		this.pJahre = pJahre;
	}

	public Vector<Sollabschuss> getSollabschusse() {
		return sollabschusse;
	}
	public void setSollabschusse(Vector<Sollabschuss> sollabschusse) {
		this.sollabschusse = sollabschusse;
	}
}
