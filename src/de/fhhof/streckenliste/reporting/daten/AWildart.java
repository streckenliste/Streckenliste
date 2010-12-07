package de.fhhof.streckenliste.reporting.daten;

import de.fhhof.streckenliste.util.Repository;

/**
 * Enumeration mit den möglichen Wildarten der Liste A
 * 
 * Neben den verschiedenen vordefinierten Arten (aReh, aSchwarz) gibt es auch noch die Möglichkeit
 * eine Wildart mit bestimmten Werten anzulegen (aCustom). Diese Ausprägung sollte nur über
 * die Methode getAWildartByValues(...) erzeugt werden, weil sonst die Werte nicht festgelegt werden
 * können.
 * 
 * In der Unterklasse AWildartNamen sind auch die Namen für die vorhandenen Wildartarten hinterlegt.
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public enum AWildart {
	aReh(10, AWildartNamen.REH), aSchwarz(100, AWildartNamen.SCHWARZ), aRot(20, AWildartNamen.ROT),
	aGams(30, AWildartNamen.GAMS),	aDam(40, AWildartNamen.DAM), aMuffel(50, AWildartNamen.MUFFEL),
	aAuerhahn(60, AWildartNamen.AUERHAHN), aBirkhahn(70, AWildartNamen.BIRKHAHN),
	aRackelhahn(80, AWildartNamen.RACKELHAHN), aCustom(0, "");
	
	/**
	 * Anzeigenamen der AWildarten
	 * 
	 * Werte beziehen sich auf das Repository
	 * 
	 * @author Sebastian
	 * @version 1.0 untested
	 */
	public static class AWildartNamen {
		public static String REH = Repository.AREH[1];
		public static String SCHWARZ = Repository.ASCHWARZ[1];
		public static String ROT = Repository.AROT[1];
		public static String GAMS = Repository.AGAMS[1];
		public static String DAM = Repository.ADAM[1];
		public static String MUFFEL = Repository.AMUFFEL[1];
		public static String AUERHAHN = Repository.AAUERHAHN[1];
		public static String BIRKHAHN = Repository.ABIRKHAHN[1];
		public static String RACKELHAHN = Repository.ARACKELHAHN[1];
	}
	
	/**
	 * Wert/ID der zu der Wildart gehört
	 */
	private int aWildartWert;
	/**
	 * Name der Wildart aus Streckenliste A
	 */
	private String aWildartName;
	
	/**
	 * Konstruktor zum Initialisiern der beiden Attribute mit den jeweiligen Einstellungen je Art
	 * 
	 * @param aWildartWert ID/Wert Wildart der Streckenliste A 
	 * @param aWildartName Name der Wildart der Streckenliste A
	 */
	private AWildart(int aWildartWert, String aWildartName) {
		this.aWildartName = aWildartName;
		this.aWildartWert = aWildartWert;
	}

	/**
	 * Erstellung einer AWildart anhand des Wildartnamens
	 * 
	 * Es werden die 
	 * @param aWildartname
	 * @return
	 */
	public static AWildart getAWildartByName(String aWildartname) {
		if (aWildartname.equalsIgnoreCase(AWildartNamen.REH))
			return AWildart.aReh;
		else if (aWildartname.equalsIgnoreCase(AWildartNamen.SCHWARZ))
			return AWildart.aSchwarz;
		else if (aWildartname.equalsIgnoreCase(AWildartNamen.ROT))
			return AWildart.aRot;
		else if (aWildartname.equalsIgnoreCase(AWildartNamen.GAMS))
			return AWildart.aGams;
		else if (aWildartname.equalsIgnoreCase(AWildartNamen.DAM))
			return AWildart.aDam;
		else if (aWildartname.equalsIgnoreCase(AWildartNamen.MUFFEL))
			return AWildart.aMuffel;
		else if (aWildartname.equalsIgnoreCase(AWildartNamen.AUERHAHN))
			return AWildart.aAuerhahn;
		else if (aWildartname.equalsIgnoreCase(AWildartNamen.BIRKHAHN))
			return AWildart.aBirkhahn;
		else if (aWildartname.equalsIgnoreCase(AWildartNamen.RACKELHAHN))
			return AWildart.aRackelhahn;
		else
			return null;
	}
	/**
	 * Erstellen einer Wildart der Liste A anhand seiner ID
	 * 
	 * Es wird eine passende Wildart der aus der Liste A gesucht, die
	 * zu der ID passt. Gibt es keinen Eintrag, wird null als Ergebnis
	 * gekliefert.
	 * 
	 * @param ID ID der Wildart
	 * @return AWildart-Objekt; null wenn zu der ID keine Wildart hinterlegt ist
	 */
	public static AWildart getAWildartByID(int ID) {
		switch (ID) {
		case 10: return AWildart.aReh;
		case 100: return AWildart.aSchwarz;
		case 20: return AWildart.aRot;
		case 30: return AWildart.aGams;
		case 40: return AWildart.aDam;
		case 50: return AWildart.aMuffel;
		case 60: return AWildart.aAuerhahn;
		case 70: return AWildart.aBirkhahn;
		case 80: return AWildart.aRackelhahn;
		default: return null;
		}
	}
	/**
	 * Erstellen einer Wildart der Liste A mit bestimmten Werten.
	 * 
	 * Es wird eine AWildart.aCustom erzeugt und mit Werten aus den
	 * Parametern erzeugt.
	 * 
	 * @param aWildartID ID die der Wildart zugewiesen werden soll
	 * @param aWildartName Name, der der Wildart zugewiesen werden soll
	 * @return AWildart.aCustom-Objekt
	 */
	public static AWildart getAWildartByValues(int aWildartID, String aWildartName) {
		AWildart result = aCustom;
		result.aWildartName = aWildartName;
		result.aWildartWert = aWildartID;
		
		return result;
	}

	/**
	 * Getter für aWildartWert
	 * 
	 * Auslesen der ID die zu der Wildart gehört
	 * Direktes Lesen
	 * @return aWildartWert
	 */
	public int getaWildartWert() {
		return aWildartWert;
	}

	/**
	 * Getter für den Wildartnamen für Wildarten der Liste A
	 * 
	 * Auslesen von aWildartName
	 * Direktes Lesen
	 * @return Name der Wildart
	 */
	public String getaWildartName() {
		return aWildartName;
	}
}
