package de.fhhof.streckenliste.reporting.daten;

import de.fhhof.streckenliste.util.Repository;

/**
 * Enumeration mit den möglichen Wildarten aus der Liste B
 * 
 * Neben alle den vordefinierten Werten gibt es noch die Möglichkeit eine Wildart
 * mit eigenen Werten zu erstellen. Dazu wird die aCustom verwendet. Diese Ausprägung
 * sollte nur über die Fabrikmethode getBWildartByValues(...) erstellt werden, weil
 * sonst die ID 0 ist, und auch keine BWildartname hinterlegt ist 
 * 
 * @author Sebastian
 * @version 1.0 untested
 */
public enum BWildart {
	aKeiler (101, BWildartNamen.KEILER), aBache (102, BWildartNamen.BACHE), aUeberM (103, BWildartNamen.UEBERM), aUeberW (104, BWildartNamen.UEBERW),
	aFrisch (105, BWildartNamen.FRISCH), bFeldhase (201, BWildartNamen.FELDHASE), bSchneehase (202, BWildartNamen.SCHNEEHASE),
	bWildkaninchen (203, BWildartNamen.WILDKANINCHEN), bMurmeltier (204, BWildartNamen.MURMELTIER), bFuchs (205, BWildartNamen.FUCHS),
	bSteinmarder (206, BWildartNamen.STEINMARDER), bBaummarder (207, BWildartNamen.BAUMMARDER), bFischotter (208, BWildartNamen.FISCHOTTER),
	bIltis (209, BWildartNamen.ILTIS), bHermelin (210, BWildartNamen.HERMELIN), bMauswiesel (211, BWildartNamen.MAUSWIESEL),
	bDachs (212, BWildartNamen.DACHS), bWaschbaer (213, BWildartNamen.WASCHBAER), bMarderhund (214, BWildartNamen.MARDERHUND),
	bSumpfbiber (215, BWildartNamen.SUMPFBIBER), bLuchs (216, BWildartNamen.LUCHS), bWildkatze (217, BWildartNamen.WILDKATZE),
	bSonstHaarwild (218, BWildartNamen.SONSTHAARWILD), bRebhuhn (301, BWildartNamen.REBHUHN), bFasan (302, BWildartNamen.FASAN),
	bRingeltaube (303, BWildartNamen.RINGELTAUBE), bTuerkentaube (304, BWildartNamen.TUERKENTAUBE), bWaldschnepfe (305, BWildartNamen.WALDSCHNEPFE),
	bBlaesshuhn (306, BWildartNamen.BLAESSHUHN), bHoeckerschwan (307, BWildartNamen.HOECKERSCHWAN), bGraureiher (308, BWildartNamen.GRAUREIHER),
	bGaensereiher (309, BWildartNamen.GAENSEREIHER), bGraugans (401, BWildartNamen.GRAUGANS), bSaatgans (402, BWildartNamen.SAATGANS),
	bKanadagans (403, BWildartNamen.KANADAGANS), bSonstGaense (404, BWildartNamen.SONSTGAENSE), bStockente (501, BWildartNamen.STOCKENTE),
	bKrickente (502, BWildartNamen.KRICKENTE), bKnaeckente (503, BWildartNamen.KNAECKENTE), bTafelente (504, BWildartNamen.TAFELENTE),
	bReiherente (505, BWildartNamen.REIHERENTE), bSonstEnte (506, BWildartNamen.SONSTENTE), bLachmoewe (601, BWildartNamen.LACHMOEWE),
	bSilbermoewe (602, BWildartNamen.SILBERMOEWE), bSonstMoewe (603, BWildartNamen.SONSTMOEWE), bMaeusebussard (701, BWildartNamen.MAEUSEBUSSARD),
	bHabicht (702, BWildartNamen.HABICHT), bSperber (703, BWildartNamen.SPERBER), bFalken (704, BWildartNamen.FALKEN),
	bSonstGreifvoegel (705, BWildartNamen.SONSTGREIFVOEGEL), bElster (801, BWildartNamen.ELSTER), bEichelhaeher (802, BWildartNamen.EICHELHAEHER),
	bRabenkraehe (803, BWildartNamen.RABENKRAEHE), bKolrabe (804, BWildartNamen.KOLRABE), bSonstFederwild (901, BWildartNamen.SONSTFEDERWILD),
	aCustom(0, null);

	/**
	 * Wildartname für die Wildarten der Liste B
	 * 
	 * Greift auf die Werte im Repository zurück
	 * 
	 * @author Sebastian
	 * @version 1.0 untested
	 */
	public static class BWildartNamen {
		public static String BACHE = Repository.ABACHE[1];
		public static String BAUMMARDER = Repository.BBAUMMARDER[1];
		public static String BLAESSHUHN = Repository.BBLAESSHUHN[1];
		public static String DACHS = Repository.BDACHS[1];
		public static String EICHELHAEHER = Repository.BEICHELHAEHER[1];
		public static String ELSTER = Repository.BELSTER[1];
		public static String FALKEN = Repository.BFALKEN[1];
		public static String FASAN = Repository.BFASAN[1];
		public static String FELDHASE = Repository.BFELDHASE[1];
		public static String FISCHOTTER = Repository.BFISCHOTTER[1];
		public static String FRISCH = Repository.AFRISCH[1];
		public static String FUCHS = Repository.BFUCHS[1];
		public static String GAENSEREIHER = Repository.BGAENSEREIHER[1];
		public static String GRAUGANS = Repository.BGRAUGANS[1];
		public static String GRAUREIHER = Repository.BGRAUREIHER[1];
		public static String HABICHT = Repository.BHABICHT[1];
		public static String HERMELIN = Repository.BHERMELIN[1];
		public static String HOECKERSCHWAN = Repository.BHOECKERSCHWAN[1];
		public static String ILTIS = Repository.BILTIS[1];
		public static String KANADAGANS = Repository.BKANADAGANS[1];
		public static String KEILER = Repository.AKEILER[1];
		public static String KNAECKENTE = Repository.BKNAECKENTE[1];
		public static String KOLRABE = Repository.BKOLRABE[1];
		public static String KRICKENTE = Repository.BKRICKENTE[1];
		public static String LACHMOEWE = Repository.BLACHMOEWE[1];
		public static String LUCHS = Repository.BLUCHS[1];
		public static String MAEUSEBUSSARD = Repository.BMAEUSEBUSSARD[1];
		public static String MARDERHUND = Repository.BMARDERHUND[1];
		public static String MAUSWIESEL = Repository.BMAUSWIESEL[1];
		public static String MURMELTIER = Repository.BMURMELTIER[1];
		public static String RABENKRAEHE = Repository.BRABENKRAEHE[1];
		public static String REBHUHN = Repository.BREBHUHN[1];
		public static String REIHERENTE = Repository.BREIHERENTE[1];
		public static String RINGELTAUBE = Repository.BRINGELTAUBE[1];
		public static String SAATGANS = Repository.BSAATGANS[1];
		public static String SCHNEEHASE = Repository.BSCHNEEHASE[1];
		public static String SILBERMOEWE = Repository.BSILBERMOEWE[1];
		public static String SONSTENTE = Repository.BSONSTENTE[1];
		public static String SONSTFEDERWILD = Repository.BSONSTFEDERWILD[1];
		public static String SONSTGAENSE = Repository.BSONSTGAENSE[1];
		public static String SONSTGREIFVOEGEL = Repository.BSONSTGREIFVOEGEL[1];
		public static String SONSTHAARWILD = Repository.BSONSTHAARWILD[1];
		public static String SONSTMOEWE = Repository.BSONSTMOEWE[1];
		public static String SPERBER = Repository.BSPERBER[1];
		public static String STEINMARDER = Repository.BSTEINMARDER[1];
		public static String STOCKENTE = Repository.BSTOCKENTE[1];
		public static String SUMPFBIBER = Repository.BSUMPFBIBER[1];
		public static String TAFELENTE = Repository.BTAFELENTE[1];
		public static String TUERKENTAUBE = Repository.BTUERKENTAUBE[1];
		public static String UEBERM = Repository.AUEBERM[1];
		public static String UEBERW = Repository.AUEBERW[1];
		public static String WALDSCHNEPFE = Repository.BWALDSCHNEPFE[1];
		public static String WASCHBAER = Repository.BWASCHBAER[1];
		public static String WILDKANINCHEN = Repository.BWILDKANINCHEN[1];
		public static String WILDKATZE = Repository.BWILDKATZE[1];
	}
	
	/**
	 * ID der BWildart
	 */
	private int bWildartWert;
	/**
	 * Name der BWildart
	 */
	private String bWildartName;
	
	/**
	 * Konstruktor für BWildart
	 * 
	 * Es weden die Eigenschaften entsprechend der Attribute gesetzt
	 * @param bWildartWert ID/Value von BWildart
	 * @param bWildartName Name für BWildart
	 */
	private BWildart(int bWildartWert, String bWildartName) {
		this.bWildartWert = bWildartWert;
		this.bWildartName = bWildartName;
	}
	
	/**
	 * Erzeugt eine BWildart anhand einer übergebenen ID
	 * 
	 * Es werden die bekannten IDs abgeprüft ob sie mit der
	 * übergebenen übereinstimmt. Wurde ein Treffer gefunden
	 * wird die entsprechende BWildart erzeugt, sonst wird null
	 * als Ergebnis geliefert.
	 * 
	 * ID's der aCustom-objekte werden nicht ignoriert
	 * 
	 * @param ID Wert einer bekannten BWildart; wird genutzt um die Wildart zu erzeugen
	 * @return BWildart-Objekt; null wenn die ID nicht verifiziert werden konnte
	 */
	public static BWildart getBWildartByID(int ID) {
		switch (ID) {
		case 101: return BWildart.aKeiler;
		case 102: return BWildart.aBache;
		case 103: return BWildart.aUeberM;
		case 104: return BWildart.aUeberW;
		case 105: return BWildart.aFrisch;
		case 201: return BWildart.bFeldhase;
		case 202: return BWildart.bSchneehase;
		case 203: return BWildart.bWildkaninchen;
		case 204: return BWildart.bMurmeltier;
		case 205: return BWildart.bFuchs;
		case 206: return BWildart.bSteinmarder;
		case 207: return BWildart.bBaummarder;
		case 208: return BWildart.bFischotter;
		case 209: return BWildart.bIltis;
		case 210: return BWildart.bHermelin;
		case 211: return BWildart.bMauswiesel;
		case 212: return BWildart.bDachs;
		case 213: return BWildart.bWaschbaer;
		case 214: return BWildart.bMarderhund;
		case 215: return BWildart.bSumpfbiber;
		case 216: return BWildart.bLuchs;
		case 217: return BWildart.bWildkatze;
		case 218: return BWildart.bSonstHaarwild;
		case 301: return BWildart.bRebhuhn;
		case 302: return BWildart.bFasan;
		case 303: return BWildart.bRingeltaube;
		case 304: return BWildart.bTuerkentaube;
		case 305: return BWildart.bWaldschnepfe;
		case 306: return BWildart.bBlaesshuhn;
		case 307: return BWildart.bHoeckerschwan;
		case 308: return BWildart.bGraureiher;
		case 309: return BWildart.bGaensereiher;
		case 401: return BWildart.bGraugans;
		case 402: return BWildart.bSaatgans;
		case 403: return BWildart.bKanadagans;
		case 404: return BWildart.bSonstGaense;
		case 501: return BWildart.bStockente;
		case 502: return BWildart.bKrickente;
		case 503: return BWildart.bKnaeckente;
		case 504: return BWildart.bTafelente;
		case 505: return BWildart.bReiherente;
		case 506: return BWildart.bSonstEnte;
		case 601: return BWildart.bLachmoewe;
		case 602: return BWildart.bSilbermoewe;
		case 603: return BWildart.bSonstMoewe;
		case 701: return BWildart.bMaeusebussard;
		case 702: return BWildart.bHabicht;
		case 703: return BWildart.bSperber;
		case 704: return BWildart.bFalken;
		case 705: return BWildart.bSonstGreifvoegel;
		case 801: return BWildart.bElster;
		case 802: return BWildart.bEichelhaeher;
		case 803: return BWildart.bRabenkraehe;
		case 804: return BWildart.bKolrabe;
		case 901: return BWildart.bSonstFederwild;
		default: return null;
		}
	}
	
	/**
	 * Erzeugen einer BWildart mit bestimmten Werten
	 * 
	 *  Es wird eine BWildart.aCustom erstellt und mit den Werten aus 
	 *  den Parametern erstellt.
	 * 
	 * @param bWildartID Wert/ID die für die Wildart gesetzt werden soll;
	 * es wird nicht geprüft ob die ID bereits vergeben ist
	 * @param bWildartName Name der BWildart
	 * @return BWildart.aCustom mit übergebenen Werten
	 */
	public static BWildart getBWildartByValues(int bWildartID, String bWildartName) {
		BWildart result = aCustom;
		result.bWildartName = bWildartName;
		result.bWildartWert = bWildartID;
		
		return result;
	}

	/**
	 * Getter für BWildartWert
	 * 
	 * Direktes Lesen
	 * @return Wert der Wildart
	 */
	public int getbWildartWert() {
		return bWildartWert;
	}

	/**
	 * Getter für Namen der BWildart
	 * 
	 * Direktes Lesen
	 * @return Name der Wildart
	 */
	public String getbWildartName() {
		return bWildartName;
	}
}
