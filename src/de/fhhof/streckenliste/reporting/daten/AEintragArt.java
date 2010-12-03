package de.fhhof.streckenliste.reporting.daten;

public enum AEintragArt {
	aErlegt(1), aVerkehr(2), aSonstFall(3), aGefangen(4);
	
	private int aEintragID;
	
	private AEintragArt(int aEintragArtID) {
		this.aEintragID = aEintragArtID;
	}
	
	public static AEintragArt getAEintragArtByID(int ID) {
		switch (ID) {
		case 1: return AEintragArt.aErlegt;
		case 2: return AEintragArt.aVerkehr;
		case 3: return AEintragArt.aSonstFall;
		case 4: return AEintragArt.aGefangen;
		default: return null;
		}
	}

	public int getaEintragID() {
		return aEintragID;
	}
}
