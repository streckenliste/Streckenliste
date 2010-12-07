package de.fhhof.streckenliste.reporting.daten;

/**
 * Klasse zum Repräsentieren eines Eintrages in der Liste B
 * 
 * Alle Wichtigen Eigenschaften eines solchen Eintrages werden erfasst
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public class BZeile {
	/**
	 * Wildart zu der die Summen erfasst werden
	 */
	private BWildart bWildart;
	/**
	 * Anzahl erlegter oder gefangener Tiere der Wildart
	 */
	private int bAnzErlegt;
	/**
	 * Anzahl an verendet gefundenen Tieren der Wildart
	 */
	private int bAnzFallVerend;
	/**
	 * Anzahl der durch einen Verkehrsunfall verendet gefundenen Wildarten
	 * Ist Teil der verendet gefundenen Tiere, d.h. bAnzFallVerend>=bAnzFallVerkehr
	 */
	private int bAnzFallVerkehr;
	/**
	 * Bemerkungstext zu der Wildart
	 */
	private String bBemerk;
	
	/**
	 * Basiskonstruktor
	 * 
	 * Nutzt den Konstruktor (BWildart, int, int, int, String)
	 * Die Summen werden mit 0 belegt, BWildart ist null und der Bemekungstext ist leer
	 */
	public BZeile() {
		this(null, 0, 0, 0, "");
	}	
	
	/**
	 * Konstruktor mit kompletter Eigenschaftsliste
	 * 
	 * Erlaubt das Setzen aller Eigenschaften einer BZeile bereits bei der Erstellung
	 * @param bWildart {@link BWildart} des Eintrages
	 * @param bAnzErlegt Anzahl erlegter/gefangener Tiere
	 * @param bAnzFallVerend Anzahl verendet gefundener Tiere
	 * @param bAnzFallVerkehr Anzahl durch einen Verkehrsunfall verendet gefundener Tiere
	 * @param bBemerk Bemerkungtext zum Eintrag
	 */
	public BZeile(BWildart bWildart, int bAnzErlegt, int bAnzFallVerend,
			int bAnzFallVerkehr, String bBemerk) {
		this.bWildart = bWildart;
		this.bAnzErlegt = bAnzErlegt;
		this.bAnzFallVerend = bAnzFallVerend;
		this.bAnzFallVerkehr = bAnzFallVerkehr;
		this.bBemerk = bBemerk;
	}
	
	/**
	 * Getter für die BWildart
	 * 
	 * Direktes Lesen
	 * @return bWildart; null wenn kein BWildartobjekt hinterlegt wurde
	 */
	public BWildart getbWildart() {
		return bWildart;
	}
	/**
	 * Setter für bWildart
	 * 
	 * Direktes Schreiben
	 * @param bWildart BWildart-Objekt das gesetzt werden soll
	 */
	public void setbWildart(BWildart bWildart) {
		this.bWildart = bWildart;
	}
	
	/**
	 * Getter für bAnzErlegt
	 * 
	 * {@link #bAnzErlegt}
	 * Direktes Lesen
	 * @return Anzahl Erlegter Tiere; Standardwert: 0
	 */
	public int getbAnzErlegt() {
		return bAnzErlegt;
	}
	/**
	 * Setter für bAnzErlegt
	 * 
	 * {@link #bAnzErlegt}
	 * @param bAnzErlegt Wert der für die Anzahl gesetzt werden soll;
	 * (bAnzErlegt>=0?bAnzErlegt:0)
	 */
	public void setbAnzErlegt(int bAnzErlegt) {
		if (bAnzErlegt < 0)
			this.bAnzErlegt = 0;
		else
			this.bAnzErlegt = bAnzErlegt;
	}
	
	/**
	 * Getter für bAnzFallVerend
	 * 
	 * {@link #bAnzFallVerend}
	 * Direktes Lesen
	 * @return Anzahl an verendet gefundener Tiere
	 */
	public int getbAnzFallVerend() {
		return bAnzFallVerend;
	}
	/**
	 * Setter für bAnzFallVerend
	 * 
	 * @param bAnzFallVerend Wert fpr die Anzahl an verendet gefundener Tiere der
	 * gesetzt werden soll; (bAnzFallVerend>=0?bAnzFallVerend:0)
	 */
	public void setbAnzFallVerend(int bAnzFallVerend) {
		if (bAnzFallVerend<0)
			this.bAnzErlegt = 0;
		else
			this.bAnzFallVerend = bAnzFallVerend;
	}
	
	/**
	 * Getter für bAnzFallVerkehr
	 * 
	 * {@link #bAnzFallVerkehr}
	 * Direktes Lesen
	 * @return Anzahl an durch einen Verkehrsunfall verendeten Tieren
	 */
	public int getbAnzFallVerkehr() {
		return bAnzFallVerkehr;
	}
	/**
	 * Setter für bAnzFallVerkehr
	 * 
	 * @param bAnzFallVerkehr Anzahl die Gesetzt werden soll;
	 * (bAnzFallVerkehr>=0?bAnzFallVerkehr:0)
	 */
	public void setbAnzFallVerkehr(int bAnzFallVerkehr) {
		if (bAnzFallVerkehr < 0)
			this.bAnzFallVerkehr = 0;
		else
			this.bAnzFallVerkehr = bAnzFallVerkehr;
	}
	
	/**
	 * Getter für bBemerk
	 * 
	 * {@link #bBemerk}
	 * Direkts Lesen
	 * @return Bemerkungstext; null wenn kein Text hinterlegt wurde
	 */
	public String getbBemerk() {
		return bBemerk;
	}
	/**
	 * Setter für bBemerk
	 * 
	 * Es werden nur die ersten 80 Zeichengespeichert
	 * @param bBemerk Speichert: substring(0, 80)
	 */
	public void setbBemerk(String bBemerk) {
		this.bBemerk = bBemerk.substring(0, 80);
	}
}
