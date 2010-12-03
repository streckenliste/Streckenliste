package de.fhhof.streckenliste.reporting.daten;

import de.fhhof.streckenliste.util.Repository;

public enum RevArt {
	eigenRev(Repository.EIGENREV[1], 1), staatsRev(Repository.STAATSREV[1], 2), gemeinRev(Repository.GEMEINREV[1], 3);
	
	private String revArtName;
	private int revArtWert;
	
	private RevArt(String bezeichner, int wert) {
		revArtName = bezeichner;
		revArtWert = wert;
	}
	
	public static RevArt getRevArtByID(int ID) {
		switch (ID) {
		case 1: return RevArt.eigenRev;
		case 2: return RevArt.staatsRev;
		case 3: return RevArt.gemeinRev;
		default: return null;
		}
	}

	public String getRevArtName() {
		return revArtName;
	}

	public int getRevArtWert() {
		return revArtWert;
	}
		
	public String toString() {
		return revArtName;
	}	
}
