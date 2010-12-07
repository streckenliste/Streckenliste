package de.fhhof.streckenliste.reporting.daten;

import de.fhhof.streckenliste.util.Repository;

/**
 * Enumeration mit allen Klassen aus der Streckenliste A die während der ersten Entwicklung
 * notwendig wahren.
 * 
 * Es werden neben den unterschiedlichen Klassen auch eine Klasse bereitgestellt, bei der der
 * Inhalt gezielt festgelegt werden kann: AKlasse.aCustom. Dieser Typ sollte nur über die
 * zugehörige Fabrikmethode getAKlasseByValues erzeugt werden, weil sonst der Inhalt nicht
 * festgelegt werden kann, auch nicht nach der Erstellung.
 * 
 * Eine mögliche Erweiterung ist die Einführung einer Methode getAKlasseByName, wobei derzeit
 * das Problem vorhanden ist, das Namen nicht eindeutig sind. Beispiel: ein Hirsch Klasse IIa
 * kann zur Wildart Damwild aber auch Rotwild gehören. 
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public enum AKlasse {
	//TODO - Methode hinzufügen: getAKlasseByName
	aBock(11, AKlasseNamen.BOCK), aGeissReh(12, AKlasseNamen.GEISS), aKitzReh(13, AKlasseNamen.KITZ),
	aKeiler(101, AKlasseNamen.KEILER), aBache(102, AKlasseNamen.BACHE), aUeberM(103, AKlasseNamen.UEBERM),
	aUeberW(104, AKlasseNamen.UEBERW), aFrisch(105, AKlasseNamen.FRISCH), aHirschIRot(21, AKlasseNamen.HIRSCHI),
	aHirschIIaRot(22, AKlasseNamen.HIRSCHIIA), aHirschIIbRot(23, AKlasseNamen.HIRSCHIIB),
	aHirschIIIRot(24, AKlasseNamen.HIRSCHIII), aAlttierRot(25, AKlasseNamen.ALTTIER),
	aSchmaltierRot(26, AKlasseNamen.SCHMALTIER), aKalbRot(27, AKlasseNamen.KALB), aBockIa(31, AKlasseNamen.BOCKIA),
	aBockIb(32, AKlasseNamen.BOCKIB), aBockIIa(33, AKlasseNamen.BOCKIIA), aBockIIb(34, AKlasseNamen.BOCKIIB),
	aGeissGams(35, AKlasseNamen.GEISS), aJaehrling(36, AKlasseNamen.JAEHRLING), aKitzGams(37, AKlasseNamen.KITZ),
	aHirschIDam(41, AKlasseNamen.HIRSCHI), aHirschIIaDam(42, AKlasseNamen.HIRSCHIIA),
	aHirschIIbDam(43, AKlasseNamen.HIRSCHIIB), aHirschIIIDam(44, AKlasseNamen.HIRSCHIII),
	aAlttierDam(45, AKlasseNamen.ALTTIER), aSchmaltierDam(46, AKlasseNamen.SCHMALTIER),
	aKalbDam(47, AKlasseNamen.KALB), aWidderIa(51, AKlasseNamen.WIDDERIA), aWidderIb(52, AKlasseNamen.WIDDERIB),
	aWidderIIa(53, AKlasseNamen.WIDDERIIA), aWidderIIb(54, AKlasseNamen.WIDDERIIB),
	aAltschaf(55, AKlasseNamen.ALTSCHAF), aSchmalschaf(56, AKlasseNamen.SCHMALSCHAF),
	aLamm(57, AKlasseNamen.LAMM), aAuerhahn(61, AKlasseNamen.AUERHAHN), aBirkenhahn(71, AKlasseNamen.BIRKENHAHN),
	aRackelhahn(81, AKlasseNamen.RACKELHANH), aCustom(0, "");
	
	/**
	 * Bezeichnungen die in den AKlassen vorkommen können
	 * 
	 * Bezieht sich auf das Repository
	 * Die Einträge sind nicht final, womit auch eine Änderung noch möglich ist
	 * 
	 * @author Sebastian
	 * @version 1.0 untested
	 */
	public static class AKlasseNamen {
		public static String BOCK = Repository.ABOCK[1];
		public static String GEISS = Repository.AGEISS[1];
		public static String KITZ = Repository.AKITZ[1];
		public static String KEILER = Repository.AKEILER[1];
		public static String BACHE = Repository.ABACHE[1];
		public static String UEBERM = Repository.AUEBERM[1];
		public static String UEBERW = Repository.AUEBERW[1];
		public static String FRISCH = Repository.AFRISCH[1];
		public static String HIRSCHI = Repository.AHIRSCHI[1];
		public static String HIRSCHIIA = Repository.AHIRSCHIIA[1];
		public static String HIRSCHIIB = Repository.AHIRSCHIIB[1];
		public static String HIRSCHIII = Repository.AHIRSCHIII[1];
		public static String ALTTIER = Repository.AALTTIER[1];
		public static String SCHMALTIER = Repository.ASCHMALTIER[1];
		public static String KALB = Repository.AKALB[1];
		public static String BOCKIA = Repository.ABOCKIA[1];
		public static String BOCKIB = Repository.ABOCKIB[1];
		public static String BOCKIIA = Repository.ABOCKIIA[1];
		public static String BOCKIIB = Repository.ABOCKIIB[1];
		public static String JAEHRLING = Repository.AJAEHRLING[1];
		public static String WIDDERIA = Repository.AWIDDERIA[1];
		public static String WIDDERIB = Repository.AWIDDERIB[1];
		public static String WIDDERIIA = Repository.AWIDDERIIA[1];
		public static String WIDDERIIB = Repository.AWIDDERIIB[1];
		public static String ALTSCHAF = Repository.AALTSCHAF[1];
		public static String SCHMALSCHAF = Repository.ASCHMALSCHAF[1];
		public static String LAMM = Repository.ALAMM[1];
		public static String AUERHAHN = Repository.AAUERHAHN[1];
		public static String BIRKENHAHN = Repository.ABIRKENHAHN[1];
		public static String RACKELHANH = Repository.ARACKELHAHN[1];
	}
	
	/**
	 * Name der AKlasse
	 */
	private String aKlasseName;
	/**
	 * ID der AKlasse
	 */
	private int aKlasseWert;
	/**
	 * AWildart der Klasse
	 */
	private AWildart aWildart;
	
	/**
	 * Privater Konstruktor
	 * 
	 * aKlassename und aKlasseWert von den Enumerationparametern übernommen 
	 * die Wildart wird anhand der aKlasseWert berechnet um daraus die AWildartID zu berechnen
	 * 
	 * @param aKlasseWert aKlasseID der AKlasse
	 * @param aKlasseName Name der AKlasse
	 */
	private AKlasse(int aKlasseWert, String aKlasseName) {
		this.aKlasseName = aKlasseName;
		this.aKlasseWert = aKlasseWert;
		aWildart = AWildart.getAWildartByID( (aKlasseWert/10)*10);
	}
	
	//Zur Zeit nicht realisierbar, weil einige Bezeichner nicht eindeutig sind
	/*
	public AKlasse getAKlasseByName(String name) {
		return null;
	}
	*/
	
	/**
	 * Erzeugt eine AKlasse anhand einer AKlasseID
	 * 
	 * @param id AKlasseID anhand derer die AKlasse erzeugt werden soll
	 * @return AKlasse-objekt; Null wenn die ID nicht bekannt ist
	 */
	public static AKlasse getAKlasseByID(int id) {
		switch (id) {
		case 11: return AKlasse.aBock;
		case 12: return AKlasse.aGeissReh;
		case 13: return AKlasse.aKitzReh;
		case 101: return AKlasse.aKeiler;
		case 102: return AKlasse.aBache;
		case 103: return AKlasse.aUeberM;
		case 104: return AKlasse.aUeberW;
		case 105: return AKlasse.aFrisch;
		case 21: return AKlasse.aHirschIRot;
		case 22: return AKlasse.aHirschIIaRot;
		case 23: return AKlasse.aHirschIIbRot;
		case 24: return AKlasse.aHirschIIIRot;
		case 25: return AKlasse.aAlttierRot;
		case 26: return AKlasse.aSchmaltierRot;
		case 27: return AKlasse.aKalbRot;
		case 31: return AKlasse.aBockIa;
		case 32: return AKlasse.aBockIb;
		case 33: return AKlasse.aBockIIa;
		case 34: return AKlasse.aBockIIb;
		case 35: return AKlasse.aGeissGams;
		case 36: return AKlasse.aJaehrling;
		case 37: return AKlasse.aKitzGams;
		case 41: return AKlasse.aHirschIDam;
		case 42: return AKlasse.aHirschIIaDam;
		case 43: return AKlasse.aHirschIIbDam;
		case 44: return AKlasse.aHirschIIIDam;
		case 45: return AKlasse.aAlttierDam;
		case 46: return AKlasse.aSchmaltierDam;
		case 47: return AKlasse.aKalbDam;
		case 51: return AKlasse.aWidderIa;
		case 52: return AKlasse.aWidderIb;
		case 53: return AKlasse.aWidderIIa;
		case 54: return AKlasse.aWidderIIb;
		case 55: return AKlasse.aAltschaf;
		case 56: return AKlasse.aSchmalschaf;
		case 57: return AKlasse.aLamm;
		case 61: return AKlasse.aAuerhahn;
		case 71: return AKlasse.aBirkenhahn;
		case 81: return AKlasse.aRackelhahn;
		default: return null;
		}
	}
	/**
	 * Erzeugt eine AKlasse anhand einer Wildart und einer KlassenID
	 * 
	 * Aus der AWildartID wird die letzte Stelle auf 0 gesetzt und die subID wird angehangen.
	 * Die subID muss einstellig sein.
	 * 
	 * @param aWildart Übergeordnete Wildart
	 * @param subID ID der Klasse; ohne vorrangegangene Wildartnumer
	 * @return Erzeugte AKlasse; Null wenn keine AKlasse erzeugt werden konnte
	 */
	public static AKlasse getAKlasseBySubID(AWildart aWildart, int subID) {
		return getAKlasseByID( (aWildart.getaWildartWert()/10)*10+subID);
	}
	/**
	 * Erzeugt eine AKlasse mit übergebenen Werten
	 * 
	 * Es wird eine AKlasse.aCustom erzeugt und dann mit den Werten aus den Parametern belegt
	 * 
	 * @param aKlasseID ID der AKlasse
	 * @param aKlasseName Name der AKlasse
	 * @param aWildart Wildart zu der die Klasse gehört
	 * @return Erzeugte AKlasse; basierend auf aCustom
	 */
	public static AKlasse getAKlasseByValues(int aKlasseID, String aKlasseName, AWildart aWildart) {
		AKlasse result = AKlasse.aCustom;
		result.aKlasseWert = aKlasseID;
		result.aKlasseName = aKlasseName;
		result.aWildart = aWildart;
		
		return result;
	}

	/**
	 * Getter für Namen der AKlasse
	 * @return Name der AKlasse
	 */
	public String getaKlasseName() {
		return aKlasseName;
	}
	/**
	 * Getter für ID der AKlasse
	 * @return ID (integer) für Klasse
	 */
	public int getaKlasseWert() {
		return aKlasseWert;
	}
	/**
	 * Getter für Wildart 
	 * @return
	 */
	public AWildart getaWildart() {
		return aWildart;
	}
}
