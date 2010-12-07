package de.fhhof.streckenliste.reporting.daten;

/**
 * Anschrift einer Untere Jagdbehörde auf einer Streckenliste
 * 
 * Umfasst alle wichtigen Informationen, die auch auf der Streckenliste
 * vermerkt werden.
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public class AnschrUJB {
	/**
	 * Name des Landratsamtes
	 */
	private String ujbLRA;
	/**
	 * Zuständiges Sachgebiet
	 */
	private String ujbSG;
	/**
	 * Straße in der die untere Jagdbehörde sitzt
	 */
	private String ujbStr;
	/**
	 * Postleitzahl der Unteren Jagdbehörde
	 */
	private String ujbPLZ;
	/**
	 * Ort in dem sich die Untere Jagdbehörde befindet
	 */
	private String ujbOrt;
	
	/**
	 * Standardkonstruktor
	 * 
	 * Alle Eingenschaften werden mit einem Leerstring initialisiert
	 */
	public AnschrUJB() {
		setUjbLRA("");
		setUjbSG("");
		setUjbStr("");
		setUjbPLZ("");
		setUjbOrt("");
	}
	
	/**
	 * Größerer Konstruktor zum Setzen der Eingeschaften des Objektes
	 * 
	 * Das Setzen der Eigenschaften läuft über die Setter
	 * @param ujbLRA Landratsamt
	 * @param ujbSG Sachgebiet
	 * @param ujbStr Straße der UJB
	 * @param ujbPLZ Postleitzahl der UJB
	 * @param ujbOrt Ort der UJB
	 */
	public AnschrUJB(String ujbLRA, String ujbSG, String ujbStr, String ujbPLZ,
			String ujbOrt) {
		setUjbLRA(ujbLRA);
		setUjbSG(ujbSG);
		setUjbStr(ujbStr);
		setUjbPLZ(ujbPLZ);
		setUjbOrt(ujbOrt);
	}
	
	/**
	 * Getter für Landratsamtangabe
	 * 
	 * Direktes Lesen
	 * @return Landratsamtname
	 */
	public String getUjbLRA() {
		return ujbLRA;
	}
	/**
	 * Setter für Landratsamtattribut
	 * 
	 * Direktes Schreiben
	 * @param ujbLRA Name des Landratsamtes
	 */
	public void setUjbLRA(String ujbLRA) {
		this.ujbLRA = ujbLRA;
	}
	
	/**
	 * Getter für Sachgebiet
	 * 
	 * Direktes Lesen
	 * @return Name des Sachgebietes
	 */
	public String getUjbSG() {
		return ujbSG;
	}
	/**
	 * Setter für Sachgebiet
	 * 
	 * Direktes Schreiben
	 * @param ujbSG Name des Sachgebietes
	 */
	public void setUjbSG(String ujbSG) {
		this.ujbSG = ujbSG;
	}
	
	/**
	 * Getter für Straße in der die UJB sitzt
	 * 
	 * Die Hausnummer muss hier mit enthalten sein
	 * Direktes Lesen
	 * @return Straßenname mit Hausnummer
	 */
	public String getUjbStr() {
		return ujbStr;
	}
	/**
	 * Setter für Straßennamen in der die UJB sitzt
	 * 
	 * Straßename mit Hausnummer eingeben
	 * Direktes Schreiben
	 * @param ujbStr Straßenname mit Hausnummer
	 */
	public void setUjbStr(String ujbStr) {
		this.ujbStr = ujbStr;
	}
	
	/**
	 * Geter für die Postleitzahl der UJB
	 * 
	 * Der Ort ist getrennt gespeichert
	 * Direktes Lesen
	 * @return Postleitzahl als Zeichenkette
	 */
	public String getUjbPLZ() {
		return ujbPLZ;
	}
	/**
	 * Setter für Postleitzahl
	 * 
	 * Den zugehörigen Ort NICHT mit angeben
	 * Direktes Schreiben
	 * @param ujbPLZ Postleitzahl als String
	 */
	public void setUjbPLZ(String ujbPLZ) {
		this.ujbPLZ = ujbPLZ;
	}
	
	/**
	 * Getter für den Ort in dem die UJB sitzt
	 * 
	 * Die Postleitzahl ist nicht mit enthalten
	 * Direktes Lesen
	 * @return Name des Ortes in dem die UJB sitzt
	 */
	public String getUjbOrt() {
		return ujbOrt;
	}
	/**
	 * Setter für den Ort der UJB
	 * 
	 * Bitte PLZ nicht mit angeben
	 * Direktes Schreiben
	 * @param ujbOrt Ortsname
	 */
	public void setUjbOrt(String ujbOrt) {
		this.ujbOrt = ujbOrt;
	}
	
	
}
