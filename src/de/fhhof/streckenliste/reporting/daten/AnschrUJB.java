package de.fhhof.streckenliste.reporting.daten;

/**
 * Anschrift einer Untere Jagdbeh�rde auf einer Streckenliste
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
	 * Zust�ndiges Sachgebiet
	 */
	private String ujbSG;
	/**
	 * Stra�e in der die untere Jagdbeh�rde sitzt
	 */
	private String ujbStr;
	/**
	 * Postleitzahl der Unteren Jagdbeh�rde
	 */
	private String ujbPLZ;
	/**
	 * Ort in dem sich die Untere Jagdbeh�rde befindet
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
	 * Gr��erer Konstruktor zum Setzen der Eingeschaften des Objektes
	 * 
	 * Das Setzen der Eigenschaften l�uft �ber die Setter
	 * @param ujbLRA Landratsamt
	 * @param ujbSG Sachgebiet
	 * @param ujbStr Stra�e der UJB
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
	 * Getter f�r Landratsamtangabe
	 * 
	 * Direktes Lesen
	 * @return Landratsamtname
	 */
	public String getUjbLRA() {
		return ujbLRA;
	}
	/**
	 * Setter f�r Landratsamtattribut
	 * 
	 * Direktes Schreiben
	 * @param ujbLRA Name des Landratsamtes
	 */
	public void setUjbLRA(String ujbLRA) {
		this.ujbLRA = ujbLRA;
	}
	
	/**
	 * Getter f�r Sachgebiet
	 * 
	 * Direktes Lesen
	 * @return Name des Sachgebietes
	 */
	public String getUjbSG() {
		return ujbSG;
	}
	/**
	 * Setter f�r Sachgebiet
	 * 
	 * Direktes Schreiben
	 * @param ujbSG Name des Sachgebietes
	 */
	public void setUjbSG(String ujbSG) {
		this.ujbSG = ujbSG;
	}
	
	/**
	 * Getter f�r Stra�e in der die UJB sitzt
	 * 
	 * Die Hausnummer muss hier mit enthalten sein
	 * Direktes Lesen
	 * @return Stra�enname mit Hausnummer
	 */
	public String getUjbStr() {
		return ujbStr;
	}
	/**
	 * Setter f�r Stra�ennamen in der die UJB sitzt
	 * 
	 * Stra�ename mit Hausnummer eingeben
	 * Direktes Schreiben
	 * @param ujbStr Stra�enname mit Hausnummer
	 */
	public void setUjbStr(String ujbStr) {
		this.ujbStr = ujbStr;
	}
	
	/**
	 * Geter f�r die Postleitzahl der UJB
	 * 
	 * Der Ort ist getrennt gespeichert
	 * Direktes Lesen
	 * @return Postleitzahl als Zeichenkette
	 */
	public String getUjbPLZ() {
		return ujbPLZ;
	}
	/**
	 * Setter f�r Postleitzahl
	 * 
	 * Den zugeh�rigen Ort NICHT mit angeben
	 * Direktes Schreiben
	 * @param ujbPLZ Postleitzahl als String
	 */
	public void setUjbPLZ(String ujbPLZ) {
		this.ujbPLZ = ujbPLZ;
	}
	
	/**
	 * Getter f�r den Ort in dem die UJB sitzt
	 * 
	 * Die Postleitzahl ist nicht mit enthalten
	 * Direktes Lesen
	 * @return Name des Ortes in dem die UJB sitzt
	 */
	public String getUjbOrt() {
		return ujbOrt;
	}
	/**
	 * Setter f�r den Ort der UJB
	 * 
	 * Bitte PLZ nicht mit angeben
	 * Direktes Schreiben
	 * @param ujbOrt Ortsname
	 */
	public void setUjbOrt(String ujbOrt) {
		this.ujbOrt = ujbOrt;
	}
	
	
}
