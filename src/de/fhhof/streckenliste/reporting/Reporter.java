package de.fhhof.streckenliste.reporting;

import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JFrame;

import de.fhhof.streckenliste.reporting.daten.Streckenliste;
import de.fhhof.streckenliste.reporting.util.JRDeckblattDataSource;
import de.fhhof.streckenliste.reporting.util.JRListeADataSource;
import de.fhhof.streckenliste.reporting.util.JRListeBDataSource;
import de.fhhof.streckenliste.reporting.util.JRSumSollDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/*
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
	 * Streckenliste mit der aktuelle gearbeitet wird
	 */
	private Streckenliste streckenliste;

	/**
	 * Datenquelle für den Reporter
	 */
	private DataIO dataSource;
	/**
	 * Namensverzeichnis; Standardnamen die zum Generieren von Reports verwendet
	 * werden
	 */
	private BasicJasperReportFiles reportFiles;

	/**
	 * Erzeugt einen neuen Reporter
	 * 
	 * @param showPreview
	 *            True wenn bei Aktionen eine eigene Vorschau erzeugt werden
	 *            soll
	 * @deprecated Verwenden: Reporter(DatFileIO)
	 */
	@Deprecated
	public Reporter(boolean showPreview) {
		this(showPreview, new DataFileIODummy());
	}

	/**
	 * Erzeugt einen Reporter
	 * 
	 * @param showPreview
	 *            Vorschau anzeigen bei Aktionen
	 * @param dataSource
	 *            Datenquelle für den Reporter
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
	 * @param dataSource
	 *            Datenquellen für den Report
	 * @param jahr
	 *            Jahr für das der Reporter arbeiten soll
	 * @param revNummer
	 *            Revierkennzeichen; in Zusammenhang mit Jahr wichtig um das
	 *            eindeutige Revier zu kennen
	 * @param baseReportPath
	 *            Pfad in dem die Reports hinterlegt sind
	 */
	public Reporter(DataIO dataSource, int jahr, String revNummer,
			String baseReportPath) {
		this.dataSource = dataSource;
		this.year = jahr;
		this.revNr = revNummer;
		reportFiles = new BasicJasperReportFiles(baseReportPath);
	}

	@SuppressWarnings("unchecked")
	private void generateReportPagesAbschluss() {
		//JasperReports laden
		JasperReport reportDeckblatt = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.DECKBLATT));
		JasperReport reportListeA = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.ALISTE));
		JasperReport reportListeASummen = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.ALISTE_SUMMEN));
		JasperReport reportListeB = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.BLISTE));
		
		lastGeneratedPrint = null;

		if (reportDeckblatt != null && reportListeA != null
				&& reportListeASummen != null && reportListeB != null) {
			try {
				//Deckblatt laden
				lastGeneratedPrint = JasperFillManager.fillReport(
						reportDeckblatt, null, new JRDeckblattDataSource(
								streckenliste));
				
				//ListeA erstellen und Seiten anhängen
				List<JRPrintPage> pages = JasperFillManager.fillReport(
						reportListeA,
						null,
						new JRListeADataSource(streckenliste
								.getListeA(), false)).getPages();
				addPagesToReport(lastGeneratedPrint, pages);
				
				//Summenseite erstellen und Seiten anhängen
				pages = JasperFillManager.fillReport(
						reportListeASummen,
						null,
						new JRSumSollDataSource(streckenliste.getListeA().getSumErl(),
								streckenliste.getListeA().getSumFall(),
								streckenliste.getListeA().getSumGes(),
								streckenliste.getSollabschuesse())
					).getPages();
				addPagesToReport(lastGeneratedPrint, pages);
				
				//ListeB erstellen und Seiten anhängen
				pages = JasperFillManager.fillReport(reportListeB,
						null,
						new JRListeBDataSource(streckenliste)
				).getPages();
				addPagesToReport(lastGeneratedPrint, pages);
				
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Generiert den Report mit allen Seiten die für die aktuelle Datenansicht
	 * erforderlich ist
	 */
	@SuppressWarnings("unchecked")
	private void generateReportPagesAktuelleDaten() {
		// JasperReport mit dem Gearbeitet wird
		JasperReport reportDeckblatt = null;
		JasperReport reportListeA = null;
		JasperReport reportListeASummen = null;
		JasperReport reportListeBAktuell = null;
		lastGeneratedPrint = null;

		// Reports laden
		reportDeckblatt = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.DECKBLATT));
		reportListeA = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.ALISTE));
		reportListeASummen = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.ALISTE_SUMMEN));
		reportListeBAktuell = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.BLISTE_AKT));

		if (reportDeckblatt != null && reportListeA != null
				&& reportListeASummen != null && reportListeBAktuell != null) {
			try {
				//Deckblatt laden
				lastGeneratedPrint = JasperFillManager.fillReport(
						reportDeckblatt, null, new JRDeckblattDataSource(
								streckenliste));
				
				//ListeA erstellen und Seiten anhängen
				List<JRPrintPage> pages = JasperFillManager.fillReport(
						reportListeA,
						null,
						new JRListeADataSource(streckenliste
								.getListeA(), false)).getPages();
				addPagesToReport(lastGeneratedPrint, pages);
				
				//Summenseite erstellen und Seiten anhängen
				pages = JasperFillManager.fillReport(
						reportListeASummen,
						null,
						new JRSumSollDataSource(streckenliste.getListeA().getSumErl(),
								streckenliste.getListeA().getSumFall(),
								streckenliste.getListeA().getSumGes(),
								streckenliste.getSollabschuesse())
					).getPages();
				addPagesToReport(lastGeneratedPrint, pages);
				
				//ListeB erstellen und Seiten anhängen
				pages = JasperFillManager.fillReport(reportListeBAktuell,
						null,
						new JRListeBDataSource(streckenliste)
				).getPages();
				addPagesToReport(lastGeneratedPrint, pages);
				
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void addPagesToReport(JasperPrint masterPage, List<JRPrintPage> pages) {
		if (masterPage != null && pages != null) {
			for (JRPrintPage page: pages) {
				masterPage.addPage(page);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void generateReportPagesZwischenmeldung() {
		//JasperReports laden
		JasperReport reportDeckblatt = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.DECKBLATT));
		JasperReport reportListeA = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.ALISTE));
		JasperReport reportListeASummenZwimeld = loadReport(reportFiles
				.getFileName(BasicJasperReportFiles.DefaultValues.ALISTE_SUMMEN_ZWIMELD));
		
		lastGeneratedPrint = null;

		if (reportDeckblatt != null && reportListeA != null
				&& reportListeASummenZwimeld != null) {
			try {
				//Deckblatt laden
				lastGeneratedPrint = JasperFillManager.fillReport(
						reportDeckblatt, null, new JRDeckblattDataSource(
								streckenliste));
				
				//ListeA erstellen und Seiten anhängen
				List<JRPrintPage> pages = JasperFillManager.fillReport(
						reportListeA,
						null,
						new JRListeADataSource(streckenliste
								.getListeA(), false)).getPages();
				addPagesToReport(lastGeneratedPrint, pages);
				
				//Summenseite erstellen und Seiten anhängen
				pages = JasperFillManager.fillReport(
						reportListeASummenZwimeld,
						null,
						new JRSumSollDataSource(streckenliste.getListeA().getSumErl(),
								streckenliste.getListeA().getSumFall(),
								streckenliste.getListeA().getSumGes(),
								streckenliste.getSollabschuesse())
					).getPages();
				addPagesToReport(lastGeneratedPrint, pages);
				
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Handler für Aktion
	 * 
	 * Je nach Meldungstyp werden die entsprechenden Reports geladen und in
	 * {@link #lastGeneratedPrint} hinterlegt. Zur Generierung wird eine Methode
	 * der Form generateReport... verwendet. Ist der meldTyp abschluss wird in
	 * der Datenquelle ein Abschluss vermerkt Ist der meldTyp zwischenmeldung
	 * wird in der Datenquelle eine Zwischenmeldung erstellt
	 */
	private void handleGenerateReportPages() {
		// TODO Jahre und Revier muss erhalten werden
		streckenliste = dataSource.readStreckenliste();
		switch (meldTyp) {
		case abschluss: {
			generateReportPagesAbschluss();
			break;
		}
		case aktuelleDaten: {
			generateReportPagesAktuelleDaten();
			break;
		}
		case zwischenmeldung: {
			generateReportPagesZwischenmeldung();
			break;
		}
		}
	}

	/**
	 * Einen kompillierten Report laden
	 * 
	 * Der Ladevorgang ist in einem Try-Catch-Block gekapselt, welcher auf der Standardausgabe
	 * angibt wenn eine Datei nicht geladen werden konnte. Der Dateiname wird dabei mit
	 * angegeben.
	 * 
	 * @param fileName
	 *            Dateiangabe zum kompilierten Report
	 * @return Ein JasperReport-Objekt; null wenn der Report nicht geladen
	 *         werden konnte
	 */
	private JasperReport loadReport(String fileName) {
		JasperReport result = null;
		try {
			result = (JasperReport) JRLoader.loadObject(fileName);
		} catch (JRException e) {
			e.printStackTrace();
			System.out.println("Report '" + fileName
					+ "' konnte nicht geladen werden");
		}

		return result;
	}

	/**
	 * Durchführen eines Exportes
	 * 
	 * Mittels showDialog kann angegeben werden ob ein Speicherdialog angezeigt
	 * werden soll, bevor die Datei exportiert wird.
	 * 
	 * @param showDialog
	 *            True: Speicherdialog anzeigen; false: Direkt Exportieren
	 * @deprecated export(String) nutzen um den zuletzt erstellten Report an einer
	 * Stelle abzulegen. Es wird bei dieser Methode KEIN Speicherdialog angezeigt
	 */
	@Deprecated
	public void export(boolean showDialog) {
		// TODO Auto-generated method stub
		// veraltet -> String-Variante nutzen
		handleGenerateReportPages();
		if (showPreview) {
			JFrame previewWindow = new JFrame("Vorschau");
			previewWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			JRViewer v = new JRViewer(lastGeneratedPrint);
			previewWindow.getContentPane().add(v);
			previewWindow.setSize(600, 400);

			previewWindow.setVisible(true);
		}
		export(new GregorianCalendar().toString()+".pdf");
	}

	/**
	 * Exportiert den zuletzt erstellten Report als PDF-Datei
	 * 
	 * @param fileName Dateiname an dem der Report als PDF abgelegt werden soll
	 */
	@Override
	public void export(String fileName) {
		try {
			JasperExportManager.exportReportToPdfFile(lastGeneratedPrint, fileName);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MeldungsTyp getMeldungstyp() {
		return meldTyp;
	}

	@Override
	public JasperPrint getPreview() {
		handleGenerateReportPages();
		return lastGeneratedPrint;
	}

	@Override
	@Deprecated
	public JasperPrint getPreview(boolean withControls) {
		return getPreview();
	}

	public BasicJasperReportFiles getReportFiles() {
		return reportFiles;
	}

	/**
	 * Getter ob eine eigene Vorschau angezeigt werden soll
	 * 
	 * @return true wenn eine eigenen Vorschau angezeigt werden soll
	 */
	public boolean isShowPreview() {
		return showPreview;
	}

	@Override
	public void print(boolean showDialog) {
		handleGenerateReportPages();
		try {
			JasperPrintManager.printReport(lastGeneratedPrint, showDialog);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setMeldungstyp(MeldungsTyp meldung) {
		this.meldTyp = meldung;
	}
	
	public void setReportFiles(BasicJasperReportFiles reportFiles) {
		this.reportFiles = reportFiles;
	}

	/**
	 * Setter für das Anzeigen einer eigenen Vorschau
	 * 
	 * @param showPreview
	 *            True wenn eine eigene Vorschau vom Reporter angezeigt werden
	 *            soll, sonst false
	 */
	public void setShowPreview(boolean showPreview) {
		this.showPreview = showPreview;
	}
}
