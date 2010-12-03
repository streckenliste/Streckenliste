package de.fhhof.streckenliste.reporting;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
	 * Bei Aktionen print und export eigene Vorschau erzeugen
	 */
	private int year = 2010;
	private String revNr = "0815";
	
	private boolean showPreview;
	private MeldungsTyp meldTyp;
	private JasperPrint lastGeneratedPrint; 
	
	private DataFileIO dataSource;
	private BasicJasperReportFiles reportFiles;
	
	/**
	 * Erzeugt einen neuen Reporter
	 * @param showPreview True wenn bei Aktionen eine eigene Vorschau erzeugt werden soll
	 */
	public Reporter(boolean showPreview) {
		this(showPreview, new DataFileIODummy());
	}
	public Reporter(boolean showPreview, DataFileIO dataSource) {
		this.showPreview = showPreview;
		this.dataSource = dataSource;
		reportFiles = new BasicJasperReportFiles("report/");
		meldTyp = MeldungsTyp.aktuelleDaten;
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
	
	private void handleGenerateReportPages() {
		//TODO Jahre und Revier muss erhalten werden
		switch(meldTyp) {
		case abschluss: {generateReportPagesAbschluss(); dataSource.streckenlisteAbschliessen(year, revNr); break;}
		case aktuelleDaten: {generateReportPagesAktuelleDaten(); break;}
		case zwischenmeldung: {generateReportPagesZwischenmeldung(); dataSource.streckenlisteZwischenmeldung(year, revNr); break;}
		}
	}	
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
	@Override
	public void export(boolean showDialog) {
		// TODO Auto-generated method stub
		handleGenerateReportPages();
		if (showPreview) {
			JFrame previewWindow = new JFrame("Vorschau");
			previewWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

			previewWindow.getContentPane().add( new JRViewer(lastGeneratedPrint) );
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
	public JPanel getPreview(boolean withControls) {
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
}
