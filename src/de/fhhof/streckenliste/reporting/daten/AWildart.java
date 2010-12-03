package de.fhhof.streckenliste.reporting.daten;

public enum AWildart {
	aReh(10, AWildartNamen.REH), aSchwarz(100, AWildartNamen.SCHWARZ), aRot(20, AWildartNamen.ROT),
	aGams(30, AWildartNamen.GAMS),	aDam(40, AWildartNamen.DAM), aMuffel(50, AWildartNamen.MUFFEL),
	aAuerhahn(60, AWildartNamen.AUERHAHN), aBirkhahn(70, AWildartNamen.BIRKHAHN),
	aRackelhahn(80, AWildartNamen.RACKELHAHN);
	
	public static class AWildartNamen {
		public static String REH = "Rehwild";
		public static String SCHWARZ = "Schwarzwild";
		public static String ROT = "Rotwild";
		public static String GAMS = "Gamswild";
		public static String DAM = "Damwild";
		public static String MUFFEL = "Muffelwild";
		public static String AUERHAHN = "Auerhahn";
		public static String BIRKHAHN = "Birkhahn";
		public static String RACKELHAHN = "Rackelhahn";
	}
	
	private int aWildartWert;
	private String aWildartName;
	
	private AWildart(int aWildartWert, String aWildartName) {
		this.aWildartName = aWildartName;
		this.aWildartWert = aWildartWert;
	}

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

	public int getaWildartWert() {
		return aWildartWert;
	}

	public String getaWildartName() {
		return aWildartName;
	}
}
