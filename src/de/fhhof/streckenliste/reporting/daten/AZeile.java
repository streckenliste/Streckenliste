package de.fhhof.streckenliste.reporting.daten;

import java.util.GregorianCalendar;

/**
 * Klasse zur Repr�sentation eines Zeile in der Liste A, d.h. eines Eintrages
 * 
 * Erfassten werden kann das Abschussdatum, Gewicht, die Wildart nach Liste A,
 * die Klasse aus Liste A, ein Bemerkungstext, die Art des Eintrages (Abschuss, Gefallen),
 * und der Zeitpunkt der Meldung, sowie die ID der Zeile.
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public class AZeile {
	/**
	 * Datum des Abschusses
	 */
	private GregorianCalendar aDatum;
	/**
	 * Gewicht des Tieres
	 */
	private float aGewicht;
	/**
	 * Wildart nach Liste A
	 */
	private AWildart aWildart;
	/**
	 * Klasse nach Liste A
	 */
	private AKlasse aKlasse;
	/**
	 * Bemerkungstext f�r einen Eintrag; darf maximal 80 Zeichen lang sein
	 */
	private String aBemerk;
	/**
	 * Art des Eintrages, bzw. Art "Abschusses"
	 */
	private AEintragArt aEintragArt;
	/**
	 * Zeitpunkt der Meldung des Eintrages an die UJB
	 */
	private GregorianCalendar aMeldedatum;
	/**
	 * ID des Eintrages
	 */
	private int id;
	
	/**
	 * Basiskonstruktor
	 * 
	 * Belegt lediglich aGewicht und id mit 0
	 * Nutzt den Konstruktor (GregorianCalendar, float, AWildart, AKlasse,
	 * String, AEintragArt, GregorianCalendar, int)
	 */
	public AZeile() {
		this(null, 0, null, null, "", null, null, 0);
	}
	
	/**
	 * Konstruktor zum setzen von weiten Teilen des Objektes
	 * 
	 * Nutzt den Konstruktor (GregorianCalendar, float, AWildart, AKlasse,
	 * String, AEintragArt, GregorianCalendar, int)
	 * ID wird mit 0 belegt
	 * @param aDatum Datum des Eintrages
	 * @param aGewicht Gewicht des erlegten Wildes
	 * @param aWildart Wildart aus Liste A des Eintrages
	 * @param aKlasse Klasse aus Liste A des Eintrages
	 * @param aBemerk Bemerkungstext zum Eintrag
	 * @param aEintragArt Art des Eintrages
	 * @param aMeldedatum Zeitpunkt der Meldung des Eintrages
	 */
	public AZeile(GregorianCalendar aDatum, float aGewicht, AWildart aWildart,
			AKlasse aKlasse, String aBemerk, AEintragArt aEintragArt,
			GregorianCalendar aMeldedatum) {
		this(aDatum, aGewicht, aWildart, aKlasse, aBemerk, aEintragArt, aMeldedatum, 0);
	}
	/**
	 * Kompletter Konstruktor
	 * 
	 * Es werden alle Eigenschaften entsprechend der Parameter belegt
	 * @param aDatum Datum des Eintrages
	 * @param aGewicht Gewicht des erlegten Wildes
	 * @param aWildart Wildart aus Liste A des Eintrages
	 * @param aKlasse Klasse aus Liste A des Eintrages
	 * @param aBemerk Bemerkungstext zum Eintrag
	 * @param aEintragArt Art des Eintrages
	 * @param aMeldedatum Zeitpunkt der Meldung des Eintrages
	 * @param id ID/lauffende Nummer des Eintrages
	 */
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
	
	/**
	 * Konstruktor der die Wildart anhand der Klasse bestimmt und �bernimmt
	 * 
	 * Nutzt den Konstruktor (GregorianCalendar, float, AWildart, AKlasse,
	 * String, AEintragArt, GregorianCalendar, int)
	 * ID wird mit 0 belegt
	 * @param aDatum
	 * @param aGewicht
	 * @param aKlasse
	 * @param aBemerk
	 * @param aEintragArt
	 * @param aMeldedatum
	 */
	public AZeile(GregorianCalendar aDatum, float aGewicht, AKlasse aKlasse,
			String aBemerk, AEintragArt aEintragArt, GregorianCalendar aMeldedatum) {
		this(aDatum, aGewicht, (aKlasse==null?null:aKlasse.getaWildart()), aKlasse, aBemerk, aEintragArt, aMeldedatum, 0);
	}

	/**
	 * Getter f�r aDatum
	 * 
	 * Direktes Lesen
	 * @return Datumseintrag; null wenn kein Objekt hinterlegt ist
	 */
	public GregorianCalendar getaDatum() {
		return aDatum;
	}
	/**
	 * Setter f�r Datum des Eintrages
	 * 
	 * Direktes Schreiben
	 * @param aDatum Datum des Eintrages
	 */
	public void setaDatum(GregorianCalendar aDatum) {
		this.aDatum = aDatum;
	}
	
	/**
	 * Getter f�r Gewicht des Wildes des Eintrages
	 * 
	 * Direktes Lesen
	 * @return Gewicht; Standardwert ist 0
	 */
	public float getaGewicht() {
		return aGewicht;
	}
	/**
	 * Setter f�r Gewicht des Wildes des Eintrages
	 * 
	 * Direktes Schreiben
	 * @param aGewicht Zusetzendes Gewicht
	 */
	public void setaGewicht(float aGewicht) {
		this.aGewicht = aGewicht;
	}
	
	/**
	 * Getter f�r AWildart des Eintrages
	 * 
	 * Direktes Lesen
	 * @return AWildart-Objek; null wenn kein Objekt hinterlegt ist
	 */
	public AWildart getaWildart() {
		return aWildart;
	}
	/**
	 * Setter f�r die aWildart
	 * 
	 * Direktes Schreiben
	 * @param aWildart AWildart des Eintrages
	 */
	public void setaWildart(AWildart aWildart) {
		this.aWildart = aWildart;
	}
	/**
	 * Setter f�r die aWildart
	 * 
	 * Pr�fung ob AWildart identisch mit der AWildart der AKlasse,
	 * sind beide nicht die Gleichen, wird aKlasse auf null gesetzt
	 * @param aWildart AWildart-Objekt des Eintrages
	 */
	public void setaWildartValidate(AWildart aWildart) {
		this.aWildart = aWildart;
		
		if (aKlasse != null) {
			if (aKlasse.getaWildart() != aWildart)
				aKlasse = null;
		}
	}
	
	/**
	 * Getter f�r die aKlasse des Eintrages
	 * 
	 * Direktes Lesen
	 * @return AKlasse-Objekt; null wenn kein Objekt hinterlegt ist
	 */
	public AKlasse getaKlasse() {
		return aKlasse;
	}
	/**
	 * Setter f�r die aKlasse des Eintrages
	 * 
	 * Es findet KEIN automatischer Abgleich mit AWildart statt,
	 * d.h. wenn die Wildart eine andere ist, als in der AKlasse
	 * des Parameters erfolgt keine Anpassung
	 * Direktes Schreiben
	 * @param aKlasse AKlasse des Eintrages
	 */
	public void setaKlasse(AKlasse aKlasse) {
		this.aKlasse = aKlasse;
	}
	/**
	 * Setter f�r die aKlasse des Eintrages
	 * 
	 * Inklusive Abgleich mit aWildart
	 * aWildart wird mit dem Wert aus aKlasse.getaWildart belegt
	 * Ist aKlasse null wird aWildart ebenfalls auch null gesetzt
	 * @param aKlasse AKlasse des Eintrages
	 */
	public void setaKlasseValidate(AKlasse aKlasse) {
		if (aKlasse == null) {
			this.aKlasse = null;
			aWildart = null;
		}
		else {
			this.aKlasse = aKlasse;
			aWildart = aKlasse.getaWildart();
		}
	}
	
	/**
	 * Getter f�r Bemerkungstext des Eintrages
	 * 
	 * Direktes Lesen
	 * @return Bemerkungstext; null wenn kein Bemerkungstext gesetzt wurde
	 */
	public String getaBemerk() {
		return aBemerk;
	}
	/**
	 * Setter f�r den Bemerkungstext des Eintrages
	 * 
	 * Maximale L�nge: 80 Zeichen
	 * Ist die Bemerkung l�nger als 80 Zeichen, werden nur
	 * die ersten 80 Zeichen gespeichert
	 * @param aBemerk Bemerkungstext; die ersten 80 Zeichen werden gespeichert
	 */
	public void setaBemerk(String aBemerk) {
		this.aBemerk = aBemerk.substring(0, 80);
	}
	
	/**
	 * Getter f�r AEintragArt des Eintrages
	 * 
	 * Direktes Lesen
	 * @return AEintragArt-Obekt; null wenn kein Wert hinterlegt ist
	 */
	public AEintragArt getaEintragArt() {
		return aEintragArt;
	}
	/**
	 * Setter f�r AEintragArt
	 * 
	 * Direktes Schreiben
	 * @param aEintragArt AEintragArt-Objekt
	 */
	public void setaEintragArt(AEintragArt aEintragArt) {
		this.aEintragArt = aEintragArt;
	}
	
	/**
	 * Getter f�r Meldedatum des Eintrages
	 * 
	 * Direktes Lesen
	 * @return GregorianCalendar-Objekt; null wenn kein Meldedatum hinterlegt ist
	 */
	public GregorianCalendar getaMeldedatum() {
		return aMeldedatum;
	}
	public void setaMeldedatum(GregorianCalendar aMeldedatum) {
		this.aMeldedatum = aMeldedatum;
	}
	
	/**
	 * Getter f�r ID des Eintrages
	 * /laufende Nummer
	 * 
	 * Direktes Lesen
	 * @return ID des Eintrages; 0 ist Standardwert
	 */
	public int getid() {
		return id;
	}
	/**
	 * Setter f�r ID des Eintrages
	 * 
	 * Direktes Schreiben
	 * @param id ID des Eintrages
	 */
	public void setid(int id) {
		this.id = id;
	}
}
