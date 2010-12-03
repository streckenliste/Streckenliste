package de.fhhof.streckenliste.reporting;

import de.fhhof.streckenliste.reporting.daten.Streckenliste;

public interface DataFileIO {
	public Streckenliste readStreckenliste();
	public Streckenliste readStreckenliste(int jahr, String revier);
	public void streckenlisteAbschliessen(int jahr, String revier);
	public void streckenlisteZwischenmeldung(int jahr, String revier);
}
