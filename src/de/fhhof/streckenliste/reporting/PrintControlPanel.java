package de.fhhof.streckenliste.reporting;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 * Grafische Oberfläche für die Auswahl von Druck oder Speichern einer Meldung
 * sowie für die Abgabe der Zwischenmeldung oder Abschlussmeldung
 *
 */
public class PrintControlPanel extends AbstractReportingControlPanel implements ActionListener{

	public class PrintPanelConstants {
		public static final String AKTUELLE_MELDUNG = "Aktueller Stand";
		public static final String ZWISCHENMELDUNG = "Zwischenmeldung";
		public static final String ABSCHLUSSMELDUNG = "Abschlussmeldung";
	}

	private static final long serialVersionUID = 1L;

	private JPanel masterPanel;
	private JPanel meldungsAuswahlPanel;
	private ButtonGroup meldungsAuswahl;
	private JRadioButton aktuelleMeldung;
	private JRadioButton zwischenmeldung;
	private JRadioButton abschlussmeldung;
	private JButton zwischenMeldButton;
	private JButton abschlussMeldButton;
	private JLabel auswahlLabel;
	private JLabel meldungsLabel;
	private DataIO data = new DataJDomParser();
	private int jahr = 0;
	private String revNum = "";
	private String path = "./report";
	private Reporter report = new Reporter(data, jahr, revNum, path);
	private JRViewer v;
	private JasperPrint page;

	/**
	 * Initialisieren der JRadioButton und Panels
	 */
	public PrintControlPanel() {
		initForm();
	}
	/**
	 * Methode zum Setzen der Panel-Layouts.
	 * - Anlegen Panel, Label und Buttons
	 * - Setzen des Meldungstypes
	 * - Anlegen eines Reports
	 * - Aufruf zum Setzen des Panels
	 */
	private void initForm() {
		setLayout(new GridLayout(1,0));
		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout());

		auswahlLabel = new JLabel();
		auswahlLabel.setText("  Auswahl:");

		meldungsLabel = new JLabel();
		meldungsLabel.setText("  Melden: ");

		zwischenMeldButton = new JButton();
		zwischenMeldButton.addActionListener(this);
		zwischenMeldButton.setText("Zwischenmeldung");

		abschlussMeldButton = new JButton();
		abschlussMeldButton.addActionListener(this);
		abschlussMeldButton.setText("Abschlussmeldung");

		meldungsAuswahlPanel = new JPanel(); 
		meldungsAuswahlPanel.setLayout(new BoxLayout(meldungsAuswahlPanel, BoxLayout.PAGE_AXIS)); {
			meldungsAuswahlPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			meldungsAuswahlPanel.add(auswahlLabel);
			meldungsAuswahlPanel.add(Box.createRigidArea(new Dimension(0, 15)));
			meldungsAuswahl = new ButtonGroup();

			zwischenmeldung = new JRadioButton(PrintPanelConstants.ZWISCHENMELDUNG);
			zwischenmeldung.addActionListener(this); {
				meldungsAuswahl.add(zwischenmeldung);
				meldungsAuswahlPanel.add(zwischenmeldung);
			}
			abschlussmeldung = new JRadioButton(PrintPanelConstants.ABSCHLUSSMELDUNG);
			abschlussmeldung.addActionListener(this); {
				meldungsAuswahl.add(abschlussmeldung);
				meldungsAuswahlPanel.add(abschlussmeldung);
			}

			aktuelleMeldung = new JRadioButton(PrintPanelConstants.AKTUELLE_MELDUNG);
			aktuelleMeldung.addActionListener(this); {
				meldungsAuswahl.add(aktuelleMeldung);
				aktuelleMeldung.setSelected(true);
				meldungsAuswahlPanel.add(aktuelleMeldung);
			}
			meldungsAuswahlPanel.setLayout(new BoxLayout(meldungsAuswahlPanel, BoxLayout.PAGE_AXIS));
			meldungsAuswahlPanel.add(Box.createRigidArea(new Dimension(0, 40)));
			meldungsAuswahlPanel.add(meldungsLabel);
			meldungsAuswahlPanel.add(Box.createRigidArea(new Dimension(0, 15)));
			meldungsAuswahlPanel.add(zwischenMeldButton);
			meldungsAuswahlPanel.add(Box.createRigidArea(new Dimension(0, 5)));
			meldungsAuswahlPanel.add(abschlussMeldButton);
		}
		aktuelleMeldung.doClick();
	}
	/**
	 * Methode zum Setzen des Panels für die Vorschau und Navigation.
	 * - entfernt alle Komponenten des Panels
	 * - setzen Meldungstyp
	 * - erzeugt neuen Report
	 * - erzeugt Vorschau für Report
	 * - setzen Zoomfaktor
	 * - setzen Rahmen
	 * - setzen Panel
	 * - zeichnen Panel
	 * @param meldung vom Typ Meldungstyp für die Erzeugung des entsprechenden Reports
	 */
	private void setPanel(MeldungsTyp meldung) {
		masterPanel.removeAll();
		report.setMeldungstyp(meldung);
		page = report.getPreview();
		v = new RestrictedViewer(page);
		v.setZoomRatio((float) 0.69);
		v.setBorder(BorderFactory.createEtchedBorder());
		masterPanel.add(meldungsAuswahlPanel, BorderLayout.WEST);
		masterPanel.add(v, BorderLayout.CENTER);
		add(masterPanel);
		masterPanel.paintAll(getGraphics());
	}
	/**
	 * ActionListener für Bestimmung der Meldungsart.
	 * Je nach Meldungsart wird der Meldungstyp gesetzt und ein JasperPrint für die Vorschau erzeugt
	 * Aufruf der setPanel-Methode
	 */
	public void actionPerformed(ActionEvent e) {				
		if(e.getSource() == zwischenmeldung) {
			setPanel(MeldungsTyp.zwischenmeldung);
			System.out.println(report.getMeldungstyp());	// Debug - löschen wenn fertig
		}
		if(e.getSource() == abschlussmeldung) {
			setPanel(MeldungsTyp.abschluss);
			System.out.println(report.getMeldungstyp());	// Debug - löschen wenn fertig
		}
		if(e.getSource() == aktuelleMeldung) {
			setPanel(MeldungsTyp.aktuelleDaten);
			System.out.println(report.getMeldungstyp());	// Debug - löschen wenn fertig
		}
		if(e.getSource() == zwischenMeldButton) {
			data.streckenlisteZwischenmeldung(jahr, revNum);
			System.out.println("Zwischenmeldung");			// Debug - löschen wenn fertig
			// noch ausformulieren
		}
		if(e.getSource() == abschlussMeldButton) {
			data.streckenlisteAbschliessen(jahr, revNum);
			System.out.println("Abschlussmeldung");			// Debug - löschen wenn fertig
			// noch ausformulieren
		}
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame("DruckTest");
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.add(new PrintControlPanel());

		testFrame.setSize(750, 450);
		testFrame.setVisible(true);
	}
}
