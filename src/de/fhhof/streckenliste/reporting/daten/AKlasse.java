package de.fhhof.streckenliste.reporting.daten;

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
	aRackelhahn(81, AKlasseNamen.RACKELHANH);
	
	public static class AKlasseNamen {
		public static String BOCK = "Bock";
		public static String GEISS = "Geißen, Schmalrehe";
		public static String KITZ = "Kitz";
		public static String KEILER = "Keiler";
		public static String BACHE = "Bache";
		public static String UEBERM = "Überläufer männlich";
		public static String UEBERW = "Überläufer weiblich";
		public static String FRISCH = "Frischling";
		public static String HIRSCHI = "Hirsch Klasse I";
		public static String HIRSCHIIA = "Hirsch Klasse IIa";
		public static String HIRSCHIIB = "Hirsch Klasse IIb";
		public static String HIRSCHIII = "Hirsch Klasse III";
		public static String ALTTIER = "Alttier";
		public static String SCHMALTIER = "Schmaltier";
		public static String KALB = "Kalb";
		public static String BOCKIA = "Bock Klasse Ia";
		public static String BOCKIB = "Bock Klasse Ib";
		public static String BOCKIIA = "Bock Klasse IIa";
		public static String BOCKIIB = "Bock Klasse IIb";
		public static String JAEHRLING = "Jährling";
		public static String WIDDERIA = "Widder Klasse Ia";
		public static String WIDDERIB = "Widder Klasse Ib";
		public static String WIDDERIIA = "Widder Klasse IIa";
		public static String WIDDERIIB = "Widder Klasse IIb";
		public static String ALTSCHAF = "Altschaft";
		public static String SCHMALSCHAF = "Schmalschaf";
		public static String LAMM = "Lamm";
		public static String AUERHAHN = "Auerhahn";
		public static String BIRKENHAHN = "Birkenhan";
		public static String RACKELHANH = "Rackelhanh";
	}
	
	private String aKlasseName;
	private int aKlasseWert;
	private AWildart aWildart;
	
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
	public static AKlasse getAKlasseBySubID(AWildart aWildart, int subID) {
		return getAKlasseByID( (aWildart.getaWildartWert()/10)*10+subID);
	}

	public String getaKlasseName() {
		return aKlasseName;
	}

	public int getaKlasseWert() {
		return aKlasseWert;
	}

	public AWildart getaWildart() {
		return aWildart;
	}
}
