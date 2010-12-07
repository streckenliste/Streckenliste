package de.fhhof.streckenliste.reporting;

import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/*
 * TODO:
 * ES muss dynamisch auf verschiedene Reviere(Reviernummer) und Jahre eingegangen werden. Wird bisher hart codiert
 */
public class Reporter implements AbstractReporting {
	/**
	 * Jahr für das der Reporter arbeiten soll
	 */
	private int year;
	/**
	 * Reviernummer
	 */
	private String revNr;
	
	/**
	 * Vorschau anzeigen
	 */
	@Deprecated
	private boolean showPreview;
	/**
	 * Art der Meldung die generiert werden soll
	 */
	private MeldungsTyp meldTyp;
	/**
	 * Zuletzt erzeugter Report
	 */
	private JasperPrint lastGeneratedPrint; 
	
	/**
	 * Datenquelle für den Reporter
	 */
	private DataIO dataSource;
	/**
	 * Namensverzeichnis; Standardnamen die zum Generieren von Reports verwendet werden
	 */
	private BasicJasperReportFiles reportFiles;
	
	/**
	 * Erzeugt einen neuen Reporter
	 * 
	 * @param showPreview True wenn bei Aktionen eine eigene Vorschau erzeugt werden soll
	 * @deprecated Verwenden: Reporter(DatFileIO)
	 */
	@Deprecated
	public Reporter(boolean showPreview) {
		this(showPreview, new DataFileIODummy());
	}
	/**
	 * Erzeugt einen Reporter
	 * 
	 * @param showPreview Vorschau anzeigen bei Aktionen
	 * @param dataSource Datenquelle für den Reporter
	 * @deprecated Verwenden: Reporter(DatFileIO)
	 */
	@Deprecated
	public Reporter(boolean showPreview, DataIO dataSource) {
		this.showPreview = showPreview;
		this.dataSource = dataSource;
		reportFiles = new BasicJasperReportFiles("report/");
		meldTyp = MeldungsTyp.aktuelleDaten;
	}
	/**
	 * Konstruktor um einen Reporter zu Erstellen
	 * 
	 * @param dataSource Datenquellen für den Report
	 * @param jahr Jahr für das der Reporter arbeiten soll
	 * @param revNummer Revierkennzeichen; in Zusammenhang mit Jahr wichtig um das eindeutige Revier zu kennen
	 * @param baseReportPath Pfad in dem die Reports hinterlegt sind
	 */
	public Reporter(DataFileIO dataSource, int jahr, String revNummer, String baseReportPath) {
		this.dataSource = dataSource;
		this.year = jahr;
		this.revNr = revNummer;
		reportFiles = new BasicJasperReportFiles(baseReportPath);
	}
	/**
	 * Einen kompillierten Report laden
	 * @param fileName Dateiangabe zum kompilierten Report
	 * @return Ein JasperReport-Objekt; null wenn der Report nicht geladen werden konnte
	 */
	private JasperReport loadReport(String fileName) {
		JasperReport result = null;
		try {
			result = (JasperReport)JRLoader.loadObject(fileName);
		} catch (JRException e) {
			e.printStackTrace();
			System.out.println("Report '"+fileName+"' konnte nicht geladen werden");
		}
		
		return result;
	}
	
	/**
	 * Handler für Aktion
	 * 
	 * Je nach Meldungstyp werden die entsprechenden Reports geladen und in
	 * {@link #lastGeneratedPrint} hinterlegt. Zur Generierung wird eine Methode der Form generateReport... verwendet.
	 * Ist der meldTyp abschluss wird in der Datenquelle ein Abschluss vermerkt
	 * Ist der meldTyp zwischenmeldung wird in der Datenquelle eine Zwischenmeldung erstellt
	 */
	private void handleGenerateReportPages() {
		//TODO Jahre und Revier muss erhalten werden
		switch(meldTyp) {
		case abschluss: {generateReportPagesAbschluss(); dataSource.streckenlisteAbschliessen(year, revNr); break;}
		case aktuelleDaten: {generateReportPagesAktuelleDaten(); break;}
		case zwischenmeldung: {generateReportPagesZwischenmeldung(); dataSource.streckenlisteZwischenmeldung(year, revNr); break;}
		}
	}
	/**
	 * Generiert den Report mit allen Seiten die für die aktuelle Datenansicht erforderlich ist
	 */
	private void generateReportPagesAktuelleDaten() {
		//TODO
		//JasperReport mit dem Gearbeitet wird
		JasperReport reportDeckblatt = null;
		lastGeneratedPrint = null;
		
		//Deckblatt erstellen
		reportDeckblatt = loadReport( reportFiles.getFileName(BasicJasperReportFiles.DefaultValues.DECKBLATT) );
		
		if (reportDeckblatt != null) {
			try {
				lastGeneratedPrint = JasperFillManager.fillReport(reportDeckblatt, null, new JRMapCollectionDataSource(ReportMapFactory.createMapArrayList(ReportMapFactory.createMapDeckblatt(dataSource.readStreckenliste()))) );
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	}
	private void generateReportPagesZwischenmeldung() {
		//TODO
	}
	private void generateReportPagesAbschluss() {
		//TODO
	}

	/**
	 * Durchführen eines Exportes
	 * 
	 * Mittels showDialog kann angegeben werden ob ein Speicherdialog
	 * angezeigt werden soll, bevor die Datei exportiert wird.
	 * 
	 * @param showDialog True: Speicherdialog anzeigen; false: Direkt Exportieren
	 */
	@Deprecated
	public void export(boolean showDialog) {
		// TODO Auto-generated method stub
		//veraltet -> String-Variante nutzen
		handleGenerateReportPages();
		if (showPreview) {
			JFrame previewWindow = new JFrame("Vorschau");
			previewWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			JRViewer v = new JRViewer(lastGeneratedPrint);
			previewWindow.getContentPane().add( v );
			previewWindow.setSize(600, 400);

			previewWindow.setVisible(true);
		}
	}

	@Override
	public MeldungsTyp getMeldungstyp() {
		// TODO Auto-generated method stub
		return meldTyp;
	}

	@Override
	public JasperPrint getPreview(boolean withControls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print(boolean showDialog) {
		// TODO Auto-generated method stub
		handleGenerateReportPages();
	}

	@Override
	public void setMeldungstyp(MeldungsTyp meldung) {
		this.meldTyp = meldung;
	}

	/**
	 * Getter ob eine eigene Vorschau angezeigt werden soll
	 * @return true wenn eine eigenen Vorschau angezeigt werden soll
	 */
	public boolean isShowPreview() {
		return showPreview;
	}
	/**
	 * Setter für das Anzeigen einer eigenen Vorschau  
	 * @param showPreview True wenn eine eigene Vorschau vom Reporter angezeigt werden soll, sonst false
	 */
	public void setShowPreview(boolean showPreview) {
		this.showPreview = showPreview;
	}
	
	public BasicJasperReportFiles getReportFiles() {
		return reportFiles;
	}
	public void setReportFiles(BasicJasperReportFiles reportFiles) {
		this.reportFiles = reportFiles;
	}
	@Override
	public void export(String fileName) {
		// TODO Auto-generated method stub
		
	}	
}
