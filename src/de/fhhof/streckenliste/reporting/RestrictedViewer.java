package de.fhhof.streckenliste.reporting;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.swing.JRViewerToolbar;

public class RestrictedViewer extends JRViewer {

	private static final long serialVersionUID = 1L;

	public RestrictedViewer(JasperPrint jrPrint) {
		super(jrPrint);
	}

	@Override
	protected JRViewerToolbar createToolbar() {
		// TODO Auto-generated method stub
		return new PDFRestrictedToolbar(viewerContext);
	}

}
