package de.fhhof.streckenliste.reporting;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;


public class PrintControlPanel extends AbstractReportingControlPanel implements ActionListener, ItemListener{

	public class PrintPanelConstants {
		public static final String AKTUELLE_MELDUNG = "Aktueller Stand der Streckenlisten";
		public static final String ZWISCHENMELDUNG = "Zwischenmeldung der Streckenliste A";
		public static final String ABSCHLUSSMELDUNG = "Abschlussmeldung der Streckenlisten";

		public static final String DRUCKEN = "Drucken";
		public static final String EXPORT = "Speichern";
		public static final String VORSCHAU_ANZEIGEN = "Vorschau anzeigen";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel masterPanel;
	private JPanel meldungsAuswahlPanel;
	private ButtonGroup meldungsAuswahl;
	private JRadioButton aktuelleMeldung;
	private JRadioButton zwischenmeldung;
	private JRadioButton abschlussmeldung;
	private JPanel aktionsPanel;
	private JButton druckenButton;
	private JButton exportButton;
	private JCheckBox vorschauAnzeigenCheckBox;
	private JPanel centerPanel;
	private JPanel leerPanel;
	
	public boolean preview = true;
	public Reporter rep = new Reporter(preview,new DataJDomParser());

	public PrintControlPanel() {
		
		initForm();
	}

	private void initForm() {

		masterPanel = new JPanel();
		masterPanel.setLayout(new BorderLayout(0, 60));

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 1));
		leerPanel = new JPanel();

		meldungsAuswahlPanel = new JPanel(); {

			meldungsAuswahlPanel.setLayout(new GridLayout(3,1));
			TitledBorder title = BorderFactory.createTitledBorder("Art der Meldung");
			title.setTitleJustification(TitledBorder.LEFT);
			meldungsAuswahlPanel.setBorder(title);

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
		}

		aktionsPanel = new JPanel(); {

			aktionsPanel.setLayout(new GridLayout(3, 1, 0, 5));

			vorschauAnzeigenCheckBox = new JCheckBox(PrintPanelConstants.VORSCHAU_ANZEIGEN);
			vorschauAnzeigenCheckBox.addItemListener(this); {
				vorschauAnzeigenCheckBox.setSelected(true);
				aktionsPanel.add(vorschauAnzeigenCheckBox);
			}

			druckenButton = new JButton(PrintPanelConstants.DRUCKEN); 
			druckenButton.addActionListener(this); {
				aktionsPanel.add(druckenButton);
			}

			exportButton = new JButton(PrintPanelConstants.EXPORT);
			exportButton.addActionListener(this); {
				aktionsPanel.add(exportButton);
			}

		}
		centerPanel.add(meldungsAuswahlPanel);
		centerPanel.add(aktionsPanel);
		masterPanel.add(leerPanel, BorderLayout.NORTH);
		masterPanel.add(centerPanel, BorderLayout.CENTER);


		add(masterPanel);
	}
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getStateChange() == ItemEvent.DESELECTED) {
			preview = false;
			System.out.println("ohne Vorschau");
		}
		else {
			preview = true;
			System.out.println("mit Vorschau");
		}
	}
	
	public void actionPerformed(ActionEvent e) {
				
		if(e.getSource() == zwischenmeldung) {
			rep.setMeldungstyp(MeldungsTyp.zwischenmeldung);
			System.out.println(rep.getMeldungstyp());
		}
		if(e.getSource() == abschlussmeldung) {
			rep.setMeldungstyp(MeldungsTyp.abschluss);
			System.out.println(rep.getMeldungstyp());
		}
		if(e.getSource() == aktuelleMeldung) {
			rep.setMeldungstyp(MeldungsTyp.aktuelleDaten);
			System.out.println(rep.getMeldungstyp());
		}
		if(e.getSource() == druckenButton) {
			rep.print(preview);
			System.out.println("Drucken von " + rep.getMeldungstyp() + " ausgewählt mit Vorschau " + preview);
		}
		if(e.getSource() == exportButton) {
			rep.export(preview);
			System.out.println("Export von " + rep.getMeldungstyp() + " ausgewählt mit Vorschau " + preview);
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
