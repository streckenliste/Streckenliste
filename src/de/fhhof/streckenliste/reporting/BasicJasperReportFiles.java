package de.fhhof.streckenliste.reporting;

import java.util.HashMap;

/**
 * Klasse die Standardwerte für Dateinamen für Reports liefert.
 * 
 * @author Sebastian
 */
public class BasicJasperReportFiles {
	public static class DefaultValues {
		public static final String DECKBLATT = "deckblatt";
		public static final String ALISTE = "listeA";
		public static final String ALISTE_SUMMEN = "listeASummen";
		public static final String BLISTE = "listeB";
	}
	//TODO Weitere Standardwerte eingeben
	private HashMap<String, String> fileNames;
	//Pfad in dem die Dateien hinterlegt sind
	private String basePath;
	
	/**
	 * Erstellen des Objektes
	 * 
	 * Nutzt den Konstruktor(String)
	 * path ... "./"
	 */
	public BasicJasperReportFiles() {
		this("./");
	}
	/**
	 * Erstellen des Objektes
	 * 
	 * @param path Pfad in dem die Dateien hinterlegt sind
	 */
	public BasicJasperReportFiles(String path) {
		fileNames = new HashMap<String, String>();
		//Defaultwerte eintragen
		fileNames.put(DefaultValues.DECKBLATT, "deckblatt.jasper");
		fileNames.put(DefaultValues.ALISTE, "streckenliste_a_ohneSumme.jasper");
		fileNames.put(DefaultValues.ALISTE_SUMMEN, "streckenliste_a_summen.jasper");
		
		//Pfad setzen
		setBasePath(path);
	}
	
	public HashMap<String, String> getFileNames() {
		return fileNames;
	}
	public void setFileNames(HashMap<String, String> fileNames) {
		this.fileNames = fileNames;
	}

	/**
	 * Gibt einen Dateinamen zu einem Schlüssel.
	 * 
	 * Der Pfad wird an den Anfang des Namens mit eingefügt
	 * 
	 * @param key Schlüssel für den Dateinamen
	 * @return Dateinamen wird vorangestellten Pfad
	 */
	public String getFileName(Object key) {
		return basePath+fileNames.get(key);
	}
	/**
	 * Speichern eines Dateinamen
	 * 
	 * Es kann auch ein Pfad eingegeben werden, weil nur die Zeichenfolge nach dem letzten / gespeichert wird.
	 * 
	 * @param key Schlüssel für den Dateinamen
	 * @param value Dateiname der hinterlegt werden soll. Nur die Zeichenfolge nach dem letzten / wird abgespeichert
	 * @return Alter Wert, falls ein wert bereits bei diesem Schlüssel liegt; null wenn kein Objekt überschrieben wurde
	 */
	public String putFileName(String key, String value) {
		value = value.substring(value.lastIndexOf('/')+1);
		
		return fileNames.put(key, value);
	}
	
	public String getBasePath() {
		return basePath;
	}
	/**
	 * Setzen des Pfades in dem die Reportdateien hinterlegt sein sollen
	 * 
	 * Folgende Ersetzungen werden vorgenommen:
	 *  \ --> /
	 *  // --> /
	 * Wenn der Pfad nicht auf / endet wird es angehängt
	 * Ein leerer Pfad wird ersetzt durch ./
	 * 
	 * @param basePath relative oder absolute Pfadangabe
	 */
	public void setBasePath(String basePath) {
		if (basePath.trim().equals(""))
			basePath = "./";
		
		basePath.replace('\\', '/');
		basePath.replace("//", "/");
		
		if (basePath.charAt(basePath.length()-1) != '/')
			basePath += '/';
		
		this.basePath = basePath;
	}	
}
