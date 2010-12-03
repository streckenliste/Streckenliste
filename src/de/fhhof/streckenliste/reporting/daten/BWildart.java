package de.fhhof.streckenliste.reporting.daten;

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
	bRabenkraehe (803, BWildartNamen.RABENKRAEHE), bKolrabe (804, BWildartNamen.KOLRABE), bSonstFederwild (901, BWildartNamen.SONSTFEDERWILD) ;

	public static class BWildartNamen {
		public static String BACHE = "Bache";
		public static String BAUMMARDER = "Baummarder (Edelmarder)";
		public static String BLAESSHUHN = "Bläßhuhn";
		public static String DACHS = "Dachs";
		public static String EICHELHAEHER = "Eichelhäher";
		public static String ELSTER = "Elster";
		public static String FALKEN = "Falken";
		public static String FASAN = "Fasan";
		public static String FELDHASE = "Feldhase";
		public static String FISCHOTTER = "Fischotter";
		public static String FRISCH = "Frischling";
		public static String FUCHS = "Fuchs";
		public static String GAENSEREIHER = "Gänsereiher";
		public static String GRAUGANS = "Graugans";
		public static String GRAUREIHER = "Graureiher";
		public static String HABICHT = "Habicht";
		public static String HERMELIN = "Hermelin";
		public static String HOECKERSCHWAN = "Höckerschwan";
		public static String ILTIS = "Iltis";
		public static String KANADAGANS = "Kanadagans";
		public static String KEILER = "Keiler";
		public static String KNAECKENTE = "Knäckente";
		public static String KOLRABE = "Kolrabe";
		public static String KRICKENTE = "Krickente";
		public static String LACHMOEWE = "Lachmöwe";
		public static String LUCHS = "Luchs";
		public static String MAEUSEBUSSARD = "Mäusebussard";
		public static String MARDERHUND = "Marderhund";
		public static String MAUSWIESEL = "Mauswiesel";
		public static String MURMELTIER = "Murmeltier";
		public static String RABENKRAEHE = "Rabenkrähe";
		public static String REBHUHN = "Rebhuhn";
		public static String REIHERENTE = "Reiherente";
		public static String RINGELTAUBE = "Ringeltaube";
		public static String SAATGANS = "Saatgans";
		public static String SCHNEEHASE = "Schneehase";
		public static String SILBERMOEWE = "Silbermöwe";
		public static String SONSTENTE = "Sonst. Entenart";
		public static String SONSTFEDERWILD = "Sonst. Felderwildart";
		public static String SONSTGAENSE = "Sonst. Gänseart";
		public static String SONSTGREIFVOEGEL = "Sonst. Greifvogelart";
		public static String SONSTHAARWILD = "Sonst. Haarwildart";
		public static String SONSTMOEWE = "Sonst. Möwenart";
		public static String SPERBER = "Sperber";
		public static String STEINMARDER = "Steinmarder";
		public static String STOCKENTE = "Stockente";
		public static String SUMPFBIBER = "Sumpfbiber (Nutria)";
		public static String TAFELENTE = "Tafelente";
		public static String TUERKENTAUBE = "Türkentaube";
		public static String UEBERM = "Überläufer männlich";
		public static String UEBERW = "Überläufer weiblich";
		public static String WALDSCHNEPFE = "Waldschnepfe";
		public static String WASCHBAER = "Waschbär";
		public static String WILDKANINCHEN = "Wildkaninchen";
		public static String WILDKATZE = "Wildkatze";
	}
	
	private int bWildartWert;
	private String bWildartName;
	
	private BWildart(int bWildartWert, String bWildartName) {
		this.bWildartWert = bWildartWert;
		this.bWildartName = bWildartName;
	}
	
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

	public int getbWildartWert() {
		return bWildartWert;
	}

	public String getbWildartName() {
		return bWildartName;
	}
}
