package de.fhhof.streckenliste.reporting;

import javax.swing.JPanel;

import net.sf.jasperreports.engine.JasperPrint;

@SuppressWarnings("unused")
public interface AbstractReporting {	
	public abstract void print(boolean showDialog);
	public abstract void export(String fileName);
	
	public abstract JasperPrint getPreview(boolean withControls);
	
	public abstract void setMeldungstyp(MeldungsTyp meldungsart);
	public abstract MeldungsTyp getMeldungstyp(); 
}
