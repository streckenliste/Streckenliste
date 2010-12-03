package de.fhhof.streckenliste.reporting.daten;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Vector;

/**
 * In der V4 vom Datendesign gibt jJahr als Attribute für jJahr und als Element
 * 
 * @author Sebastian
 */
public class ListeA {
	private String jJahr;
	private GregorianCalendar abgDatum;
	private String ort;
	private Object abgUnterschrift;
	private Vector<AZeile> aZeile;
	private HashMap<AKlasse, Integer> sumErl;
	private HashMap<AKlasse, Integer> sumFall;
	private HashMap<AKlasse, Integer> sumGes;
	
	public ListeA() {
		aZeile = new Vector<AZeile>();
	}
	public ListeA(String jJahr, GregorianCalendar abgDatum, String ort, Object abgUnterschrift) {
		this();
		
		this.jJahr = jJahr;
		this.abgDatum = abgDatum;
		this.ort = ort;
		this.abgUnterschrift = abgUnterschrift;
	}
	public ListeA(String jJahr, GregorianCalendar abgDatum, String ort,
			Object abgUnterschrift, Vector<AZeile> aZeile,
			HashMap<AKlasse, Integer> sumErl,
			HashMap<AKlasse, Integer> sumFall,
			HashMap<AKlasse, Integer> sumGes) {
		super();
		this.jJahr = jJahr;
		this.abgDatum = abgDatum;
		this.ort = ort;
		this.abgUnterschrift = abgUnterschrift;
		this.aZeile = aZeile;
		this.sumErl = sumErl;
		this.sumFall = sumFall;
		this.sumGes = sumGes;
	}
	public String getJJahr() {
		return jJahr;
	}
	public void setJJahr(String jJahr) {
		this.jJahr = jJahr;
	}
	
	public GregorianCalendar getAbgDatum() {
		return abgDatum;
	}
	public void setAbgDatum(GregorianCalendar abgDatum) {
		this.abgDatum = abgDatum;
	}
	
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	public Object getAbgUnterschrift() {
		return abgUnterschrift;
	}
	public void setAbgUnterschrift(Object abgUnterschrift) {
		this.abgUnterschrift = abgUnterschrift;
	}
	
	public Vector<AZeile> getAZeile() {
		return aZeile;
	}
	public void setAZeile(Vector<AZeile> aZeile) {
		this.aZeile = aZeile;
	}
	
	public HashMap<AKlasse, Integer> getSumErl() {
		return sumErl;
	}
	public void setSumErl(HashMap<AKlasse, Integer> sumErl) {
		this.sumErl = sumErl;
	}
	
	public HashMap<AKlasse, Integer> getSumFall() {
		return sumFall;
	}
	public void setSumFall(HashMap<AKlasse, Integer> sumFall) {
		this.sumFall = sumFall;
	}
	
	public HashMap<AKlasse, Integer> getSumGes() {
		return sumGes;
	}
	public void setSumGes(HashMap<AKlasse, Integer> sumGes) {
		this.sumGes = sumGes;
	}	
}