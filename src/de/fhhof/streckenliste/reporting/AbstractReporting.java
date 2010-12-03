package de.fhhof.streckenliste.reporting;

import javax.swing.JPanel;

public interface AbstractReporting {	
	public abstract void print(boolean showDialog);
	public abstract void export(boolean showDialog);
	
	public abstract JPanel getPreview(boolean withControls);
	
	public abstract void setMeldungstyp(MeldungsTyp meldungsart);
	public abstract MeldungsTyp getMeldungstyp();
}
