package de.fhhof.streckenliste.reporting.daten;

public class Streckenliste {
	private AnschrUJB anschrUJB;
	private RevArt revArt;
	private String revName;
	private Verwert verwert;
	private String bSatzart = "08";
	private String amtID;
	private String revNr;
	private ListeA listeA;
	private ListeB listeB;
	private Sollabschuesse sollabschuesse;
	
	//Konstruktoren
	
	//Getter und Setter
	public AnschrUJB getAnschrUJB() {
		return anschrUJB;
	}
	public void setAnschrUJB(AnschrUJB anschrUJB) {
		this.anschrUJB = anschrUJB;
	}
	
	public RevArt getRevArt() {
		return revArt;
	}
	public void setRevArt(RevArt revArt) {
		this.revArt = revArt;
	}
	
	public String getRevName() {
		return revName;
	}
	public void setRevName(String revName) {
		this.revName = revName;
	}
	
	public Verwert getVerwert() {
		return verwert;
	}
	public void setVerwert(Verwert verwert) {
		this.verwert = verwert;
	}
	
	public String getbSatzart() {
		return bSatzart;
	}
	public void setbSatzart(String bSatzart) {
		this.bSatzart = bSatzart;
	}
	
	public String getAmtID() {
		return amtID;
	}
	public void setAmtID(String amtID) {
		this.amtID = amtID;
	}
	
	public String getRevNr() {
		return revNr;
	}
	public void setRevNr(String revNr) {
		this.revNr = revNr;
	}
	
	public ListeA getListeA() {
		return listeA;
	}
	public void setListeA(ListeA listeA) {
		this.listeA = listeA;
	}
	
	public ListeB getListeB() {
		return listeB;
	}
	public void setListeB(ListeB listeB) {
		this.listeB = listeB;
	}
	
	public Sollabschuesse getSollabschuesse() {
		return sollabschuesse;
	}
	public void setSollabschuesse(Sollabschuesse sollabschuesse) {
		this.sollabschuesse = sollabschuesse;
	}
}
