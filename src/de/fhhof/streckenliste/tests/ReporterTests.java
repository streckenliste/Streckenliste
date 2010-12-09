package de.fhhof.streckenliste.tests;

import javax.swing.JFrame;

import net.sf.jasperreports.view.JRViewer;

import de.fhhof.streckenliste.reporting.AbstractReporting;
import de.fhhof.streckenliste.reporting.DataFileIODummy;
import de.fhhof.streckenliste.reporting.MeldungsTyp;
import de.fhhof.streckenliste.reporting.Reporter;

public class ReporterTests {
	public static void testGetPreview() {
		AbstractReporting reporter = new Reporter(new DataFileIODummy(), 2010, "0815", "./report/");
		reporter.setMeldungstyp(MeldungsTyp.zwischenmeldung);
		
		JFrame frame = new JFrame("Test getPreview");
		frame.setSize(600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new JRViewer(reporter.getPreview()));
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		testGetPreview();
	}
}