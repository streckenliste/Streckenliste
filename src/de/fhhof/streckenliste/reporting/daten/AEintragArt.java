package de.fhhof.streckenliste.reporting.daten;

import de.fhhof.streckenliste.util.Repository;

/**
 * Enumeration mit verschiedenen Arten eines Eintrages in der Streckenliste A
 * 
 * Es werden die vordefinierten Arten angeboten, sowie auch die Möglichkeit eigene Werte
 * zu definieren. Dabei ist zu beachten, dass alle abweichenden Varianten den selben
 * Typ haben (AEintragArt.aCustom)
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public enum AEintragArt {
	aErlegt(1, Repository.AERLEGT[1]), aVerkehr(2, Repository.AVERKEHR[1]),
	aSonstFall(3, Repository.ASONSTFALL[1]), aGefangen(4, Repository.AGEFANGEN[1]),
	aCustom(0, "");
	
	/**
	 * ID/Wert der AEintragsArt
	 */
	private int aEintragID;
	/**
	 * Name der Eintragsart
	 */
	private String aEintragName;
	
	/**
	 * Enumerationkonstruktor
	 * 
	 * die Eingenschaften aEintragsArtName und -ID werden aus Parametern genommen
	 * 
	 * @param aEintragArtID ID der Eintragsart
	 * @param aEintragname Name der Eintragsart
	 */
	private AEintragArt(int aEintragArtID, String aEintragname) {
		this.aEintragID = aEintragArtID;
		this.aEintragName = aEintragname;
	}
	
	/**
	 * Erzeugt eine AEintragsArt anhand einer ID
	 * @param ID eine gültige AEintragsArtID
	 * @return AEintragsArt; null wenn die ID nicht bekannt ist
	 */
	public static AEintragArt getAEintragArtByID(int ID) {
		switch (ID) {
		case 1: return AEintragArt.aErlegt;
		case 2: return AEintragArt.aVerkehr;
		case 3: return AEintragArt.aSonstFall;
		case 4: return AEintragArt.aGefangen;
		default: return null;
		}
	}
	
	/**
	 * Erzeugt eine AEintragArt anhand von Namen
	 * 
	 * Als Namen sind die Anzeigenamen und Feldnamen aus dem Repository erlaubt
	 * Es werden die Feldnamen geprüft.
	 * Die Arten werden in der folgendne Reihenfolge geprüft:
	 * AERLEGT
	 * AVERKEHR
	 * ASONSTFALL
	 * AGEFANGEN
	 * 
	 * @param aEintragArtName Namen der zum Erzeugen der Eintragsart genutzt werden soll
	 * @return AEintragArt; Null wenn der Name nicht evaluiert werden konnte
	 */
	public static AEintragArt getAEintragArtByName(String aEintragArtName) {
		AEintragArt result = null;
		
		if (aEintragArtName.equalsIgnoreCase(Repository.AERLEGT[0]) )
			result = aErlegt;
		else if (aEintragArtName.equalsIgnoreCase(Repository.AVERKEHR[0]) )
			result = aVerkehr;
		else if (aEintragArtName.equalsIgnoreCase(Repository.ASONSTFALL[0]) )
			result = aSonstFall;
		else if (aEintragArtName.equalsIgnoreCase(Repository.AGEFANGEN[0]) )
			result = aGefangen;
		
		return result;
	}
	
	/**
	 * Erzeugt eine AEintragArt anahnd von Werten
	 * 
	 * Es wird ein AEintragsArt.Custom erzeugt und anschließend mit Werten belegt
	 * 
	 * @param aEintragID ID/Wert der AEintragArt
	 * @param aEintragName Name für AEintrag
	 * @return
	 */
	public static AEintragArt getAEintragArtByValues(int aEintragID, String aEintragName) {
		AEintragArt result = AEintragArt.aCustom;
		result.aEintragID = aEintragID;
		result.aEintragName = aEintragName;
		
		return result;
	}

	public int getaEintragID() {
		return aEintragID;
	}
	public String getAEintragName() {
		return aEintragName;
	}
}
